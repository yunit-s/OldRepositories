package basicgrammar;

public class inheritanceSuper {

	// field
	int a = staticCall("05번. 슈퍼 클래스의 일반 필드"); // instance variable. 인스턴스가 생성되어얐을 때 Heap 공간에 할당된다.
	static int b = staticCall("01번. 슈퍼 클래스의 static 필드"); // class variable. Method Area에 할당된다.
	
	// constructor
	public inheritanceSuper() {
		// super(); // 상위 클래스(Object)의 instance 생성
		// 우리 객체를 위한 공간을 Heap 영역에 할당. 이후 int a가 메모리에 할당된다.
		// 우리 객체에 대한 초기화 진행. 여기서는 default 생성자 활용
		// 이후 사용자 정의 코드 실행
		staticCall("06번. 슈퍼 클래스의 기본 생성자");
	}
	// constructor overloading
	public inheritanceSuper(int i) {
		this(); // this() : 현재 class의 다른 생성자를 호출
		staticCall("07번. 슈퍼 클래스의 int 매개변수 생성자");
	}
	
	// method
	public static int staticCall(String msg) {
		System.out.println(msg);
		return 7; // 7 : 리턴을 위한 수. 다른 숫자여도 무관하다.
	}
	
	public void myFunc() {
		System.out.println("10번. 슈퍼 클래스의 일반 메소드");
	}
}
