package step8.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import step8.vo.User;

// Database처리하는 코드
// 2개의 method를 작성할꺼예요!
// 사용자 입력, 조회
public class UserDao {

	// 이번엔 interface를 활용해보자.
	ConnectionMaker connectionMaker;

	// Injection 이 발생했다.
	// Injection은 생성자를 통한 주입이 있고, setter를 통한 주입이 있다.
	//		spring에서는 setter를 통한 주입을 좀 더 선호한다.
	public UserDao(ConnectionMaker connectionMaker) {
//		super();
		this.connectionMaker = connectionMaker;
		// 이 클래스도 Bean이다. Bean의 생성자 호출을 출력해보자.
		System.out.println("UserDao 생성자 호출됨");
	}
	
	public void insert(User user) throws Exception {
		
		// pure JDBC를 이용해서 Database처리를 해 보아요!
		// 6단계로 처리를 해요!
		
		Connection con = connectionMaker.getConnection();
		
		// 3. PreparedStatemenet를 만들어요!
		String sql = "INSERT INTO users VALUES (?, ?, ?)";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, user.getId());
		pstmt.setString(2, user.getPassword());
		pstmt.setString(3, user.getName());
		
		// 4. SQL구문 실행
		int result = pstmt.executeUpdate();
		
		// 5. 결과처리
		if(result == 1) {
			System.out.println("정상적으로 입력되었어요!");
		}
		
		// 6. resource 해제
		pstmt.close();
		con.close();
	}
	
	public User select(String userId) throws Exception {
		// pure JDBC를 이용해서 Database처리를 해 보아요!
		// 6단계로 처리를 해요!
		
		Connection con = connectionMaker.getConnection();
		
		// 3. PreparedStatemenet를 만들어요!
		String sql = "SELECT * FROM users WHERE id = ?";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, userId);
		
		// 4. SQL구문 실행
		ResultSet result = pstmt.executeQuery();
		
		// 5. 결과처리
		result.next();
		User user = new User();
		user.setId(result.getString("id"));
		user.setPassword(result.getString("password"));
		user.setName(result.getString("name"));
		
		// 6. resource 해제
		pstmt.close();
		con.close();
		
		return user;
	}
	
}
