package my.spring.SpringWeb.sample05;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import my.spring.SpringWeb.sample05.vo.User;

@Controller
@SessionAttributes
public class ModelAttributesController {

	Logger log = LogManager.getLogger("case3");
	
	// 일반 메소드
	// method에 @ModelAttribute를 지정할 때는 이름을 하나 명시해야 한다.
	//		이 method는 handler가 호출되기 이전에 자동으로 호출된다.
	//		그리고 해당 메소드의 리턴값이 Model에 자동으로 등록된다.
	@ModelAttribute("v1")
		// v1이 데이터의 key값
	public String createString() {
		log.debug("createString() 메소드 실행. 문자열 객체 생성");
		return "createString()으로 생성된 문자열객체";
	}
	
	@ModelAttribute("v2")
	public User createUser() {
		log.debug("createUser() 메소드 실행. User 객체 생성");
		User user = new User(25, "홍길동", "철학과");
		return user;
	}
	
	@ModelAttribute("data1")
	public int createNumber1() {
		log.debug("createNumber1() 메소드 실행. int형 데이터 100 생성");
		return 100;
	}
	
	@ModelAttribute("data2")
	public int createNumber2() {
		log.debug("createNumber2() 메소드 실행. int형 데이터 123 생성");
		return 123;
	}
	
	// 핸들러를 호출하면, @ModelAttribute 가 붙은 메소드들이 자동으로 호출되어 데이터가 등록되는데,
	//		순서가 어떤 것부터 등록될지는 보장되지 않는다.
	// 위 일반 메소드를 통해 만들어진 데이터들을 핸들러의 인자로 받아올 수 있다.
	//		인자로 넣어야하는 데이터가 작업이 많이 필요할 경우 사용할 수 있는 기능이다.
	@RequestMapping(value="modelAttributes1")
//	public String myMethod1() {
	public String myMethod1(@ModelAttribute("data1") int num1,
			@ModelAttribute("data2") int num2, Model model) {
		log.debug("ModelAttributesController.myMethod1() handler 호출!!");
		
		model.addAttribute("sum", num1 + num2);
		
		return "sample05/modelResult";
	}

	// html로부터 넘어온 데이터를 가지고 실행해보자.
	//		전송방식은 post 방식
//	@RequestMapping(value="modelAttributes2")
	@PostMapping(value="modelAttributes2")
	public String myMethod2(User user) {
		log.debug("ModelAttributesController.myMethod2() handler 호출!!");
		
		// Command 객체
		//		클라이언트가 보내준 데이터로 만들어진 객체
		//		대부분 VO를 이용해서 Command 객체를 만든다.
		// Command 객체 생성 순서
		//		1. 만약 class level에서(클래스 전체에 대해) sessionAttributes가 지정되어 있으면
		//			@ModelAttribute User user 이 코드는 session에서 user를 찾는다.
		//				이때 찾는 user는 VO 이름이 User니까 앞글자를 소문자로 만든 'user'를 가리킨다.
		//		2. User의 생성자를 찾아 호출해서 객체를 생성한다.
		//			public 생성자를 찾는다.
		//			만약 생성자가 여러개일 경우, 인자가 가장 적은 생성자를 호출한다.
		//				(default 생성자가 있으면 default 생성자를 호출한다.)
		//			생성자를 이용해서 객체 생성.
		//		3. setter를 이용해서 클라이언트가 보내준 데이터를 VO에 저장한다.
		//		4. @ModelAttribute는 Model 객체에 해당 vo를 저장해준다.
		//			이때 매개변수 이름 user 말고, 클래스이름 User에서 앞글자를 소문자로 만들어서 사용한다.
		//			이름을 직접 지정해줄 때는, @ModelAttribute("지정하고싶은이름") 방식으로 지정하면 된다.
		return "sample05/modelResult";
	}
}
