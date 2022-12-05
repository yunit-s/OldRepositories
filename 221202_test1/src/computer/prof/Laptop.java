package computer.prof;

public class Laptop extends Computer implements Graphic {

	// constructor
	public Laptop() {

	}

	public Laptop(String name, int cpu, int memory, int battery) {
		super(name, cpu, memory, battery);
	}
	
	// abstract method들을 overriding해야만 이 클래스가 추상 클래스가 되지 않는다.
	@Override
	public double rendering(int size) {
		return (double)size / (getCpu() * getMemory()) * 20;
	}
	@Override
	public void operate(int time) {
		// 입력으로 들어온 시간 10 당 1씩 배터리가 감소
		// 프로그램에서 연산(+, -, *, /, ...)들은 같은 데이터 타입끼리 발생한다.
		int result = time / 10; // 정수 / 정수 = 정수
		setBattery(getBattery() - result);
	}

}
