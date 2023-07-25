package test3_computer;

public abstract class Computer {
	
	// constructors
	public Computer() {
		
	}
	public Computer(String name, int cpu, int memory, int battery) {
		this.name = name;
		this.cpu = cpu;
		this.memory = memory;
		this.battery = battery;
	}

	// fields
	private String name;
	private int cpu;
	private int memory;
	private int battery;
	
	// getter & setter
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getCpu() {
		return cpu;
	}
	public void setCpu(int cpu) {
		this.cpu = cpu;
	}
	public int getMemory() {
		return memory;
	}
	public void setMemory(int memory) {
		this.memory = memory;
	}
	public int getBattery() {
		return battery;
	}
	public void setBattery(int battery) {
		this.battery = battery;
	}
	
	// methods
	public abstract void operate(int time);
}
