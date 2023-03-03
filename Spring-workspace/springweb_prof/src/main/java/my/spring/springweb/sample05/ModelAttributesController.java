package my.spring.springweb.sample05;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import my.spring.springweb.sample05.vo.User;

@Controller
public class ModelAttributesController {

	Logger log = LogManager.getLogger("case3");
	
	// method에 @ModelAttribute를 지정할때는 이름을 하나 명시해야 해요!
	// 이 method는 handler가 호출되기 이전에 자동으로 호출되요!
	// 그리고 해당 메소드의 리턴값이 Model에 자동으로 등록되요!
	@ModelAttribute("v1")
	public String createString() {
		log.debug("문자열 객체 생성!!");
		return "이것은 소리없는 아우성";
	}
	
	@ModelAttribute("v2")
	public User createUser() {
		log.debug("VO 객체 생성!!");		
		User user = new User(25,"홍길동","철학과");		
		return user;
	}

	@ModelAttribute("data1")
	public int createNumber1() {
		log.debug("첫번째 숫자 생성!");			
		return 100;
	}

	@ModelAttribute("data2")
	public int createNumber2() {
		log.debug("두번째 숫자 생성!");			
		return 200;
	}
	
	
	@RequestMapping(value = "modelAttributes1")
	public String myMethod1(@ModelAttribute("data1") int num1,
			@ModelAttribute("data2") int num2, Model model) {
		
		log.debug("handler 호출!!");
		
		model.addAttribute("sum",num1+num2);
		
		return "sample05/modelResult";
	}

	@PostMapping(value = "modelAttributes2")
	public String myMethod2(@ModelAttribute User user) {
		
		// 이렇게 클라이언트가 보내준 데이터로 객체를 생성할 수 있어요!
		// Command 객체라고 불러요! 대부분 VO를 이용해서 Command 객체를 생성해요!
		
		// 이게 사실 순서가 있어요!
		// 1. 만약 class level에서 @SessionAttributes가 지정되어 있으면
		//    @ModelAttribute User user 이 코드는 session에서 user를 찾아요!
		//    지금 우리는 @SessionAttributes를 사용하지 않고 있어요! 그래서 이 부분은 넘어가요!
		// 2. User의 생성자를 찾아 호출해서 객체를 생성해요!
		//    public 생성자를 찾아요!
		//    만약 여러개면..그 중 인자가 가장 적은 생성자를 찾아요! -> 일반적으로 default생성자가 선택
		//    생성자를 이용해서 객체를 생성해요!
		// 3. setter를 이용해서 클라이언트가 보내준 데이터를 VO에 저장해요!
		// 4. @ModelAttribute는 Model객체에 해당 vo를 저장해줘요!
		//    기본적으로는 class의 이름을 앞글자 소문자로 만들어서 Model에 저장해요!
		//    만약 내가 이름을 달리해서 저장하고 싶으면 @ModelAttribute("myUser")이런 형식으로
		//    이름을 변경해서 Model에 저장할 수 있어요!
		
		
		
		log.debug("handler 호출!!");
			
		return "sample05/modelResult";
	}	
	
}
