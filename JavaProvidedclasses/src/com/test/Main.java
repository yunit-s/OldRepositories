package com.test;

public class Main {

	public static void main(String[] args) {
	
		Student s1 = new Student("홍길동", 20);
		Student s2 = new Student("신사임당", 30);
		Student s3 = new Student("홍길동", 20);
		
		// 두 객체가 같은 객체인가요?
		System.out.println(s1 == s2); // false 출력됨. '==' 연산자는 비교 연산자. 따라서 이 연산의 결과는 true/false 논리값이 리턴된다.
		System.out.println(s1 == s3); // false 출력됨.
		System.out.println(s1.equals(s3)); // overriding 하기 전 : false 출력됨. equals() 메소드 원형에서는 메모리 주소만 비교하기 때문.
										// overriding 후 : true가 나오도록 할 수 있겠지
		
		System.out.println(s1.toString()); // overriding하기 전 : com.test.Student@626b2d4a 출력됨.
										// overriding 후 : 홍길동20
	}
}
