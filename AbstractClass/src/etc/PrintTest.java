package etc;

public class PrintTest {

	// constructor
	
	// field
	private String name;
	private int age;
	
	// method
	
	@Override
	public String toString() {
//		return super.toString();
		return "이름은 : " + name + ", 나이는 : " + age;
	}
	
	public static void main(String[] args) {
		// PrintTest라는 class의 instance를 생성
		PrintTest a = new PrintTest();
		// 이제 객체의 정보를 출력해보자.
		System.out.println("안녕하세요!"); // 인자는 문자열로 변환이 가능한 값이 와요 한다.
		System.out.println(100); // 100이라는 정수값도 문자열로 변환이 가능하기 때문에, 정상적으로 100이 출력된다.
		System.out.println(a); // 이건 좀 달라. a는 instance를 지칭하고 있거든. 메모리 시작 주소를 가리키는 거지.
			// 그럼 이 메모리 주소값에 대한 hash값을 문자열로 어떻게 변경할까?
			// com.uni.prof.PrintTest@515f550a <= 객체를 문자열로 변환한 값
		// instance를 문자열로 변경을 시켜보자. 그걸 행할 수 잇는 게 toString()이야.
		System.out.println(a.toString()); // toString()이라는 메소드는 어디서 왔겠어? 바로 Object 클래스야. 거기서 상속받은 거지.
			// 결국, Java의 모든 인스턴스는 toString()이라는 메소드를 사용할 수 있다는 뜻이다.
		// Object.toString() => 이 메소드는 원래 메모리 주소의 해쉬값을 문자열로 변환하는 일을 한다.
		// 기능을 바꿔서 사용하고 싶기 때문에, toString() 메소드에 대해 오버라이딩을 한다.
	}

}
