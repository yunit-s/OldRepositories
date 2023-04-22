package Algorithm;

import java.util.HashMap;
import java.util.Map;

class Solution_1845 {
    public int solution(int[] nums) {
        int answer = 0;

        Map<Integer, Integer> ponkemonMap = new HashMap<>();

        // nums 데이터를 해시로 저장
        for (int ponkemon : nums) {
            ponkemonMap.put(ponkemon, ponkemonMap.getOrDefault(ponkemon, 1) + 1);
        }

        // 종류가 너무 적으면 종류 수만큼 가능. 종류가 너무 많으면 모든 종류 한 마리씩 가능
        if (nums.length / 2 < ponkemonMap.size())
            answer = nums.length / 2;
        else
            answer = ponkemonMap.size();

        return answer;
    }
}

public class Pgms_1845_Ponkemon {
    public static void main(String[] args) {
        int[][] tcNums = {
                { 3, 1, 2, 3 },
                { 3, 3, 3, 2, 2, 4 },
                { 3, 3, 3, 2, 2, 2 }
        };

        Solution_1845 sol = new Solution_1845();
        for (int i = 0; i < tcNums.length; i++) {
            int result = sol.solution(tcNums[i]);
            System.out.println("tc" + (i + 1) + "> " + result);
        }
    }
}

/*
// --------------------------------------------------
// 1845-폰켓몬
// 구현 방법
해시

// --------------------------------------------------
// 제출 결과
1번째 : 통과

// test case 정답
2
3
2

*/
