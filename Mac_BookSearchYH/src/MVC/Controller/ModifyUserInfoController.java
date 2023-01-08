package MVC.Controller;

import MVC.Service.UserService;
import MVC.VO.UserVO;

public class ModifyUserInfoController {

	public UserVO checkIdInUsersDB(String id) {
		UserService userService = new UserService();
		UserVO user = userService.getUserById(id);
		return user;
	}

	public int editUserToUsersDB(UserVO user) {
		UserService userService = new UserService();
		int rows = userService.editUserByUserVO(user);
		return rows;
	}

}
