package sample;

import java.io.File;
//import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;

public class Exam02_ObjectStream {

	public static void main(String[] args) {
		
		// Stream을 통해서 내보낼 HashMap 데이터를 만들자
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("1",  "홍길동");
		map.put("2",  "신사임당");
		map.put("3",  "강감찬");
		
		// 실제 파일을 생성하려면 당연히 자바쪽에서 File객체를 만들어야 한다. text파일 같은 것
		File file = new File("readme.txt"); // 우리가 출력할 파일명을 설정한 객체를 만든다.
		
		try {
			FileOutputStream fos = new FileOutputStream(file); // 데이터를 내보내는 통로를 만들 거야. 뒤쪽에는 우리가 방금 만든 파일 객체를 넣어야지.
					// 이것도 예외처리 필수
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			// 통로를 만들어줬으니 이제 데이터를 보내고 받기 위해 메소드를 활용하자
			oos.writeObject(map);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
