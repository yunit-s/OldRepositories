package Algorithm;

import java.util.Stack;

class Solution_42584 {
    public int[] solution(int[] prices) {
        int[] answer = {};
        answer = new int[prices.length];

        // 주식 가격과 시간을 동시에 저장하는 스택
        Stack<Integer[]> st = new Stack<>();

        // 처음부터 끝까지 반복
        //      스택이 비어있으면, 무조건 push
        //      기준 주가보다 peek가 더 크면 전부 pop
        //          기준 주가와 가격이 같아지거나, 스택이 빌 때까지 pop
        //      현재 정보 푸시
        // 끝까지 갔으면, 나머지 스택 모두 pop
        for (int i = 0; i < prices.length; i++) {
            if (st.isEmpty()) {
                st.push(new Integer[]{ prices[i], i });
            } else {
                while (st.peek()[0] > prices[i]) {
                    answer[st.peek()[1]] = i - st.peek()[1];
                    st.pop();
                    if (st.isEmpty()) {
                        break;
                    }
                }
                st.push(new Integer[]{ prices[i], i });
            }
        }

        // 남은 스택 모두 pop
        while (!st.isEmpty()) {
            Integer[] stPrice = st.pop();
            answer[stPrice[1]] = prices.length - 1 - stPrice[1];
        }

        return answer;
    }
}

public class Pgms_42584_StockPrice {
    public static void main(String[] args) {
        int[][] tcPrices = {
                { 1, 2, 3, 2, 3 },
                { 3, 4, 6, 4, 5, 2, 4, 3, 6, 5, 2 }
        };

        Solution_42584 sol = new Solution_42584();
        for (int i = 0; i < tcPrices.length; i++) {
            System.out.print("tc" + (i + 1) + "> ");
            int[] result = sol.solution(tcPrices[i]);
            for (int j = 0; j < result.length; j++) {
                System.out.print(result[j] + ", ");
            }
            System.out.println();
        }
    }
}
