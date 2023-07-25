package library.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import library.vo.BookVO;

public class BookDAO {

	private static BasicDataSource basicDS;
	
	static {
		// connection pool 생성
		System.out.println("@@ BookDAO에서 Connection Pool 생성");
		basicDS = new BasicDataSource();
		basicDS.setDriverClassName("com.mysql.cj.jdbc.Driver");
		basicDS.setUrl("jdbc:mysql://127.0.0.1:3306/library?characterEncoding=UTF-8&serverTimezone=UTC&useSSL=false&allowPublicKeyRetrieval=true");
		basicDS.setUsername("root");
		basicDS.setPassword("qwer1234");
		basicDS.setInitialSize(10);
		basicDS.setMaxTotal(20);
	}

	public static DataSource getDataSource() {
		return basicDS;
	}
	
	public ObservableList<BookVO> select(String searchKeyword) {
		// TODO Auto-generated method stub
		
		// 커넥션 열기
		Connection con = null;
		try {
			con = basicDS.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// sql 문 작성
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT bisbn, btitle, bauthor, bprice ");
		sql.append("FROM book ");
		sql.append("WHERE btitle LIKE ?");
		sql.append("ORDER BY bprice DESC");
		
		ObservableList<BookVO> list = FXCollections.observableArrayList();
		try {
			// pstmt 생성
			PreparedStatement pstmt = con.prepareStatement(sql.toString());
			pstmt.setString(1, "%" + searchKeyword + "%");

			// execute
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				BookVO book = new BookVO(rs.getString("bisbn"), rs.getString("btitle"), rs.getString("bauthor"), rs.getInt("bprice"));
				list.add(book);
			}
			
			// 리소스 해제
			rs.close();
			pstmt.close();
			con.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// list 리턴
		return list;
	}

	public int delete(String isbnOfSelectedBook) {
		// TODO Auto-generated method stub
		
		// con 빌려오기
		Connection con = null;
		try {
			con = basicDS.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// sql문 작성
		StringBuffer sql = new StringBuffer();
		sql.append("DELETE FROM book ");
		sql.append("WHERE bisbn = ?");

		int rows = 0;
		try {
			con.setAutoCommit(false);
			System.out.println("@@ Transaction 시작");
			
			// Statement 생성
			PreparedStatement pstmt = con.prepareStatement(sql.toString());
			pstmt.setString(1, isbnOfSelectedBook);

			// execute
			rows = pstmt.executeUpdate();

			con.rollback();
			System.out.println("@@ rollback 성공");
			
			// 리소스 해제
			pstmt.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return rows;
	}

}
