package abstracttest;

public class Main {

	public static void main(String[] args) {
		// abstract class로부터 instance를 생성해보자.
		SuperClass a1 = new SubClass(); // 인스턴스화할 수 없다.
//		SubClass a2 = new SubClass(); // 다형성
//		Object a3 = new SubClass(); // 다형성
	}
}
