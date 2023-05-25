package Algorithm;

class Solution_42842 {
    public int[] solution(int brown, int yellow) {
        int[] answer = {};

        int lengthSum = (brown + 4) / 2;
        for (int height = lengthSum / 2; height >= 3; height--) {
            int width = lengthSum - height;
            if ((height - 2) * (width - 2) == yellow) {
                answer = new int[]{width, height};
                break;
            }
        }

        return answer;
    }
}

public class Pgms_42842_Carpet {
    public static void main(String[] args) {
        int[] tcBrown = { 10, 8, 24 };
        int[] tcYellow = { 2, 1, 24 };

        Solution_42842 sol = new Solution_42842();
        for (int i = 0; i < tcBrown.length; i++) {
            System.out.print("tc" + (i + 1) + "> ");
            int[] result = sol.solution(tcBrown[i], tcYellow[i]);
            System.out.println(result[0] + ", " + result[1]);
        }
    }
}