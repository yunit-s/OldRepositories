package Algorithm;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution_Test230511_02 {
    public boolean solution(int[] arr, int n) {
        // 큰 숫자 제거해서 새 list 생성
        List<Integer> list = new ArrayList<>();
        for (int num : arr) {
            if (num < n) {
                list.add(num);
            }
        }

        // list 오름차순 정렬
        Collections.sort(list);

        // list에 있는 숫자들 중, 제일 작은 수와 제일 큰 수의 합을 기준으로 검색
        // 합이 n보다 작으면, left++
        // 합이 n보다 크면, right++
        int left = 0, right = list.size() - 1;
        while (left != right) {
            if (list.get(left) + list.get(right) == n) {
                return true;
            } else {
                if (list.get(left) + list.get(right) < n) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return false;
    }
}

public class Pgms_Test230511_02_Saltlux {
    public static void main(String[] args) {
        int[][] tcArr = {
                { 5, 3, 9, 13 },
                { 5, 3, 9, 13 }
        };
        int[] tcN = { 8, 7 };

        Solution_Test230511_02 sol = new Solution_Test230511_02();
        for (int i = 0; i < tcArr.length; i++) {
            System.out.println("tc" + (i + 1) + "> " + sol.solution(tcArr[i], tcN[i]));
        }
    }
}

/*
// 문제
두 수의 합

// point
2중 for문이면 무조건 안 됨.
우선순위 큐, Collections.sort(list) 다 안 됨

// 마지막 코드
통과

정확성 테스트
테스트 1 〉 통과 (0.31ms, 87.5MB)
테스트 2 〉 통과 (0.29ms, 76.1MB)
테스트 3 〉 통과 (0.41ms, 71.6MB)
테스트 4 〉 통과 (0.70ms, 73.7MB)
테스트 5 〉 통과 (0.95ms, 72.4MB)
테스트 6 〉 통과 (1.74ms, 73MB)
테스트 7 〉 통과 (2.15ms, 78.4MB)
테스트 8 〉 통과 (1.70ms, 75.4MB)
테스트 9 〉 통과 (1.18ms, 85.4MB)
테스트 10 〉 통과 (1.55ms, 68.8MB)
테스트 11 〉 통과 (2.54ms, 66.4MB)
테스트 12 〉 통과 (3.87ms, 80MB)
테스트 13 〉 통과 (2.43ms, 84.5MB)
테스트 14 〉 통과 (2.77ms, 76.2MB)
효율성 테스트
테스트 1 〉 통과 (319.06ms, 95MB)
테스트 2 〉 통과 (239.78ms, 90.7MB)
테스트 3 〉 통과 (247.13ms, 90.5MB)
테스트 4 〉 통과 (375.83ms, 95.3MB)
*/
