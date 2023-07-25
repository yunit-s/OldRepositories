package my.spring.springweb.sample07;

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

import my.spring.springweb.sample07.vo.Student;

@Controller
@SessionAttributes({ "data1", "shin", "newStudent" })
@RequestMapping(value = "/sessionAttributesTest06")
public class SessionAttributesController06 {

	Logger log = LogManager.getLogger("case3");
	
	// handler가 호출되기 이전에 아래의 메소드가 호출되요!
	// data1이라는 key로 메소드의 리턴값이 Model에 저장되요!
	@ModelAttribute("data1")
	public String createString1() {
		log.debug("createString1() 호출되었어요!");
		return "createString1";
	}

	@ModelAttribute("data2")
	public String createString2(Model model) {

		Student student = new Student(30,"신사임당","국어국문");
		model.addAttribute("shin", student);
		
		log.debug("createString2() 호출되었어요!");
		
		return "createString2";
	}
	
	@ModelAttribute("newStudent")
	public Student createString3() {

		Student student = new Student();
		
		return student;
	}
	
	//    문제!!!
	//    Controller에 @SessionAttributes({ "data1", "shin", "newStudent" })명시되어 있어요!
	//    핸들러의 인자를 봤더니..
	//    @ModelAttribute("newStudent") Student studentVO 가 있어요.
	//    그러면 command객체를 생성하는게 아니라.. session에서 newStudent 키값으로 저장되어 있는 객체를 
	//    찾아서 인자로 주입해요!
	
	//    따라서 이 코드가 오류가 안날려면.. 당연히 session에 newStudent 키값으로 저장되어 있는 객체가 
	//    있어야해요..정확히 얘기하면 newStudent 이 키가 session에 존재해야 해요!
	
	//    처음들어오면 당연히 session에 해당 key값이 존재하지 않아요!
	//    코드 오류를 피하려면 @ModelAttribute annotation을 method위에 붙이고 빈 command 객체를
	//    생성해서 Model에 저장해요! 당연히 session에 같이 저장될 꺼예요!
	
	//    그런다음 핸들러가 호출되기 때문에 오류를 필할 수 있게되요!
	//    핸들러는 command객체를 생성하지 않겠죠. 그리고 클라이언트가 보내준 데이터를
	//    setter를 이용해서 command객체에 데이터를 삽입해요!
	
	
	
	@PostMapping
	public String handler(@ModelAttribute("data1") String str1,
			@ModelAttribute("data2") String str2,
			@RequestParam(value = "msg") String requestMsg,
			@ModelAttribute("newStudent") Student studentVO) {
		
		log.debug("handler()에서 출력 : " + str1 + ", " + str2);
		log.debug("msg : " + requestMsg);
		log.debug("student : " + studentVO);
		
		
		return "sample07/sessionResult06";
	}
}
