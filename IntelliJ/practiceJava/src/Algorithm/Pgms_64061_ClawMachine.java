package Algorithm;

import java.util.Stack;

class Solution_64061 {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;

        Stack<Integer> basketStack = new Stack<>();
        basketStack.push(0);
        // 뽑기 반복
        for (int move : moves) {
            // 0 아닌 칸을 만날 때까지 반복
            for (int i = 0; i < board.length; i++) {
                if (board[i][move - 1] != 0) {
                    // 일단 숫자 빼오고, 배열 숫자 0으로 변환
                    int target = board[i][move - 1];
                    board[i][move - 1] = 0;
                    // peek과 비교해서 동일 숫자면 pop / answer += 2
                    if (target == basketStack.peek()) {
                        basketStack.pop();
                        answer += 2;
                    } else {
                        // peek과 다른 숫자면 push
                        basketStack.push(target);
                    }
                    break;
                }
            }
        }

        return answer;
    }
}

public class Pgms_64061_ClawMachine {
    public static void main(String[] args) {
        int[][][] boards = {
                {
                        { 0, 0, 0, 0, 0 },
                        { 0, 0, 1, 0, 3 },
                        { 0, 2, 5, 0, 1 },
                        { 4, 2, 4, 4, 2 },
                        { 3, 5, 1, 3, 1 }
                }
        };
        int[][] moves = {
                { 1, 5, 3, 5, 1, 2, 1, 4 }
        };

        Solution_64061 sol = new Solution_64061();
        for (int i = 0; i < boards.length; i++) {
            int result = sol.solution(boards[i], moves[i]);
            System.out.println("tc" + i + "> " + result);
        }
    }
}
