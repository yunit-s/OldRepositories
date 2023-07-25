package test2_planetest;

public class Airplane extends Plane {

	// fields
	
	// constructors
	public Airplane() {
		
	}
	public Airplane(String planeName, int fuelSize) {
		super(planeName, fuelSize);
	}
	
	// methods
	@Override
	public void flight(int distance) {
		setFuelSize(getFuelSize() - distance * 3);
	}
}
