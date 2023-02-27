package my.spring.SpringWeb.sample02;

//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import my.spring.SpringWeb.sample02.vo.Member;

@Controller
//@RequestMapping
public class MemberController {

//	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);
	
	@PostMapping(value="member1")
	public ModelAndView myMethod1(
			@RequestParam(value="name", defaultValue="없음") String name,
			@RequestParam(value="phone", defaultValue="없음") String phone,
//			@RequestParam(value="id", defaultValue="없음") String id,
			String id,
			@RequestParam(value="password", defaultValue="없음") String password) {
		// @RequestParam
		//		value : 어떤 이름으로 들어오는지 명시하기
		//		defaultValue : 이 이름으로 데이터 안 들어오면 적용할 기본값
		//		value값과 매개변수 이름이 완전히 동일하면 @RequestParam 어노테이션을 생략해도 된다.
		
		// 인자에 Model 객체 안 들어왔으니 ModelAndView 객체 활용해보자.
		ModelAndView mav = new ModelAndView();
		mav.addObject("name", name); // 이렇게 붙인 객체는 Model이 아니라 request 객체에 들어간다. 이를 통해 jsp에서 EL로 호출할 수 있다.
		mav.addObject("phone", phone);
		mav.addObject("id", id);
		mav.addObject("password", password);
		
		mav.setViewName("sample02/memberView");
		return mav;
	}

	@PostMapping(value="member11")
	// member1과 달리 Model 객체 활용해보기
	public ModelAndView myMethod11(
			@RequestParam(value="name", defaultValue="없음") String name,
			@RequestParam(value="phone", defaultValue="없음") String phone,
//			@RequestParam(value="id", defaultValue="없음") String id,
			String id,
			@RequestParam(value="password", defaultValue="없음") String password,
			Model model) {
		ModelAndView mav = new ModelAndView();
		model.addAttribute("name", name);
		model.addAttribute("phone", phone);
		model.addAttribute("id", id);
		model.addAttribute("password", password);
		
		mav.setViewName("sample02/memberView");
		return mav;
	}
	
	@PostMapping(value="member2")
	public ModelAndView myMethod2(@ModelAttribute Member vo) {
		// ㅍㅍㅍㅍㅍㅍㅍㅍㅍㅍㅍㅍㅍㅍㅍㅍㅍㅍㅍㅍ vo가 어떻게 들어온다고?
		// @ModelAttribute
		//		간단하게 설명하면, 얘를 이용하면 파라미터를 VO로 받을 수가 있다고 생각하면 된다.
		
		// 그럼 @RequestParam 이 생략된 건지, @ModelAttribute가 생략된 건지 어떻게 알아?
		//		Spring에서는 primitive 타입일 땐 @RequestParam을,
		//			reference 타입일 땐 @ModelAttribute를 자동으로 매칭시켜서 해석한다.
		//		공부할 땐 하나하나 명시해주는 게 좋고, 현업에서는 당연한 거니까 명시를 잘 ㅌㅇ안 하게 된다.
//		logger.debug("MemberController.myMethod2() (PostMapping) 호출");
		
//		logger.debug(vo.toString());
			// 확인하면 정말로 클라이언트가 보내준 데이터가 VO로 생성되는지 확인 가능하다.
			// 필드 이름이랑 다 똑같이 입력하니까 알아서 vo로 만들어서 전달이 된다.
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("memberVO", vo);
		
		mav.setViewName("sample02/memberView");
		return mav;
	}

	@PostMapping(value="member3")
	public String myMethod3(@ModelAttribute Member vo) {
//		logger.debug("MemberController.myMethod3() (PostMapping) 호출");
		
		// @ModelAttribute
		//		말 그대로 Model의 속성이잖아?
		//		이 vo가 자동으로 Model 객체에 등록이 된다.
		//		key값은 디폴트값으로 클래스 이름이 들어가는데, 맨 앞 글자가 소문자로 바뀌어서 들어간다.
		
//		logger.debug(vo.toString());
		
		return "sample02/memberView";
	}

	@PostMapping(value="member33")
	public String myMethod33(@ModelAttribute(value="mem") Member vo) {
		// @ModelAttribute
		//		value : 데이터에 이름을 직접 붙일 수 있다.
//		logger.debug("MemberController.myMethod33() (PostMapping) 호출");
		
//		logger.debug(vo.toString());
		
		return "sample02/memberView";
	}

	@PostMapping(value="member4")
	public String myMethod4(Member vo, String address) {
		// vo는 @ModelAttribute, address는 @RequestParam 이 자동으로 적용된다.
//		logger.debug("MemberController.myMethod4() (PostMapping) 호출");
		
		return "sample02/memberView";
	}
	
}
