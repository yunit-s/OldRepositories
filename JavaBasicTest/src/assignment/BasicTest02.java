package assignment;

public class BasicTest02 {

	public static void main(String[] args) {
		int input = Integer.parseInt(args[0]);
		int result = 1;
		for (int i = 1; i <= input; i++) {
			result *= i;
			System.out.print(i);
			if (i != input)
				System.out.print("*");
		}
		System.out.println(" = " + result);
	}
}
