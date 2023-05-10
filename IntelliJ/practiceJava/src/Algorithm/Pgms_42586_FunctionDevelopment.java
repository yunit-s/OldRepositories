package Algorithm;

import java.util.ArrayList;
import java.util.List;

class Solution_42586 {
    public int[] solution(int[] progresses, int[] speeds) {
        int[] answer = {};

        // 배포까지 걸리는 날짜 계산
        int[] distrDay = new int[progresses.length];
        for (int i = 0; i < progresses.length; i++) {
            distrDay[i] = (int)Math.ceil((100.0 - progresses[i]) / speeds[i]);
        }

        // 배포 날짜 배열을 0부터 끝까지 검토하면서, 뒷 수가 앞 수보다 더 작으면, 앞 수로 올리기
        for (int i = 0; i < distrDay.length - 1; i++) {
            if (distrDay[i + 1] < distrDay[i]) {
                distrDay[i + 1] = distrDay[i];
            }
        }

        // 숫자가 연속되는 횟수 카운트해서 answer에 저장하기
        List<Integer> answerList = new ArrayList<>();
        int count = 0; // 연속으로 나오는 개수 저장
        for (int i = 0; i < distrDay.length - 1; i++) {
            if (distrDay[i] == distrDay[i + 1]) {
                count++;
            } else {
                answerList.add(count + 1); // 지금 수까지 개수에 포함하고 저장
                count = 0;
            }
        }
        // 마지막 수에 대한 처리
        // 이전 수와 같든 다르든 이걸로 해결 가능
        answerList.add(count + 1);

        // ArrayList 를 int[] 배열로 변경
        answer = new int[answerList.size()];
        for (int i = 0; i < answerList.size(); i++) {
            answer[i] = answerList.get(i);
        }

        return answer;
    }
}

public class Pgms_42586_FunctionDevelopment {
    public static void main(String[] args) {
        int[][] tcProgresses = {
                { 93, 30, 55 },
                { 95, 90, 99, 99, 80, 99 }
        };
        int[][] tcSpeeds = {
                { 1, 30, 5 },
                { 1, 1, 1, 1, 1, 1 }
        };

        Solution_42586 sol = new Solution_42586();
        for (int i = 0; i < tcProgresses.length; i++) {
            int[] result = sol.solution(tcProgresses[i], tcSpeeds[i]);
            System.out.print("tc" + (i + 1) + "> ");
            for (int item : result) {
                System.out.print(item + ", ");
            }
            System.out.println();
        }
    }
}
