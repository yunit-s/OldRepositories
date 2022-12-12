package assignment;

public class BasicTest01 {

	public static void main(String[] args) {
		double arg1 = Double.parseDouble(args[0]);
		double arg2 = Double.parseDouble(args[1]);
		double remain = arg1 / arg2;
		if (remain > 1)
			System.out.println("나머지가 1보다 크다!");
		else
			System.out.println("나머지가 1보다 작거나 같다!");
	}
}
