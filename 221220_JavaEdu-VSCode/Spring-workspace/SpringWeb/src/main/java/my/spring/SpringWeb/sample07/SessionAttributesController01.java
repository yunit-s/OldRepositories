package my.spring.SpringWeb.sample07;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import my.spring.SpringWeb.sample07.vo.Student;

@Controller
@SessionAttributes(value={"data1"}) // value는 써도 되지만 안 써도 된다.
	// data1이라는 key값으로 Model 객체에 저장할 때, 그 데이터를 session에도 저장하겠다는 의미
@RequestMapping("sessionAttributesTest01")
public class SessionAttributesController01 {

	Logger log = LogManager.getLogger("case3");
	
	// handler가 호출되기 이전에 아래의 메소드가 호출된다.
	// data1이라는 key로 메소드의 리턴값이 Model에 자동으로 저장된다.
	@ModelAttribute("data1")
	public String createString1() {
		log.debug("SessionAttributesController01.createString1() 호출");
		return "createString1";
	}
	
	@ModelAttribute("data2")
	public String createString2() {
		log.debug("SessionAttributesController01.createString2() 호출");
		return "createString2";
	}
	
	@PostMapping
	public String handler(@ModelAttribute("data1") String str1,
			@ModelAttribute("data2") String str2,
			@RequestParam(value="msg") String requestMsg,
			@ModelAttribute("newStudent") Student studentVO) {
		
		log.debug("handler() 호출. 출력 : " + str1 + ", " + str2);
		log.debug("msg : " + requestMsg);
		log.debug("student : " + studentVO);
		
		return "sample07/sessionResult01";
	}
}
