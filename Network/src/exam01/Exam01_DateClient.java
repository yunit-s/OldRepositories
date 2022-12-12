package exam01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class Exam01_DateClient extends Application {

	// field
	TextArea textarea;
	Button connBtn;
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		// 화면구성을 해보자.
		// 레이아웃 구성하기
		BorderPane root = new BorderPane();
		root.setPrefSize(700, 500);
		
		// component 생성
		textarea = new TextArea();
		root.setCenter(textarea); // center에 textarea 붙이기
		
		// 버튼 만들기
		connBtn = new Button("Date 서버 접속"); // 버튼 내용을 바로 지정해줄 수 있다.
		connBtn.setPrefSize(150, 40);
		connBtn.setOnAction(new EventHandler<ActionEvent>() {
			 // action이 일어났을 때, 안에 있는 listener에 오버라이드가 일어난다.
			
			@Override
			public void handle(ActionEvent arg0) {
				// 접속 버튼을 클릭하면 하는 일을 여기에 작성
				// 서버와 접속하는 코드를 만들어주면 된다.
//				System.out.println("서버에 접속해요!");
				
				textarea.clear(); // textarea 안의 내용을 전부 지우기
				
				// 서버에 접속하기. 즉, 클라이언트에서 Socket객체 생성을 시도한다.
				// 서버에 접속하려면? 서버의 IP와 Port를 알아야한다.
				// 일단 우리는 서버와 클라이언트 모두 내 컴퓨터에 있다. 이럴 때는 일단 내 컴퓨터를 향해서 나가고, 내 컴퓨터로 돌아와. 이거를 루프백이라고 불러.
				// 루프백은 나 자신을 지칭하는 IP로, 127.0.0.1 로 고정되어 있어. domain name으로는 local host 라고 쓸 수 있다.
				try {
					Socket s = new Socket("127.0.0.1", 3000);
//					Socket s = new Socket("localhost", 3000);
					System.out.println("서버에 접속 성공!");
					
					// 스트림 만들기
//					s.getInputStream(); // input 스트림 생성. 근데 이거보다 좀 더 좋은 걸 쓰고 싶어.
					BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream())); // 조금 더 좋은, 그리고 그보다 조금 더 좋은 통로인 BufferedReader를 사용하자.
					
					// 데이터 받기
					String msg = br.readLine(); // 통로로 들어오는 데이터를 읽자. (통로를 통해서 데이터가 들어올 때까지 blocking되어 있음)
					System.out.println(msg);
					
					br.close(); // 스트림 닫기
					s.close(); // 소켓 닫기
					
					System.out.println("서버와 연결 종료!");
					
				} catch (UnknownHostException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		});
		
		// 판때기 만들자. FlowPane으로.
		FlowPane flowpane = new FlowPane(); // south 영역에 붙는 layout
		// 보기좋게 여백(padding) 설정하기
		flowpane.setPadding(new Insets(10, 10, 10, 10)); // 여백공간 설정. 상하좌우 10pixels씩 띄어준다.
		flowpane.setColumnHalignment(HPos.CENTER); // 정렬하기. HPos : 가로 가운데정렬
		flowpane.setPrefSize(700, 40);
		flowpane.setHgap(20);
		
		// flowpane에 버튼 붙이기
		flowpane.getChildren().add(connBtn);
		
		// 이렇게 만든 flowpane(판때기)를 borderlayout의 아래쪽에 붙여야한다.
		root.setBottom(flowpane);
		
		Scene scene = new Scene(root); // 장면 만들기
		primaryStage.setScene(scene); // 윈도우에 장면 갖다 붙이기
		primaryStage.show(); // 윈도우에 띄우기
	}

	public static void main(String[] args) {
		launch();
	}
}
