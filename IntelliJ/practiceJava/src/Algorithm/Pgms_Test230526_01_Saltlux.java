package Algorithm;

class Solution_Test230526_01 {
    public int solution(int num) {
        int answer = 0;

        for (int i = 1; i <= num; i ++) {
            if (String.valueOf(i).contains("3") || String.valueOf(i).contains("6") || String.valueOf(i).contains("9")) {
                answer++;
            }
        }
        return answer;
    }
}

public class Pgms_Test230526_01_Saltlux {
    public static void main(String[] args) {
        int[] tcNum = { 10, 33, 15 };

        Solution_Test230526_01 sol = new Solution_Test230526_01();
        for (int i = 0; i < tcNum.length; i++) {
            System.out.println("tc" + (i + 1) + "> " + sol.solution(tcNum[i]));
        }
    }
}
