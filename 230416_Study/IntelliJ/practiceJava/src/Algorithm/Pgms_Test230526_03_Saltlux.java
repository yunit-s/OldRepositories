package Algorithm;

import java.util.LinkedList;
import java.util.Queue;

class Solution_Test230526_03 {
    public int[] solution(int[][] v) {
        int count = 0;
        int maxSize = 0;
        boolean[][] visited = new boolean[v.length][v[0].length];

        // x, y 반복
        for (int x = 0; x < v.length; x++) {
            for (int y = 0; y < v[0].length; y++) {
                // visited == false 찾으면, calcSize() 호출
                if (v[x][y] == 1 && !visited[x][y]) {
                    count++;
                    int size = calcSize(x, y, v, visited);
                    if (size > maxSize) {
                        maxSize = size;
                    }
                }
            }
        }

        return new int[]{ count, maxSize };
    }

    private int calcSize(int x, int y, int[][] v, boolean[][] visited) {
        int size = 0;
        visited[x][y] = true;

        int[] dx = { -1, 1, 0, 0 };
        int[] dy = { 0, 0, -1, 1 };

        // BFS
        // q에 offer() 할 때마다, size++
        // visited가 false면, q.offer()
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{x, y});
        size++;
        while (!q.isEmpty()) {
            int[] cell = q.poll();

            for (int i = 0; i < 4; i++) {
                int nx = cell[0] + dx[i];
                int ny = cell[1] + dy[i];

                if (nx >= 0 && nx < visited.length && ny >= 0 && ny < visited[0].length && v[nx][ny] == 1 && visited[nx][ny] == false) {
                    visited[nx][ny] = true;
                    q.offer(new int[]{nx, ny});
                    size++;
                }
            }
        }

        return size;
    }
}

public class Pgms_Test230526_03_Saltlux {
    public static void main(String[] args) {
        int[][][] tcV = {
                {
                        { 1, 1, 0, 1, 1 }, { 0, 1, 1, 0, 0 }, { 0, 0, 0, 0, 0 }, { 1, 1, 0, 1, 1 }, { 1, 0, 1, 1, 1 }, { 1, 0, 1, 1, 1 }
                }
        };

        Solution_Test230526_03 sol = new Solution_Test230526_03();
        for (int i = 0; i < tcV.length; i++) {
            System.out.print("tc" + (i + 1) + "> ");
            int[] result = sol.solution(tcV[i]);
            for (int j = 0; j < result.length; j++) {
                System.out.print(result[j] + ", ");
            }
            System.out.println();
        }
    }
}
