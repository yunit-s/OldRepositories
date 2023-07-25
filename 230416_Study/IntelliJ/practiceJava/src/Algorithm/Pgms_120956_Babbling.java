package Algorithm;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Solution_120956 {
    // sol1 : 실패(문제점 못 찾음)
    public int solution_1(String[] babbling) {
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

        return answer;
    }

    // sol2 : 성공
    public int solution_2(String[] babbling) {
        int answer = 0;

        // babbling 단어 반복
        for (String word : babbling) {
//            System.out.println("word = " + word);
            // 발음 가능한 단어 저장
            Queue<String> ableQ = new LinkedList<>();
            ableQ.add("aya");
            ableQ.add("ye");
            ableQ.add("woo");
            ableQ.add("ma");

            // 일치하는 단어들로만 구성되어 있는지 체크
            int index = 0;
            boolean abled = true;
            while (index < word.length()) {
                boolean matched = false;
                // queue에 저장된 단어들 반복 비교
                for (int i = 0; i < ableQ.size(); i++) {
                    String qWord = ableQ.poll();
                    // 남은 단어길이가 qWord보다 작으면 비교 안 함. 그 이상일 때만 비교
                    if (word.length() - index >= qWord.length()) {
                        String sourceWord = word.substring(index, index + qWord.length());
//                        System.out.println("source = " + sourceWord + ", qWord = " + qWord);
                        if (sourceWord.equals(qWord)) {
//                            System.out.println("mached!");
                            matched = true;
                            index += qWord.length();
                            break;
                        }
                    }
                    // 매치되지 않았으면 다시 Queue에 저장
                    ableQ.add(qWord);
                }

                // 일치하는 거 없으면 실패, 일치하면 다음 확인
                if (matched == false) {
//                    System.out.println("disabled");
                    abled = false;
                    break;
                }
            }
            // 실패한 적 없는데 index가 단어 길이 이상이 되면 성공
            if (abled == true) {
//                System.out.println("answer++");
                answer++;
            }

        }
        return answer;
    }
}

public class Pgms_120956_Babbling {
    public static void main(String[] args) {
        String[][] babblings = {
                { "aya", "yee", "u", "maa", "wyeoo" },
                { "ayaye", "uuuma", "ye", "yemawoo", "ayaa" },
                { "ye" },
                { "yee" },
                { "y" },
                { "aaya", "ayayewooma", "ayayewoo", "ayayewoomaaya", "maya" }
        };

        Solution_120956 sol = new Solution_120956();
        for (int i = 0; i < babblings.length; i++) {
            int result = sol.solution_2(babblings[i]);
            System.out.println("tc" + (i + 1) + "> " + result);
        }
    }
}

/*
// --------------------------------------------------
// 120956-옹알이
// 구현 방법
3중 for문?

// --------------------------------------------------
// 제출 결과
sol1 : 실패. 5개쯤 통과되고 통과가 안 됐다. 왜지?
sol2 : 그냥 다시 풀어봄. 통과됨. sol1과 뭐가 다른 거지?

// test case 정답
1
3
1
0
0
2

*/
