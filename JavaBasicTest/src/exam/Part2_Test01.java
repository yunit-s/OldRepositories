package exam;

public class Part2_Test01 {

	public static void main(String[] args) {
		int[][] array = { { 12, 41, 36, 56 }, { 82, 10, 12, 61 }, { 14, 16, 18, 78 }, { 45, 26, 72, 23 } };
		double sum = 0, numCount = 0, avr = 0;
		for (int[] arr : array) {
			for (int num : arr) {
				sum += num;
				numCount++;
			}
		}
		avr = sum / numCount;
		System.out.println("합계 : " + sum);
		System.out.println("평균 : " + avr);
	}
}
