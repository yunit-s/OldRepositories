// 미완성
package Algorithm;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Solution_120956 {
    public int solution(String[] babbling) {
        int answer = 0;

        // babbling 단어 반복
        for (String word : babbling) {
            Queue<String> ableQ = new LinkedList<>();
            ableQ.add("aya");
            ableQ.add("ye");
            ableQ.add("woo");
            ableQ.add("ma");

            // 단어 하나의 처음부터 끝까지 반복
            int i = 0;
            while (i < word.length()) {

                boolean matched = false;
                // able 단어 비교
                for (int j = 0; j < ableQ.size(); j++) {
                    String a = ableQ.poll();
                    if (i + a.length() <= word.length()) {
                        String b = word.substring(i, i + a.length());
                        if (a.equals(b)) {
                            matched = true;
                            i += a.length();
                            break;
                        } else {
                            ableQ.add(a);
                        }
                    }
                }

                // 매치되는 단어가 있었는지 확인
                if (matched == false) {
                    // 발음 불가
                    break;
                } else if (i >= word.length()) {
                    answer++;
                }
            }
        }

        System.out.println(answer);
        return answer;
    }
}

public class Pgms_120956_Babbling {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[] babbling = new String[n];
        for (int i = 0; i < n; i++) {
            babbling[i] = sc.next();
        }

        Solution_120956 sol = new Solution_120956();
        sol.solution(babbling);
    }
}

/*
// --------------------------------------------------
// 120956-옹알이
// 구현 방법
3중 for문?

// --------------------------------------------------
// 제출 결과


// test case
5 aya yee u maa wyeoo
5 ayaye uuuma ye yemawoo ayaa
1 ye
1 yee
1 y
5 aaya ayayewooma ayayewoo ayayewoomaaya maya

// test case 정답
1
3
1
0
0
2

*/
