package step3;

import step3.dao.NUserDao;
import step3.dao.UserDao;
import step3.vo.User;

public class UserDaoTest {

	public static void main(String[] args) throws Exception {
		
		// 1. 사용자 VO 생성
		User user = new User();
		user.setId("hong");
		user.setPassword("1234");
		user.setName("홍길동");
		
		// 2. DAO 생성
		UserDao dao = new NUserDao();
		
		// 3. 사용자 입력
		dao.insert(user);
		System.out.println("사용자 등록성공!");
		
		// 4. 사용자 조회
		User result = dao.select("hong");
		System.out.println(result.getName()); // 홍길동
		
	}
}