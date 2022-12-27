package jdbc.vo;

public class PracticeJDBC_test02_Book {

	private String category;
	private String department_name;
	private int capacity;
	
	public PracticeJDBC_test02_Book() {
		// TODO Auto-generated constructor stub
	}

	public PracticeJDBC_test02_Book(String category, String department_name, int capacity) {
		this.category = category;
		this.department_name = department_name;
		this.capacity = capacity;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getDepartment_name() {
		return department_name;
	}

	public void setDepartment_name(String department_name) {
		this.department_name = department_name;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
}
