package Algorithm;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Solution_1844 {
    public int solution(int[][] maps) {
        int answer = 0;

        // map 정보
        int xLen = maps[0].length;
        int yLen = maps.length;

        // dx, dy(동서남북 순서)
        int[] dx = { 1, -1, 0, 0 };
        int[] dy = { 0, 0, 1, -1 };

        // variables
        Queue<int[]> q = new LinkedList<>(); // 탐색 대상
        boolean[][] visited = new boolean[yLen][xLen];



        return answer;
    }
}

public class Pgms_1844_GameMapShortest {
    public static void main(String[] args) {
        int[][][] tcMaps = {
                {
                        {1,0,1,1,1}, {1,0,1,0,1}, {1,0,1,1,1}, {1,1,1,0,1}, {0,0,0,0,1}
                },
                {
                        {1,0,1,1,1}, {1,0,1,0,1}, {1,0,1,1,1}, {1,1,1,0,0}, {0,0,0,0,1}
                }
        };

        Solution_1844 sol = new Solution_1844();
        for (int i = 0; i < tcMaps.length; i++) {
            System.out.println("tc" + (i + 1) + "> " + sol.solution(tcMaps[i]));
        }
    }
}
