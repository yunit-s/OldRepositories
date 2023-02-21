package springioc.sample3;

public class User {

	// 이건 VO 클래스가 맞고, VO는 Bean으로 만들지 않는게 맞지만, 우리는 일단 Bean으로 만들어본다.
	private String userName;
	
	public User() {
		System.out.println("User 기본 생성자 호출");
	}

	public User(String userName) {
		super();
		this.userName = userName;
		System.out.println("User 생성자 호출 - " + userName);
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
	
}
