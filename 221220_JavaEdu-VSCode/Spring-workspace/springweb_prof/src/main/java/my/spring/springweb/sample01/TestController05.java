package my.spring.springweb.sample01;

//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value="/testController05")
public class TestController05 {

//	private static final Logger logger = 
//			LoggerFactory.getLogger(TestController05.class);
	
	@GetMapping(params="myName")
	String myMethod1() {
//		logger.debug("testController05 호출호출!! - myName");
		return "sample01/testController05";
	}
	
	@GetMapping(params="myName=신사임당")
	String myMethod2() {
//		logger.debug("testController05 호출호출!! - myName=신사임당");
		return "sample01/testController05";
	}
	
}
