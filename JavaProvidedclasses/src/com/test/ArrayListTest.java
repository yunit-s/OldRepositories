package com.test;

import java.util.ArrayList;

public class ArrayListTest {

	public static void main(String[] args) {
		
		// ArrayList를 하나 생성해 보자.
//		ArrayList a = new ArrayList();
		ArrayList<Object> a = new ArrayList<Object>(); // 이렇게 generic 을 설정해주면, ArrayList에서 여러 가지 primitive type 데이터를 넣어도 warning(노란색 밑줄)이 안 생긴다.
		a.add("Hello");
		a.add(new Student("홍길동", 20)); // Heap 어딘가에 객체가 만들어짐
//		a.add(new Integer(100));
		a.add(100); // 정수값 int형인데 Auto Boxing이 발생. 사용하는 class는 Integer
		a.add(3.14); // 실수값 double형인데, Auto Boxing이 발생. Double 클래스로 객체화되어 ArrayList에 저장하게 된다.

//		ArrayList b = new ArrayList(); // 이 방법 안 좋아. 다른 방법을 써보자.
		ArrayList<String> b = new ArrayList<String>(); // 배열에 저장되는 data type을 하나로 고정시켜주는 방법
		b.add("Hello");
		b.add("홍길동");
		b.add(new String("소리없는 아우성!"));
//		b.add(100);
		
		
		
	}
}
