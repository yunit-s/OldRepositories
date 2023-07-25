package exam;

import java.util.HashMap;

public class Part2_Test05 {

	public static void main(String[] args) {

		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		double sum=0.0;
		
		for(int i = 1; i <= 10; i++){
			// HashMap에 1~100까지의 정수를 랜덤하게 10개 셋팅
			map.put(i, (int)Math.ceil(Math.random() * 100));
		}
		for(Integer a : map.keySet()){
			// HashMap 데이터를 화면에 출력
			System.out.print(map.get(a) + " ");
		}
		System.out.println();
		for(Integer a : map.keySet()){
			// HashMap 데이터의 합계를 계산
			sum += map.get(a);
		}
		
		// 합계와 평균을 화면에 출력
		System.out.println("합계 : " + sum);
		System.out.println("평균 : " + (sum / map.size()));
		
	}
}
