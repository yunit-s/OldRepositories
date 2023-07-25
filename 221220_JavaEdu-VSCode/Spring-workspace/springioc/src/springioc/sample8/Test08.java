package springioc.sample8;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test08 {

	public static void main(String[] args) {
		
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml", DataBean.class);
		TestBean beanAuto = context.getBean("myObjAuto", TestBean.class);
		System.out.println(beanAuto.getData1());
		System.out.println(beanAuto.getData2());
	}
}

//
// 
/*
아까 data2 가 null 났던 거 뭐 수정한 거지?
xml 수동 설정한 거 왜 오류나지?
*/
