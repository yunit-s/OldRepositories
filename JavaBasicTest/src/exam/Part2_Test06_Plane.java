package exam;

public abstract class Part2_Test06_Plane {
	
	private String planeName;
	private int fuelSize;
	
	public Part2_Test06_Plane() {
	}
	public Part2_Test06_Plane(String planeName, int fuelSize) {
		this.planeName = planeName;
		this.fuelSize = fuelSize;
	}
	
	public String getPlaneName() { return planeName; }
	public void setPlaneName(String planeName) { this.planeName = planeName; }
	public int getFuelSize() { return fuelSize; }
	public void setFuelSize(int fuelSize) { this.fuelSize = fuelSize; }

	public void refuel(int fuel) {
		fuelSize += fuel;
	}
	public abstract void flight(int distance);
	
}
