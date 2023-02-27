package my.spring.SpringWeb.sample03;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LogTestController {

	Logger log = LogManager.getLogger("case3");
		// log4j2.xml 에서 설정한 case1 logger를 활용한다.
	
	@RequestMapping(value = "/log1")
	public String myMethod1() {
	
		log.debug("소리없는 아우성");
		return "sample03/logView";
	}
}
