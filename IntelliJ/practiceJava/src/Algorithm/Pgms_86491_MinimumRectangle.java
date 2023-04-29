package Algorithm;

class Solution_86491 {
    public int solution(int[][] sizes) {
        int answer = 0;

        // 작은 변 길이, 큰 변 길이
        int small = 0, big = 0;

        // 전체 반복
        for (int i = 0; i < sizes.length; i++) {
            // sizes[i] 의 0번과 1번 수 사이에 크기 비교
            // 더 큰 수는 big과 비교, 더 작은 수는 small과 비교
            if (sizes[i][0] > sizes[i][1]) {
                if (sizes[i][0] > big)
                    big = sizes[i][0];
                if (sizes[i][1] > small)
                    small = sizes[i][1];
            } else {
                if (sizes[i][0] > small)
                    small = sizes[i][0];
                if (sizes[i][1] > big)
                    big = sizes[i][1];
            }
        }
        answer = small * big;
        return answer;
    }
}

public class Pgms_86491_MinimumRectangle {
    public static void main(String[] args) {
        int[][][] tcSizes = {
                {
                        { 60, 50 }, { 30, 70 }, { 60, 30 }, { 80, 40 }
                },
                {
                        { 10, 7 }, { 12, 3 }, { 8, 15 }, { 14, 7 }, { 5, 15 }
                },
                {
                        { 14, 4 }, { 19, 6 }, { 6, 16 }, { 18, 7 }, { 7, 11 }
                }
        };

        Solution_86491 sol = new Solution_86491();
        for (int i = 0; i < tcSizes.length; i++) {
            System.out.println("tc" + (i + 1) + "> " + sol.solution(tcSizes[i]));
        }
    }
}
