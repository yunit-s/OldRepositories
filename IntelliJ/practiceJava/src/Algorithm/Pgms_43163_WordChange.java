package Algorithm;

import java.util.*;

class Solution_43163 {
    public int solution(String begin, String target, String[] words) {
        int answer = 0;

        // words 단어들을 set에 저장
        Set<String> wordsSet = new HashSet<>(Arrays.asList(words));

        // 탐색을 마친 단어들의 거리값을 저장할 map 생성. <단어, 거리>
        Map<String, Integer> distMap = new HashMap<>();

        // BFS를 위한 Queue 생성
        Queue<String> q = new LinkedList<>();

        // q에 begin 추가
        q.offer(begin);
        distMap.put(begin, 0);

        // BFS
        while (!q.isEmpty()) {
            // 탐색 대상 한 개 추출
            String curWord = q.poll();
            int curDist = distMap.get(curWord);

            // 현재 탐색 대상이 target과 같다면, 리턴하면서 프로그램 종료
            if (curWord.equals(target)) {
                answer = curDist;
                break;
            }
            // 탐색 대상이 target이 아니라면
            else {
                // 다음 탐색 대상을 찾아서 q에 저장하고, 거리를 map에 저장
                Set<String> tempSet = new HashSet<>(wordsSet);
                for (String nextWord : tempSet) {
                    // 한 자리만 바꿔서 만들 수 있는 단어들을 다음 탐색으로 활용
                    if (canMake(curWord, nextWord)) {
                        q.offer(nextWord);
                        distMap.put(nextWord, curDist + 1);
                        wordsSet.remove(nextWord);
                    }
                }
            }
        }

        return answer;
    }

    private boolean canMake(String curWord, String nextWord) {
        int diffCnt = 0; // 서로 다른 알파벳 개수
        for (int i = 0; i < curWord.length(); i++) {
            if (curWord.charAt(i) != nextWord.charAt(i)) {
                diffCnt++;
                if (diffCnt == 2) {
                    return false;
                }
            }
        }
        return true;
    }
}

public class Pgms_43163_WordChange {
    public static void main(String[] args) {
        String[] tcBegin = {
                "hit", "hit"
        };
        String[] tcTarget = {
                "cog", "cog"
        };
        String[][] tcWords = {
                { "hot", "dot", "dog", "lot", "log", "cog" },
                { "hot", "dot", "dog", "lot", "log" }
        };

        Solution_43163 sol = new Solution_43163();
        for (int i = 0; i < tcBegin.length; i++) {
            System.out.println("tc" + (i + 1) + "> " + sol.solution(tcBegin[i], tcTarget[i], tcWords[i]));
        }
    }
}
