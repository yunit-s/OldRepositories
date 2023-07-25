package lecture.jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import lecture.jdbc.vo.BookVO;

public class BookDAO {

	//  데이터베이스 처리 전문 객체를 만들기 위한 클래스

	private static BasicDataSource basicDS;

	static {
		// Connection Pool 생성
		basicDS = new BasicDataSource();
		basicDS.setDriverClassName("com.mysql.cj.jdbc.Driver");
		basicDS.setUrl("jdbc:mysql://127.0.0.1:3306/library?characterEncoding=UTF-8&serverTimezone=UTC&useSSL=false&allowPublicKeyRetrieval=true");
		basicDS.setUsername("root");
		basicDS.setPassword("qwer1234");
		basicDS.setInitialSize(10);
		basicDS.setMaxTotal(20);
	}

	public static DataSource getDataSource() {
		// DataSource 는 BasicDataSource 의 상위 인터페이스 개념이다. IS-A 관계를 활용하자.
		return basicDS;
	}

	public ObservableList<BookVO> select(String text) {
		// TODO Auto-generated method stub
		
		// 2. 데이터베이스 연결
		DataSource ds = getDataSource();
	    ObservableList<BookVO> list = FXCollections.observableArrayList();
		Connection con = null;
		try {
			con = ds.getConnection();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		// 3. 실행할 SQL문장을 가지고 있는 Statement 생성하기
		StringBuffer sql = new StringBuffer();
		sql.append("select bisbn, btitle, bauthor, bprice ");
		sql.append("from book ");
		sql.append("where btitle like ?");
		sql.append("order by bprice desc");
		
		PreparedStatement pstmt = null;
		try {
		    pstmt = con.prepareStatement(sql.toString());
			pstmt.setString(1, "%" + text + "%");
			
		    // 4. 실행
		    ResultSet rs = pstmt.executeQuery();

		    // 5. 결과처리
			while (rs.next()) {
		    	// VO를 생성해야 한다.
				BookVO book = new BookVO(rs.getString("bisbn"), rs.getString("btitle"), rs.getString("bauthor"), rs.getInt("bprice"));
				// arraylist에 추가하기
				list.add(book);
		    }

		    // 6. 사용한 리소스 해제
		    rs.close();
		    pstmt.close();
		    con.close();

		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		return list;
	}

	public int delete(String deleteISBN) {
		// TODO Auto-generated method stub

		// 2. 데이터베이스 연결
		DataSource ds = getDataSource();
	    ObservableList<BookVO> list = FXCollections.observableArrayList();
		Connection con = null;
		try {
			con = ds.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		StringBuffer sql = new StringBuffer();
		sql.append("DELETE ");
		sql.append("FROM book ");
		sql.append("WHERE bisbn = ?");
		
		try {
			// transaction 시작
			con.setAutoCommit(false); // Auto commit 기능을 끄면서, 이때부터는 트랜잭션이 걸리게 된
			
			PreparedStatement pstmt = con.prepareStatement(sql.toString());
			pstmt.setString(1, deleteISBN);
			
			int count = pstmt.executeUpdate();
			System.out.println("영향받은 row : " + count + " 줄");
			
			// transaction을 종료하고, 지금까지 실행한 SQL문을 모두 무효화시킴
//			if (count == 1) {
//				con.commit();
//			} else {
//				con.rollback();
//			}
			con.rollback();
			System.out.println("delete 에 대한 rollback 실행함.");
			
			// 6. 사용한 자원 반납
			pstmt.close();
			con.close();
			
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		return 0;
	}

}
