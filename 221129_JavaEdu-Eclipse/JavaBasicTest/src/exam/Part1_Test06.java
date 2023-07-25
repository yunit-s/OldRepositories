package exam;

public class Part1_Test06 {

	public static void main(String[] args) {
		int[] array = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
		double sum = 0;
		for (int num : array) {
			if (num % 2 == 0) continue;
			sum += num;
			System.out.println(num);
		}
		System.out.println("합계 : " + sum);
	}
}
