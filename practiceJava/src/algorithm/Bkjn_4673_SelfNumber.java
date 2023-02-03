package algorithm;

public class Bkjn_4673_SelfNumber {

	public static void main(String[] args) {
		// Input
		int[] result = new int[10001]; // 생성자 있으면 1, 없으면 0
		
		// Process
		for (int i = 0; i < 10000; i++) {
			int selfSum = i;
			int tmpNum = i;
			while (tmpNum > 0) {
				selfSum += tmpNum % 10;
				if (selfSum >= 10000)
					break;
				else
					tmpNum /= 10;
			}
			if (selfSum <= 10000)
				result[selfSum] = 1;
		}
		
		// Output
		for (int i = 1; i <= 10000; i++) {
			if (result[i] == 0)
				System.out.println(i);
		}
	}
}
