package springioc.sample2;

public class Foo {

	public Foo() {
		System.out.println("Foo 기본 생성자 호출");
	}
	
	public Foo(String str) {
		System.out.println("Foo 생성자 호출 - " + str);
	}
	
	public Foo(String str, int num) {
		System.out.println("Foo 생성자 호출 - " + str + ", " + num);
	}
	
	public Foo(Bar bar) {
		// injection
		//		값을 집어넣는 모든 걸 injection이라고 하긴 하는데,
		//		우리가 injection이라고 하면 보통 DI를 뜻한다. 의존성을 주입했을 경우를 뜻하는 것.
		System.out.println("Foo 생성자 호출 - " + bar);
	}
}
