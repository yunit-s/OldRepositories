package MVC.Controller;

import MVC.Service.UserService;

public class LoginController {

	public boolean tryLogin(String id, String pw) {
		// TODO Auto-generated method stub
		UserService userService = new UserService();
		boolean result = userService.Login(id, pw);
		return result;
	}

}
