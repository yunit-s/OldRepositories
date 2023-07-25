package exam;

public abstract class Part2_Test07_Employee {

	private String name;
	private int number;
	private String department;
	private int salary;

	public Part2_Test07_Employee() {
	}
	public Part2_Test07_Employee(String name, int number, String department, int salary) {
		this.name = name;
		this.number = number;
		this.department = department;
		this.salary = salary;
	}
	
	public String getName() {return name;}
	public void setName(String name) {this.name = name;}
	public int getNumber() {return number;}
	public void setNumber(int number) {this.number = number;}
	public String getDepartment() {return department;}
	public void setDepartment(String department) {this.department = department;}
	public int getSalary() {return salary;}
	public void setSalary(int salary) {this.salary = salary;}

	@Override
	public String toString() {
		return name + "\t\t" + department + "\t" + salary;
	}
	public abstract double tax();
	
}
