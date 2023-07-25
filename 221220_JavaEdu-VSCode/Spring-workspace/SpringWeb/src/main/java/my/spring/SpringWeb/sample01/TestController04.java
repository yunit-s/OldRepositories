package my.spring.SpringWeb.sample01;

//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

// 일반적으로 @RequestMapping 은 class level에서 사용한다.

@Controller
@RequestMapping(value="testController04")
public class TestController04 {

//	private static final Logger logger = LoggerFactory.getLogger(TestController04.class);

	// 접속 URL : http://localhost:8080/SpringWeb/testController04	
	@GetMapping
		// 이 리퀘스트 맵핑을 통해서 들어왔을 때, GET 방식으로 호출된 경우 여기로 온다.
		// method=RequestMethod.GET 이 방식으로도 동작은 되는데, 실제로 잘 안 쓰임
	String myMethod1() {
//		logger.debug("/testController04 (@GetMapping) 호출");
		return "sample01/testController04";
	}

	// 접속 URL : http://localhost:8080/SpringWeb/testController04/test001
	@GetMapping(value="/test001")
	String myMethod2() {
//		logger.debug("/testController04/test001 (@GetMapping) 호출");
		return "sample01/testController04";
	}
}
