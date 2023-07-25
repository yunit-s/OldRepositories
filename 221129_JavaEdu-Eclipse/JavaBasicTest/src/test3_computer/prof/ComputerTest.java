package test3_computer.prof;

public class ComputerTest {

	public static void main(String[] args) {
		
		Computer[] arrays = new Computer[4];
		// int[] k = new int[4]; 랑 완전히 동일한 거임. 배열이라고 헷갈리지 말자.
		// 아하.. arrays 안에는 Computer라는 클래스 타입의 객체가 들어온다.
		// Laptop과 Tab은 둘 다 Computer의 subclass다.
		// 따라서 IS-A 관계에 의해 Laptop과 Tab의 instance는 배열에 저장이 가능하다.
		arrays[0] = new Laptop("Laptop01", 2, 1024, 2000);
		arrays[1] = new Laptop("Laptop02", 3, 2048, 2300);
		arrays[2] = new Tab("Tab01", 2, 1024, 1200);
		arrays[3] = new Tab("Tab02", 3, 2048, 1300);
		
		// 기본정보 출력
		for (Computer tmp : arrays) {
			System.out.println(tmp.toString());
		}
		
		// 컴퓨터 사용
		for (Computer tmp : arrays) {
			tmp.operate(55); // 동적 바인딩이 발생한다. 그래서 overriding된 method를 호출한다.
//			tmp.rendering //이거 안 먹혀.
//			(Graphics)tmp // 이것도 안 돼. Computer class와 Graphics interface는 서로 관계가 없으니까.
			if (tmp instanceof Laptop) {
				System.out.println(((Laptop)tmp).rendering(100));
			} else {
				System.out.println(((Tab)tmp).rendering(100));
			}
		}
	}
}
