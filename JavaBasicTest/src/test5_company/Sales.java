package test5_company;

public class Sales extends Employee implements Bonus {

	// constructors
	public Sales() {
	}
	public Sales(String name, int number, String department, int salary) {
		super(name, number, department, salary);
	}
	
	// fields
	
	// getter & setter

	// methods
	
	// override methods
	@Override
	public void incentive(int pay) {
		setSalary(getSalary() + (int)(pay * 1.2));
	}

	@Override
	public double tax() {
		return getSalary() * 0.13;
	}
}
