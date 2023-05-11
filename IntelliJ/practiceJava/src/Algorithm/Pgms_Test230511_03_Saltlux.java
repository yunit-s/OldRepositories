package Algorithm;

class Solution_Test230511_03 {
    public String solution(String encrypted_text, String key, int rotation) {
        String answer = "";

        // 새 char 배열에 rotation 역순 결과 저장
        char[] rotationChar = new char[encrypted_text.length()];
        for (int i = 0; i < rotationChar.length; i++) {
            int newIdx = i - (rotation % rotationChar.length);
            if (newIdx < 0) {
                newIdx = newIdx + rotationChar.length;
            } else if (newIdx >= rotationChar.length) {
                newIdx = newIdx - rotationChar.length;
            }
//            System.out.println(newIdx + ", " + i);
            rotationChar[newIdx] = encrypted_text.charAt(i);
        }

        // 각 문자열 역변환
        for (int i = 0; i < rotationChar.length; i++) {
            char nextChar = (char)(rotationChar[i] - (key.charAt(i) - 'a' + 1));
            if (nextChar < 'a') {
                nextChar = (char)(nextChar + ('z' - 'a' + 1));
            }
            rotationChar[i] = nextChar;
        }
        answer = new String(rotationChar);

        return answer;
    }
}

public class Pgms_Test230511_03_Saltlux {
    public static void main(String[] args) {
        String[] tcEncrypted_text = {
                "qyyigoptvfb", "a", "bbbb", "bbbbbb"
        };
        String[] tcKey = {
                "abcdefghijk", "a", "abcd", "zyxabc"
        };
        int[] tcRotation = { 3, 1, 5, 6 };

        Solution_Test230511_03 sol = new Solution_Test230511_03();
        for (int i = 0; i < tcEncrypted_text.length; i++) {
            System.out.println("tc" + (i + 1) + "> " + sol.solution(tcEncrypted_text[i], tcKey[i], tcRotation[i]));
        }

    }
}

/*
// 문제
복호화

정확성 테스트
테스트 1 〉 통과 (0.03ms, 88.7MB)
테스트 2 〉 통과 (0.05ms, 79.9MB)
테스트 3 〉 통과 (0.06ms, 72.1MB)
테스트 4 〉 통과 (0.03ms, 74.7MB)
테스트 5 〉 통과 (0.05ms, 77.9MB)
테스트 6 〉 통과 (0.03ms, 73.9MB)
테스트 7 〉 통과 (0.03ms, 73.3MB)
테스트 8 〉 통과 (0.04ms, 77.6MB)
테스트 9 〉 통과 (0.02ms, 71.4MB)
테스트 10 〉 통과 (0.03ms, 68.5MB)
테스트 11 〉 통과 (0.02ms, 80.1MB)
테스트 12 〉 통과 (0.03ms, 76.6MB)
테스트 13 〉 통과 (0.03ms, 75.9MB)
테스트 14 〉 통과 (0.03ms, 74.7MB)
테스트 15 〉 통과 (0.04ms, 74.3MB)
테스트 16 〉 통과 (0.06ms, 77.6MB)
테스트 17 〉 통과 (0.03ms, 74.9MB)
테스트 18 〉 통과 (0.03ms, 72.8MB)
 */
