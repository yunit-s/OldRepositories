package Algorithm;

import java.util.Arrays;
import java.util.Comparator;

// 다른 사람 코드 보고 로직 참고함
//    정확성  테스트
//    테스트 1 〉	통과 (1941.82ms, 390MB)
//    테스트 2 〉	통과 (832.98ms, 400MB)
//    테스트 3 〉	통과 (3285.40ms, 395MB)
//    테스트 4 〉	통과 (36.99ms, 99.5MB)
//    테스트 5 〉	통과 (1741.54ms, 408MB)
//    테스트 6 〉	통과 (1265.87ms, 390MB)
//    테스트 7 〉	통과 (15.12ms, 83.4MB)
//    테스트 8 〉	통과 (17.60ms, 75.3MB)
//    테스트 9 〉	통과 (15.53ms, 77.2MB)
//    테스트 10 〉	통과 (19.97ms, 82MB)
//    테스트 11 〉	통과 (14.89ms, 77.4MB)
//    테스트 12 〉	통과 (16.76ms, 85.5MB)
//    테스트 13 〉	통과 (12.52ms, 80.1MB)
//    테스트 14 〉	통과 (14.45ms, 82.8MB)
//    테스트 15 〉	통과 (13.80ms, 80.3MB)
class Solution_42746 {
    public String solution(int[] numbers) {
        String answer = "";

        // 두 숫자를 이어붙이는 두 가지 방법에 대한 대소 비교. 더 큰 숫자가 나오게 하는 게 앞에 온다.
        Integer[] instNumbers = Arrays.stream(numbers).boxed().toArray(Integer[]::new);
        Arrays.sort(instNumbers, new Comparator<Integer>() {
            @Override
            public int compare(Integer s1, Integer s2) {
                return -1 * (s1.toString() + s2.toString()).compareTo(s2.toString() + s1.toString());
            }
        });
        numbers = Arrays.stream(instNumbers).mapToInt(Integer::intValue).toArray();

        // 정렬한 숫자 이어붙이기
        for (int num: numbers) {
            answer += num;
        }

        // 연속 0 예외처리 (테스트케이스 11)
        boolean isZero = true;
        for (int i = 0; i < answer.length(); i++) {
            if (answer.charAt(i) != '0') {
                isZero = false;
                break;
            }
        }
        if (isZero == true)
            answer = "0";

        return answer;
    }
}

public class Pgms_42746_LargestNumber {
    public static void main(String[] args) {
        int[][] tcNumbers = {
                { 6, 10, 2 },
                { 3, 30, 34, 5, 9 },
                { 0, 5, 55, 555, 545, 565, 546 },
                { 0, 0, 0, 0, 0 }
        };

        Solution_42746 sol = new Solution_42746();
        for (int i = 0; i < tcNumbers.length; i++) {
            System.out.println("tc" + (i + 1) + "> " + sol.solution(tcNumbers[i]));
        }
    }
}