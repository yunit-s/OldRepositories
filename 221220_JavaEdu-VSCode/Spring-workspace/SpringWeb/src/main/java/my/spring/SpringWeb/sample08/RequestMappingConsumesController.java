package my.spring.SpringWeb.sample08;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class RequestMappingConsumesController {

	Logger log = LogManager.getLogger("case3");
	
	@RequestMapping(value="/testConsumesController1",
			method=RequestMethod.GET,
			consumes= { "application/json", "application/xml" })
	// consumes
	//		여기에는 여러 가지 정보를 입력해야 해서 배열로 입력한다.
	//		MIME type으로 표현한다.
	//			applictaion/json
	//				json이라는 의미
	//			applictaion/xml
	//				xml이라는 의미
	// Get 방식으로 보내면, Request 의 header 안에 content-type 정보가 없다.
	//		따라서 호출이 안 되어 415 Error가 발생한다.
	//			HTTP 상태 415 – 지원되지 않는 Media Type
	public String myMethod1() {
		log.debug("Get방식으로 호출. consumes 통과해서 myMethod1이 실행됨");
		
		return "/sample08/requestMappingConsumesView";
	}

	@RequestMapping(value="/testConsumesController2",
			method=RequestMethod.POST,
			consumes= { "application/json", "application/x-www-form-urlencoded" })
	// form 태그에 Post 방식으로 보낼 경우,
	//		Request Headers의 Content-Type 디폴트값
	//			application/x-www-form-urlencoded
	public String myMethod2() {
		log.debug("Post방식으로 호출. consumes 통과해서 myMethod2가 실행됨");
		
		return "/sample08/requestMappingConsumesView";
	}
	
}
