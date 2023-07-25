package Algorithm;

import java.util.Arrays;

class Solution_42748 {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = {};
        answer = new int[commands.length];

        // commands 조합 수만큼 반복
        for (int i = 0; i < commands.length; i++) {
            // 새 배열에 골라낸 원소 담기
            int[] newArr = new int[commands[i][1] - commands[i][0] + 1];
            for (int j = 0; j < newArr.length; j++) {
                newArr[j] = array[commands[i][0] - 1 + j];
            }

            // 원소 정렬해서 정답 추춣
            Arrays.sort(newArr);
            answer[i] = newArr[commands[i][2] - 1];
        }

        return answer;
    }
}

public class Pgms_42748_KthNumber {
    public static void main(String[] args) {
        int[][] tcArray = {
                { 1, 5, 2, 6, 3, 7, 4 }
        };
        int[][][] tcCommands = {
                {
                        { 2, 5, 3 },
                        { 4, 4, 1 },
                        { 1, 7, 3 }
                }
        };

        Solution_42748 sol = new Solution_42748();
        for (int i = 0; i < tcArray.length; i++) {
            System.out.print("tc" + (i + 1) + "> ");
            for (int result : sol.solution(tcArray[i], tcCommands[i])) {
                System.out.print(result + ", ");
            }
            System.out.println();
        }
    }
}
