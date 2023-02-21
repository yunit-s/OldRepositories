package springioc.sample3;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

	public static void main(String[] args) {

		// Application Context 객체를 생성 -> Spring IoC Container 생성
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml", User.class);
			// 뒤에 있는 User.class 는 단지 힌트일 뿐이다.
			//		.xml 파일을 찾을 수 있는 곳에 대한 힌트를 주는 것.
			//		User.class 가 있는 폴더에서 찾아라! 라는 의미가 된다.
		
		UserService service = context.getBean("userService", UserService.class);
		User user = context.getBean("obj1", User.class);
		service.addUser(user);
		
		((ClassPathXmlApplicationContext)context).close();
	}
}
