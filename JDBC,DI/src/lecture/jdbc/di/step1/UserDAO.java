package lecture.jdbc.di.step1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAO {

	public void insert(UserVO user) {
		
		// 일반 JDBC 코드
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			String jdbc_url = "jdbc:mysql://127.0.0.1:3306/example01?characterEncoding=UTF-8&serverTimezone=UTC&useSSL=false&allowPublicKeyRetrieval=true";
			String id = "root";
			String pw = "qwer1234";
			
			Connection con = DriverManager.getConnection(jdbc_url, id, pw);
			
			String sql = "INSERT INTO users VALUES (?, ?, ?)";
			PreparedStatement pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, user.getId()); // 첫 번째 물음표? 에 UserVO의 id 입력하기
			pstmt.setString(2, user.getName()); // 두 번째 물음표? 에 UserVO의 name 입력하기
			pstmt.setString(3, user.getPassword()); // 세 번째 물음표? 에 UserVO의 password 입력하기
			
			int count = pstmt.executeUpdate(); // 사용자 등록
			
			pstmt.close();
			con.close();
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public UserVO select(String string) {
		// TODO Auto-generated method stub
		// 일반 JDBC 코드
		UserVO user = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			String jdbc_url = "jdbc:mysql://127.0.0.1:3306/example01?characterEncoding=UTF-8&serverTimezone=UTC&useSSL=false&allowPublicKeyRetrieval=true";
			String id = "root";
			String pw = "qwer1234";
			
			Connection con = DriverManager.getConnection(jdbc_url, id, pw);
			
			String sql = "SELECT * FROM users WHERE id = ?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, string); // 첫 번째 물음표? 에 UserVO의 id 입력하기
			
			ResultSet rs = pstmt.executeQuery(); // 사용자 등록
			rs.next();
			
			user = new UserVO(string, rs.getString("name"), rs.getString("password"));
			
			rs.close();
			pstmt.close();
			con.close();
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return user;
	}

//	public void select(UserVO user) {
//		
//		// 일반 JDBC 코드
//		try {
//			Class.forName("com.mysql.cj.jdbc.Driver");
//			
//			String jdbc_url = "jdbc:mysql://127.0.0.1:3306/example01?characterEncoding=UTF-8&serverTimezone=UTC&useSSL=false&allowPublicKeyRetrieval=true";
//			String id = "root";
//			String pw = "qwer1234";
//			
//			Connection con = DriverManager.getConnection(jdbc_url, id, pw);
//			
//			String sql = "SELECT * FROM users WHERE id = ?";
//			PreparedStatement pstmt = con.prepareStatement(sql);
//			
//			pstmt.setString(1, user.getId()); // 첫 번째 물음표? 에 UserVO의 id 입력하기
//			
//			int count = pstmt.executeUpdate(); // 사용자 등록
//			
//			pstmt.close();
//			con.close();
//			
//		} catch (ClassNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//	}
}
