package exam;

class Human {
	
	String name;
	int age;
	int height;
	int weight;
	
	public Human() {
	}
	public Human(String name, int age, int height, int weight) {
		super();
		this.name = name;
		this.age = age;
		this.height = height;
		this.weight = weight;
	}
	
	public String printInformation() {
		return name + "\t" + age + "\t" + height + "\t" + weight;
	}
}

class Student extends Human {
	
	private String number;
	private String major;
	
	public Student() {
	}
	public Student(String name, int age, int height, int weight, String number, String major) {
		super(name, age, height, weight);
		this.number = number;
		this.major = major;
	}
	
	@Override
	public String printInformation() {
		return super.printInformation() + "\t" + number + "\t" + major;
	}
}

public class Part2_Test02 {
	
	public static void main(String[] args) {
		
		Student[] arrays = new Student[3];
		arrays[0] = new Student("홍길동", 15, 171, 81, "201101", "영문");
		arrays[1] = new Student("한사람", 13, 183, 72, "201102", "건축");
		arrays[2] = new Student("임걱정", 16, 175, 65, "201103", "무용");
		
		for (Student s : arrays) {
			System.out.println(s.printInformation());
		}
	}
}
