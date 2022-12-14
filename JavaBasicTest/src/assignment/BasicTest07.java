package assignment;

//import java.util.Scanner;

public class BasicTest07 {

	public static void main(String[] args) {
		// Scanner로 입력받는 방법 
//		Scanner sc = new Scanner(System.in);
//		double[] a = new double[5];
//		a[0] = sc.nextDouble(); 
		
		// arguments 입력받기
		if (args.length != 5) {
			System.out.println("Err> 5개의 정수를 입력하세요.");
		} else {
			int[] input = new int[5];
			for (int i = 0; i < 5; i++) {
				input[i] = Integer.parseInt(args[i]);
				if (input[i] < 10 || input[i] > 99) {
					System.out.println("Err> 10~99까지의 숫자를 입력하세요.");
					return;
				}
			}
			
			// 계산
			double result = (input[0] + input[1]) / 2 * 0.6 + (input[2] + input[3]) / 2 * 0.2 + input[4] * 0.2;
			System.out.println("평가점수 : " + result + "점");
			System.out.print("Class : ");
			if (result >= 90) {
				System.out.println("Gold Class");
			} else if (result >= 80) {
				System.out.println("Silver Class");
			} else if (result >= 70) {
				System.out.println("Bronze Class");
			} else {
				System.out.println("Normal Class");
			}
		}
	}
}
