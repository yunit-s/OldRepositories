package finaltest;

public class SubClass extends SuperClass {
	
	// constructor
	public SubClass() {
		super(100); // 상위 클래스의 instance 생성
		
		// 메모리에 공간을 확보(instance를 위해). c를 위한 공간을 확보하면서 6출력
		
		// 이 아래가 객체 초기와 작업
		staticCall("8번 문장입니다.");
		super.myFunc();
	}
	
	// field
	int c = staticCall("6번 문장입니다.");
	static int d = staticCall("7번 문장입니다.");
	
	// method
	// method overriding하자.
	@Override // 이런걸 annotation이라고 한다.
	public void myFunc() {
		System.out.println("9번 문장입니다.");
	}
	
	public static void main(String[] args) {
		System.out.println("10번 문장입니다.");
		SuperClass obj = new SubClass();
		obj.myFunc();
	}
}
