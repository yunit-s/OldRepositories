package Algorithm;

// 배열로 풀었음
class Solution_42583 {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;

        int[] move = new int[truck_weights.length];
        int front = 0; // 다리 위에 있는 맨 앞 차량의 인덱스 저장
        // 맨 앞 차 번호 front가 truck_weights.length 와 같아지면 break;
        while (front < truck_weights.length) {
            // front부터 무게 합이 weight 이하일 때까지의 모든 트럭을 움직임
            //      단, 앞 차보다 항상 뒤에 있어야 함
            int tIdx = front;
            int weightSum = 0;
            if (move[tIdx] < bridge_length) {
                // 이번 이동에서 맨 앞차가 다리를 빠져나가지 못하는 경우, 무게 합산에 추가
                weightSum += truck_weights[tIdx];
            }
            while (weightSum <= weight) {
                move[tIdx]++;
                if (tIdx < truck_weights.length - 1 && move[tIdx] > move[tIdx + 1] + 1) {
                    tIdx++;
                    weightSum += truck_weights[tIdx];
                    if (weightSum > weight) {
                        break;
                    }
                } else {
                    break;
                }
            }

            // 맨 앞 차가 다리를 완전히 지나가면, 맨 앞 차 변경
            if (move[front] == bridge_length + 1) {
                front++;
            }
            answer++;
        }

        return answer;
    }
}

public class Pgms_42583_TruckOnBridge {
    public static void main(String[] args) {
        int[] tcBridge_length = { 2, 100, 100 };
        int[] tcWeight = { 10, 100, 100 };
        int[][] tcTruck_weights = {
                { 7, 4, 5, 6 },
                { 10 },
                { 10, 10, 10, 10, 10, 10, 10, 10, 10, 10 }
        };

        Solution_42583 sol = new Solution_42583();
        for (int i = 0; i < tcBridge_length.length; i++) {
            System.out.println("tc" + (i + 1) + "> " + sol.solution(tcBridge_length[i], tcWeight[i], tcTruck_weights[i]));
        }
    }
}
