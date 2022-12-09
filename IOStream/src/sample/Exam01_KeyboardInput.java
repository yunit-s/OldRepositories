package sample;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Exam01_KeyboardInput {

	public static void main(String[] args) {
		System.out.println("키보드로 한 줄을 입력하세요!");
		
		// 키보드로부터 입력을 받으려면, 데이터 연결통로(Stream)이 있어야 한다.
		// System.in 을 제공받을 수 있는데, 얘는 InputStream class의 객체야. 사용하기가 불편하다.
		// 문자 기반의 데이터를 받기를 원하니, 문자열 기반의 Reader를 하나 만들자
//		new InputStreamReader(System.in); // Stream을 결합해서 조금 더 편한, 문자 기반의 연결통로를 하나 만들 수 있어.
		// 근데 위에것도 불편해. 이것보다 조금 더 편한 문자 기반의 데이터 입력 연결통로를 만들어 보자.
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 연결 통로를 조금씩 더 좋은 것으로 발전해나간다는 느낌의 개념이다.
		// 통로에서 메소드를 활용해서 문자를 읽어오자.
		// 여기서 한 줄(한 라인)이 어디까지일까?
		// 엔터 까지 포함하는게 한 줄이다.
		try {
			String s = br.readLine(); // 얘도 무조건 예외처리를 해줘야해.
			System.out.println("입력받은 데이터는 : " + s);
		} catch (IOException e) {
		}
		
	}
}
