package MVC.Service;

import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import MVC.DAO.BookDAO;
import MVC.DAO.DBCP_Apache;
import MVC.DAO.UserDAO;
import MVC.MyBatis.MyBatisConnectionFactory;
import MVC.VO.BookVO;
import MVC.VO.SearchObjectVO;
import MVC.VO.UserVO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.ButtonBar.ButtonData;

public class UserService {

	private SqlSessionFactory factory;
	
	public UserService() {
		factory = MyBatisConnectionFactory.getSqlSessionFactory();
	}
	
	public UserVO userLogin_mybatis(String id, String pw) {
		System.out.println("@@ UserService.userLogin_mybatis() 실행");
		
		SqlSession session = null;
		UserDAO userDao = null;
		UserVO user = null;
		try {
			session = factory.openSession();
			userDao = new UserDAO(session);
			user = userDao.searchUserByCategory_mybatis(id);
			if (user.getPw().equals(pw)) {
				// 비밀번호 일치. 로그인 성공
				return user;
			}
		} catch (Exception e) {
			System.out.println("@@@ userLogin_mybatis() 오류");
		} finally {
			session.close();
		}
		return null;
	}
	
//	public UserVO userLogin(String id, String pw) {
//		System.out.println("@@ userService.login() 실행");
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
//		UserVO user = userDao.searchUserByCategory("id", id);
//				
//		try {
//			con.close();
//			if (user.getPw().equals(pw)) {
//				// 비밀번호 일치. 로그인 성공
//				return user;
//			}
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		return null;
//		
//	}

	public UserVO getUserById_mybatis(String id) {
		System.out.println("@@ UserService.getUserById_mybatis() 실행");
		
		SqlSession session = null;
		UserDAO userDao = null;
		UserVO user = null;
		try {
			session = factory.openSession();
			userDao = new UserDAO(session);
			user = userDao.searchUserByCategory_mybatis(id);
			return user;
		} catch (Exception e) {
			System.out.println("@@@ getUserById_mybatis() 오류");
		} finally {
			session.close();
		}
		return null;
	}
	
//	public UserVO getUserById(String id) {
//		System.out.println("@@ userService.getUserById() 실행");
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
//		UserVO user = userDao.searchUserByCategory_mybatis(id);
//				
//		try {
//			con.close();
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		return user;
//	}

	public int addNewuser_mybatis(UserVO user) {
		System.out.println("@@ UserService.addNewuser_mybatis() 실행");
		
		SqlSession session = null;
		UserDAO userDao = null;
		int rows = 0;
		try {
			session = factory.openSession();
			userDao = new UserDAO(session);
			rows = userDao.insertUser_mybatis(user);
			if (rows == 1)
				session.commit();
		} catch (Exception e) {
			System.out.println("@@@ rollback");
			session.rollback();
		} finally {
			session.close();
		}
		return rows;
	}
	
//	public int addNewuser(UserVO user) {
//		System.out.println("@@ userService.addNewuser() 실행");
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
//		int rows = userDao.insertUser(user);
//		
//		try {
//			con.close();
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		return rows;
//	}
	
	public int editUserByUserVO_mybatis(UserVO user) {
		System.out.println("@@ UserService.editUserByUserVO_mybatis() 실행");

		SqlSession session = null;
		UserDAO userDao = null;
		int rows = 0;
		try {
			session = factory.openSession();
			userDao = new UserDAO(session);
			rows = userDao.updateUser_mybatis(user);
			if (rows == 1)
				session.commit();
		} catch (Exception e) {
			System.out.println("@@@ rollback");
			session.rollback();
		} finally {
			session.close();
		}
		return rows;
	}

//	public int editUserByUserVO(UserVO user) {
//		System.out.println("@@ userService.editUserByUserVO() 실행");
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
//		int rows = userDao.updateUser(user);
//		
//		try {
//			con.close();
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		return rows;
//	}

	public int deleteUser_mybatis(String id) {
		System.out.println("@@ UserService.deleteUser_mybatis() 실행");

		SqlSession session = null;
		UserDAO userDao = null;
		int rows = 0;
		try {
			session = factory.openSession();
			userDao = new UserDAO(session);
			rows = userDao.deleteUser_mybatis(id);
			if (rows == 1)
				session.commit();
		} catch (Exception e) {
			System.out.println("@@@ rollback");
			session.rollback();
		} finally {
			session.close();
		}
		return rows;
	}
	
//	public int deleteUser(String id) {
//		System.out.println("@@ userService.deleteUser() 실행");
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
//		int rows = userDao.deleteUser(id);
//		
//		try {
//			con.close();
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		return rows;
//	}

