package Algorithm;

import java.util.Arrays;
import java.util.Comparator;

class Solution_42884 {
    public int solution(int[][] routes) {
        int answer = 0;

        // 전체 로직
        // 가장 작은 숫자에서 종료되는 위치에 설치
        // 그 값 이하에서 시작하는 모든 루트 제거
        // 무한 반복

        // 기존 내 코드는 핵심 로직은 맞는데 너무 지저분해서, 다른 사람 코드 참고함
        // 참고 : https://school.programmers.co.kr/questions/45282

        // 기본 가정 : 모든 route는 진입지점 값이 진출지점 값보다 작다.
        // 진입 지점을 기준으로 오름차순 정렬
        Arrays.sort(routes, Comparator.comparingInt(a -> a[0]));
        int minEnd = 30000;
        for (int[] route: routes) {
            if (route[0] > minEnd) {
                // 진입지점이 minEnd값보다 크다?
                //      minEnd에 카메라를 설치
                answer++;
                // 이번 경로의 마지막을 minEnd값으로 지정
                minEnd = route[1];
            } else {
                minEnd = Math.min(minEnd, route[1]);
            }
        }
        answer++;

        return answer;
    }
}

public class Pgms_42884_ControlCamera {
    public static void main(String[] args) {
        int[][][] tcRoutes = {
                {
                        { -20, -15 }, { -14, -5 }, { -18, -13 }, { -5, -3 }
                },
                {
                        { 0, 1 }, { 1, 2 }, { 2, 3 }, { 3, 4 }, { 4, 5 }
                },
                {
                        { 0, 1 }, { 1, 2 }, { 2, 3 }, { 3, 4 }, { 4, 5 }, { 4, 1 }
                },
                {
                        { 0, 2 }, { 0, 2 }, { 0, 3 }, { 0, 3 }, { 2, 5 },
                        { 3, 5 }, { 7, 15 }, { 7, 10 }, { 7, 8 }, { 9, 16 }
                },
                {
                        { -30000, 30000 }, { -20000, 20000 }
                }
        };

        Solution_42884 sol = new Solution_42884();
        for (int i = 0; i < tcRoutes.length; i++) {
            System.out.println("tc" + (i + 1) + "> " + sol.solution(tcRoutes[i]));
        }
    }
}
