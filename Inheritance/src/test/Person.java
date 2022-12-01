package test;

//import java.lang.*; // 생략하면 Java에서 알아서 import함

// 모든 클래스는 define될 때 Object를 상속받는다. 굳이 extends Object 를 안 적어도 되는 것.
public class Person {

	// 1. constructor
	public Person() {
		// default constructor
		// 상위 class 초기화
		super(); // Person class의 상위 class인 Object class의 생성자 호출. Object() 를 실행
		// 자기 class 초기화
		
		System.out.println("Person의 생성자가 호출!!");
	}
	
	// 2. field
	private String name;
	private String gender;
	private int age;
	
	// 3. method
	// business logic method
	// 일반적인 메소드는 외부에서 사용해야하는 거니까 보통 public으로 잡는다.
	public void eat() {
		System.out.println("밥을 먹어요!");
	}
}
