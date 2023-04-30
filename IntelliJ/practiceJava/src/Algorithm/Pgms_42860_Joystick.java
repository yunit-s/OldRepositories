package Algorithm;

class Solution_42860 {
    public int solution(String name) {
        int answer = 0;

        // 각 자리에서 A까지의 거리 더하기
        for (int i = 0; i < name.length(); i++) {
            answer += 13 - Math.abs('N' - name.charAt(i));
        }

        // 초기 위치에서 좌우 각각 이동해야하는 횟수 체크
        int right = 0;
        int blank = 0;
        for (int i = 1; i < name.length(); i++) {
            if (name.charAt(i) != 'A') {
                right = i;
                blank = 0;
            } else {
                blank++;
                if (blank >= name.length() / 2) {
                    break;
                }
            }
        }
        int left = 0;
        blank = 0;
        for (int i = 1; i < name.length(); i++) {
            if (name.charAt(name.length() - i) != 'A') {
                left = i;
                blank = 0;
            } else {
                blank++;
                if (blank >= name.length() / 2) {
                    break;
                }
            }
        }

        // answer = sum (거리) + 왼쪽 혹은 오른쪽 최단거리
        if (blank < name.length() / 2) {
            answer += Math.min(left, right);
        } else {
            answer += Math.min(left, right) + left + right;
        }

        return answer;
    }
}

public class Pgms_42860_Joystick {
    public static void main(String[] args) {
        String[] tcName = {
                "JEROEN", "JAN", "A", "C", "N",
                "Y", "AAAAA", "CAAAA", "CACAA", "CAACA",
                "AACCA", "AANCA", "AAAAAA", "YAAAAA", "YAYAAA",
                "YAAYAA", "YAAAYA", "NANAAA", "NAANAA", "NAAANA",
                "AACAAAC", "ACAAACA", "AACAACA", "ACAAAACA", "AACAAAAC",
                "ACAAACAA", "AACAAACA"
        };

        Solution_42860 sol = new Solution_42860();
        for (int i = 0; i < tcName.length; i++) {
            System.out.println("tc" + (i + 1) + "> " + sol.solution(tcName[i]));
        }
    }
}

/*

// --------------------------------------------------
// 42860-조이스틱
// 구현 방법
모든 자리마다 변환해야 하는 수 + 최단거리 이동 횟수
최단거리 계산 시 주의점
꼭 한 바퀴를 돌 필요가 없는 경우도 있다. 왔던 길 되돌아가는 게 최단거리일 수 있음


// --------------------------------------------------
// 제출 결과
구현 시간 -
1번째:48.1. 한 방향으로만 이동한 경우
2번째:85.2. 왔다가 한 번 되돌아간 경우

// test case 정답
56 23 0 2 13
2 0 2 6 6
7 18 0 2 6
7 6 28 29 28
8 8 9 8 8
9 10

*/