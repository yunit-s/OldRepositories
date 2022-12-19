package exam;

public class Part2_Test06_Cargoplane extends Part2_Test06_Plane {

	public Part2_Test06_Cargoplane() {
		super();
	}
	public Part2_Test06_Cargoplane(String planeName, int fuelSize) {
		super(planeName, fuelSize);
	}

	@Override
	public void flight(int distance) {
		setFuelSize(getFuelSize() - (distance / 10) * 50);
	}

}
