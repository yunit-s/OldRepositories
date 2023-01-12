package MVC.DAO;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import MVC.VO.SearchObjectVO;
import MVC.VO.UserVO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class UserDAO {

	SqlSession session;
	
	public UserDAO(SqlSession session) {
		this.session = session;
	}

	public ObservableList<UserVO> selectUserList_mybatis(SearchObjectVO searchObjectVO) {
		System.out.println("@@ UserDAO.selectUserList_mybatis() 실행");
		
		List<UserVO> list = session.selectList("OnlineLibrary.UserXml.selectUsersByCategoryUserVO", searchObjectVO);
		ObservableList<UserVO> oList = FXCollections.observableArrayList(list);
		return oList;
	}

	public UserVO searchUserByCategory_mybatis(String searchWord) {
		System.out.println("@@ UserDAO.searchUserByCategory_mybatis() 실행");
		
		UserVO user = session.selectOne("OnlineLibrary.UserXml.selectUsersByIdUserVOMap", searchWord);
		return user;
	}
	
	public int insertUser_mybatis(UserVO user) {
		System.out.println("@@ UserDAO.insertUser_mybatis() 실행");
		
		int rows = session.insert("OnlineLibrary.UserXml.insertUserOne", user);
		return rows;
	}
	
	public int updateUser_mybatis(UserVO user) {
		System.out.println("@@ UserDAO.updateUser_mybatis() 실행");
		
		int rows = session.update("OnlineLibrary.UserXml.updateUserOne", user);
		return rows;
	}

	public int deleteUser_mybatis(String id) {
		System.out.println("@@ UserDAO.deleteUser_mybatis() 실행");
		
		int rows = session.update("OnlineLibrary.UserXml.deleteUserOne", id);
		return rows;
	}
	
}
