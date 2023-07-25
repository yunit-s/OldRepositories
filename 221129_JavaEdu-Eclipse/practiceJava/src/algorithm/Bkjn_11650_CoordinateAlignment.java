/*
// 11650-좌표 정렬하기
// 구현 방법
merge sort 두 번

// 변수 설명

*/

package algorithm;

import java.util.Scanner;

class Process {
	
	private int N;
	private int[][] dot;
	
	public void input() {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		dot = new int[N][2];
		
		for (int i = 0; i < N; i++) {
			dot[i][0] = sc.nextInt();
			dot[i][1] = sc.nextInt();
		}
	}
	
	public void printDot() {
		for (int i = 0; i < N; i++) {
//			System.out.println("(" + dot[i][0] + ", " + dot[i][1] + ")");
			System.out.println(dot[i][0] + " " + dot[i][1]);
		}
	}
	
}

public class Bkjn_11650_CoordinateAlignment {
	
	public static void main(String[] args) {
		
		Process pr = new Process();
		
		// input
		pr.input();
		
		// process
		
		// output
		pr.printDot();
	}
}

/*

//제출 결과
구현 시간 - 1시간 20분
1번째 시도 - 맞았습니다! 채점 시간 3초

//test case
5
3 4
1 1
1 -1
2 2
3 3

//test case 정답
1 -1
1 1
2 2
3 3
3 4

*/
