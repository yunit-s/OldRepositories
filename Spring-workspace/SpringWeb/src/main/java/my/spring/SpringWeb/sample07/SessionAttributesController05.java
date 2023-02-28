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
@SessionAttributes(value={"data1", "shin", "newStudent"}) // value는 써도 되지만 안 써도 된다.
	// data1이라는 key값으로 Model 객체에 저장할 때, 그 데이터를 session에도 저장하겠다는 의미
	// 간단하게 생각하면, 이 기능은 데이터를 모델에만 저장하지 말고 세션에도 저장해줘! 라는 의미로 받아들이면 된다.
	// 그런데 newStudent는 왜 안 될까?
	//		method 위에 붙어있는 @ModelAttribute
	//		인자로 쓰는 @ModelAttribute는 클라이언트가 주는 데이터를 받아서 Command객체를 만들어서 model에 저장한다 는 의미인데,
	//			이 시점에 이미 session에 newStudent가 존재한다.
	//			이미 session에 데이터가 존재할 경우, session에서 자동으로 데이터를 가져오게 된다.
	//			Command 객체를 만들지 않게 되는 것.
	//			그런데 아직 session에 newStudent 데이터가 없기 때문에,
	//				Error 500 : Expected session attribute 'newStudent'
	//			가 발생하게 된다.
@RequestMapping("sessionAttributesTest05")
public class SessionAttributesController05 {

	Logger log = LogManager.getLogger("case3");
	
	// handler가 호출되기 이전에 아래의 메소드가 호출된다.
	// data1이라는 key로 메소드의 리턴값이 Model에 자동으로 저장된다.
	@ModelAttribute("data1")
	public String createString1() {
		log.debug("SessionAttributesController05.createString1() 호출");
		return "createString1";
	}
	
	@ModelAttribute("data2")
	public String createString2(Model model) {
		log.debug("SessionAttributesController05.createString2() 호출");

		Student student = new Student(30, "신사임당", "국어국문");
		model.addAttribute("shin", student);
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
		
		return "sample07/sessionResult05";
	}
}
