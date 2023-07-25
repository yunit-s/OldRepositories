package exam;

public class Part1_Test03 {

	public static void main(String[] args) {
		for (int i = 2; i < 6; i++) {
			for (int j = 1; j < 10; j++) {
				int mul = i * j;
				if (mul % 2 != 0) System.out.println(i + "*" + j + "=" + mul);
			}
		}
	}
}
