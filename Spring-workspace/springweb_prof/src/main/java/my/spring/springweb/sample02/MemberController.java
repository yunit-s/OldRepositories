package my.spring.springweb.sample02;

//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import my.spring.springweb.sample02.vo.Member;

@Controller
public class MemberController {

//	private static final Logger logger = 
//			LoggerFactory.getLogger(MemberController.class);
	
	@PostMapping(value = "member1")
	public ModelAndView myMethod1(
			@RequestParam(value = "name", defaultValue = "없음") String name,
			@RequestParam(value = "phone", defaultValue = "없음") String phone,
			String id,
			@RequestParam(value = "password", defaultValue = "없음") String password,
			Model model) {
		
		ModelAndView mav = new ModelAndView();
//		mav.addObject("name", name);
//		mav.addObject("id", id);
//		mav.addObject("phone", phone);
//		mav.addObject("password", password);

		model.addAttribute("name", name);
		model.addAttribute("id", id);
		model.addAttribute("phone", phone);
		model.addAttribute("password", password);
		
		mav.setViewName("sample02/memberView");
		return mav;
	}
	
	@PostMapping(value = "member2")
	public ModelAndView myMethod2(Member vo) {
		
//		logger.debug(vo.toString());
		// 확인하면 정말로 클라이언트가 보내준 데이터가 VO로 생성되는지 확인이 가능!
		
		ModelAndView mav = new ModelAndView();
		
		mav.addObject("memberVO", vo);
		
		mav.setViewName("sample02/memberView");
		
		return mav;
		
	}

	@PostMapping(value = "member3")
//	public String myMethod3(@ModelAttribute Member vo) {
	public String myMethod3(@ModelAttribute(value = "mem") Member vo) {
		
//		logger.debug(vo.toString());
		// 확인하면 정말로 클라이언트가 보내준 데이터가 VO로 생성되는지 확인이 가능!
			
		return "sample02/memberView";
		
	}

	@PostMapping(value = "member4")
	public String myMethod4(Member vo, String address) {
		
//		logger.debug(vo.toString());
		// 확인하면 정말로 클라이언트가 보내준 데이터가 VO로 생성되는지 확인이 가능!
			
		return "sample02/memberView";
		
	}
	
}
