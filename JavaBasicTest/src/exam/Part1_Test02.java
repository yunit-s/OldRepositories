package exam;

public class Part1_Test02 {

	public static void main(String[] args) {
		Integer[] input = new Integer[2];
		input[0] = Integer.parseInt(args[0]);
		input[1] = Integer.parseInt(args[1]);
		if (input[0] * input[1] / 10 > 0) System.out.println((input[0] * input[1]) + " 은 두 자릿수 이상입니다.");
		else System.out.println((input[0] * input[1]) + " 은 한 자릿수입니다.");
	}
}
