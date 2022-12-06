package com.test;

class MyClass extends Exception {
	
}

public class CustomExceptionTest {
	
	public static void main(String[] args) throws Exception {
		System.out.println("시작");
		
		
		try {
			

//			new MyClass(); // 단순하게 exception 객체를 생성하기만 한다. 따로 발생하지는 않는다.	
			throw new MyClass(); // 이런 exception 객체를 던져야 된다. 내가 일부러 의도를 가지고서 예외상황을 만들었다.
		} catch (Exception e) {
			
		}
		
		System.out.println("끝");
	}
}
