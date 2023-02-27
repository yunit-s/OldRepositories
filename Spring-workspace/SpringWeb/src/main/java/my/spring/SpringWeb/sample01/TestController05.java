package my.spring.SpringWeb.sample01;

//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value="/testController05")
public class TestController05 {

//	private static final Logger logger = LoggerFactory.getLogger(TestController05.class);
	
	@GetMapping(params="myName")
		// 파라미터에 myName 이 있어야만 호출되도록 한다.
		// 접속 URL : http://localhost:8080/SpringWeb/testController05?myName=홍길동
	String myMethod1() {
//		logger.debug("testController05 (@GetMapping) 호출 - params=myName");
		return "sample01/testController05";
	}
	
	@GetMapping(params="myName=신사임당")
		// 파라미터에 myName=신사임당 이 있어야만 호출되도록 한다.
		// 접속 URL : http://localhost:8080/SpringWeb/testController05?myName=신사임당
		// myMethod1 에도 조건이 부합하지만, 더 세세한 정보로 세팅된 경우에 우선순위가 있다.
		//		보통 이렇게 헷갈리게 코딩하지는 않는다.
	String myMethod2() {
//		logger.debug("testController05 (@GetMapping) 호출 - params=(myName=신사임당)");
		return "sample01/testController05";
	}
}
