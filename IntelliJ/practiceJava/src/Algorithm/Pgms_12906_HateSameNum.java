package Algorithm;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Solution_12906 {
    public int[] solution(int []arr) {
        int[] answer = {};

        Queue<Integer> q = new LinkedList<>();
        q.add(arr[0]);
        int i = 1;
        while (i < arr.length) {
            if (arr[i - 1] != arr[i]) {
                q.add(arr[i]);
            }
            i++;
        }

        answer = new int[q.size()];
        int j = 0;
        while (!q.isEmpty()) {
            answer[j++] = q.poll();
        }

        return answer;
    }
}

public class Pgms_12906_HateSameNum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // input
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        // process
        Solution_12906 sol = new Solution_12906();
        for (int num : sol.solution(arr)) {
            System.out.print(num + ", ");
        }
    }
}

/*
// --------------------------------------------------
// 12906-같은 숫자는 싫어
// 구현 방법
스택/큐 문제니까.. 억지로 써보자.

// --------------------------------------------------
// 제출 결과
구현 시간 - 25분
1번째 - 통과

// test case
7 1 1 3 3 0 1 1

// test case 정답
1 3 0 1

*/
