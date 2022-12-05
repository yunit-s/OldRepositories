package computer.prof;

public class Tab extends Computer implements Graphic {

	// constructor
	public Tab() {
		super();
	}

	public Tab(String name, int cpu, int memory, int battery) {
		super(name, cpu, memory, battery);
	}

	@Override
	public double rendering(int size) {
		return (double)size / (getCpu() * getMemory()) * 30;
	}

	@Override
	public void operate(int time) {
		// 입력으로 들어온 시간 5 당 1씩 배터리가 감소
		int result = time / 5;
		setBattery(getBattery() - result);
	}

	
}
