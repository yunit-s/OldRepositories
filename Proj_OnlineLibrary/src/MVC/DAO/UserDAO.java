package MVC.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAO {

	Connection con;
	
	public UserDAO(Connection con) {
		// TODO Auto-generated constructor stub
		this.con = con;
	}

	public String getPassword(String id) {
		// TODO Auto-generated method stub
		// sql 문 작성
		// con을 이용해서 pstmt 생성
		// execute
		// password 값 리턴
		
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT pw ");
		sql.append("FROM users ");
		sql.append("WHERE id = ?");
		
		String userPw = null;
		try {
			PreparedStatement pstmt = con.prepareStatement(sql.toString());
			pstmt.setString(1, id);
			
			ResultSet rs = pstmt.executeQuery();
			rs.next();
			userPw = rs.getString("pw");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return userPw;
	}

}
