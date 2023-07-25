package Algorithm;

import java.util.Arrays;
import java.util.Comparator;

class Solution_87946 {
    int answer = -1;
    public int solution(int k, int[][] dungeons) {

        // 최소 필요 피로도를 기준으로 내림차순 정렬
        Arrays.sort(dungeons, Comparator.comparingInt(value -> value[0]));

        int[] visited = new int[dungeons.length];
        dfs(k, dungeons, visited, 0);

        return answer;
    }

    // 현재 체력, 던전 정보, 방문 여부, 이번 포함 방문 개수
    private void dfs(int health, int[][] dungeons, int[] visited, int count) {
        if (answer < count) {
            answer = count;
        }

        // 남은 장소 중, 들어갈 수 잇는 곳이 있으면 들어가기
        for (int i = 0; i < visited.length; i++) {
            if (visited[i] == 0 && health >= dungeons[i][0]) {
                int[] newVisited = Arrays.copyOf(visited, visited.length);
                newVisited[i] = 1;
                dfs(health - dungeons[i][1], dungeons, newVisited, count + 1);
            }
        }
    }
}

public class Pgms_87946_Fatigue {
    public static void main(String[] args) {
        int[] tcK = { 80 };
        int[][][] tcDungeons = {
                {
                        { 80, 20 }, { 50, 40 }, { 30, 10 }
                }
        };

        Solution_87946 sol = new Solution_87946();
        for (int i = 0; i < tcK.length; i++) {
            System.out.println("tc" + (i + 1) + "> " + sol.solution(tcK[i], tcDungeons[i]));
        }
    }
}
