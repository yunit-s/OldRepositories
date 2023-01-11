package MVC.Controller;

import org.apache.ibatis.session.SqlSessionFactory;

import MVC.MyBatis.MyBatisConnectionFactory;
import MVC.Service.UserService;
import MVC.VO.UserVO;

public class LoginController {

//	public UserVO login(String id, String pw) {
//		// TODO Auto-generated method stub
//		UserService userService = new UserService();
//		UserVO result = userService.userLogin(id, pw);
//		return result;
//	}

	public UserVO login(String id, String pw) {
		UserService userService = new UserService();
		UserVO result = userService.userLogin_mybatis(id, pw);
		return result;
	}

}
