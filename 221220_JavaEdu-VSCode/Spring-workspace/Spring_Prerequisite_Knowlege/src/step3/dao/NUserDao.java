package step3.dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class NUserDao extends UserDao {
	
	@Override
	protected Connection getConnection() throws Exception {
		// UserDao를 구입한 회사에서
		// 나름대로의 데이터베이스 연결 코드를 여기에 넣어서 우리 UserDao를
		// 확장시켜 사용할 수 있어요!
		// 1. Driver Loading
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		// 2. 연결해보아요!
		String jdbcUrl = "jdbc:mysql://127.0.0.1:3306/spring?characterEncoding=UTF-8&serverTimezone=UTC&useSSL=false&allowPublicKeyRetrieval=true";
		String id = "root";
		String pw = "qwer1234";
		
		Connection con = DriverManager.getConnection(jdbcUrl, id, pw);	
		return con;
		
	}

}
