package exam;

import java.util.*;

public class Part2_Test04 {

	public static void main(String[] args) {
		
		List<Integer> list = new ArrayList<Integer>();
		for(int i = 0; i < 10; i++) {
			// ArrayList에 1~10까지의 정수를 랜덤하게 셋팅 하고 셋팅 된 데이터를 출력 한다.
//			System.out.println((int)Math.ceil((Math.random() * 10)));
			Integer num = (int)Math.ceil(Math.random() * 10);
			System.out.print(num + " ");
			list.add(num);
		}
		System.out.println();
		
		// ArrayList의 값들을 Sorting 처리
		Collections.sort(list);
		for(int i = 0; i < list.size(); i++){
			// Sorting 된 ArrayList 값들을 화면에 출력
			System.out.print(list.get(i) + " ");
		}
	}
}
