package Algorithm;

import java.util.Scanner;

class Solution_120906 {
    public int solution(int n) {
        int answer = 0;

        while (n > 0) {
            answer += n % 10;
            n = n / 10;
        }

        return answer;
    }
}

public class Pgms_120906_SumDigits {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        Solution_120906 sol = new Solution_120906();
        int answer = sol.solution(n);
        System.out.println(answer);
    }
}

/*
// --------------------------------------------------
// 120906-자릿수 더하기
// 구현 방법


// --------------------------------------------------
// 제출 결과


// test case
930211

// test case 정답
16

*/
