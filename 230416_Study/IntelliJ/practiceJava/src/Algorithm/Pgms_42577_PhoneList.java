package Algorithm;

import java.util.Arrays;

class Solution_42577 {
    public boolean solution(String[] phone_book) {
        boolean answer = true;

        // 전화번호 정렬
        Arrays.sort(phone_book);

        // 시작부분 포함하는지 조사
        for (int i = 0; i < phone_book.length - 1; i++) {
            if (phone_book[i + 1].startsWith(phone_book[i])) {
                answer = false;
                break;
            }
        }

        return answer;
    }
}

public class Pgms_42577_PhoneList {
    public static void main(String[] args) {
        String[][] tcPhone_book = {
                { "119", "97674223", "1195524421" },
                { "123","456","789" },
                { "12","123","1235","567","88" }
        };

        Solution_42577 sol = new Solution_42577();
        for (int i = 0; i < tcPhone_book.length; i++) {
            System.out.println("tc" + (i + 1) + "> " + sol.solution(tcPhone_book[i]));
        }
    }
}

/*
// 결과
indexOf 로 풀기
테스트 1 〉	통과 (16.61ms, 56MB)
테스트 2 〉	통과 (31.40ms, 56.1MB)
테스트 3 〉	통과 (366.51ms, 99MB)
테스트 4 〉	통과 (317.19ms, 96.6MB)

startsWith 로 풀기
테스트 1 〉	통과 (16.21ms, 57.6MB)
테스트 2 〉	통과 (17.33ms, 56MB)
테스트 3 〉	통과 (359.17ms, 98.1MB)
테스트 4 〉	통과 (297.14ms, 111MB)

 */