package Algorithm;

import java.util.Scanner;

public class ExpertAPS_230510 {

    // variables
    static int AnswerN = 0;
    static int N = 0; // 교차로 개수
    static int K = 0; // 거리
    public static void main(String[] args) {
        //System.setIn(new FileInputStream("C:\sample_input.txt"));
        Scanner sc = new Scanner(System.in);

        // test case 반복
        int T = sc.nextInt();
        for(int test_case = 1; test_case <= T; test_case++) {

            // input
            N = sc.nextInt();
            K = sc.nextInt();

            // 지도 정보 입력
            int[][] map = new int[N + 1][N + 1];
            for (int i = 0; i < N - 1; i++) {
                int start = sc.nextInt();
                int end = sc.nextInt();
                map[start][end] = 1;
                map[end][start] = 1;
            }

            // 범죄자 정보 입력
            int[] criminal = new int[N + 1];
            for (int i = 1; i < N + 1; i++) {
                criminal[i] = sc.nextInt();
            }

            // process
            // 노드 별로 계산해서 합산하기
            AnswerN = 0;
            for (int i = 1; i < N + 1; i++) {
                int[] visited = new int[N + 1];
                AnswerN += visit(map, criminal, K, -1, i, visited);
//                System.out.println("i = " + i + "> " + AnswerN);
            }

            // output
            System.out.println("#"+test_case+" "+AnswerN);
        }

    }

    static int visit(int[][] map, int[] criminal, int K, int dist, int current, int[] visited) {
//        System.out.println("visit() - " + K + ", " + dist + ", " + current + ", " + count);
        visited[current] = 1;
        int curDist = dist + 1;
        int count = 0;

        if (curDist < K) {
            // map에 도로가 존재하고, visited == 0 인 인접한 곳에 대해 visit 실행
            // 그 return 값을 count에 더하기
            for (int i = 1; i < N + 1; i++) {
                if (map[current][i] == 1 && visited[i] == 0) {
                    count += visit(map, criminal, K, curDist, i, visited);
                }
            }
        }
        count += criminal[current]; // 현재 위치에 있는 범죄자 수 더하기

        return count;
    }
}

/*
// test case
2
8 1
1 4
5 4
7 5
5 8
3 7
6 5
2 6
1 0 0 1 1 0 0 1
5 6
1 2
2 3
3 4
4 5
1 0 1 1 0

// test case answer
#1 12
#2 15

// 기타 메모
count를 매개변수로 넣을 필요가 없었네... 그냥 지역변수로 잡고 0으로 초기화해서 사용하면 될 듯...

 */