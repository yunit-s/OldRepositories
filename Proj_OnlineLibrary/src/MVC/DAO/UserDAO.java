package MVC.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import MVC.VO.BookVO;
import MVC.VO.UserVO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class UserDAO {

	Connection con;
	
	public UserDAO(Connection con) {
		// TODO Auto-generated constructor stub
		this.con = con;
	}

//	public String getPassword(String id) {
//		// TODO Auto-generated method stub
//		// sql 문 작성
//		// con을 이용해서 pstmt 생성
//		// execute
//		// password 값 리턴
//		
//		StringBuffer sql = new StringBuffer();
//		sql.append("SELECT pw ");
//		sql.append("FROM users ");
//		sql.append("WHERE id = ?");
//		
//		String userPw = null;
//		try {
//			PreparedStatement pstmt = con.prepareStatement(sql.toString());
//			pstmt.setString(1, id);
//			
//			ResultSet rs = pstmt.executeQuery();
//			if (rs.next()) {
//				// rs 안에 유효 row가 존재할 때
//				userPw = rs.getString("pw");
//			} else {
//				System.out.println("@@ UserDAO - getPassword() 검색결과 없음");
//			}
//			
//			rs.close();
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		return userPw;
//	}

	public UserVO searchUserByCategory(String category, String searchWord) {
		// sql 문 작성
		// con을 이용해서 pstmt 생성
		// execute
		// user 데이터 리턴
		
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT * ");
		sql.append("FROM users ");
		sql.append("WHERE " + category + " = ?");
		
		UserVO user = null;
		try {
			PreparedStatement pstmt = con.prepareStatement(sql.toString());
			pstmt.setString(1, searchWord);
			
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				// rs 안에 유효 row가 존재할 때
				user = new UserVO(rs.getString("id"), rs.getString("nickname"), rs.getString("pw"), rs.getString("email"),
						rs.getString("phone"), rs.getString("identquest"), rs.getString("identanswer"), rs.getString("tier"), rs.getInt("point"));
			} else {
				System.out.println("@@ UserDAO - searchUserByCategory() 검색결과 없음");
			}
			
			rs.close();
			pstmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return user;
	}

	public int insertUser(UserVO user) {
		// sql 문 작성
		// con을 이용해서 pstmt 생성
		// execute
		// 영향받은 row 수 리턴

		String id = user.getId();
		String nickname = user.getNickname(); 
		String pw = user.getPw();
		String email = user.getEmail();
		String phone = user.getPhone();
		String identquest = user.getIdentquest();
		String identanswer = user.getIdentanswer();
		String tier = user.getTier();
		int point = user.getPoint();
		
		StringBuffer sql = new StringBuffer();
		sql.append("INSERT INTO users values(?, ?, ?, ?, ?, ?, ?, ?, ?)");
		
		int rows = 0;
		try {
			PreparedStatement pstmt = con.prepareStatement(sql.toString());
			pstmt.setString(1, id);
			pstmt.setString(2, nickname);
			pstmt.setString(3, pw);
			pstmt.setString(4, email);
			pstmt.setString(5, phone);
			pstmt.setString(6, identquest);
			pstmt.setString(7, identanswer);
			pstmt.setString(8, tier);
			pstmt.setInt(9, point);
			
			System.out.println("@@ 회원가입 pstmt = " + pstmt.toString());
			rows = pstmt.executeUpdate();
			
			pstmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return rows;
	}

	public int updateUser(UserVO user) {
		// sql 문 작성
		// con을 이용해서 pstmt 생성
		// execute
		// 영향받은 row 수 리턴

		String id = user.getId();
		String nickname = user.getNickname(); 
		String pw = user.getPw();
		String email = user.getEmail();
		String phone = user.getPhone();
		String identquest = user.getIdentquest();
		String identanswer = user.getIdentanswer();
		String tier = user.getTier();
		int point = user.getPoint();
		
		StringBuffer sql = new StringBuffer();
		sql.append("UPDATE users ");
		sql.append("SET nickname = ?, pw = ?, email = ?, phone = ?, ");
		sql.append("identquest = ?, identanswer = ?, tier = ?, point = ? WHERE id = ?");
		
		int rows = 0;
		try {
			PreparedStatement pstmt = con.prepareStatement(sql.toString());
			pstmt.setString(1, nickname);
			pstmt.setString(2, pw);
			pstmt.setString(3, email);
			pstmt.setString(4, phone);
			pstmt.setString(5, identquest);
			pstmt.setString(6, identanswer);
			pstmt.setString(7, tier);
			pstmt.setInt(8, point);
			pstmt.setString(9, id);
			
			System.out.println("@@ 회원 정보 수정 pstmt = " + pstmt.toString());
			rows = pstmt.executeUpdate();
			
			pstmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return rows;
	}

	public int deleteUser(String id) {
		// sql 문 작성
		// con을 이용해서 pstmt 생성
		// execute
		// 영향받은 row 수 리턴

		StringBuffer sql = new StringBuffer();
//		sql.append("INSERT INTO users values(?, ?, ?, ?, ?, ?, ?, ?)");
		sql.append("DELETE FROM users ");
		sql.append("WHERE id = ?");
		
		int rows = 0;
		try {
			PreparedStatement pstmt = con.prepareStatement(sql.toString());
			pstmt.setString(1, id);
			
			System.out.println("@@ 회원 정보 삭제 pstmt = " + pstmt.toString());
			rows = pstmt.executeUpdate();
			
			pstmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return rows;
	}

	public ObservableList<UserVO> selectUserList(String searchCategory, String searchWord) {
		// sql 문 작성
		// con을 이용해서 pstmt 생성
		// execute
		// user 데이터 리턴
		
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT * ");
		sql.append("FROM users ");
		sql.append("WHERE " + searchCategory + " LIKE ?");
		

		ObservableList<UserVO> list = FXCollections.observableArrayList();
		try {
			PreparedStatement pstmt = con.prepareStatement(sql.toString());
			pstmt.setString(1, "%" + searchWord + "%");
			System.out.println("@@ User 검색 pstmt = " + pstmt.toString());
			
			ResultSet rs = pstmt.executeQuery();
			
			while (rs.next()) {
				UserVO user = new UserVO(rs.getString("id"), rs.getString("nickname"), rs.getString("pw"), rs.getString("email"),
						rs.getString("phone"), rs.getString("identquest"), rs.getString("identanswer"), rs.getString("tier"), rs.getInt("point"));
				list.add(user);
			}
			
			rs.close();
			pstmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}

}
