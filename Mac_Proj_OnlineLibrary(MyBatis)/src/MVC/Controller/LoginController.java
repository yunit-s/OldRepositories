package MVC.Controller;

import MVC.Service.UserService;
import MVC.VO.UserVO;

public class LoginController {

	public UserVO login(String id, String pw) {
		UserService userService = new UserService();
		UserVO result = userService.userLogin_mybatis(id, pw);
		return result;
	}

}
