package my.spring.SpringWeb.sample01;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class TestController01 {

	private static final Logger logger = LoggerFactory.getLogger(TestController01.class);
	
	// 접속 URL : http://localhost:8080/SpringWeb/testController01
	// value에 '/' 을 빼고 적어도 된다. 안 써도, context route 다음에 자동으로 '/'를 붙여주기 때문.
	//		교수님은 가독성 좋게 하기 위해 적어주셨다.
	@RequestMapping(value="/testController01", method=RequestMethod.GET)
	String myMethod() {
		logger.debug("TestController01.myMethod() 호출");
		return "sample01/testController01";
			// 핸들러가 myMethod()를 실행한 뒤, 핸들러 어쩌구한테 리턴해줘
			// 그러면 이걸 디스패처한테 넘겨주고,
			// 디스패처는 이 문자열을 가지고 view를 만들어
	}
}
