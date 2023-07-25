package my.spring.SpringWeb.sample07;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import my.spring.SpringWeb.sample07.vo.Member;

@Controller
@SessionAttributes(value= {"memberInfo"})
	// 본질적인 목적은 session에 데이터를 저장하기 위함이다.
public class MemberRegisterController {

	Logger log = LogManager.getLogger("case3");
	
	// 빈 객체 생성하기
	@ModelAttribute("memberInfo")
		// 같은 컨트롤러 내에서 계속적으로 새로고침이 이루어질 때,
		//		session의 데이터가 초기화되지 않는다.
		//		즉, session에 이미 이 데이터가 있다면, 이 메소드가 반복적으로 호출되지 않는다.
	public Member createMember() {
		log.debug("MemberRegisterController.createMember() 호출");
		
		Member member = new Member();
		return member;
	}
	
	@PostMapping(value="memberRegisterStep1")
	public String handler1() {
		log.debug("MemberRegisterController.handler1() 호출 - memberRegisterStep1");
		
		
		return "sample07/registerStep1";
	}
	
	@PostMapping(value="memberRegisterStep2")
	public String handler2(@ModelAttribute("memberInfo") Member member) {
		log.debug("MemberRegisterController.handler2() 호출 - memberRegisterStep2");
		log.debug(member);
		
		return "sample07/registerStep2";
	}
	
	@PostMapping(value="memberRegisterStep3")
	public String handler3(@ModelAttribute("memberInfo") Member member, SessionStatus sessionStatus) {
		// SessionStatus
		//		session 안에 있는 key값을 만료시킬 수 있는 인터페이스
		log.debug("MemberRegisterController.handler3() 호출 - memberRegisterStep3");
		log.debug(member);
		
//		sessionStatus.setComplete();
			// session 안에 있는 데이터 중 내가 처리할 데이터 key를 제거한다.
		
//		return "sample07/registerStep3";
		return "redirect:/saveInfo";
			// redirect는 Get방식으로 실행된다.
	}
	
	@GetMapping(value="saveInfo")
	public String saveInfoHandler() {
		log.debug("MemberRegisterController.saveInfoHandler() 호출");
		
		return "sample07/registerStep1";
	}
}
