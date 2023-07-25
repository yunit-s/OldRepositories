package basicgrammar;

public class inheritanceSub extends inheritanceSuper {

	// constructor
	public inheritanceSub() {
		super(100); // 상위 클래스의 instance 생성
		// 이 클래스의 instance 생성을 위해 메모리에 공간을 확보. 일반 필드 c를 위한 공간을 Heap 안에 확보하면서 6출력
		// 우리 객체에 대한 초기화 진행. 여기서는 default 생성자 활용
		// 이후 사용자 정의 코드 실행
		staticCall("09번. 서브 클래스의 기본 생성자");
		super.myFunc();
	}
	
	// field
	int c = staticCall("08번. 서브 클래스의 일반 필드"); // instance variable. 인스턴스가 생성되어얐을 때 Heap 공간에 할당된다.
	static int d = staticCall("02번. 서브 클래스의 static 필드"); // class variable. Method Area에 할당된다.

	// method
	@Override // 이런걸 annotation이라고 한다.
	public void myFunc() {
		System.out.println("11번. 서브 클래스의 일반 메소드(슈퍼 클래스의 메소드를 override함)");
	}
	
	// static block
	static {
		System.out.println("03번. static block. main 메소드보다 먼저 실행된다.");
	}
	
	public static void main(String[] args) {
		System.out.println("04번. main 메소드 시작");
		inheritanceSuper obj = new inheritanceSub();
		obj.myFunc();
	}
}
