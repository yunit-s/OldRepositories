package MVC.Service;

import java.sql.Connection;
import java.sql.SQLException;

import MVC.DAO.BookDAO;
import MVC.DAO.DBCP_Apache;
import MVC.DAO.UserDAO;
import MVC.VO.BookVO;
import MVC.VO.UserVO;
import javafx.collections.ObservableList;

public class UserService {

//	public boolean Login(String id, String pw) {
//		// TODO Auto-generated method stub
////		System.out.println("@@ userService.login() 실행");
//		
//		Connection con = null;
//		try {
//			con = DBCP_Apache.getDataSource().getConnection();
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		UserDAO userDao = new UserDAO(con);
//		String userPw = userDao.getPassword(id);
//		
//		boolean result = false;
//		if (pw.equals(userPw)) {
//			// 비밀번호 일치. 로그인 성공
//			System.out.println("@@ 비밀번호 일치");
//			result = true;
//		}
//		
//		try {
//			con.close();
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		return result;
//	}
	
	public UserVO userLogin(String id, String pw) {
		System.out.println("@@ userService.login() 실행");
		
		Connection con = null;
		try {
			con = DBCP_Apache.getDataSource().getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		UserDAO userDao = new UserDAO(con);
		UserVO user = userDao.searchUserByCategory("id", id);
				
		try {
			con.close();
			if (user.getPw().equals(pw)) {
				// 비밀번호 일치. 로그인 성공
				return user;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
		
	}

	public UserVO getUserById(String id) {
		System.out.println("@@ userService.getUserById() 실행");
		
		Connection con = null;
		try {
			con = DBCP_Apache.getDataSource().getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		UserDAO userDao = new UserDAO(con);
		UserVO user = userDao.searchUserByCategory("id", id);
				
		try {
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return user;
	}

	public int addNewuser(UserVO user) {
		System.out.println("@@ userService.addNewuser() 실행");
		
		Connection con = null;
		try {
			con = DBCP_Apache.getDataSource().getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		UserDAO userDao = new UserDAO(con);
		int rows = userDao.insertUser(user);
		
		try {
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return rows;
	}

	public int editUserByUserVO(UserVO user) {
		System.out.println("@@ userService.editUserByUserVO() 실행");
		
		Connection con = null;
		try {
			con = DBCP_Apache.getDataSource().getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		UserDAO userDao = new UserDAO(con);
		int rows = userDao.updateUser(user);
		
		try {
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return rows;
	}

	public int deleteUser(String id) {
		System.out.println("@@ userService.deleteUser() 실행");
		
		Connection con = null;
		try {
			con = DBCP_Apache.getDataSource().getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		UserDAO userDao = new UserDAO(con);
		int rows = userDao.deleteUser(id);
		
		try {
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return rows;
	}

	public ObservableList<UserVO> searchUser(String searchCategory, String searchWord) {

		Connection con = null;
		try {
			con = DBCP_Apache.getDataSource().getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// dao에서 select 실행
		UserDAO userDao = new UserDAO(con);
		ObservableList<UserVO> list = userDao.selectUserList(searchCategory, searchWord);

		try {
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}

}
