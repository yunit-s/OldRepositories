package step7;

import step7.dao.UserDao;
import step7.vo.User;

public class UserDaoTest {

	public static void main(String[] args) throws Exception {
		
		// 1. 사용자 VO 생성
		User user = new User();
		user.setId("hong");
		user.setPassword("1234");
		user.setName("홍길동");
		
//		ConnectionMaker connectionMaker = new SimpleMakeConnection();
		
		// 2. DAO 생성
//		UserDao dao = new UserDao(connectionMaker);
		
		UserDao dao = new DaoFactory().userDao();
			// DaoFactory()가 어떤 클래스를 이용해서 객체를 만들 지를 결정하기 때문에, 제어권이 바뀌었다고 해서 제어의 역전(IoC)라고 한다.
		
		// 3. 사용자 입력
		dao.insert(user);
		System.out.println("사용자 등록성공!");
		
		// 4. 사용자 조회
		User result = dao.select("hong");
		System.out.println(result.getName()); // 홍길동
		
	}
}
