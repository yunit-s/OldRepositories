package my.spring.SpringWeb.sample07;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import my.spring.SpringWeb.sample07.vo.Student;

@Controller
@SessionAttributes(value={"data1"}) // value는 써도 되지만 안 써도 된다.
	// data1이라는 key값으로 Model 객체에 저장할 때, 그 데이터를 session에도 저장하겠다는 의미
@RequestMapping("sessionAttributesTest02")
public class SessionAttributesController02 {

	Logger log = LogManager.getLogger("case3");
	
	// handler가 호출되기 이전에 아래의 메소드가 호출된다.
	// data1이라는 key로 메소드의 리턴값이 Model에 자동으로 저장된다.
	@ModelAttribute("data1")
	public String createString1() {
		log.debug("SessionAttributesController02.createString1() 호출");
		return "createString1";
	}
	
	@ModelAttribute("data2")
	public String createString2(HttpServletRequest request) {
		log.debug("SessionAttributesController02.createString2() 호출");

		// session 직접 이용하기
		HttpSession session = request.getSession(true);
			// true
			//		클라이언트 세션이 없으면 만들고 reference를 가져온다.
			//		클라이언트 세션이 있으면 reference만 가져온다.
		
		Student student = new Student(30, "신사임당", "국어국문");
		session.setAttribute("shin", student);
		return "createString2";
	}
	
	@PostMapping
	public String handler(@ModelAttribute("data1") String str1,
			@ModelAttribute("data2") String str2,
			@RequestParam(value="msg") String requestMsg,
			@ModelAttribute("newStudent") Student studentVO,
			Model model) {
		
		log.debug("handler() 호출. 출력 : " + str1 + ", " + str2);
		log.debug("msg : " + requestMsg);
		log.debug("student : " + studentVO);
		
		return "sample07/sessionResult02";
	}
}
