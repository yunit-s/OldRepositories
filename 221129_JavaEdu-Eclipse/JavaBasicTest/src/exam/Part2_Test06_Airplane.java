package exam;

public class Part2_Test06_Airplane extends Part2_Test06_Plane {

	public Part2_Test06_Airplane() {
		super();
	}
	public Part2_Test06_Airplane(String planeName, int fuelSize) {
		super(planeName, fuelSize);
	}

	@Override
	public void flight(int distance) {
		setFuelSize(getFuelSize() - (distance / 10) * 30);
	}
	
}
