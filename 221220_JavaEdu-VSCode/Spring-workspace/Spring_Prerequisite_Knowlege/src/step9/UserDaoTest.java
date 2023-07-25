package step9;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import step9.dao.UserDao;
import step9.vo.User;

public class UserDaoTest {

	public static void main(String[] args) throws Exception {
		
		// 1. 사용자 VO 생성
		System.out.println("1. 사용자 VO 생성");
		User user = new User();
		user.setId("hong");
		user.setPassword("1234");
		user.setName("홍길동");
		
		// 2. DAO 생성
		System.out.println("2. DAO 생성");
//		ApplicationContext context = new AnnotationConfigApplicationContext(DaoFactory.class);
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml", UserDao.class);
		UserDao dao = context.getBean("userDao", UserDao.class);
		System.out.println(dao);
		
		// 3. 사용자 데이터 삭제 후 입력
		System.out.println("3. 사용자 데이터 삭제 후 입력");
		dao.delete();
		dao.insert(user);
		System.out.println("사용자 등록성공!");
		
		// 4. 사용자 조회
		System.out.println("4. 사용자 조회");
		User result = dao.select("hong");
		System.out.println(result.getName()); // 홍길동
		
	}
}
