package Algorithm;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Solution_42840 {
    public int[] solution(int[] answers) {
        int[] submit1 = { 1, 2, 3, 4, 5 };
        int[] submit2 = { 2, 1, 2, 3, 2, 4, 2, 5 };
        int[] submit3 = { 3, 3, 1, 1, 2, 2, 4, 4, 5, 5 };

        // 점수 계산
        int[] score = { 0, 0, 0 };
        for (int i = 0; i < answers.length; i++) {
            if (answers[i] == submit1[i % submit1.length]) {
                score[0]++;
            }
            if (answers[i] == submit2[i % submit2.length]) {
                score[1]++;
            }
            if (answers[i] == submit3[i % submit3.length]) {
                score[2]++;
            }
        }

        // 최댓값 찾기
        int max = score[0];
        if (score[1] > max) {
            max = score[1];
        }
        if (score[2] > max) {
            max = score[2];
        }

        // 최대 점수를 받은 사람들만 저장
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < score.length; i++) {
            if (score[i] == max)
                list.add(i + 1);
        }

        int[] answer = new int[list.size()];
        int j = 0;
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }

        return answer;
    }

    public void printAnswer(int[] answer) {
        for (int i = 0; i < answer.length; i++) {
            System.out.print(answer[i] + ", ");
        }
    }
}

public class Pgms_42840_MockTest {
    public static void main(String[] args) {
        int[][] tc = {{ 1, 2, 3, 4, 5 },
                { 1, 3, 2, 4, 2 },
                { 1 },
                { 2 },
                { 3 },
                { 3, 2 },
                { 1, 3, 2, 4, 2, 1, 2, 4, 5, 5 }};

        Solution_42840 sol = new Solution_42840();
        for (int i = 0; i < tc.length; i++) {
            System.out.print("tc" + (i + 1) + "> ");
            sol.printAnswer(sol.solution(tc[i]));
            System.out.println();
        }
    }
}

/*
// --------------------------------------------------
// 42840-모의고사
// 구현 방법


// --------------------------------------------------
// 제출 결과
구현 시간 - 25분

// test case 정답
1
1 2 3
1
2
3
1 3
1 2 3


*/
