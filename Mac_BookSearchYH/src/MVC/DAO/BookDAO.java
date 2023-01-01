package MVC.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;

import MVC.VO.BookVO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class BookDAO {

	private static BasicDataSource basicDS;
	
	static {
		// connection pool 생성
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
		System.out.println("@@ BookDAO select");
		
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
		
		ObservableList<BookVO> list  = null;
		try {
			// pstmt 생
			PreparedStatement pstmt = con.prepareStatement(sql.toString());
			pstmt.setString(1, "%" + searchKeyword + "%");
			// execute
			ResultSet rs = pstmt.executeQuery();
			
			list = FXCollections.observableArrayList();
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

}
