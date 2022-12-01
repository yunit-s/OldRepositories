package finaltest;

public class SuperClass {

	// constructor
	public SuperClass() {
		// super(); // 상위 클래스(Object)의 instance 생성
		
		// 우리 객체를 위한 공간을 Heap 영역에 할당.
		// 그 다음에야 int a가 메모리에 할당된다.
		
		// 우리 객체에 대한 초기화 진행. 근데 딱히 초기화는 안 했을 뿐...
		staticCall("3번 문장입니다!");
	}
	// constructor overloading으로 또 다른 생성자를 하나 정의한다.
	public SuperClass(int i) {
		this(); // 현재 class의 다른 생성자를 호출하는 기능
		staticCall("4번 문장입니다!");
	}
	
	// field
	// field는 일반적으로는 private로 설정해야 하지만, 이번 문제에서는 너무 복잡해지기 때문에 package로 설정하자.
	int a = staticCall("1번 문장입니다!"); // field a는 instance variable(instance가 생성되어야만 공간이 실제로 만들어지고 사용할 수 있기 때문. Heap 공간에 할당됨.)
	static int b = staticCall("2번 문장입니다!"); // field b는 class variable(instance가 없어도 사용 가능하다. method area에 만들어지기 때문.)
	
	// method
	// method는 일반적으로 public으로 지정
	// method의 결과값을 리턴한다? : 메소드를 호출했던 곳으로 값을 대치한다는 의미
	public static int staticCall(String msg) {
		System.out.println(msg);
		return 100; // 리턴 타입을 int라고 적었기 때문에, return 키워드가 한 번은 반드시 나와야 한다.
	}
	
	public void myFunc() {
		System.out.println("5번 문장입니다!");
	}
}
