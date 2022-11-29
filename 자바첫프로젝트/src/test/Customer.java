package test;

// import java.lang.*; // 이거를 명시하지 않으면, Java가 알아서 추가를 해준다.

public class Customer {
	// 1. 생성자들
	// 클래스 안에 있는 생성자를 이용해서 class로부터 instance를 생성할 수 있다.
	// 결국, 모든 class는 하나 이상의 생성자를 가지고 있다.
	// 생성자가 없는 class는 존재하지 않는다.
	// 만드는 규칙이 있다.
	// 일단 public(public을 쓸 수도 있고 아닐 수도 있다.)
	// 메소드 형태가 나온다.
	// 생성자는 메소드가 아니다. => 리턴타입이 존재하지 않는다.
	// 생성자의 이름은 정해져 있다. => 클래스의 이름으로 정해져 있다.
	// 입력인자(parameter)를 가질 수 있다.
	// 중괄호 안에 instance의 초기화 코드가 들어온다.
	// 당연히 리턴 구문은 존재하지 않는다.
	// 이렇게 만든 걸 우리는 생성자(constructor)라고 한다.
	public Customer() {
		// 생성될 인스턴스의 초기화 코드가 들어옴.
	}

	
	// 2. field들
	// 변수들이 온다. -> camel case notation
	String customerName; // 고객이름
	public long balance; // 잔액
	String customerAccount; // 고객 계좌번호
	int customerAge; // 고객 나이
	// long, int는 primitive data type
	// String은 Reference data type
	// 결국, String은 class이다. 우리가 만들지 않은, Java가 제공한 class. 프로그래밍을 쉽게 하기 위해서 제공되었다.
	// 이렇게 제공된 class가 매우 많다.(class library라고 얘기한다.)
	// 이 많은 제공된 class는 당연히 package로 묶어서 제공된다.
	// 저 위에서 String이라는 class가 사용되었는데, 원래는 package을 함께 써야 하기 때문에 java.lang.String이라고 써야 한다.
	// 이거를 생략하기 위한 방법이 import 구문이다.
	
	// 3. method들
	// 일반적으로 method는 특별한 용도가 아닌 이상 public을 기본으로 지정해요!
	// 리턴타입 => 메소드는 우리가 알고 있는 함수 형태.
	//	함수는 입력을 받아서 로직처리한 후 그 결과물을 생성해서 결과물을
	//	함수를 호출한 곳으로 돌려주기 위해서 사용! => 이 돌려주는 값을 리턴값.
	//	이 리턴값이 어떤 데이터 타입인지를 method 정의할 때 선언.
	public int getAge(int kk) {
		// kk : 파라미터. method의 입력을 받아들이는 역할을 수행한다.
		// business logic 처리가 진행돼요!
		System.out.println("나이를 알려주는 기능이에요!");
		// if, for...
		return 30;
	}
}