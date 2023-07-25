package com.test;
// import java.lang.*; // 내가 입력하지 않아도 기본으로 삽입된다.

public class Student {

	//constructor
	public Student() {
		// 인자가 없는 생성자는 가급적 직접적으로 구현해주는 것이 좋다.
	}
	public Student(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}

	// field
	private String name;
	private int age;
	
	// method
	@Override
	public boolean equals(Object obj) {
		// equals method의 기능을 재정의
		// 'instance의 이름과 나이가 같으면 같다'라고 새롭게 만들자.
		Student target = (Student)obj; // 들어온 인자를 형변환(casting) 해준다. 그래야 Student 클래스의 필드에 접근할 수 있으니까
		boolean result = false;
//		if ((this.name == target.name) && (this.age == target.age)) { // 객체 비교는 '==' 로 하는 게 아니다. 가급적 equals() 메소드를 활용하자.
		if ((this.name.equals(target.name)) && (this.age == target.age)) {
			result = true;
		}
		return result;
	}
	@Override
	public String toString() {
		return name + age;
	}
	
	// getter & setter
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
}
