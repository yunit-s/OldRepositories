package springioc.anno.sample2;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestAnno02 {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml", Emp.class);
		Engineer empBean = context.getBean("engineer", Engineer.class);
		System.out.println(empBean);
	}
}
