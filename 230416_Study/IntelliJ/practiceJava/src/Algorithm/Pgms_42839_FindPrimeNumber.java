package Algorithm;

import java.util.TreeSet;

class Solution_42839 {
    public int solution(String numbers) {
        int answer = 0;

        // 소수 저장 - 에라토스테네스의 체
        // 소수가 0, 소수 아니면 1
        int[] primeNum = new int[(int)Math.pow(10, numbers.length())];
        primeNum[1] = 1;
        primeNum[0] = 1;
        for (int i = 2; i < Math.sqrt(Math.pow(10, numbers.length())); i++) {
            if (primeNum[i] == 0) {
                int j = i * 2;
                while (j < (int)Math.pow(10, numbers.length())) {
                    if (primeNum[j] == 0)
                        primeNum[j] = 1;
                    j += i;
                }
            }
        }

        // 만들 수 있는 모든 수 numSet에 저장
        TreeSet<Integer> numSet = new TreeSet<>();
        makeNumSet(numSet, 0, numbers.toCharArray());

        // numSet 요소 중 소수 개수 세기
        for (int item : numSet) {
            if (primeNum[item] == 0)
                answer++;
        }

        return answer;
    }

    // index가 digit인 곳부터 numArr 뒷부분 숫자 위치섞기
    void makeNumSet(TreeSet<Integer> numSet, int digit, char[] numArr) {
        if (digit == numArr.length) {
            // 마지막 자릿수까지 swap이 됐을 때, 1~n자리 수 저장
            for (int i = 0; i < numArr.length; i++) {
                numSet.add(Integer.parseInt((new String(numArr)).substring(i)));
            }
        } else {
            // 아직 재귀호출할 게 남아있는 경우
            char[] newArr = new char[numArr.length];
            System.arraycopy(numArr,0, newArr, 0, numArr.length); // 현재 상태 저장
            for (int i = digit; i < newArr.length; i++) {
                // 자리 swap
                char temp = newArr[digit];
                newArr[digit] = newArr[i];
                newArr[i] = temp;
                // 재귀함수 호출
                makeNumSet(numSet, digit + 1, newArr);
            }
        }
    }
}

public class Pgms_42839_FindPrimeNumber {
    public static void main(String[] args) {
        String[] tcNumbers = {
                "17", "011", "000", "001", "011",
                "033", "333", "0011", "1234"
        };

        Solution_42839 sol = new Solution_42839();
        for (int i = 0; i < tcNumbers.length; i++) {
            System.out.println("tc" + (i + 1) + "> " + sol.solution(tcNumbers[i]));
        }
    }
}

/*
// 테스트 케이스 정답
3, 2, 0, 0, 2,
1, 1, 2, 14

첫 번째 시도 : 2, 10, 11, 12번 실패
두 번째 시도 : 성공
테스트 1 〉	통과 (3.13ms, 82.7MB)
테스트 2 〉	통과 (94.21ms, 96.1MB)
테스트 3 〉	통과 (0.78ms, 72.9MB)
테스트 4 〉	통과 (93.85ms, 97.4MB)
테스트 5 〉	통과 (1503.76ms, 116MB)
테스트 6 〉	통과 (0.86ms, 74.3MB)
테스트 7 〉	통과 (4.65ms, 69.6MB)
테스트 8 〉	통과 (1552.45ms, 139MB)
테스트 9 〉	통과 (0.96ms, 76.7MB)
테스트 10 〉	통과 (96.21ms, 82.8MB)
테스트 11 〉	통과 (13.77ms, 76.2MB)
테스트 12 〉	통과 (14.82ms, 82.1MB)
세 번째 시도 : 에라토스테네스 체 제곱근까지만 하는 방식으로 개선
테스트 1 〉	통과 (2.14ms, 84.4MB)
테스트 2 〉	통과 (70.05ms, 93MB)
테스트 3 〉	통과 (0.60ms, 72.1MB)
테스트 4 〉	통과 (64.51ms, 91.5MB)
테스트 5 〉	통과 (814.40ms, 133MB)
테스트 6 〉	통과 (0.65ms, 76.3MB)
테스트 7 〉	통과 (2.20ms, 74MB)
테스트 8 〉	통과 (831.18ms, 129MB)
테스트 9 〉	통과 (1.04ms, 77.6MB)
테스트 10 〉	통과 (57.73ms, 97.9MB)
테스트 11 〉	통과 (11.16ms, 77.6MB)
테스트 12 〉	통과 (10.83ms, 76.6MB)
 */