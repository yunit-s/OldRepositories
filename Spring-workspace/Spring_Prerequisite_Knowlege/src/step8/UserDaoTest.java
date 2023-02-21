package step8;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import step8.dao.UserDao;
import step8.vo.User;

public class UserDaoTest {

	public static void main(String[] args) throws Exception {
		
		// 1. 사용자 VO 생성
		User user = new User();
		user.setId("hong");
		user.setPassword("1234");
		user.setName("홍길동");
		
		// 2. DAO 생성
//		UserDao dao = new DaoFactory().userDao();
		
		// step8 변경사항
		// Application Context를 생성한 후 이 Application Context에게 UserDao객체를 요청해서 받아와서 사용할 예정
		ApplicationContext context = new AnnotationConfigApplicationContext(DaoFactory.class);
		// Application Context로부터 Bean 객체 하나 받아오기
//		UserDao dao = (UserDao)context.getBean(""); // Object 타입으로 리턴되기 때문에 casting해야한다.
			// 그러면 맨날 casting을 명시해줘야할까?
			// 아니다. 일반적으로 이렇게 안 한다. 아예 class 타입을 인자로 넘겨준다.
		UserDao dao = context.getBean("userDao", UserDao.class);
		UserDao dao2 = context.getBean("userDao", UserDao.class);
		System.out.println(dao);
		System.out.println(dao2); // 지금은 Bean이 singleton으로 되어 있기 때문에 dao와 dao2가 동일한 bean을 가리킨다.
			// 원래 싱글톤은 비정상적인 클래스로 만들어야 동작되는 건데,
			//		application contxet는 일반 클래스를 싱글톤으로 만들어준다. 이거 굉장시 독특한 거야.
		
		// 3. 사용자 입력
		dao.insert(user);
		System.out.println("사용자 등록성공!");
		
		// 4. 사용자 조회
		User result = dao.select("hong");
		System.out.println(result.getName()); // 홍길동
		
	}
}
