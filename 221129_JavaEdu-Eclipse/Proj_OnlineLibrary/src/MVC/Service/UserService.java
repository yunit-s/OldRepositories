package MVC.Service;

import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;

import MVC.DAO.BookDAO;
import MVC.DAO.DBCP_Apache;
import MVC.DAO.UserDAO;
import MVC.VO.BookVO;
import MVC.VO.UserVO;
import javafx.collections.ObservableList;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.ButtonBar.ButtonData;

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

	public int changePointToUserByReturndate(UserVO user, String returndate) {
		System.out.println("@@ userService.changePointToUserByReturndate() 실행");
		
		Connection con = null;
		try {
			con = DBCP_Apache.getDataSource().getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// 반납 날짜에 따른 포인트 계산
		LocalDate now = LocalDate.now();
		LocalDate deadline = LocalDate.parse(returndate);
		int userPointOld = user.getPoint();
		int userPointNew = user.getPoint();
		StringBuffer msg = new StringBuffer();
		msg.append("- 반납 완료 -");
		if (deadline.isAfter(now)) {
			userPointNew = userPointOld + 5;
			msg.append("\n기한 내 반납 완료 : +5 points");
		} else {
			userPointNew = userPointOld - 5;
			msg.append("\n반납 기한 만료 : -5 points");
		}
		if (userPointNew < 0) userPointNew = 0;
		user.setPoint(userPointNew);
		msg.append("\n현재 점수 : " + userPointNew + " point");
		
		// 티어 계산
		String userTierOld = user.getTier();
		String userTierNew = userTierOld;
		if (!userTierOld.equals("Admin")) {
			if (userPointNew >= 100) {
				userTierNew = "VIP";
			} else if (userPointNew >= 70) {
				userTierNew = "Platinum";
			} else if (userPointNew >= 40) {
				userTierNew = "Gold";
			} else if (userPointNew >= 20) {
				userTierNew = "Silver";
			} else {
				userTierNew = "Bronze";
			}
			if(!userTierNew.equals(userTierOld)) {
				msg.append("\n\n등급이 변동되었습니다. \n현재 등급 : " + userTierNew);
			}
		}
		user.setTier(userTierNew);
		
		// 안내메시지 출력
		Dialog<String> dialog = new Dialog<String>();
        dialog.setTitle("반납 완료");
        ButtonType typeOk= new ButtonType("확인", ButtonData.OK_DONE);
	    dialog.setContentText(msg.toString());
	    dialog.getDialogPane().getButtonTypes().add(typeOk);
	    dialog.showAndWait();
		
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

}
