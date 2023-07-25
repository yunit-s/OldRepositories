package Algorithm;

class Solution_43165 {
    int answer = 0;
    public int solution(int[] numbers, int target) {
        answer = 0;

        calc(numbers, target, 0, 0);

        return answer;
    }

    // numbers : 전체 숫자 배열
    // idx : 이번에 계산할 자리의 인덱스
    // num : 이전 자리 수까지 계산한 결과
    public void calc(int[] numbers, int target, int idx, int num) {
        // num +- numbers[idx] 계산 후, 이 뒤에도 숫자가 남았으면 재귀호출
//        System.out.println(idx + ", " + num);

        // +
        int curNum = num + numbers[idx];
        if (idx < numbers.length - 1) {
            calc(numbers, target, idx + 1, curNum);
        } else {
            if (curNum == target) {
                answer++;
            }
        }

        // -
        curNum = num - numbers[idx];
        if (idx < numbers.length - 1) {
            calc(numbers, target, idx + 1, curNum);
        } else {
            if (curNum == target) {
                answer++;
            }
        }
    }
}

public class Pgms_43165_TargetNumber {
    public static void main(String[] args) {
        int[][] tcNumbers = {
                { 1, 1, 1, 1, 1 },
                { 4, 1, 2, 1 }
        };
        int[] tcTarget = { 3, 4 };

        Solution_43165 sol = new Solution_43165();
        for (int i = 0; i < tcNumbers.length; i++) {
            System.out.println("tc" + (i + 1) + "> " + sol.solution(tcNumbers[i], tcTarget[i]));
        }
    }
}
