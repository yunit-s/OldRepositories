package com.test;

import java.util.HashSet;

public class SetTest {

	public static void main(String[] args) {
		
		HashSet<String> set = new HashSet<String>();
		
		// set안에 데이터 저장하기
		set.add("123");
		set.add("홍길동");
		set.add("신사임당");
		set.add("Hello");
		
		// set에서 데이터 추출하기
		for (String s : set) {
			System.out.println(s);
		}
		
	}
}
