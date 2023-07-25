package exam;

class Calc {
	public int sum(int a, int b) { return a + b; } 
	public int subtract(int a, int b) { return a - b; } 
	public int multiply(int a, int b) { return a * b; } 
	public int divide(int a, int b) {
		if (b <= 0) return 0;
		else return a / b; 
	}
}

public class Part1_Test05 {

	public static void main(String[] args) {
		Integer[] num = { Integer.parseInt(args[0]), Integer.parseInt(args[1]) };
		Calc clac = new Calc();
		System.out.println("합 : " + clac.sum(num[0], num[1]));
		System.out.println("차 : " + clac.subtract(num[0], num[1]));
		System.out.println("곱 : " + clac.multiply(num[0], num[1]));
		System.out.println("나누기 : " + clac.divide(num[0], num[1]));
		
	}
}
