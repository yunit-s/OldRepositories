package my.spring.springweb.sample01;

//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

// 일반적으로 @RequestMapping은 class level에서 사용해요!

@Controller
@RequestMapping(value="testController04")
public class TestController04 {

//	private static final Logger logger = LoggerFactory.getLogger(TestController04.class);
	
	@GetMapping
	String MyMethod01() {
//		logger.debug("testController04 - GET 호출되었어요!");
		return "sample01/testController04";
	}

	@GetMapping(value="/test001")
	String MyMethod03() {
//		logger.debug("testController04/test001 - GET 호출되었어요!");
		return "sample01/testController04";
	}
	
	@PostMapping
	String MyMethod02() {
//		logger.debug("testController04 - POST 호출되었어요!");
		return "sample01/testController04";
	}
	
}




