package test5_company.prof;

import java.util.HashMap;

public class Company {

	public static void main(String[] args) {
		//프로그램을 엔트리하기 위한 main클래스의 더미클래스.
		HashMap<Integer, Employee> map = new HashMap<Integer, Employee>();
		map.put(1, new Secretary("Hilery", 1, "secretary", 800)); // 1은 auto boxing돼서 알아서 입력된다.
		map.put(2, new Sales("Clinten", 2, "sales", 1200));
		
		// map에 있는 모든 객체에 대해 출력하자.
		for (Integer i : map.keySet()) {
			System.out.println(map.get(i));
		}
		
		// 모든 객체에 인센티브를 100씩 지급하자.
		// 타입 캐스팅과 동적 바인딩 내용을 이해해야 한다.
		for (Integer i : map.keySet()) {
			((Bonus)(map.get(i))).incentive(100);
		}
		
		// map에 있는 모든 객체에 대해 출력하자.
		for (Integer i : map.keySet()) {
			System.out.println(map.get(i) + "   " + map.get(i).tax()); // tax()는 동적바인딩
		}
	}
}
