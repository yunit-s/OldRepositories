package MVC.Controller;

import MVC.Service.UserService;

public class WithdrawController {

	public int withdrawAccount(String id) {

		UserService userService = new UserService();
		int rows = userService.deleteUser(id);
		return rows;
	}

}
