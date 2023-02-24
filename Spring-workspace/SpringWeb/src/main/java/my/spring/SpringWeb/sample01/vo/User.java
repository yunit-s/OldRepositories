package my.spring.SpringWeb.sample01.vo;

// JavaBean 규약
// 1. 기본생성자가 존재해야 한다.
// 2. 모든 field는 private이어야 한다.
// 3. 각 field를 사용하기 위해 public으로 되어 있는 setter, getter
// 이렇게 JavaBean 규약을 지키면서 
// field를 윌가 뭐라고 하냐? property라고 부른다.

public class User {

	private String userName;
	private int userAge;
	
	public User() {
		// TODO Auto-generated constructor stub
	}

	public User(String userName, int userAge) {
		super();
		this.userName = userName;
		this.userAge = userAge;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public int getUserAge() {
		return userAge;
	}

	public void setUserAge(int userAge) {
		this.userAge = userAge;
	}
	
}
