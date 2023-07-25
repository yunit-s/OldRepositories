package Algorithm;

class Solution_42862 {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = n;

        int[] studentArr = new int[n];

        // 여벌을 빌려주기 전 상황 정리
        // 0 : 체육복 있음, -1 : 잃어버림, 1 : 여벌 있음
        for (int i = 0; i < lost.length; i++) {
            studentArr[lost[i] - 1] = -1;
        }
        for (int i = 0; i < reserve.length; i++) {
            if (studentArr[reserve[i] - 1] == -1) {
                studentArr[reserve[i] - 1] = 0;
            } else {
                studentArr[reserve[i] - 1] = 1;
            }
        }

        // Greedy 적용
        for (int i = 0; i < n; i++) {
            if (studentArr[i] == -1) {
                // 앞에서부터 탐색하므로, 앞사람한테 여벌이 있는지부터 확인, 앞사람이 없으면 뒷사람에게 빌리기
                // 가능한 앞번호 학생에게 체육복 몰아주기
                if (i == 0) {
                    if (studentArr[i + 1] == 1) {
                        studentArr[i] = 0;
                        studentArr[i + 1] = 0;
                    } else {
                        answer--;
                    }
                } else if (i == n - 1) {
                    if (studentArr[i - 1] == 1) {
                        studentArr[i] = 0;
                        studentArr[i - 1] = 0;
                    } else {
                        answer--;
                    }
                } else {
                    if (studentArr[i - 1] == 1) {
                        studentArr[i] = 0;
                        studentArr[i - 1] = 0;
                    } else if (studentArr[i + 1] == 1) {
                        studentArr[i] = 0;
                        studentArr[i + 1] = 0;
                    } else {
                        answer--;
                    }
                }
            }
        }

        return answer;
    }
}

public class Pgms_42862_GymClothes {
    public static void main(String[] args) {
        int[] tcN = { 5, 5, 3 };
        int[][] tcLost = {
                { 2, 4 },
                { 2, 4 },
                { 3 },
        };
        int[][] tcReserve = {
                { 1, 3, 5 },
                { 3 },
                { 1 },
        };

        Solution_42862 sol = new Solution_42862();
        for (int i = 0; i < tcN.length; i++) {
            System.out.println(sol.solution(tcN[i], tcLost[i], tcReserve[i]));
        }
    }
}
