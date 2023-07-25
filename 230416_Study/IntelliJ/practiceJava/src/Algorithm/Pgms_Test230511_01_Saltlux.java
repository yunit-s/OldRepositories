package Algorithm;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution_Test230511_01 {
    public int[] solution(int[] waiting) {
        int[] answer = {};

        // waiting에 있는 수를 hashset에서 검색, 있으면 넘어가고, 없으면 set에 저장하면서 arraylist에 저장
        Set<Integer> set = new HashSet<>();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < waiting.length; i++) {
            if (!set.contains(waiting[i])) {
                set.add(waiting[i]);
                list.add(waiting[i]);
            }
        }

        answer = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }

        return answer;
    }
}

public class Pgms_Test230511_01_Saltlux {
    public static void main(String[] args) {
        int[][] tcWaiting = {
                { 1, 5, 8, 2, 10, 5, 4, 6, 4, 8 },
                { 5, 4, 4, 3, 5 }
        };

        Solution_Test230511_01 sol = new Solution_Test230511_01();
        for (int i = 0; i < tcWaiting.length; i++) {
            int[] result = sol.solution(tcWaiting[i]);
            System.out.print("tc" + (i + 1) + "> ");
            for (int item : result) {
                System.out.print(item + ", ");
            }
            System.out.println();
        }

    }
}

/*
// 문제
영화 예매 중복신청 리스트 제거

정확성 테스트
테스트 1 〉 통과 (0.10ms, 65.9MB)
테스트 2 〉 통과 (0.04ms, 73.4MB)
테스트 3 〉 통과 (0.05ms, 76MB)
테스트 4 〉 통과 (0.28ms, 74.3MB)
테스트 5 〉 통과 (0.43ms, 74.9MB)
테스트 6 〉 통과 (0.60ms, 76.1MB)
테스트 7 〉 통과 (0.68ms, 74.8MB)
테스트 8 〉 통과 (0.06ms, 71.9MB)
테스트 9 〉 통과 (1.22ms, 85.2MB)
테스트 10 〉 통과 (0.11ms, 66.7MB)
테스트 11 〉 통과 (0.13ms, 69.2MB)
테스트 12 〉 통과 (0.20ms, 73MB)
테스트 13 〉 통과 (0.36ms, 79.3MB)
테스트 14 〉 통과 (0.58ms, 83.2MB)
테스트 15 〉 통과 (1.56ms, 76MB)
테스트 16 〉 통과 (2.40ms, 70MB)
테스트 17 〉 통과 (2.78ms, 77.3MB)
테스트 18 〉 통과 (3.21ms, 80.3MB)
테스트 19 〉 통과 (2.36ms, 85.1MB)
테스트 20 〉 통과 (2.58ms, 83.4MB)
테스트 21 〉 통과 (0.07ms, 72.5MB)
테스트 22 〉 통과 (0.08ms, 77.4MB)
효율성 테스트
테스트 1 〉 통과 (57.48ms, 84.5MB)
테스트 2 〉 통과 (68.00ms, 90.7MB)
테스트 3 〉 통과 (52.75ms, 86.1MB)
테스트 4 〉 통과 (57.13ms, 90.3MB)
테스트 5 〉 통과 (55.45ms, 88.3MB)
 */