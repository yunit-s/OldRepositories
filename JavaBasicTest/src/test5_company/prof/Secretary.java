package test5_company.prof;

public class Secretary extends Employee implements Bonus {

	public Secretary() {
	}
	public Secretary(String name, int number, String department, int salary) {
		super(name, number, department, salary);
	}

	@Override
	public void incentive(int pay) {
		setSalary((int)((pay * 0.8) + getSalary())); // 정수와 실수 사이에 연산이 이루어지면, 범위가 더 큰 실수로 맞춰진다.
	}

	@Override
	public double tax() {
		return getSalary() * 0.1;
	}
}
