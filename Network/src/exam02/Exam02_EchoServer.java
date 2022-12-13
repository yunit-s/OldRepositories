package exam02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

import javafx.application.Application;
import javafx.application.Platform;
//import javafx.event.ActionEvent;
//import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class Exam02_EchoServer extends Application {

	TextArea textarea;
	Button startBtn;
	Button stopBtn;
	ServerSocket server;
	Socket s;
	
	PrintWriter pr;
	BufferedReader br;
	
	// 이 클래스 내부에서만 쓰기 위해서 private 로 설정
	private void printMsg(String msg) {
		Platform.runLater(() -> {
			textarea.appendText(msg + "\n"); // textarea 에 문자열을 추가한다.
		});
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		// 뭐가 있어야 화면을 띄우니까, 창의 화면을 구성하자
		// Layout
		BorderPane root = new BorderPane();
		root.setPrefSize(700, 500); // 여기서는 pane의 크기가 곧 layout의 크기가 되겠지
		
		textarea = new TextArea();
		root.setCenter(textarea);

		// 서버 시작하기
		startBtn = new Button("서버시작!");
		startBtn.setPrefSize(150, 40);
		// 버튼을 클릭했을 때(클릭이 ActionEvent. 그리고 입력에서 Enter치는 것도 action)
		// setOnAction() 괄호 안에 이벤트를 처리할 핸들러객체를 넣는다.
		// 이벤트 처리는 Listener객체(Handler 객체)가 담당한다. -> 그래서 delegation model이라고 무른다.
		// interface타입의 객체를 만들고, <> 안에는 어떠한 이벤트를 처리할 지 적어놓는다.
		
//		// 아래가 기본 코드 방식이야.
//		// 이것보다 더 기본은 따로 class를 만들어야 하는데, 그게 너무 번거로울 수 있으니 여기에서 새로
//		// interface 타입의 객체를 만들면서 바로 오버라이딩한 건데, 사실 이것도 코드가 복잡해.
//		startBtn.setOnAction(new EventHandler<ActionEvent>() {
//			
//			@Override
//			public void handle(ActionEvent arg0) {
//				// TODO Auto-generated method stub
//				
//			}
//		});
		
		// 위 내용을 더욱 축약해서 아래처럼 표현할 수 있다. 이게 Java의 문법 중 하나고, 이런 방식이 통하는 경우가 정해져있다.
		// Arrow Function. e 는 ActionEvent의 객체 (arg0) 를 의미한다. 일반적으로 이 방식을 많이 활용한다.
		startBtn.setOnAction(e -> {
//			textarea.appendText("서버가 시작되었어요!" + "\n"); // textarea 에 문자열을 추가한다.
			// appendText() 가 blocking method 이다. 실행되는 동안 수행이 잠시 중지된다. 전체 프로그램이 묶여.
			// 순차 처리를 안 하기 위해서 Thread 를 사용해야 한다.
			// 근데 또 다 만들려면 힘들잖아? 그래서 JavaFX가 지원해주는 기능이 있어.
			// JavaFX에서 GUI의 components 를 제어할 때 편리하게 쓰라고 만들어줌.
			
//			// 가장 기본적인 쓰레드 생성 코드
//			new Thread(new Runnable() {
//				
//				@Override
//				public void run() {
//					// TODO Auto-generated method stub
//					
//				}
//			});
//			// 위 내용을 줄인 코드
//			new Thread(() -> {});
			
//			// JavaFX에서 만들어준 기능을 활용하는 기본적인 방법
//			Platform.runLater(new Runnable() {
//				
//				@Override
//				public void run() {
//					// TODO Auto-generated method stub
//					
//				}
//			});
			
//			// 위 방식이 불편하니까 더 짧게 줄인 코드
//			// run() 안에 인자값이 없을 때 표현하는 방식이야. 
//			Platform.runLater(() -> {
//				textarea.appendText("서버가 시작되었어요!" + "\n"); // textarea 에 문자열을 추가한다.
//			});
			
			// 위 내용을 그냥 메소드로 구현해버리고 사용하자.
			printMsg("서버가 시작되었어요!");
			
			// 서버 소켓 만들고, 클라이언트 접속 대기하기
			try {
				// 클라이언트 접속 대기
				server = new ServerSocket(5000);
				printMsg("클라이언트 접속 대기 중!");
//				server.accept(); // 실제로 써보면 여기서 버튼이 안 올라오게 됨
						// block이 걸리면서, setOnAction() 이 끝나지를 않게 되고, 버튼이 다시 활성화되지도 않은 채로 묶여 있게 된다.
						// 이를 막기 위해서 추가적인 쓰레드를 생성하자.
				//ㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁ
				// 모습은 이래도, 이게 결국 새 쓰레드에서 run() 실행하는 코드(ㅍㅍㅍㅍㅍㅍㅍㅍㅍㅍㅍㅍㅍㅍㅍㅍㅍㅍㅍㅍㅍㅍㅍ)
				(new Thread(() -> {
					try {
						s = server.accept();
						printMsg("클라이언트 접속 성공!");
						// stream 열자
						pr = new PrintWriter(s.getOutputStream()); // 소켓을 통해서 output stream을 연다.
						br = new BufferedReader(new InputStreamReader(s.getInputStream()));
						
						while (true) {
							String msg = br.readLine(); // 클라이언트가 보낸 메시지 수신
							printMsg("클라이언트의 메시지 : " + msg);
							
							if (msg.equals("/exit")) {
								break; // 가장 근접한 반복문을 벗어남
							}
							// echo 메시지 송신
							pr.println(msg);
							pr.flush();	
						}
						
						printMsg("클라이언트 종료! & 서버 Process 종료!");
						
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				})).start();
				
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		});
		
		stopBtn = new Button("서버중지!");
		stopBtn.setPrefSize(150, 40);
		stopBtn.setOnAction(null);
		
		FlowPane flowPane = new FlowPane();
		flowPane.setPadding(new Insets(10, 10, 10, 10));
		flowPane.setColumnHalignment(HPos.CENTER); // 가로 방향에 대한 정렬
		flowPane.setHgap(10); // components들 사이의 가로 간격 설정
		
		flowPane.getChildren().add(startBtn);
		flowPane.getChildren().add(stopBtn);
		
		root.setBottom(flowPane);
		
		Scene scene = new Scene(root);
		
		primaryStage.setScene(scene);
		
		primaryStage.setTitle("Echo Server Program");
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(); // static 메소드. 실제 코드 실행시키기. GUI 쓰레드를 실행시킨다.
				// 내부적으로 쓰레드를 하나 만들어서 외부와 별개로 실행되는 쓰레드
	}
}
