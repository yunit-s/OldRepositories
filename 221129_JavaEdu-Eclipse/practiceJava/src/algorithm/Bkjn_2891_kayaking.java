/*
// 2891-카약과 강풍
// 구현 방법
우선, 여분을 가져온 팀의 카약이 부서지면, 처음부터 여분이 없는 샘 친다.
그 다음, 가장 앞번호 팀의 여분을, 빌려줄 수 있는 팀 중 앞번호 팀에게 최대한 몰아준다.
(만약 여분이 있는 팀을 끝번호부터 시작할 경우, 빌려줄 수 있는 팀 중 끝번호 팀에게 빌려줘야 한다.)
이런 식으로 고장난 팀을 하나씩 제거하면 최대한 많은 팀을 케어할 수 있게 된다.

// 변수 설명
sTeam : 인덱스가 곧 팀번호
rTeamNum : 여분이 있는 팀번호. 인덱스는 여분이 있는 팀의 수

*/

package algorithm;

import java.util.Scanner;

public class Bkjn_2891_kayaking {

	public static void main(String[] args) {
		// input
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int S = sc.nextInt();
		int R = sc.nextInt();
		int sTeam[] = new int[11]; // 0 : 정상, 1 : 파손
		int rTeamNum[] = new int[10];
		for (int i = 1; i < 11; i++) {
			sTeam[i] = 0; // 0 초기화
		}
		for (int i = 0; i < S; i++) {
			int team = sc.nextInt();
			sTeam[team] = 1;
		}
		for (int i = 0; i < R; i++) {
			rTeamNum[i] = sc.nextInt();
		}
		
		// process
		for (int i = 0; i < R; i++) {
			int team = rTeamNum[i];
			if (sTeam[team] == 1) {
				sTeam[team] = 0;
			} else if (team > 1 && sTeam[team - 1] == 1) {
				sTeam[team - 1] = 0;
			} else if (team < N && sTeam[team + 1] == 1) {
				sTeam[team + 1] = 0;
			}
		}
		
		// output
		int answer = 0;
		for (int i = 1; i < N + 1; i++) {
			if (sTeam[i] == 1)
				answer++;
		}
		System.out.println(answer);
	}
}

/*

//제출 결과
구현 시간 - 1시간 20분
1번째 시도 - 맞았습니다! 채점 시간 3초

//test case

9 3 3
5 6 8
4 5 7

9 4 3
3 5 7 8
2 4 6

9 4 3
1 2 4 6
3 5 7

//test case 정답
 
0
1
1

*/
