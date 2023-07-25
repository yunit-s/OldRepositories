package step9;

import step9.dao.ConnectionMaker;
import step9.dao.SimpleMakeConnection;
import step9.dao.UserDao;

//@Configuration
public class DaoFactory {

//	@Bean
	public UserDao userDao() {
		
//		UserDao dao = new UserDao(new SimpleMakeConnection());
		UserDao dao = new UserDao();
		dao.setConnectionMaker(connectionMaker());
		return dao;
	}
	
//	@Bean
	public ConnectionMaker connectionMaker() {
		return new SimpleMakeConnection();
	}
}
