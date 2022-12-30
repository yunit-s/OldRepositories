package library.dao;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;

import javafx.collections.ObservableList;
import library.vo.BookVO;

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
		
		// 커넥션 열기
		// sql 문 작성하기
		// pstmt 만들기
		// execute
		// 리소스 해제
		// list 리턴
		Connection con = null;
		try {
			con = basicDS.getConnection();
			
			StringBuffer sql = new StringBuffer();
			sql.append("SELECT");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT bisbn, btitle, bauthor, bprice ");
		sql.append("FROM books ");
		sql.append("SELECT bisbn, btitle, bauthor, bprice ");
		sql.append("SELECT bisbn, btitle, bauthor, bprice ");
		
		return null;
	}

}
