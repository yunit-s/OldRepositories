package lecture.jdbc.di.step3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

// step3의 문제점
// 만약 KosaUserDAO 가 다른 클래스를 또 상속해야 한다면?
// Java는 단일상속만 지원하기 때문에 이미 다른 class를 상속하고 있다면, 우리의 UserDAO를 상속할 수 없다.
public class KosaUserDAO extends UserDAO {

	@Override
	protected Connection getConnection() {
		// TODO Auto-generated method stub
		// 자기 나름대로의 데이터베이스 준비 코드를 넣어주면 된다.
		// connection을 리턴하는 코드를 작성하면 된다.

		Connection con = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			String jdbc_url = "jdbc:mysql://127.0.0.1:3306/example01?characterEncoding=UTF-8&serverTimezone=UTC&useSSL=false&allowPublicKeyRetrieval=true";
			String id = "root";
			String pw = "qwer1234";
			
			con = DriverManager.getConnection(jdbc_url, id, pw);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return con;
	}

}
