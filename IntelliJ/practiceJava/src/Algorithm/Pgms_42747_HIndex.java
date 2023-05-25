package Algorithm;

import java.util.Arrays;
import java.util.Collections;

class Solution_42747 {
    public int solution(int[] citations) {
        int answer = 0;

        // int[] 데이터를 내림차순으로 정렬
        Integer[] integerCitations = Arrays.stream(citations).boxed().toArray(Integer[]::new);
        Arrays.sort(integerCitations, Collections.reverseOrder());
        for (int i  = 0; i < integerCitations.length; i++) {
            if (integerCitations[i] >= i + 1) {
                answer++;
            } else {
                break;
            }
        }

        return answer;
    }
}

public class Pgms_42747_HIndex {
    public static void main(String[] args) {
        int[][] tcCitations = {
                { 3, 0, 6, 1, 5 },
                { 0, 0, 0, 0 },
                { 1, 0, 0, 0 },
                { 0, 0, 3, 0 },
                { 1, 0, 3, 2 },
        };

        Solution_42747 sol = new Solution_42747();
        for (int i = 0; i < tcCitations.length; i++) {
            System.out.println("tc" + (i + 1) + "> " + sol.solution(tcCitations[i]));
        }
    }
}
