package my.spring.SpringWeb.sample01;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/testController02")
public class TestController02 {

	private static final Logger logger = LoggerFactory.getLogger(TestController02.class);
	
	@RequestMapping("/info")
		// 계층구조로써, 이 메소드는 /testController02/info 로 접근해야 한다.
	String myMethod1() {
		logger.debug("/testController02/info 호출");
		return "sample01/testController02";
	}
	
	@RequestMapping("/profile")
	String myMethod2() {
		logger.debug("/testController02/profile 호출");
		return "sample01/testController02";
	}
	
	// 이걸 다 수동으로 입력해야할까? 아니다
	// 하나의 핸들러가 여러 개의 url에 대해 처리할 수 있다.
	// 아래같은 경우 접속 가능한 url
	//		http://localhost:8080/SpringWeb/testController02/
	//		http://localhost:8080/SpringWeb/testController02/test01
	//		http://localhost:8080/SpringWeb/testController02/test01/
	//		http://localhost:8080/SpringWeb/testController02/test02
	//		http://localhost:8080/SpringWeb/testController02/test02/
	//		http://localhost:8080/SpringWeb/testController02/test03/
	//		http://localhost:8080/SpringWeb/testController02/test03/1
	// 이거는 안 된다.
	//		http://localhost:8080/SpringWeb/testController02/test03
	@RequestMapping(value= {"", "/test01", "test02", "test03/*"})
	String myMethod3() {
		logger.debug("/testController02/ 멀티 호출");
		return "sample01/testController02";
	}
}
