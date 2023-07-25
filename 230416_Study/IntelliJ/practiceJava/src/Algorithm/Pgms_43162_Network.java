package Algorithm;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

// ChatGPT 코드
// 깔끔하네
class Solution_43162_2 {
    public int solution(int n, int[][] computers) {
        boolean[] visited = new boolean[n];
        int count = 0;

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(i, computers, visited);
                count++;
            }
        }

        return count;
    }

    private void dfs(int node, int[][] computers, boolean[] visited) {
        visited[node] = true;

        for (int i = 0; i < computers.length; i++) {
            if (computers[node][i] == 1 && !visited[i]) {
                dfs(i, computers, visited);
            }
        }
    }
}
class Solution_43162_1 {
    public int solution(int n, int[][] computers) {
        int answer = 0;

        // 연결된 네트워크를 HashMap에 저장(양방향 모두 저장)
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            // 네트워크의 출발지점을 key, 연결된 다른 노드들을 set으로 모아서 value에 저장
            Set<Integer> set = new HashSet<>();
            for (int j = 0; j < n; j++) {
                if (i != j && computers[i][j] == 1) {
                    set.add(j);
                }
            }
            map.put(i, set);
        }

        // map에서 하나씩 꺼내면서, 해당 노드에 연결되어 있는 하위 노드들을 map에서 제거하는 메서드 호출
        for (int i = 0; i < computers.length; i++) {
            if (map.containsKey(i)) {
                answer++; // 네트워크 개수 +1
                delNodes(map, i);
            }
        }

        return answer;
    }

    private void delNodes(Map<Integer, Set<Integer>> map, int currentNode) {
        // 현재 노드에 연결된 네트워크 정보를 curSet에 임시로 저장하고, map에서 현재 노드 제거
        Set<Integer> curSet = map.get(currentNode);
        map.remove(currentNode);

        // 현재 노드에 연결된 노드들을 map에서 제거하기 위해 delNodes 재귀 호출
        for (int nextNode : curSet) {
            if (map.containsKey(nextNode)) {
                delNodes(map, nextNode);
            }
        }
    }
}

public class Pgms_43162_Network {
    public static void main(String[] args) {
        int[] tcN = { 3, 3 };
        int[][][] tcComputers = {
                {
                        { 1, 1, 0 }, { 1, 1, 0 }, { 0, 0, 1 }
                },
                {
                        { 1, 1, 0 }, { 1, 1, 1 }, { 0, 1, 1 }
                },
        };

        Solution_43162_1 sol =  new Solution_43162_1();
        for (int i = 0; i < tcN.length; i++) {
            System.out.println("tc" + (i + 1) + "> " + sol.solution(tcN[i], tcComputers[i]));
        }
    }
}

/*
// check point
이미 map.entrySet() 으로 for-each문이 실행되는 경우, 하위 로직을 실행하는 중에 map에서 데이터를 빼버리면
for문에서 오류난다.

        // 재귀호출한 곳에서 map의 요소를 제거하면, for문 동작에 문제가 생김...
        // entrySet() 이 아닌 for문으로 방식 바꿀 것
//        // map에서 하나씩 꺼내면서, 해당 노드에 연결되어 있는 하위 노드들을 map에서 제거하는 메서드 호출
//        for (Map.Entry<Integer, Set<Integer>> item : map.entrySet()) {
//            System.out.println("start : " + item.getKey());
//            answer++; // 네트워크 개수 +1
//            delNodes(map, item.getKey());
//            System.out.println("end : " + item.getKey());
//            for (int i : map.keySet()) {
//                System.out.print("남은 key : ");
//                System.out.print(i + ", ");
//                System.out.println();
//            }
//        }
//
//        return answer;
 */
