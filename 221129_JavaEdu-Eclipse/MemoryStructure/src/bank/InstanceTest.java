package bank;


public class InstanceTest {

//	// 1. 생성자
//
//	// 2. field
//	static int a = staticCall("1번쩌 출력입니다."); // a라는 필드에 값을 assign한다.
//	int b = staticCall("2번째 출력입니다.")
//	
//	// 3. method
//	public int staticCall(String msg) {
//		System.out.println(msg);
//		return 100;
//	}

// ----------------------------------------------------------------------

// javac InstanceTest.java => compile 한 후
// java bank.InstanceTest => JVM을 이용해서 실행
	
	// 1. 생성자
	public InstanceTest() {
	}
	
	// 2. field
	// class variable : class만 있으면, class 이름으로 사용할 수 있는 변수
	static int a = 100; // a는 Method Area에 생성된다. 따라서 instance를 만들지 않아도 사용할 수 있다.
	// instance variable : instance가 있어야만 사용할 수 있는 variable
	int b = 200; // b는 instance가 생성된 후에 그 안에 공간이 생성된다. 따라서 heap 공간에 저장된다.
	
	// 3. method
	public void instanceCall(String msg) {
		System.out.println(msg);
	}
	
	public static void staticCall(String msg) {
		System.out.println(msg);
	}

	public static void main(String[] args) {
		int k = 100; // local variable(지역변수) => stack에 저장되며, method가 종료되면 사라진다.
		InstanceTest hong = new InstanceTest(); // hong이라는 지역변수고, 데이터타입은 InstanceTest.
		
		hong.a = 300; // instance를 이용해서 static field를 이용할 수 있다.
		InstanceTest.a = 500; // static field이기 때문에, class를 이용해서도 사용할 수 있다.
		
		hong.b = 300; // 가능
//		InstanceTest.b = 500; // 오루. b는 static이 아니기 때문
		
	}
}