	public ObservableList<UserVO> searchUser_mybatis(String searchCategory, String searchWord) {
		System.out.println("@@ UserService.searchUser_mybatis() 실행");
		
		SqlSession session = null;
		ObservableList<UserVO> list = FXCollections.observableArrayList();
		UserDAO userDao = null;
		SearchObjectVO searchObjectVO = null;
		try {
			session = factory.openSession();
			userDao = new UserDAO(session);
			// category에 따라 다른 검색 결과를 위해 만든 점색 전용 Object
			searchObjectVO = new SearchObjectVO(searchCategory, "%" + searchWord + "%");
			list = userDao.selectUserList_mybatis(searchObjectVO);
			return list;
		} catch (Exception e) {
			System.out.println("@@@ searchUser_mybatis() 오류");
		} finally {
			session.close();
		}
		return null;
	}

//	public ObservableList<UserVO> searchUser(String searchCategory, String searchWord) {
//
//		Connection con = null;
//		try {
//			con = DBCP_Apache.getDataSource().getConnection();
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//
//		// dao에서 select 실행
//		UserDAO userDao = new UserDAO(con);
//		ObservableList<UserVO> list = userDao.selectUserList(searchCategory, searchWord);
//
//		try {
//			con.close();
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		return list;
//	}

	public int changePointToUserByReturndate_mybatis(UserVO user, String returndate) {
		System.out.println("@@ UserService.changePointToUserByReturndate_mybatis() 실행");
		
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
		
		SqlSession session = null;
		UserDAO userDao = null;
		int rows = 0;
		try {
			session = factory.openSession();
			userDao = new UserDAO(session);
			rows = userDao.updateUser_mybatis(user);
			if (rows == 1)
				session.commit();
		} catch (Exception e) {
			System.out.println("@@@ rollback");
			session.rollback();
		} finally {
			session.close();
		}
		return rows;
	}
	
//	public int changePointToUserByReturndate(UserVO user, String returndate) {
//		System.out.println("@@ userService.changePointToUserByReturndate() 실행");
//		
//		Connection con = null;
//		try {
//			con = DBCP_Apache.getDataSource().getConnection();
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		// 반납 날짜에 따른 포인트 계산
//		LocalDate now = LocalDate.now();
//		LocalDate deadline = LocalDate.parse(returndate);
//		int userPointOld = user.getPoint();
//		int userPointNew = user.getPoint();
//		StringBuffer msg = new StringBuffer();
//		msg.append("- 반납 완료 -");
//		if (deadline.isAfter(now)) {
//			userPointNew = userPointOld + 5;
//			msg.append("\n기한 내 반납 완료 : +5 points");
//		} else {
//			userPointNew = userPointOld - 5;
//			msg.append("\n반납 기한 만료 : -5 points");
//		}
//		if (userPointNew < 0) userPointNew = 0;
//		user.setPoint(userPointNew);
//		msg.append("\n현재 점수 : " + userPointNew + " point");
//		
//		// 티어 계산
//		String userTierOld = user.getTier();
//		String userTierNew = userTierOld;
//		if (!userTierOld.equals("Admin")) {
//			if (userPointNew >= 100) {
//				userTierNew = "VIP";
//			} else if (userPointNew >= 70) {
//				userTierNew = "Platinum";
//			} else if (userPointNew >= 40) {
//				userTierNew = "Gold";
//			} else if (userPointNew >= 20) {
//				userTierNew = "Silver";
//			} else {
//				userTierNew = "Bronze";
//			}
//			if(!userTierNew.equals(userTierOld)) {
//				msg.append("\n\n등급이 변동되었습니다. \n현재 등급 : " + userTierNew);
//			}
//		}
//		user.setTier(userTierNew);
//		
//		// 안내메시지 출력
//		Dialog<String> dialog = new Dialog<String>();
//		dialog.setTitle("반납 완료");
//		ButtonType typeOk= new ButtonType("확인", ButtonData.OK_DONE);
//		dialog.setContentText(msg.toString());
//		dialog.getDialogPane().getButtonTypes().add(typeOk);
//		dialog.showAndWait();
//		
//		UserDAO userDao = new UserDAO(con);
//		int rows = userDao.updateUser_mybatis(user);
//		
//		try {
//			con.close();
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		return rows;
//	}

}
