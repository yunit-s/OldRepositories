package main;

import bank.*;

public class Main {

	// 1. 생성자
	// default 생성자 들어옴
	
	// 2. field 도 존재할 수 있지만, 지금은 필요 없음.
	
	// 3. method는 entry point인 main method만 존재
	public static void main(String[] args) {
		
//		// 1. 홍길동 instance를 생성
//		Customer hong = new Customer();
//		// 2. 생성한 객체에 이름을 홍길동으로 setting
//		hong.name = "홍길동";

		// 따로 생성자를 만들어두면, 한 줄에서 초기값도 직접 설정할 수 있게 된다.
		Customer hong = new Customer("홍길동");

		// 3. 홍길동이 잔액을 확인한다.
		long result = hong.getBalance();
		System.out.println("잔액은 : " + result); // 문자열 + 숫자 -> concatenation이 일어난다. 문자열로 바뀜.
		
		// 4. 홍길동이 입금한다.
		hong.deposit(2000);
		result = hong.getBalance();
		System.out.println("잔액은 : " + result);
		
		// 5. 홍길동이 3000원 출금한다.
		long rest = hong.withdraw(3000);
		System.out.println("잔액은 : " + rest);
		
		// 6. 홍길동이 1000원 출금한다.
		rest = hong.withdraw(1000);
		System.out.println("잔액은 : " + rest);
	}
}
