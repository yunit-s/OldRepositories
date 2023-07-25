package sample;

interface myInterface {
	
	void aa();
}

// 이렇게 사용자 클래스를 만들어도 되지만, 다른 방법이 있어.
//class MyClass implements myInterface {
//
//	@Override
//	public void aa() {
//		// TODO Auto-generated method stub
//		
//	}
//	
//}

public class InterfaceTest {

	public static void main(String[] args) {
//		myInterface a = new MyClass();
		myInterface a = new myInterface() {
			
			// 이 인터페이스를 구현한 임시 클래스가 하나 정의된다고 생각하면 된다.
			@Override
			public void aa() {
				// TODO Auto-generated method stub
				
			}
		};
	}
}
