package Algorithm;

import java.util.LinkedList;
import java.util.Queue;

class Solution_42587 {
    public int solution(int[] priorities, int location) {
        int answer = 0;

        // 프로세스 정보를 Queue에 저장, 각 우선순위별 개수를 배열에 저장
        Queue<Integer[]> q = new LinkedList<>();
        int[] numCount = new int[10]; // 0은 사용 안 함
        for (int i = 0; i < priorities.length; i++) {
            q.offer(new Integer[]{priorities[i], i});
            numCount[priorities[i]]++;
        }

        // 하나씩 꺼내면서 메인 로직 실행
        while (!q.isEmpty()) {
            Integer[] process = q.poll();
            boolean first = true;

            // 판단
            for (int i = process[0] + 1; i < 10; i++) {
                if (numCount[i] > 0) {
                    first = false;
                    break;
                }
            }
            if (first == false) {
                // 최우선순위가 아니라면, 다시 집어넣기
                q.offer(process);
            } else {
                // 최우선순위라면, 개수 차감하고 answer++;
                numCount[process[0]]--;
                answer++;
                // 방금 빼낸 queue가 location 타겟이라면, 로직 종료
                if (process[1] == location) {
                    break;
                }
            }
        }

        return answer;
    }
}

public class Pgms_42587_Process {
    public static void main(String[] args) {
        int[][] tcPriorities = {
                { 2, 1, 3, 2 },
                { 1, 1, 9, 1, 1, 1 }
        };
        int[] tcLocation = { 2, 0 };

        Solution_42587 sol = new Solution_42587();
        for (int i = 0; i < tcPriorities.length; i++) {
            System.out.println("tc" + (i + 1) + "> " + sol.solution(tcPriorities[i], tcLocation[i]));
        }
    }
}
