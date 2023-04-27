package Algorithm;

class Solution_67256 {
    // sol1 : 거리값 하드코딩
    public String solution_1(int[] numbers, String hand) {
        String answer = "";

        // 숫자끼리의 거리 저장(2차원 배열)
        int[][] distArr = {
                { 0, 4, 3, 4, 3, 2, 3, 2, 1, 2, 1, 1 }, // 0
                { 4, 0, 1, 2, 1, 2, 3, 2, 3, 4, 3, 5 }, // 1
                { 3, 1, 0, 1, 2, 1, 2, 3, 2, 3, 4, 4 }, // 2
                { 4, 2, 1, 0, 3, 2, 1, 4, 3, 2, 5, 3 }, // 3
                { 3, 1, 2, 3, 0, 1, 2, 1, 2, 3, 2, 4 }, // 4
                { 2, 2, 1, 2, 1, 0, 1, 2, 1, 2, 3, 3 }, // 5
                { 3, 3, 2, 1, 2, 1, 0, 3, 2, 1, 4, 2 }, // 6
                { 2, 2, 3, 4, 1, 2, 3, 0, 1, 2, 1, 3 }, // 7
                { 1, 3, 2, 3, 2, 1, 2, 1, 0, 1, 2, 2 }, // 8
                { 2, 4, 3, 2, 3, 2, 1, 2, 1, 0, 3, 1 }, // 9
                { 1, 3, 4, 5, 2, 3, 4, 1, 2, 3, 0, 2 }, // *
                { 1, 5, 4, 3, 4, 3, 2, 3, 2, 1, 2, 0 } // #
        };

        int curL = 10;
        int curR = 11;
        // numbers만큼 반복
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] % 3 == 1) {
                // 1, 4, 7인 경우, 왼손
                answer = answer + "L";
                curL = numbers[i];
            } else if (numbers[i] % 3 == 0 && numbers[i] != 0) {
                // 3, 6, 9인 경우, 오른손
                answer = answer + "R";
                curR = numbers[i];
            } else {
                // 왼손 거리 계산
                int distL = distArr[numbers[i]][curL];
                // 오른손 거리 계산
                int distR = distArr[numbers[i]][curR];
                if (distL == distR) {
                    // 두 거리가 같은 경우, 주 손잡이를 이번 위치에 놓기
                    if (hand.equals("left")) {
                        answer = answer + "L";
                        curL = numbers[i];
                    } else {
                        answer = answer + "R";
                        curR = numbers[i];
                    }
                } else {
                    // 더 짧은 손을 이번 위치에 놓기
                    if (distL < distR) {
                        answer = answer + "L";
                        curL = numbers[i];
                    } else {
                        answer = answer + "R";
                        curR = numbers[i];
                    }
                }
            }
        }

        return answer;
    }

    // sol2 : 거리 계산하기(미완성)
    public String solution_2(int[] numbers, String hand) {
        String answer = "";

        // *과 숫자 사이의 거리 저장
        int[] distStar = new int[10];
        distStar[0] = 1;
        int index = 1;
        for (int j = 3; j > 0; j--) {
            for (int k = 0; k < 3; k++) {
                distStar[index++] = j + k;
            }
        }
        // #과 숫자 사이의 거리 저장
        int[] distSharp = new int[10];
        distSharp[0] = 1;
        index = 1;
        for (int j = 3; j > 0; j--) {
            for (int k = 2; k >= 0; k--) {
                distStar[index++] = j + k;
            }
        }

//        int[][] distArr = new int[10][10];
//        for (int i = 0; i < 10; i++) {
//            for (int j = 0; j < 10; j++) {
//                int small = 0;
//                int big = 0;
//                if (i < j) {
//                    small = i;
//                    big = j;
//                } else {
//                    small = j;
//                    big = i;
//                }
//                // 거리 계산식
//            }
//        }

        return answer;
    }
}

public class Pgms_67256_PressKeypad {
    public static void main(String[] args) {
        int[][] tcNumbers = {
                { 1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5 },
                { 7, 0, 8, 2, 8, 3, 1, 5, 7, 6, 2 },
                { 1, 2, 3, 4, 5, 6, 7, 8, 9, 0 }
        };
        String[] tcHand = {
                "right", "left", "right"
        };

        Solution_67256 sol = new Solution_67256();
        for (int i = 0; i < tcNumbers.length; i++) {
            System.out.println(sol.solution_1(tcNumbers[i], tcHand[i]));
        }
    }
}
