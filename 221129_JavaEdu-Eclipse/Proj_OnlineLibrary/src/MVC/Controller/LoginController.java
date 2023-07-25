package MVC.Controller;

import MVC.Service.UserService;
import MVC.VO.UserVO;

public class LoginController {

//	public boolean tryLogin(String id, String pw) {
//		// TODO Auto-generated method stub
//		UserService userService = new UserService();
//		boolean result = userService.Login(id, pw);
//		return result;
//	}

	public UserVO login(String id, String pw) {
		// TODO Auto-generated method stub
		UserService userService = new UserService();
		UserVO result = userService.userLogin(id, pw);
		return result;
	}

}
