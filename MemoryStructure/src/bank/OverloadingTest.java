package bank;

public class OverloadingTest {

	// 1. 생성자
	// instance를 생성할 때 초기화해주는 역할 담당.
	public OverloadingTest() {
		// default constructor
		// Java의 모든 class는 default 생성자를 가질 수 있도록 코드를 작성하자. 다시말해, 직접 명시하라는 뜻.(아니면 아예 없게 하거나)
	}
	// 생성자 overloading
	public OverloadingTest(String a, String b, int c) {
		// a, b, c : parameter 혹은 형식인자 formal parameter 라고 한다.
		this.name = a;
		this.mobile = b;
		this.age = c;
	}
	
	// 2. field
	public String name; // 사람 이름
	public String mobile; // 사람 전화번호
	public int age; // 사람 나이
	
	// 3. method
	public static void main(String[] args) {
//		OverloadingTest tmp = new OverloadingTest();
		// 메소드에 넘겨주는 변수값들 ("홍길동, "010-1111-2222", 20) => arguments. 혹은 실인자 actual parameter
		OverloadingTest tmp = new OverloadingTest("홍길동", "010-1111-2222", 20); // 객체를 생성하는 생성자를 직접 골라서 호출할 수 있음.
		// 인스턴스가 만들어지면, 그 안에 name, mobile, age의 공간이 생성됨.
		// 이 공간은 해당 데이터 타입으로 각각 초기화가 진행된다.
		// 아무런 초기화값을 안 넣으면, name, mobile => ""(empty string. 빈 문자열. 공백 문자열.), age => 0 으로 초기화됨.
		tmp.name = "홍길동";
		tmp.mobile = "010-1111-2222";
		tmp.age = 20;
	}
	
}
