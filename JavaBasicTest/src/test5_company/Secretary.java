package test5_company;

public class Secretary extends Employee implements Bonus {

	// constructors
	public Secretary() {
	}
	public Secretary(String name, int number, String department, int salary) {
		super(name, number, department, salary);
	}
	
	// fields
	
	// getter & setter

	// methods
	
	// override methods
	@Override
	public void incentive(int pay) {
		setSalary(getSalary() + (int)(pay * 0.8));
	}

	@Override
	public double tax() {
		return getSalary() * 0.1;
	}
}
