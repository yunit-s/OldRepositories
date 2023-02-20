package step7;

import step7.dao.ConnectionMaker;
import step7.dao.SimpleMakeConnection;
import step7.dao.UserDao;

public class DaoFactory {

	public UserDao userDao() {
		
		UserDao dao = new UserDao(new SimpleMakeConnection());
		
		return dao;
	}
	
	public ConnectionMaker connectionMaker() {
		return new SimpleMakeConnection();
	}
}
