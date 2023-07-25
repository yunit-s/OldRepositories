package springioc.sample1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class test {

	public static void main(String[] args) {
		
		// Applicatino Context부터 생성하자.
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml", MessageBean.class);
			// 맨 뒤에는 xml파일이 있는 위치의 힌트가 들어간다.
		
		System.out.println("===== IoC/DI 컨테이너 생성 =====");
		
		// singleton인 경우
		//		이미 context 안에 존재하는 Bean을 찾아서 리턴한다.
		// prototype인 경우
		//		이 시점에 Bean객체를 생성해서 리턴한다.
		MessageBean myBean = context.getBean("messageBean", MessageBean.class); // getBean(Bean id)
		
		myBean.sayHello(); // 출력 : 딸기, 3000
		
		System.out.println(myBean);
		System.out.println(context.getBean("messageBean", MessageBean.class));
		
		// resource 를 해제시켜야 한다.
		//		interface라서 close가 없다.
		//		casting 부터 해야 한다.
		((ClassPathXmlApplicationContext)context).close();
		
	}
}
