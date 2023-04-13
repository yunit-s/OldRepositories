/*

// 참고 사이트
HashMap 데이터 내림차순 정렬하
	https://velog.io/@cgw0519/Java-HashMap-Value-%EA%B8%B0%EC%A4%80%EC%9C%BC%EB%A1%9C-%EC%A0%95%EB%A0%AC%ED%95%98%EA%B8%B0



 */


package algorithm;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Map.Entry;

class Solution42889 {
	
	int[] currStage;
	int[] complUser;
	
    public int[] solution(int N, int[] stages) {
        int[] answer = {};
        
        // 스테이지별 도전 중인 사람의 수
        currStage = new int[N + 2];
        for (int stage: stages) {
        	currStage[stage]++;
        }
        
        // 스테이지에 도달한 사람의 수
        complUser = new int[N + 3];
        for (int i = N + 1; i > 0; i--) {
        	complUser[i] = complUser[i + 1] + currStage[i];
        }
        
        // 실패율 데이터 저장
        Map<Integer, Double> failRateMap = new HashMap<>();
        for (int i = 1; i < N + 1; i++) {
        	if (complUser[i] == 0) {
        	    failRateMap.put(i, 0.0);
        	}
        	else {
                failRateMap.put(i, (double)currStage[i] / complUser[i]);
            }
            // System.out.println("failrate:" + i + " " + failRateMap.get(i));
        }

        // value값으로 정렬
        List<HashMap.Entry<Integer, Double>> entryList = new ArrayList<>(failRateMap.entrySet());
        entryList.sort(new Comparator<HashMap.Entry<Integer, Double>>() {
        	@Override
        	public int compare(Entry<Integer, Double> o1, Entry<Integer, Double> o2) {
        		// TODO Auto-generated method stub
        		// value값 기준 내림차순
        		if (o1.getValue() > o2.getValue())
        			return -1;
        		else
        			return 1;
        	}
        });
        
        // output
        answer = new int[N];
        for (int i = 0; i < N; i++) {
        	answer[i] = entryList.get(i).getKey();
        }
        
        printArray(answer);
        
        return answer;
    }
    
    public void printArray(int[] arr) {
    	System.out.println("@@ stages : ");
    	for (int item : arr) {
    		System.out.print(item + ", ");
    	}
    	System.out.println();
    }
}

public class Pgms_42889_FailureRate {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N;
		
		// input
		N = sc.nextInt();
		int stages_num = sc.nextInt();
		int[] stages = new int[stages_num];
		for (int i = 0; i < stages_num; i++) {
			stages[i] = sc.nextInt();
		}
		
		// process
		Solution42889 s = new Solution42889();
		s.solution(N, stages);
		
	}
}

/*

//제출 결과
구현 시간 - 1시간 20분
1번째 시도 - 맞았습니다! 채점 시간 3초

//test case

5 8
2 1 2 6 2 4 3 3

4 5
4 4 4 4 4

5 8
2 1 2 6 2 4 3 3


//test case 정답
 
[3,4,2,1,5]
 
[4,1,2,3]

[3, 4, 2, 1, 5]

*/
