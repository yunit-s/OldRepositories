package student;

public class Student extends Human {

	// fields
	private String number;
	private String major;
	
	// constructors
	public Student() {
		
	}
	public Student(String name, int age, int height, int weight, String number, String major) {
		super(name, age, height, weight);
		this.number = number;
		this.major = major;
	}
	
	// methods
	public String printInformation() {
		return super.printInformation() + "\t" + number + "\t" + major;
	}
	
	// getter & setter
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getMajor() {
		return major;
	}
	public void setMajor(String major) {
		this.major = major;
	}
}
