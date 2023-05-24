package Algorithm;

import java.util.LinkedList;
import java.util.Queue;

class Solution_87694 {

    int[][] map;
    int shortestDistance = -1;
    Queue<Point> queue;

    class Point {
        private int x;
        private int y;
        private int distance;

        public Point(int x, int y, int distance) {
            this.x = x;
            this.y = y;
            this.distance = distance;
        }

        public int getX() {
            return x;
        }
        public void setX(int x) {
            this.x = x;
        }
        public int getY() {
            return y;
        }
        public void setY(int y) {
            this.y = y;
        }
        public int getDistance() {
            return distance;
        }
        public void setDistance(int distance) {
            this.distance = distance;
        }
    }

    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        int answer = 0;

        // 지도 그리기 - 2배 크기
        //      0:공백, 1:안 가본 길, 2:벽, 3: 가본 길
        map = new int[51 * 2][51 * 2];
        for (int i = 0; i < rectangle.length; i++) {
            int lbX = rectangle[i][0] * 2;
            int lbY = rectangle[i][1] * 2;
            int rtX = rectangle[i][2] * 2;
            int rtY = rectangle[i][3] * 2;
            for (int x = lbX; x < rtX + 1; x++) {
                for (int y = lbY; y < rtY + 1; y++) {
                    // 벽이 아닌 곳에 대해서만 값 변경
                    if (map[x][y] != 2) {
                        // 안 가본 길, 벽 구분
                        if (x == lbX || x == rtX || y == lbY || y == rtY) {
                            map[x][y] = 1;
                        } else {
                            map[x][y] = 2;
                        }
                    }
                }
            }
        }

//        // 지도 출력
//        for (int x = map.length - 1; x >= 0; x--) {
//            for (int y = 0; y < map.length; y++) {
//                System.out.print(map[x][y]);
//            }
//            System.out.println();
//        }

        // BFS
        map[characterX * 2][characterY * 2] = 3;
        queue = new LinkedList<>();
        queue.offer(new Point(characterX * 2, characterY * 2, 0));
        int[] dX = { 1, -1, 0, 0 };
        int[] dY = { 0, 0, 1, -1 };
        while (!queue.isEmpty()) {
            Point curPoint = queue.poll();
            int charX = curPoint.getX();
            int charY = curPoint.getY();
            int distance = curPoint.getDistance();
            if (charX == itemX * 2 && charY == itemY * 2) {
                answer = distance;
                break;
            } else {
                for (int i = 0; i < dX.length; i++) {
                    int nX = charX + dX[i];
                    int nY = charY + dY[i];
                    if (nX >= 0 && nX < 51 * 2 && nY >= 0 && nY < 51 * 2 && map[nX][nY] == 1) {
                        map[nX][nY] = 3;
                        queue.offer(new Point(nX, nY, distance + 1));
                    }
                }
            }
        }
//        System.out.println("answer:" + answer);
        return answer / 2;
    }
}

public class Pgms_87694_PickUpItems {
    public static void main(String[] args) {
        int[][][] tcRectangle = {
                {
                        { 1, 1, 7, 4 }, { 3, 2, 5, 5 }, { 4, 3, 6, 9 }, { 2, 6, 8, 8 }
                },
                {
                        { 1, 1, 8, 4 }, { 2, 2, 4, 9 }, { 3, 6, 9, 8 }, { 6, 3, 7, 7 }
                },
                {
                        { 1, 1, 5, 7 }
                },
                {
                        { 2, 1, 7, 5 }, { 6, 4, 10, 10 }
                },
                {
                        { 2, 2, 5, 5 }, { 1, 3, 6, 4 }, { 3, 1, 4, 6 }
                }
        };
        int[] tcCharacterX = { 1, 9, 1, 3, 1 };
        int[] tcCharacterY = { 3, 7, 1, 1, 4 };
        int[] tcItemX = { 7, 6, 4, 7, 6 };
        int[] tcItemY = { 8, 1, 7, 10, 3 };

        Solution_87694 sol = new Solution_87694();
        for (int i = 0; i < tcRectangle.length; i++) {
            System.out.println("tc" + (i + 1) + "> " + sol.solution(tcRectangle[i], tcCharacterX[i], tcCharacterY[i], tcItemX[i], tcItemY[i]));
        }
    }
}
