package test5_company;

public abstract class Employee {

	// constructors
	public Employee() {
	}
	public Employee(String name, int number, String department, int salary) {
		this.name = name;
		this.number = number;
		this.department = department;
		this.salary = salary;
	}
	
	// fields
	private String name;
	private int number;
	private String department; // 부서
	private int salary; // 월급
	
	// getter & setter
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	
	// methods
	
	// abstract methods
	public abstract double tax(); // 세금

	// override methods
	@Override
	public String toString() {
		return name + "\t" + department + "\t" + salary;
	}
	
}
