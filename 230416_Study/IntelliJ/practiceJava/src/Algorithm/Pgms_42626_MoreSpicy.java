package Algorithm;

import java.util.PriorityQueue;

class Solution_42626 {
    public int solution(int[] scoville, int K) {
        int answer = 0;

        PriorityQueue<Integer> pQueue = new PriorityQueue<>();
        for (int food : scoville) {
            pQueue.add(food);
        }

        // pQueue의 최솟값이 K보다 작을 때만 반복
        // 최솟값 두 번 빼서 합한 걸 다시 넣기
        while (pQueue.peek() < K && pQueue.size() > 1) {
            pQueue.add(pQueue.poll() + pQueue.poll() * 2);
            answer++;
        }

        if (answer == scoville.length - 1 && pQueue.peek() < K)
            return -1;
        else
            return answer;
    }
}

public class Pgms_42626_MoreSpicy {
    public static void main(String[] args) {
        int[][] tcScoville = {
                { 1, 2, 3, 9, 10, 12 },
                { 0, 1 },
                { 0, 1 }
        };
        int[] tcK = { 7, 0, 2 };

        Solution_42626 sol = new Solution_42626();
        for (int i = 0; i < tcScoville.length; i++) {
            System.out.println(sol.solution(tcScoville[i], tcK[i]));
        }
    }
}

/*
// --------------------------------------------------
// 42626-더 맵게
// 구현 방법
힙. 우선순위 큐 클래스를 활용해보자.

// --------------------------------------------------
// 제출 결과
1번째 : 런타임 에러
pQueue에 저장된 값이 없는데도 poll()을 실행시키려 했기 때문
2번째 : 실패
완성되지 못하는 경우(-1이 리턴되는 경우)를 고려하지 않음
3번째 : 성공

// test case 정답
2
0
1

*/
