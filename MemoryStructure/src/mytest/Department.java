package mytest;

public class Department {

	// constructor
	public Department() {
	}
	public Department(String deptName, String deptNumber) {
		this.deptName = deptName;
		this.deptNumber = deptNumber;
	}
	
	// field
	private String deptName; // 학과명
	private String deptNumber; // 학과 전화번호
	
	// method
	// business method 생략
	// getter & setter
	public String getDeptName() {
		return deptName;
	}
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	public String getDeptNumber() {
		return deptNumber;
	}
	public void setDeptNumber(String deptNumber) {
		this.deptNumber = deptNumber;
	}
	
}
