package computer;

public class Laptop extends Computer implements Graphic {

	// constructors
	public Laptop() {
		
	}
	public Laptop(String name, int cpu, int memory, int battery) {
		super(name, cpu, memory, battery);
	}

	// methods
	@Override
	public void operate(int time) {
		setBattery(getBattery() - time / 10);
	}
	@Override
	public double rendering(int size) {
		return Math.round((double)size / (getCpu() * getMemory()) * 20 * 100) / 100.0;
	}
}
