package springioc.sample6;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

	public static void main(String[] args) {
		
		// Application Context 생성
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml", Output.class);
		
		MessageBean bean = context.getBean("myBeanConsole", MessageBean.class); // 뒤에 나오는 class는 casting할 데이터 타입
		bean.sayHello(); // 설정에 따라 console에 출력할 수도 있고, file에 출력할 수도 있다.

		MessageBean beanFile = context.getBean("myBeanFile", MessageBean.class);
		beanFile.sayHello();
		MessageBean beanFile2 = context.getBean("myBeanFile2", MessageBean.class);
		beanFile2.sayHello();
		MessageBean beanFile3 = context.getBean("myBeanFile3", MessageBean.class);
		beanFile3.sayHello();
		MessageBean beanFile4 = context.getBean("myBeanFile4", MessageBean.class);
		beanFile4.sayHello();
		
		// memory leak 방지
		((ClassPathXmlApplicationContext)context).close();
	}
}
