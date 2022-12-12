package exam01;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.DateFormat;
import java.util.Date;

public class Exam01_DateServer {

	public static void main(String[] args) {
		
		// server 돌리기 시작
		// 먼저 ServerSocket 을 만들어 줄 거야. 왜냐? 클라이언트를 대기하고 있는 놈이거든.
		try {
			 // ServerSocket 객체 생성
			ServerSocket server = new ServerSocket(3000);
			System.out.println("서버소켓이 생성되었어요 - 포트번호 3000");
			// 이 서버소켓을 통해 클라이언트의 접속을 기다려야 해
			Socket s = server.accept(); // 클라이언트 대기
			System.out.println("클라이언트의 접속이 들어왔어요!");
			
			// 서버에서 클라이언트로 데이터를 전송해보자
			// 클라이언트와 연결된 output stream(데이터를 내보내기 위한 스트림)을 만들 거야.
			// 그런데 단순히 s.getOutputStream()만 쓰면 좀 안 좋아. 좀 더 쓰기 편하게 PrintWriter를 쓰는 거야.
			PrintWriter out = new PrintWriter(s.getOutputStream());
			
			// 현재 시간을 보내주자.
			DateFormat dateFormat = DateFormat.getInstance(); // 이 dateFormat을 이용하면 지금의 날짜와 시간 정보를 가져올 수 있다.
			String currentDate = dateFormat.format(new Date()); // 클라이언트한테 보내즐 데이터 획득
			
			out.println(currentDate); // 클라이언트에게 데이터 송신(실제로는 송신을 위한 버퍼에 저장)
			out.flush(); // 버퍼에 실은 데이터를 실제로 송신
			
			// 연결 마무리
			out.close(); // stream을 닫자.
			s.close(); // socket을 닫자.
			server.close(); // server socket을 닫자.
			
			System.out.println("서버 프로그램 종료!");
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
