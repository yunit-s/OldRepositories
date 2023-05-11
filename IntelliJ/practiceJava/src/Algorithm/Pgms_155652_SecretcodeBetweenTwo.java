package Algorithm;

class Solution_155652 {
    public String solution(String s, String skip, int index) {
        String answer = "";

        // 가변 문자열을 적용하기 위해 StringBuilder 클래스 사용
        StringBuilder sb = new StringBuilder(s);

        // skip 문자들을 배열로 표현
        boolean[] skipArr = new boolean[26]; // 26 : 알파벳 개수
        for (int i = 0; i < skip.length(); i++) {
            skipArr[skip.charAt(i) - 'a'] = true;
        }

        // 문자열 변환
        for (int i = 0; i < sb.length(); i++) {
            // remain 횟수 만큼 문자 변환
            int remain = index;
            while (remain > 0) {
                if (sb.charAt(i) == 'z') {
                    sb.setCharAt(i, 'a');
                } else {
                    sb.setCharAt(i, (char) (sb.charAt(i) + 1));
                }

                // skip 문자가 아니면 remain 1 감소
                if (!skipArr[sb.charAt(i) - 'a']) {
                    remain--;
                }
            }
        }

        answer = sb.toString();
        return answer;
    }
}

public class Pgms_155652_SecretcodeBetweenTwo {
    public static void main(String[] args) {
        String[] tcS = {
                "aukks"
        };
        String[] tcSkip = {
                "wbqd"
        };
        int[] tcIndex = {
                5
        };

        Solution_155652 sol = new Solution_155652();
        for (int i = 0; i < tcS.length; i++) {
            System.out.println("tc" + (i + 1) + "> " + sol.solution(tcS[i], tcSkip[i], tcIndex[i]));
        }
    }
}
