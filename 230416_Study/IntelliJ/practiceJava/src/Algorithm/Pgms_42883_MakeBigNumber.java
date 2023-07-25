package Algorithm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import java.util.Stack;

// ChatGPT 코드
// 이걸 스택 느낌으로 풀 수가 있구나.. 그리고 큰 수들만 남겨두는 방법도 좋네
class Solution_42883_3 {
    public String solution(String number, int k) {
        int len = number.length();
        int remain = len - k; // 남아야 할 숫자의 개수
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < len; i++) {
            char curr = number.charAt(i);

            while (!stack.isEmpty() && stack.peek() < curr && k > 0) {
                stack.pop();
                k--;
            }

            stack.push(curr);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < remain; i++) {
            sb.append(stack.get(i));
        }

        return sb.toString();
    }
}

// 너무 지저분해져서 포기. 근데 로직은 맞긴 한 듯
//class Solution_42883_2 {
//    public String solution(String number, int k) {
//        String answer = "";
//
//        // 삭제해야하는 위치 저장
//        boolean[] delArr = new boolean[number.length()];
//
//        // k가 0이 될 때까지 처음부터 끝까지 탐색
//        Map<Integer, List> numMap = new HashMap<>(); // 각 자리 숫자를 map에 나눠서 인덱스 저장
//        for (int i = 0; i < 10; i++) {
//            numMap.put(i, new ArrayList());
//        }
//        int stdIdx = 0; // 기준 위치
//        int curIdx = 0; // 현재 위치
////        int max = -1; // 구간별 최댓값
//        while (k > 0) {
//            System.out.print("stdIdx:" + stdIdx + ", curIdx:" + curIdx + ", k:" + k + "\t");
//            // 남은 숫자를 모두 버려야하는 경우
//            if (stdIdx + k == number.length()) {
//                System.out.println("case1");
//                for (int i = stdIdx; i < number.length(); i++) {
//                    delArr[i] = true;
//                }
//                k = 0;
//            } else {
//                // 현재 숫자를 숫자map에 저장. key:숫자값, value:인덱스
//                int curNum = number.charAt(curIdx) - '0';
//                int stdNum = number.charAt(stdIdx) - '0';
//                numMap.get(curNum).add(curIdx);
//
//                // 가장 큰 수가 나타났을 경우
//                if (curNum > stdNum) {
//                    System.out.println("case2");
//                    // 그 앞 숫자를 다 delArr에 추가
//                    // 해당 숫자들을 map에서 제거
//                    // k를 앞 숫자 개수만큼 빼기
//                    // stdIdx = curIdx + 1;
//                    // curIdx += 2;
//                    for (int i = stdIdx; i < curIdx; i++) {
//                        delArr[i] = true;
//                        numMap.get(number.charAt(i) - '0').remove(0); // 무조건 맨 앞부터 지우면 됨
//                    }
//                    k -= curIdx - stdIdx;
//                    stdIdx = curIdx + 1;
//                    curIdx ++;
//                } else {
//                    // k+1개만큼 숫자를 확인한 경우
//                    if (curIdx == stdIdx + k) {
//                        System.out.println("case3");
//                        // k+1개 숫자 중에서 기준 숫자가 가장 큰 경우 - 기준 숫자는 확정 숫자 취급
//                        // map에서 기준 숫자만 제거
//                        // stdIdx++;
//                        // curIdx++;
//                        // map에 있는 데이터 중 가장 큰 수를 기준으로 그 앞 숫자 다 지우고, 그 숫자를 stdIdx로 잡고, 다시 진행
//
////                        numMap.get(stdNum).remove(0); // 무조건 맨 앞부터 지우면 됨
////                        stdIdx++;
////                        curIdx++;
//                    } else {
//                        // 아직 숫자 더 확인해야 하는 경우
//                        System.out.println("case4");
//                        curIdx++;
//                    }
//                }
//            }
//        }
////        System.out.println(numMap);
//        StringBuilder sb = new StringBuilder();
//        for (int i = 0; i < number.length(); i++) {
//            if (delArr[i] == false) {
//                sb.append(number.charAt(i));
//            }
//        }
//        System.out.println(sb.toString());
//        return answer;
//    }
//}

// 비효율적인 코드들이 좀 있어도 그냥 해봤는데, 진짜 시간초과뜨네
// 10번 시간초과, 나머진 성공
class Solution_42883_1 {
    public String solution(String number, int k) {
        String answer = "";

        // 0~k 위치의 숫자까지 중 가장 큰 숫자를 찾고, 그 숫자의 앞부분 잘라내기
        // 가장 큰 수만 남기고, 그 이후 숫자들을 가지고 똑같은 행동 반복
        // k가 0이 되면, 문자열을 answer에 저장
        StringBuilder num = new StringBuilder(number);
        int idx = 0;
        while (k > 0) {
            int max = -1, maxIdx = 0;
            // 남은 숫자 개수가 충분한 경우
            if (idx + k < num.length()) {
                for (int i = idx; i < idx + k + 1; i++) {
                    if (num.charAt(i) - '0' > max) {
                        max = num.charAt(i) - '0';
                        maxIdx = i;
                    }
                }
//                System.out.println("num:" + num.toString() + ", idx:" + idx + ", maxIdx:" + maxIdx + ", k:" + k);
                if (maxIdx > idx) {
                    num.delete(idx, maxIdx);
                    k -= maxIdx - idx;
                }
                idx++;
            } else {
                // 남은 숫자 개수가 k와 동일한 경우, 남은 숫자 모두 제거
                num.delete(idx, num.length());
                k = 0;
            }
        }
        answer = num.toString();

        return answer;
    }
}

public class Pgms_42883_MakeBigNumber {
    public static void main(String[] args) {
        String[] tcNumber = {
                "1924", "1231234", "4177252841", "2635472849251", "751437463835"
        };
        int[] tcK = { 2, 3, 4, 5, 5 };

        Solution_42883_1 sol = new Solution_42883_1();
        for (int i = 0; i < tcNumber.length; i++) {
            System.out.println("tc" + (i + 1) + "> " + sol.solution(tcNumber[i], tcK[i]));
        }
    }
}
