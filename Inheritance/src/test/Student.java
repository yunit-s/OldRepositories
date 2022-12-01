package test;

//// 상속을 이용하기 전
//public class Student {
//
//	public Student() {
//		// default constructor
//	}
//	
//	// field
//	private String name;
//	private String gender;
//	private int age;
//	private String dept; // 학과
//	
//	// method
//	public void eat() {
//		System.out.println("밥을 먹어요!");
//	}
//	
//	public void study() {
//		System.out.println("공부를 해요!");
//	}
//}

// -------------------------------------------------

// 객체지향의 상속을 이용해서 class 다시 만들기
// java에서 extends 라는 keyword를 제공해준다.
// Java는 단일 상속만 지원하고 다중 상속을 지원하지 않기 때문에, extends 뒤에 단 1개의 class만 올 수 있다.

// 프로그램 실행 후 시스템의 동작

public class Student extends Person {

	public Student() {
		// default constructor
	}

	//	public Student() {
//		// 상위 클래스의 constructor 호출
//		super(); // 상위 class의 생성자를 호출하는 코드. 만약 이 코드가 없으면 자동으로 삽입하여 실행함.
//		// super(100); 이라고 사용할 경우, Person(100) 의 생성자를 실행하게 된다.
//		
//		// 현재 객체의 field를 초기화하는 부분
//	}
	
	// field
//	private String name;
//	private String gender;
//	private int age;
	private String dept; // 학과
	
	// method
	
	// 상속받은 상위 클래스의 메소드를 하위 클래스에서 재정의(다시 정의)한다.
	// 이를 method overriding (메소드 오버라이딩)이라고 한다.
	public void eat() {
		super.eat(); // overriding때문에 접근하기 어려워진 메소드를 강제로 호출하는 방법
		System.out.println("밥을 신나게 먹어요!");
	}
	
	public void study() {
		System.out.println("공부를 해요!");
	}
	
	public static void main(String[] args) {
		Student s1 = new Student(); // 원래는 이렇게 만들려고 했다.
		Person s2 = new Student(); // 그런데 이런 방식의 선언도 가능하다. Student객체를 만들어놓고, 그 안의 Person 영역에 대해서만 가리키는 변수 s를 만든다는 뜻.
		Object s3 = new Student();
		
		// 현재 s3로는 eat() method 를 호추랗ㄹ 수 없어요!
		// 형(Type)변환을 이용하면 된다. => casting 작업을 하면 된다. => 괄호 이용
		
		
		s1.eat();
		// s2.study(); 사용 못 함
		// s3.eat(), s.study() 호출 못 함
		((Person)s3).eat(); // casting작업
		
		s1.eat(); // "밥을 신나게 먹어요!" 출력
		s2.eat(); // 이것도 "밥을 신나게 먹어요!" 가 출력된다. 이걸 동적 바인딩 (Dynamic Binding) 이라고 부른다.
		

	}
}
