package Algorithm;

import java.util.HashMap;
import java.util.Map;

class Solution_42578 {
    public int solution(String[][] clothes) {
        int answer = 0;

        // 의상 종류별 가지수 세기
        Map<String, Integer> kindMap = new HashMap<>();
        for (String[] cloth : clothes) {
            kindMap.put(cloth[1], kindMap.getOrDefault(cloth[1], 0) + 1);
        }

        // 각 종류별로 선택 경우의 수 : 옷 가짓수 + 1(안 입는 경우)
        // 옷 입는 가짓수 : 모든 경우의 수를 곱한 다음, 아무 것도 입지 않는 경우(1)을 뺀다.
        answer = 1;
        for (int cases : kindMap.values()) {
            answer *= (cases + 1);
        }
        answer -= 1;

        return answer;
    }
}

public class Pgms_42578_Clothes {
    public static void main(String[] args) {
        String[][][] tcClothes = {
                {
                        { "yellow_hat", "headgear" },
                        { "blue_sunglasses", "eyewear" },
                        { "green_turban", "headgear" }
                },
                {
                        { "crow_mask", "face" },
                        { "blue_sunglasses", "face" },
                        { "smoky_makeup", "face" }
                }
        };

        Solution_42578 sol = new Solution_42578();
        for (int i = 0; i < tcClothes.length; i++) {
            System.out.println("tc" + (i + 1) + "> " + sol.solution(tcClothes[i]));
        }
    }
}
