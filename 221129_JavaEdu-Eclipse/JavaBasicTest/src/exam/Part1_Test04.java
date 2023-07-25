package exam;

public class Part1_Test04 {

	public static void main(String[] args) {
		int sum = 0, i = 1;
		do {
			sum += i++;
		} while(i < 101);
		System.out.println("합계 : " + sum + "\n평균 : " + sum/100);
	}
}
