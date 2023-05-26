package Algorithm;

class Solution_Test230526_04 {

    int cnt;
    long answer;

    public long solution(int n) {
        cnt = 0;
        answer = 0;

        // len자리 수를 만들어내는 메서드 dfs 호출
        int len = 1;
        while (cnt < n) {
//            System.out.println("길이 증가. len : " + len);
            dfs("", len, n);
            len++;
        }

        return answer;
    }

    // curStr 이후 len자리 수 완성하기
    //      curStr : 왼쪽 숫자배열
    //      len : 앞으로 완성해야하는 자릿수
    //      n : 목표 순위
    private void dfs(String curStr, int len, int n) {
        // 목표 숫자 찾았으면 종료
        if (cnt >= n) {
            return;
        }

        // 남은 자릿수(len)가 0이 될 때까지 재귀호출
        if (len >= 1) {
            //  두 자리가 남은 경우, 13부터 추가해야 함
            if (len > 1) {
                dfs(curStr + "13", len - 2, n);
            }
            dfs(curStr + "4", len - 1, n);
        } else {
            // len == 0인 경우, 카운트 세기
            cnt++;
//            System.out.println("cnt: " + cnt + ". \t" + curStr);
            if (cnt == n) {
                answer = Long.parseLong(curStr);
            }
        }
    }
}

public class Pgms_Test230526_04_Saltlux {
    public static void main(String[] args) {
        int[] tcN = { 1, 2, 3, 5000 };

        Solution_Test230526_04 sol = new Solution_Test230526_04();
        for (int i = 0; i < tcN.length; i++) {
            System.out.println("tc" + (i + 1) + "> " + sol.solution(tcN[i]));
        }
    }
}
