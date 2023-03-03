package my.spring.springweb.sample08;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class RequestMappingConsumesController {

	Logger log = LogManager.getLogger("case3");

	@RequestMapping(value = "/testController1", method = RequestMethod.GET, consumes = { "application/json",
			"application/xml" })
	public String myMethod1() {

		log.debug("GET방식으로 호출되었어요!");

		return null;
	}

	@RequestMapping(value = "/testController2", 
			        method = RequestMethod.POST, 
			        consumes = { "application/json", "application/x-www-form-urlencoded" })
	public String myMethod2() {

		log.debug("POST방식으로 호출되었어요!");

		return null;
	}

}
