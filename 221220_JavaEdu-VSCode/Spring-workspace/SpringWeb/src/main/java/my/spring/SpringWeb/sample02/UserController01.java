package my.spring.SpringWeb.sample02;

//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import my.spring.SpringWeb.sample02.vo.User;

@Controller
@RequestMapping(value="userCtr01")
public class UserController01 {

//	private static final Logger logger = LoggerFactory.getLogger(UserController01.class);
	
	@GetMapping(value="callByGet")
	public ModelAndView callByGetMethod() {
//		logger.debug("userCtr01/callByGet (@GetMapping) 호출");
		
		ModelAndView mav = new ModelAndView();
		
		User lombokUser = new User();
		lombokUser.setUserName("롬복의 이름");
		lombokUser.setUserAge(999);
		lombokUser.setUserDept("롬복의 부서는 lombok");
		lombokUser.setUserAddress("롬복의 주소는 인터넷 어딘가");
		mav.addObject("lombokUser", lombokUser);
		
		User lombokUser2 = new User("유저2-이름", 111, "유저2-부서", "유저2-주소");
		mav.addObject("lombokUser2", lombokUser2);
		
		mav.setViewName("sample02/userController01");
		
		return mav;
	}
}
