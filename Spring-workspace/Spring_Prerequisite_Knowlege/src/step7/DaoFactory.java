package step7;

import step7.dao.ConnectionMaker;
import step7.dao.SimpleMakeConnection;
import step7.dao.UserDao;

public class DaoFactory {

	public UserDao userDao() {
		System.out.println("!! DaoFactory.userDao() 실행");
		
		UserDao dao = new UserDao(new SimpleMakeConnection());
		return dao;
	}
	
	public ConnectionMaker connectionMaker() {
		System.out.println("!! DaoFactory.connectionMaker() 실행");
		
		return new SimpleMakeConnection();
	}
}
