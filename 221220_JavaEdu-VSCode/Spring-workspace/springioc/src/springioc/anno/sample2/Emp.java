package springioc.anno.sample2;

public class Emp {

	private String name;
	private int age;
	
	public Emp() {
		System.out.println("!! Emp() default 생성자 호출");
	}

	public Emp(String name, int age) {
		super();
		this.name = name;
		this.age = age;
		System.out.println("!! Emp() 생성자 호출 - name:" + name + ", age:" + age);
	}

	public void setName(String name) {
		this.name = name;
		System.out.println("!!! Emp.setName() 호출 - name:" + name);
	}

	public void setAge(int age) {
		this.age = age;
		System.out.println("!!! Emp.setAge() 호출 - name:" + age);
	}

	@Override
	public String toString() {
		return name + ", " + age;
	}
}
