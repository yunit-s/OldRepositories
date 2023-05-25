package Algorithm;

import java.util.Stack;

class Solution_12909 {
    boolean solution(String s) {
        boolean answer = true;

        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push('(');
            } else {
                if (stack.isEmpty()) {
                    answer = false;
                    break;
                } else {
                    stack.pop();
                }
            }
        }
        if (!stack.isEmpty()) {
            answer = false;
        }

        return answer;
    }
}

public class Pgms_12909_CorrectParentheses {
    public static void main(String[] args) {
        String[] tcS = { "()()", "(())()", ")()(", "(()(" };

        Solution_12909 sol = new Solution_12909();
        for (int i = 0; i < tcS.length; i++) {
            System.out.println("tc" + (i + 1) + "> " + sol.solution(tcS[i]));
        }
    }
}
