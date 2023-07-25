package exam;

public class Part1_Test01 {

	public static void main(String[] args) {
		Integer input = Integer.parseInt(args[0]);
		if (input % 2 == 0) System.out.println(input + " 은 2의 배수입니다.");
		else System.out.println(input + " 은 2의 배수가 아닙니다.");
	}
}
