package computer.prof;

public abstract class Computer {

	// constructor
	public Computer() {
		
	}
	public Computer(String name, int cpu, int memory, int battery) {
		super();
		this.name = name;
		this.cpu = cpu;
		this.memory = memory;
		this.battery = battery;
	}
	
	// field
	private String name;
	private int cpu;
	private int memory;
	private int battery;
	
	// method
	
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
	
	public abstract void operate(int time);

	// 모든 객체의 기본 정보를 출력 -> toString() 메소드 오버라이딩하면 편하겠지
	// 모든 객체에 toString 활용할 거니까, 여기에서 오버라이딩 하자.
	@Override
	public String toString() {
		return name + "     " + cpu + "     " + memory + "     " + battery;
	}
	
}
