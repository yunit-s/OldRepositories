package Algorithm;

import java.util.Arrays;

class Solution_Test230526_02 {
    public int solution(int n) {
        int answer = 0;

        int[] egg = new int[2];
        int[] dragon = new int[4]; // 4는 알 못 낳는 드래곤
        egg[0] = 1;

        for (int day = 1; day <= n; day++) {
            int[] nEgg = new int[2];
            int[] nDragon = new int[4];

            nEgg[0] = egg[1] + dragon[0] + dragon[1] + dragon[2];
            nEgg[1] = egg[0];
            nDragon[0] = egg[1];
            nDragon[1] = dragon[0];
            nDragon[2] = dragon[1];
            nDragon[3] = dragon[3] + dragon[2];

            egg = Arrays.copyOf(nEgg, nEgg.length);
            dragon = Arrays.copyOf(nDragon, nDragon.length);
        }

        return egg[0] + egg[1] + dragon[0] + dragon[1] + dragon[2] + dragon[3];
    }
}

public class Pgms_Test230526_02_Saltlux {
    public static void main(String[] args) {
        int[] tcN = { 6 };

        Solution_Test230526_02 sol = new Solution_Test230526_02();
        for (int i = 0; i < tcN.length; i++) {
            System.out.println("tc" + (i + 1) + "> " + sol.solution(tcN[i]));
        }
    }
}
