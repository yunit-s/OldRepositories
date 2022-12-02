package computer;

public class Tab extends Computer implements Graphic {

	// constructors
	public Tab() {

	}
	public Tab(String name, int cpu, int memory, int battery) {
		super(name, cpu, memory, battery);
	}

	// methods
	@Override
	public void operate(int time) {
		setBattery(getBattery() - time / 5);
	}
	@Override
	public double rendering(int size) {
		return Math.round((double)size / (getCpu() * getMemory()) * 30 * 100) / 100.0;
	}

}
