package com.test;

class Customer {
	public String name;
	public long balance;
}

public class ExceptionTest {

	public static void main(String[] args) throws Exception {
		System.out.println("예외상황을 발생시켜요!");
		
		// 강제로 오류 만들어보자.
//		int result = 10 / 0; // 문법적인 오류는 없기 때문에, compile time에서는 오류가 발생하지 않는다.
						// 다만, runtime에 이상한 상황(Exception)이 발생하지.
						// Exception in thread "main" java.lang.ArithmeticException: / by zero
						// 해당 클래스에 관련된 오류가 생겼으며, 그 내용이 옆에 적혀있다.
		// java에는 무한대를 숫자로 표현하지는 못하고, 대신 무한대를 의미하는 키워드? 가 따로 있다.
		
//		Customer a = null; // 생성자를 일부러 빼고, null을 넣어놨어. Heap 영역으로 referencing하는 영역이 없다는 뜻. 쉽게 말해서, 가리키는 객체가 존재하지 않는다.
//		a.name = "홍길동"; // Exception in thread "main" java.lang.NullPointerException: Cannot assign field "name" because "a" is null
		
//		// try catch 연습
//		try {
//			int result = 10 / 0;
//		} catch (NullPointerException e) {
//			System.out.println("널 포인터 익셉션!!!");
//			// 예외상황 처리하는 코드
//		} catch (ArithmeticException e) {
//			System.out.println("수학연산 잘못됐어요!");
//		} catch (Exception e) {
//			// 어떤 exception이든간에 상관없이 모든 예외상황을 다 잡아오게 된다.
//			// 위에서부터 조건에 걸리기 때문에, (Exception) 조건은 맨 아래에 적어두는 게 좋다.
//			System.out.println("모든 예외처리 다 잡아온다.");
//		} finally {
//			// 얘는 무조건 수행된다.(예외가 있든 없든...)
//		}
		// main 자체에 throws Exception 을 걸면, 여기에서 처리하지 않게 된다.
		
		System.out.println("여기는 출력되나요?");
		
	}
}
