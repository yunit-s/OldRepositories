package MVC.Controller;

import MVC.Service.BookService;
import MVC.Service.UserService;
import MVC.VO.UserVO;
import javafx.collections.ObservableList;

public class UserSearchController {

	public ObservableList<UserVO> searchUser(String searchCategory, String searchWord) {
		// service 생성
		// service의 searchBook 호출
		// 리턴받은 list 리턴

		UserService userService = new UserService();
		ObservableList<UserVO> list = userService.searchUser_mybatis(searchCategory, searchWord);
		return list;
	}

}
