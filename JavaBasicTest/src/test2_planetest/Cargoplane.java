package test2_planetest;

public class Cargoplane extends Plane {

	// fields
	
	// constructors
	public Cargoplane() {
		
	}
	public Cargoplane(String planeName, int fuelSize) {
		super(planeName, fuelSize);
	}
	
	// methods
	@Override
	public void flight(int distance) {
		setFuelSize(getFuelSize() - distance * 5);
	}
}
