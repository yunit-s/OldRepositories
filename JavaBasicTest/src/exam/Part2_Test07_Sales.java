package exam;

public class Part2_Test07_Sales extends Part2_Test07_Employee implements Part2_Test07_Bonus {

	public Part2_Test07_Sales() {
		super();
	}
	public Part2_Test07_Sales(String name, int number, String department, int salary) {
		super(name, number, department, salary);
	}
	
	@Override
	public void incentive(int pay) {
		setSalary((int)(getSalary() + pay * 1.2));
	}
	@Override
	public double tax() {
		return getSalary() * 0.13;
	}

}
