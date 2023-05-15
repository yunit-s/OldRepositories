package Algorithm;

import java.util.*;

class Solution_43164 {

    int ticketNum; // 티켓 개수
    Map<String, PriorityQueue<String>> ticketMap; // 전체 티켓 정보. key : 출발 공항 String, value : 도착 공항 Priority Queue(최소 힙)

    public String[] solution(String[][] tickets) {
        String[] answer = {};

        // 티켓 정보 저장
        ticketNum = tickets.length;
        ticketMap = new HashMap<>();
        for (String[] ticket : tickets) {
            // 아직 출발 항공으로 등록되지 않은 경우
            if (!ticketMap.containsKey(ticket[0])) {
                PriorityQueue<String> q = new PriorityQueue<>();
                q.offer(ticket[1]);
                ticketMap.put(ticket[0], q);
            }
            // 이미 출발 항공으로 등록되어 있는 경우
            else {
                ticketMap.get(ticket[0]).offer(ticket[1]);
            }
        }

        // 경로를 저정할 Stack 생성
        Stack<String> route; // 이동 경로
        route = new Stack<>();

        // DFS 재귀호출


        return answer;
    }

    private void travel(Stack<String> route, String begin) {
        // 방문 기록
        route.push(begin);

        // 이번 공항에서 출발하는 여분 티켓이 있는 경우
        if (!ticketMap.get(begin).isEmpty()) {
//            Stack<String> newRoute = new Stack<>(route.e);
            // 다음 여행지로 이동
//            travel(, ticketMap.get(begin).poll());
        }
        // 이번 공항에서 더 이상 갈 곳이 없는 경우
        else {
            // 아직 여분의 티켓이 있는 경우 - 잘못된 경로. 탐색 되돌아가기
            if (route.size() != ticketNum) {
                route.pop();
            }
        }
    }
}

public class Pgms_43164_TravelRoute {
    public static void main(String[] args) {
        String[][][] tcTickets = {
                {
                        { "ICN", "JFK" },
                        { "HND", "IAD" },
                        { "JFK", "HND" }
                },
                {
                        { "ICN", "SFO" },
                        { "ICN", "ATL" },
                        { "SFO", "ATL" },
                        { "ATL", "ICN" },
                        { "ATL", "SFO" }
                }
        };

        Solution_43164 sol = new Solution_43164();
        for (int i = 0; i < tcTickets.length; i++) {
            System.out.print("tc" + (i + 1) + "> ");
            for (String item : sol.solution(tcTickets[i])) {
                System.out.print(item + ", ");
            }
            System.out.println();
        }
    }
}
