package exam;

public class Part2_Test07_Secretary extends Part2_Test07_Employee implements Part2_Test07_Bonus {

	public Part2_Test07_Secretary() {
		super();
	}
	public Part2_Test07_Secretary(String name, int number, String department, int salary) {
		super(name, number, department, salary);
	}

	@Override
	public void incentive(int pay) {
		setSalary((int)(getSalary() + pay * 0.8));
	}
	@Override
	public double tax() {
		return getSalary() * 0.1;
	}
	
}
