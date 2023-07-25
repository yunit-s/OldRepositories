package my.spring.SpringWeb.common;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
public class ApplicationContextProvider implements ApplicationContextAware {

	// 어디서든 접근할 수 있도록 static으로 잡는다.
	private static ApplicationContext ctx;

	public static ApplicationContext getApplicationContext() {
		// 왜 static이죠..? ㅍㅍㅍㅍㅍㅍㅍㅍㅍㅍㅍ
		return ctx;
	}

	// 이 클래스가 Bean으로 등록되는 순간 아래 메소드가 자동으로 호출된다.
	//		이를 통해 ctx 필드가 초기화된다.
	//		이후에는 getter를 사용하면 어디서든 ctx의 레퍼런스를 확보할 수 있게 된다.
	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		// TODO Auto-generated method stub
		// 인자로 들어오는 게 root application context다. 쉽게 말해서 spring application context다.
		//
		this.ctx = applicationContext;
	}
	
}



























// 안녕 이윤형!
// 이따 같이 밥먹으러 가자!
// 친하게 지내고 싶어!

