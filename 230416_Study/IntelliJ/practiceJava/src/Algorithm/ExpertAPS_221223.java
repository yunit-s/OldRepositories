/*
// 코딩 테스트 - 장기판의 포
X : 목표 장기말
L : 빈 칸
Y : 넘을 수 없는 다른 포
H : 넘을 수 있고, 먹을 수 있는 말
먹을 수 있는 말의 개수 세기

 */

package Algorithm;

import java.util.Scanner;
//import java.io.FileInputStream;

public class ExpertAPS_221223 {
	static int AnswerN;
	static int N = 10;

	public static void main(String args[]) throws Exception {
//		System.setIn(new FileInputStream("C:\sample_input.txt"));
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		char[][] map = new char[100][100];
		int X_i = 0, X_j = 0, cnt = 0;

		for(int test_case = 1; test_case <= T; test_case++) {
			// input
			AnswerN = 0;
			N = sc.nextInt();
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					map[i][j] = sc.next().charAt(0);
					if (map[i][j] == 'X') {
						X_i = i;
						X_j = j;
					}
				}
			}
			
			// process
			// up
			cnt = 0;
			for (int i = X_i; i >= 0; i--) {
				// Y이면 아웃
				// H 이면서 cnt 0 이면 cnt++
				// H 이면서 cnt 1 이면 true. AnswerN++, break;
				if (map[i][X_j] == 'Y') {
					break;
				} else if (map[i][X_j] == 'H') {
					if (cnt == 0) cnt++;
					else {
						AnswerN++;
						break;
					}
				}
			}

			// down
			cnt = 0;
			for (int i = X_i; i < N; i++) {
				if (map[i][X_j] == 'Y') {
					break;
				} else if (map[i][X_j] == 'H') {
					if (cnt == 0) cnt++;
					else {
						AnswerN++;
						break;
					}
				}
			}

			// left
			cnt = 0;
			for (int j = X_j; j >= 0; j--) {
				if (map[X_i][j] == 'Y') {
					break;
				} else if (map[X_i][j] == 'H') {
					if (cnt == 0) cnt++;
					else {
						AnswerN++;
						break;
					}
				}
			}

			// right
			cnt = 0;
			for (int j = X_j; j < N; j++) {
				if (map[X_i][j] == 'Y') {
					break;
				} else if (map[X_i][j] == 'H') {
					if (cnt == 0) cnt++;
					else {
						AnswerN++;
						break;
					}
				}
			}
			
			// output
			System.out.println("#"+test_case+" "+AnswerN);
		}
	}
}

/*
// 예시 테스트 케이스
3
8
L L H L L L L L
L L H L L L L L
L L Y L L L L L
H H X L L L H H
L L L L L L L L
L L Y L L L L L
L L Y L L L L L
L L L L L L L L
8
L L H L L L L L
L L H H L L L L
L L Y H L L L L
H H L L L L H H
H H L X H Y H L
L L Y H L L L L
L L Y H L L L L
L L L Y L L L L
8
L L H L L L L L
L L H H L L L L
L H Y X L Y H Y
H H L L L L H H
H L L H H Y H L
L L Y H L L L L
L L Y H L L L L
L L L Y L L L L

// 예시 답안
#1 2
#2 3
#3 1

*/