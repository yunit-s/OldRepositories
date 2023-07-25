package test2_planetest.prof;

public class AirPlane extends Plane {

	public AirPlane() {
		
	}
	public AirPlane(String planeName, int fuelSize) {
		super(planeName, fuelSize);
	}
	
	@Override
	public void flight(int distance) {
		// 연료량은 운행거리 * 3만큼 줄이면 된다.
		setFuelSize(getFuelSize() - (distance * 3));
	}

}

class CargoPlane extends Plane {

	public CargoPlane() {
		super();
	}
	public CargoPlane(String planeName, int fuelSize) {
		super(planeName, fuelSize);
	}

	@Override
	public void flight(int distance) {
		setFuelSize(getFuelSize() - (distance * 5));
	}
}