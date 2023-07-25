package Algorithm;

import java.util.*;
import java.util.stream.Collectors;

// ChatGPT 코드 1
//테스트 1 〉	통과 (0.41ms, 82.1MB)
//테스트 2 〉	통과 (0.39ms, 72.1MB)
//테스트 3 〉	통과 (0.54ms, 76.9MB)
//테스트 4 〉	통과 (0.41ms, 76.8MB)
class Solution_43164_2 {
    Map<String, PriorityQueue<String>> graph;
    List<String> itinerary;

    public String[] solution(String[][] tickets) {
        graph = new HashMap<>();
        itinerary = new ArrayList<>();

        // 그래프 구성
        for (String[] ticket : tickets) {
            String from = ticket[0];
            String to = ticket[1];
            graph.putIfAbsent(from, new PriorityQueue<>());
            graph.get(from).add(to);
        }

        // DFS를 사용하여 경로 탐색
        dfs("ICN");

        // 경로를 역순으로 저장했으므로, 뒤집어서 반환
        Collections.reverse(itinerary);

        return itinerary.toArray(new String[itinerary.size()]);
    }

    private void dfs(String airport) {
//        System.out.println("check-" + airport + ", " + graph.get(airport));
        // 출발 공항에서 가능한 도착 공항들을 탐색
        // && 로 묶인 조건문은 앞에서부터 조건을 검토함.
        //      따라서 !graph.get(airport).isEmpty() 부터 실행하면 NullPointException이 발생할 수 있으나,
        //      graph.containsKey(airport) 부터 실행하면 오류가 발생하지 않음
//        while (!graph.get(airport).isEmpty() && graph.containsKey(airport)) {
        while (graph.containsKey(airport) && !graph.get(airport).isEmpty()) {
            dfs(graph.get(airport).poll()); // 도착 공항으로 이동
        }
//        System.out.println("\taddItinerary-" + airport);
        itinerary.add(airport); // 경로에 현재 공항 추가
    }
}

class Solution_43164_1 {
    // 제출 시 1, 2번 런타임 에러, 3, 4번 통과
    // 아무래도 Map 데이터를 putAll()로 복사한다고 해서, 그 안의 객체 데이터가 따로 생기지는 않고,
    //      해시값만 복사되는 것 같다.
    // 여분 티켓이나 왔던 경로를 계속 새로 만들어서 매개변수로 넘겨주지 말고, 전역변수 필드 활용하자.

    List<String> answerRoute;

    public String[] solution(String[][] tickets) {
        String[] answer = {};

        // 티켓 정보 저장
        Map<String, List<String>> totalTicketMap; // 전체 티켓 정보. key : 출발 공항 String, value : 도착 공항 리스트
        totalTicketMap = new HashMap<>();
        for (String[] ticket : tickets) {
            // 티켓의 출발 공항이 아직 출발 공항 리스트에 등록된 적 없는 경우
            if (!totalTicketMap.containsKey(ticket[0])) {
                List<String> arrivalList = new ArrayList<>();
                arrivalList.add(ticket[1]);
                totalTicketMap.put(ticket[0], arrivalList);
            }
            // 이미 출발 항공으로 등록되어 있는 경우
            else {
                totalTicketMap.get(ticket[0]).add(ticket[1]);
            }
        }

        // 도착 공항 list 정보를 모두 정렬해놓기
        for (String key : totalTicketMap.keySet()) {
            List<String> arrivalList = totalTicketMap.get(key);
            arrivalList = arrivalList.stream().sorted().collect(Collectors.toList());
            totalTicketMap.put(key, arrivalList);
        }

        // 경로를 저정할 ArrayList 생성
        List<String> route; // 이동 경로
        route = new ArrayList<>();

        // 재귀호출
        travel(totalTicketMap, route, "ICN");

        // output
        answer = answerRoute.toArray(new String[answerRoute.size()]);

        return answer;
    }

