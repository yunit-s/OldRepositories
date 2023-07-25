package com.test;

import java.util.HashMap;
import java.util.Set;

public class MapTest {

	public static void main(String[] args) {
		
		HashMap<String, String> map = new HashMap<String, String>();
		
		// Map에 데이터 자정하기
		map.put("123", "Hello");
		map.put("4", "안녕!!");
		map.put("kk", "홍길동");
		map.put("aa", "신사임당");
		map.put("123", "소리없는 아우성!"); // 이건 오류일까? ㄴㄴ 해당 데이터의 value값이 교체될 뿐
		
		// Map에서 데이터 추출하기
		System.out.println(map.get("123"));
		
		// Map 안에 있는 모든 key를 알고 싶을 때
		Set<String> s = map.keySet(); // Set은 상위class이기 때문에 is-a 관계에 의해 이렇게 사용 가능하다.
		for (String a : s) {
			System.out.println(a);
		}
	}
}
