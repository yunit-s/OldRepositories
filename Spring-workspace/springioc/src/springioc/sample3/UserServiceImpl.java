package springioc.sample3;

public class UserServiceImpl implements UserService {

	// 필드 없는게 맞지만, 예제니까 잠시 필드 만들자
	private User user;
	
	public UserServiceImpl() {
		System.out.println("UserServiceImpl 기본 생성자 호출");
	}
	
	public UserServiceImpl(User user) {
		this.user = user;
		System.out.println("UserServiceImpl 생성자 호출 - " + user);
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public void addUser(User user) {
		// 일반적인 Business Logic 처리
		System.out.println("UserServiceImpl - addUser() 호출");
	}
}
