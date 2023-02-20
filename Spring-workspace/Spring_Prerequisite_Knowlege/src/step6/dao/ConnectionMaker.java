package step6.dao;

import java.sql.Connection;

public interface ConnectionMaker {

	// interface니까 여기에는 추상 메소드만 들어갈 수 있다.
	Connection getConnection() throws Exception;
	
}
