package MVC.Controller;

import MVC.Service.UserService;
import MVC.VO.UserVO;

public class SignUpController {

	public UserVO checkIdInUsersDB(String id) {
		UserService userService = new UserService();
		UserVO user = userService.getUserById(id);
		return user;
	}

	public int addNewuserToUsersDB(UserVO user) {
		UserService userService = new UserService();
		int rows = userService.addNewuser(user);
		return rows;
	}

}
