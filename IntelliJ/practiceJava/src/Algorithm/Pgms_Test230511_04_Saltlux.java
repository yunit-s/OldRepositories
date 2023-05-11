package Algorithm;

class Solution_Test230511_04 {
    public int solution(String s) {
        int answer = 0;

        // 처음으로 나오는 a나 z 찾기
        char lastChar = '0';
        int idx = 0;
        for (idx = 0; idx < s.length(); idx++) {
            if (s.charAt(idx) == 'a' || s.charAt(idx) == 'z') {
                lastChar = s.charAt(idx);
                break;
            }
        }

        // 이후 끝까지 검색하면서 'a' 와 'z' 가 바뀌는 횟수 세기
        idx++;
        while (idx < s.length()) {
            if (lastChar == 'a' && s.charAt(idx) == 'z') {
                answer++;
                lastChar = 'z';
            } else if (lastChar == 'z' && s.charAt(idx) == 'a') {
                answer++;
                lastChar = 'a';
            }
            idx++;
        }

        return answer;
    }
}

public class Pgms_Test230511_04_Saltlux {
    public static void main(String[] args) {
        String[] tcS = { "abcz", "zabzczxa", "abcd" };

        Solution_Test230511_04 sol = new Solution_Test230511_04();
        for (int i = 0; i < tcS.length; i++) {
            System.out.println("tc" + (i + 1) + "> " + sol.solution(tcS[i]));
        }
    }
}

/*
// 문제
z와 a가 교차되는 횟수 세기

정확성 테스트
테스트 1 〉 통과 (0.02ms, 78.1MB)
테스트 2 〉 통과 (0.04ms, 75.9MB)
테스트 3 〉 통과 (0.04ms, 72.1MB)
테스트 4 〉 통과 (0.03ms, 80MB)
테스트 5 〉 통과 (0.03ms, 65.5MB)
테스트 6 〉 통과 (0.03ms, 77.2MB)
테스트 7 〉 통과 (0.02ms, 68.8MB)
테스트 8 〉 통과 (0.03ms, 70.9MB)
테스트 9 〉 통과 (0.03ms, 71.8MB)
테스트 10 〉 통과 (0.03ms, 81.5MB)
테스트 11 〉 통과 (0.03ms, 76.2MB)
테스트 12 〉 통과 (0.02ms, 70.5MB)
테스트 13 〉 통과 (0.03ms, 72.2MB)
테스트 14 〉 통과 (0.04ms, 73.7MB)
테스트 15 〉 통과 (0.07ms, 74.9MB)
테스트 16 〉 통과 (0.08ms, 83.9MB)
테스트 17 〉 통과 (0.14ms, 75.9MB)
테스트 18 〉 통과 (0.22ms, 75.6MB)
테스트 19 〉 통과 (0.27ms, 76.2MB)
테스트 20 〉 통과 (1.42ms, 73.4MB)
테스트 21 〉 통과 (0.96ms, 74.9MB)
테스트 22 〉 통과 (6.54ms, 84.1MB)
테스트 23 〉 통과 (6.22ms, 86.1MB)
테스트 24 〉 통과 (6.18ms, 74.1MB)
 */