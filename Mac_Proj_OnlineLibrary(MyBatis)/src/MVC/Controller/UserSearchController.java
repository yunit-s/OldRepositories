package MVC.Controller;

import MVC.Service.UserService;
import MVC.VO.UserVO;
import javafx.collections.ObservableList;

public class UserSearchController {

	public ObservableList<UserVO> searchUser(String searchCategory, String searchWord) {
		UserService userService = new UserService();
		ObservableList<UserVO> list = userService.searchUser_mybatis(searchCategory, searchWord);
		return list;
	}

}
