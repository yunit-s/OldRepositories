package main;

import test.Customer;

public class Main {

	public static void main(String[] args) {
		// 프로그램의 entry point
		// class를 이용해서 instance를 생성해 보자.
		System.out.println("프로그램 시작!");

		Customer hong = new Customer(); // reference data type
		// hong : reference variable(참조 변수)
		// 메모리 주소에 대한 참조값(해쉬값)이 들어가 있기 때문에 이 변수를 이렇게 부른다.
		// instance는 메모리에 존재해요(메모리 공간 중 어디에 위치하냐? Heap이라고 불리는 영역에 존재한다.)
		// 우리가 사용하는 건 결국 instance를 사용하는 것이다. 이 공간을 사용하기 위해 참조변수를 이용하는 것.
		// 그래서 우리가 편하게(일반적으로) hong을 객체라고 얘기한다.
		hong.balance = 1000;
		
		Customer shin = new Customer();
		shin.balance = 2000;
		// field는 instance variable. instance마다 각각의 공간이 따로따로 생성됨.
	}

}
