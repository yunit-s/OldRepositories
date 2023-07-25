/*
// 코딩 테스트 - 팀 구성
N : 사람 수
L, R : 옆 사람 index

 */

package Algorithm;

import java.util.Scanner;
//import java.io.FileInputStream;

class CalcMethod_230321 {

	private int N;
	private int[] score = new int[100];
	private int[] teamScore = new int[100];
	
	public void inputData(Scanner sc, int N) {
		this.N = N;
		for (int i = 0; i < N; i++) {
			score[i] = sc.nextInt();
		}
	}
	
	public void process() {
		for (int i = 0; i < N; i++) {
			getTeamScore(i);
		}
	}
	
	public void getTeamScore(int person) {
		int L = person - 1, R = person + 1;
		int minscore = 0, tempminscore= 0;
		int tempscoresum = score[person];
		int scoresum = score[person];
		int maxscoresum = score[person];
		
		while(L >= 0) {
			tempscoresum += score[L];
			if (score[L] < tempminscore) tempminscore = score[L];
			if (tempscoresum > maxscoresum) {
				scoresum = tempscoresum;
				maxscoresum = tempscoresum;
				minscore = tempminscore;
			} else if ((tempscoresum - tempminscore) > maxscoresum) {
				scoresum = tempscoresum;
				maxscoresum = tempscoresum - tempminscore;
				minscore = tempminscore;
			}
			L--;
		}
		
		tempscoresum = scoresum;
		tempminscore = minscore;
		while(R < N) {
			tempscoresum += score[R];
			if (score[R] < tempminscore) tempminscore = score[R];
			if (tempscoresum > maxscoresum) {
				scoresum = tempscoresum;
				maxscoresum = scoresum;
				minscore = tempminscore;
			} else if ((tempscoresum - tempminscore) > maxscoresum) {
				scoresum = tempscoresum;
				maxscoresum = tempscoresum - tempminscore;
				minscore = tempminscore;
			}
			R++;
		}
		
		teamScore[person] = maxscoresum;
	}
	
	public int getAnswer() {
		int answer = 0;
		for (int i = 0; i < N; i++) {
			answer += teamScore[i];
		}
		return answer;
	}
}

public class ExpertAPS_230321 {
	static int AnswerN;
	static int N = 10;

	public static void main(String args[]) throws Exception {
//		System.setIn(new FileInputStream("C:\sample_input.txt"));
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for(int test_case = 1; test_case <= T; test_case++) {
			// input
			CalcMethod_230321 Calc = new CalcMethod_230321();
			AnswerN = 0;
			N = sc.nextInt();
			Calc.inputData(sc, N);
			
			// process
			Calc.process();
			
			// output
			AnswerN = Calc.getAnswer();
			System.out.println("#"+test_case+" "+AnswerN);
		}
	}
}

/*
// 예시 테스트 케이스
3
5
-1 2 -3 2 -1
1
0
4
1 1 1 1

// 예시 답안
#1 15
#2 0
#3 16

*/