    // 넘겨받을 정보 : 여분의 티켓 리스트, 지금까지의 경로, 출발지
    // 리턴 : 끝까지 정상적으로 도달했을 경우만 true, 그 외에 모두 false
    // 끝까지 이동했을 경우, answerRoute에 경로 저장
    private boolean travel(Map<String, List<String>> remainTicketMap, List<String> route, String begin) {
        // 티켓 정보 저장 잘 됐나 확인
        System.out.println("티켓 체크. 시작점 : " + begin);
        for (String key : remainTicketMap.keySet()) {
            System.out.print(key + " : " + remainTicketMap.get(key));
            System.out.println();
        }

        // begin에서 출발할 다음 여행지가 있는 경우, 재귀 탐색
        // begin이 아예 출발항공 리스트에 없는 경우를 if 조건에 추가해야 함
        if (remainTicketMap.get(begin) == null) {
            System.out.println("출발 항공 없음");
            // 다른 티켓이 남은 경우 - 잘못된 경로. return;
            for (List<String> nextList : remainTicketMap.values()) {
                if (!nextList.isEmpty()) {
                    return false;
                }
            }

            // 다른 티켓이 남지 않은 경우 - 여행 완료. answerRoute에 경로 저장
            answerRoute = new ArrayList<>();
            answerRoute.addAll(route);
            answerRoute.add(begin);
            return true;
        }
        else if (!remainTicketMap.get(begin).isEmpty()) {
            for (int i = 0; i < remainTicketMap.get(begin).size(); i++) {
                // 데이터 복사 (꼭 필요한 게 맞는지 다시 체크할 것)
                Map<String, List<String>> subRemainTicketMap = new HashMap<>();
                subRemainTicketMap.putAll(remainTicketMap);
                String next = subRemainTicketMap.get(begin).get(i);
                subRemainTicketMap.get(begin).remove(i);
                List<String> subRoute = new ArrayList<>();
                subRoute.addAll(route);
                subRoute.add(begin);
                System.out.println("@ " + i + ", " + begin + ", " + next);
                if (travel(subRemainTicketMap, subRoute, next)) {
                    // 탐색 성공
                    return true;
                }
            }
        }
        // begin에서 출발할 티켓이 없는 경우
        else {
            // 다른 티켓이 남은 경우 - 잘못된 경로. return;
            for (List<String> nextList : remainTicketMap.values()) {
//                System.out.println("nextList : " + nextList);
                if (!nextList.isEmpty()) {
                    return false;
                }
            }

            // 다른 티켓이 남지 않은 경우 - 여행 완료. answerRoute에 경로 저장
            answerRoute = new ArrayList<>();
            answerRoute.addAll(route);
            answerRoute.add(begin);
            return true;
        }

        return false; // 도달하는 경우가 없어야 함
    }
}

public class Pgms_43164_TravelRoute {
    public static void main(String[] args) {
        String[][][] tcTickets = {
                {
                        { "ICN", "JFK" }, { "HND", "IAD" }, { "JFK", "HND" }
                },
                {
                        { "ICN", "SFO" }, { "ICN", "ATL" }, { "SFO", "ATL" }, { "ATL", "ICN" }, { "ATL", "SFO" }
                },
                {
                        { "ICN", "SFO" }
                },
                {
                        { "ICN", "SFO" }, { "SFO", "ATL" }, { "ATL", "ICN" }, { "ICN", "SFO" }, { "SFO", "ATL" },
                        { "ATL", "ICN" }, { "ICN", "SFO" }, { "SFO", "ATL" }, { "ATL", "ICN" }, { "ICN", "SFO" },
                        { "SFO", "ATL" }, { "ATL", "ICN" }, { "ICN", "SFO" }, { "SFO", "ATL" }, { "ATL", "ICN" },
                        { "ICN", "ATL" }, { "ATL", "SFO" }, { "SFO", "ICN" }, { "ICN", "ATL" }, { "ATL", "SFO" },
                        { "SFO", "ICN" }, { "ICN", "ATL" }, { "ATL", "SFO" }, { "SFO", "ICN" }, { "ICN", "ATL" },
                        { "ATL", "SFO" }, { "SFO", "ICN" }, { "ICN", "ATL" }, { "ATL", "SFO" }, { "SFO", "ICN" },
                },
                {
                        { "ICN", "SFO" }, { "SFO", "ATL" }, { "ATL", "ICN" }, { "ICN", "SFO" }, { "SFO", "ATL" },
                        { "ATL", "ICN" }, { "ICN", "SFO" }, { "SFO", "ATL" }, { "ATL", "ICN" }, { "ICN", "SFO" },
                        { "SFO", "ATL" }, { "ATL", "ICN" }, { "ICN", "SFO" }, { "SFO", "ATL" }, { "ATL", "ICN" },
                        { "ICN", "ATL" }, { "ATL", "SFO" }, { "SFO", "ICN" }, { "ICN", "ATL" }, { "ATL", "SFO" },
                        { "SFO", "ICN" }, { "ICN", "ATL" }, { "ATL", "SFO" }, { "SFO", "ICN" }, { "ICN", "ATL" },
                        { "ATL", "SFO" }, { "SFO", "ICN" }, { "ICN", "ATL" }, { "ATL", "SFO" }, { "SFO", "ICN" },
                        { "ICN", "AAB" }, { "AAB", "AAC" }, { "AAC", "AAD" }, { "AAD", "AAE" }
                },
        };

        Solution_43164_2 sol = new Solution_43164_2();
        for (int i = 0; i < tcTickets.length; i++) {
            System.out.print("tc" + (i + 1) + "> ");
            for (String item : sol.solution(tcTickets[i])) {
                System.out.print(item + ", ");
            }
            System.out.println();
        }
    }
}
