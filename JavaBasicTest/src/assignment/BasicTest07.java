package assignment;

import java.util.Scanner;

public class BasicTest07 {

	public static void main(String[] args) {
		// Scanner로 입력받는 방법 
//		Scanner sc = new Scanner(System.in);
//		double[] a = new double[5];
//		a[0] = sc.nextDouble(); 
		
		// arguments 입력받기
		while (true) {
			if (args.length != 5) {
				System.out.println("Err> 5개의 정수를 입력하세요.");
			} else {
				int input;
				for (int i = 0; i < 5; i++) {
					input = Integer.parseInt(args[i]);
					if (input < 10 || input > 99) {
						System.out.println("Err> 10~99까지의 숫자를 입력하세요.");
						break;
					}
				}
			}
		}
		for (int i = 0; i < 5; i++) {
		}
		
		for (int i = 0; i < 5; i++) {
			System.out.println(a[i] + ", ");
		}
		
	}
}
