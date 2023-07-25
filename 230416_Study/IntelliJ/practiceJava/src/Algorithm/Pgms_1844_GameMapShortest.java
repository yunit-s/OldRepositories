package Algorithm;

import java.util.LinkedList;
import java.util.Queue;

class Solution_1844 {
    public int solution(int[][] maps) {
//        int answer = 0;

        // map 사이즈
        int rowLen = maps.length;
        int colLen = maps[0].length;

        // dRow, dCol(상, 하, 좌, 우 순서)
        int[] dRow = { -1, 1, 0, 0 };
        int[] dCol = { 0, 0, -1, 1 };

        // variables setting
        Queue<int[]> q = new LinkedList<>(); // 탐색 대상 목록
        boolean[][] visited = new boolean[rowLen][colLen]; // 방문 전 0, 방문 후 1

        // BFS(Bread-First Search)
        q.offer(new int[]{ 0, 0, 1 }); // 시작 위치 (0, 0)과 이동거리 1을 queue 에 저장
        while (!q.isEmpty()) {
            // queue에서 탐색 대상 한 개 선택
            int[] cur = q.poll();
            int row = cur[0];
            int col = cur[1];
            int distance = cur[2];
//            System.out.println("test : " + row + ", " + col + ", "  + distance);

            // 최종 목적지인 경우, 이동거리 리턴하면서 탐색 종료(프로그램 종료)
            if (row == rowLen - 1 && col == colLen - 1) {
                return distance;
            }
            // 최종 목적지가 아닌 경우
            else {
                // 상하좌우 칸 중 다음 탐색할 대상을 queue에 저장
                for (int i = 0; i < 4; i++) {
                    // 다음 칸 좌표
                    int nRow = row + dRow[i];
                    int nCol = col + dCol[i];

                    // 다음 칸이 탐색 대상으로 적절하면, 거리를 1 더하면서 queue에 저장
                    // 탐색 조건 : 맵을 벗어나지 않을 것, 벽이 아니라 도로일 것, 방문한 적이 없을 것
                    if (nRow >= 0 && nRow < rowLen && nCol >= 0 && nCol < colLen && maps[nRow][nCol] == 1 && visited[nRow][nCol] == false) {
                        q.offer(new int[]{ nRow, nCol, distance + 1 });
                        visited[nRow][nCol] = true; // 방문하기로 예약
                    }
                }
            }
        }

        return -1;
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
