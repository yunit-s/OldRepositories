package Algorithm;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class Solution_42576 {
    // 배열로 풀기
    public String solution_1(String[] participant, String[] completion) {
        String answer = "";

        // 문자열 배열 정렬
        Arrays.sort(participant);
        Arrays.sort(completion);

        // 사전순으로 일치하지 않는 값이 있으면 해당 값이 answer
        for (int i = 0; i < completion.length; i++) {
            if (!participant[i].equals(completion[i])) {
                answer = participant[i];
                break;
            }
        }

        // 마지막 명단이 answer인 경우
        if (answer.equals(""))
            answer = participant[participant.length - 1];

        return answer;
    }

    // HashMap으로 풀기
    public String solution_2(String[] participant, String[] completion) {
        String answer = "";

        // p 데이터 맵에 저장
        Map<String, Integer> pMap = new HashMap<>();
        for (int i = 0; i < participant.length; i++) {
            pMap.put(participant[i], 0);
        }

        // p 데이터 개수 저장
        for (int i = 0; i < participant.length; i++) {
            pMap.put(participant[i], pMap.get(participant[i]) + 1 );
        }

        // c 데이터만금 value 값 차감
        for (int i = 0; i < completion.length; i++) {
            pMap.put(completion[i], pMap.get(completion[i]) - 1);
        }

        // 값이 1인 key값 찾기
        for (String key : pMap.keySet()) {
            if (pMap.get(key) == 1) {
                answer = key;
                break;
            }
        }

        return answer;
    }
}

public class Pgms_42576_FailedFinishedRunner {
    public static void main(String[] args) {

        String[][] p = {{ "leo", "kiki", "eden" },
                { "marina", "josipa", "nikola", "vinko", "filipa" },
                { "mislav", "stanko", "mislav", "ana" } };
        String[][] q = {{ "eden", "kiki" },
                { "josipa", "filipa", "marina", "nikola" },
                { "stanko", "ana", "mislav" }};

        Solution_42576 sol = new Solution_42576();
        for (int i = 0; i < p.length; i++) {
            String answer = sol.solution_2(p[i], q[i]);
            System.out.println("tc" + (i + 1) + "> " + answer);
        }

    }
}

/*

// solution_1
테스트 1 〉	통과 (0.30ms, 75.9MB)
테스트 2 〉	통과 (0.33ms, 70.6MB)
테스트 3 〉	통과 (1.89ms, 80.8MB)
테스트 4 〉	통과 (2.93ms, 81.6MB)
테스트 5 〉	통과 (3.86ms, 78.2MB)
테스트 6 〉	통과 (0.23ms, 76.6MB)
테스트 7 〉	통과 (0.19ms, 71.6MB)
효율성  테스트
테스트 1 〉	통과 (126.77ms, 83.2MB)
테스트 2 〉	통과 (285.54ms, 88.4MB)
테스트 3 〉	통과 (308.33ms, 93.9MB)
테스트 4 〉	통과 (290.40ms, 94.9MB)
테스트 5 〉	통과 (315.92ms, 94.9MB)

// solution_2
정확성  테스트
테스트 1 〉	통과 (0.13ms, 75MB)
테스트 2 〉	통과 (0.07ms, 66.8MB)
테스트 3 〉	통과 (0.43ms, 75.8MB)
테스트 4 〉	통과 (0.65ms, 78.1MB)
테스트 5 〉	통과 (0.57ms, 79.7MB)
테스트 6 〉	통과 (0.06ms, 71.6MB)
테스트 7 〉	통과 (0.05ms, 72.5MB)
효율성  테스트
테스트 1 〉	통과 (48.30ms, 80.6MB)
테스트 2 〉	통과 (86.06ms, 88.8MB)
테스트 3 〉	통과 (82.72ms, 97MB)
테스트 4 〉	통과 (92.46ms, 97MB)
테스트 5 〉	통과 (82.50ms, 95.5MB)

// --------------------------------------------------
// 42576-완주하지 못한 선수
// 구현 방법
sol1 : 배열 활용
sol2 : hashmap 활용

// --------------------------------------------------
// 제출 결과
구현 시간 - 2시간? GPT 잡본 한 번 보고 다시 두 가지 방법으로 풀어봄
hashmap 쓴 게 메모리는 비슷하게 사용하는데 수행 시간이 훨씬 빠르다. 아마 배열은 sort때문에 느린 듯...

// test case 정답
leo
vinko
mislav

 */