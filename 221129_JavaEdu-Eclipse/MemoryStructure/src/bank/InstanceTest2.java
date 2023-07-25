package bank;

public class InstanceTest2 {

	// field
	static int a = staticCall("1번째 출력입니다.");
	int b = staticCall("2번째 출력입니다."); // b는 instance가 만들어질 때 공간이 할당되고, 그때 staticCall()이 호출된다.
	
	// method
	public static int staticCall(String msg) {
		System.out.println(msg);
		return 100;
	}
	
	// static block
	// 이 static block은 언제 실행될까?
	static {
		System.out.println("static block입니다. a의 값은 = " + a);
		// 프로그램에서 사용되는 라이브러리를 미리 로딩하고자 할 때.
	}
	
	// constructor
	public InstanceTest2() {
		this.b = staticCall("3번째 출력입니다.");
	}
	
	public static void main(String[] args) {
		System.out.println("4번째 출력입니다.");
		int c = staticCall("5번쨰 출력입니다.");
		InstanceTest2 d = new InstanceTest2();
	}
	
}
