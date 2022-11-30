//package bpackage;
//
//import apackage.*; // apackage 안의 모든 것에 대해 패키지명 생략할 수 있게 해줌.
//
//class BClass {
//
//	// 1. constructor
//	BClass() {
//		
//	}
//	
//	// 2. field
//	int bField;
//	
//	// 3. method
//	void bMethod() {
//		System.out.println("하이하이");
//	}
//	
//	public static void main(String[] args) {
//		// AClass의 instance를 만들어 보자.
//		AClass a = new AClass();
//		a.aField = 100;
//	}
//}

// ----------------------------------------------------------------

package bpackage;

class BClass {

	// 1. constructor
	BClass() {
		
	}
	
	// 2. field
	private int bField;
	// bField라는 private field는 우리 class 내에서만 조회와 변경이 가능하도록 처리해야 한다.
	// 특수한 목적의 method를 이용해야 한다.
	// 하나는 private field의 값을 조회하는 목적을 가진 method
	// 다른 하나는 private field의 값을 변경하는 목적을 가진 method
	// getter & setter
	// access modifier는 public
	// 규칙 : camel case. 필드는 보통 첫글자가 소문자니까, 그 첫글자만 대문자로 바꾸고, 그 앞에 get 혹은 set을 붙인다.
//	public int getBField() {
//		return this.bField;
//	}
//	public void setBField(int bField) {
//		this.bField = bField;
//	}
	// getter, setter 자동완성기능 활용해보자
	public int getbField() {
		return bField;
	}

	public void setbField(int bField) {
		this.bField = bField;
	}
	
	// 3. method
	void bMethod() {
		System.out.println("하이하이");
	}

}
