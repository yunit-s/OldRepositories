package my.spring.springweb.sample01.vo;

// JavaBean 규약
// 1. 기본생성자가 존재해야 해요!
// 2. 모든 field는 private이어야 해요!
// 3. 각 field를 사용하기 위해 public으로 되어 있는 setter, getter
// 이렇게 JavaBean규약을 지켜서 만들 클래스의 객체를 생성했을때
// filed를 우라가 뭐라고 하냐하면... => property라고 불러요!

public class User {

	private String userName;
	private int userAge;
	
	public User() {
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
