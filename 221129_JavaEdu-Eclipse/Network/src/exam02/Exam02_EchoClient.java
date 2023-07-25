package exam02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class Exam02_EchoClient extends Application{

	TextArea textarea; // 여러 줄짜리 입력상자
	Button connBtn;
	TextField textField; // 한 줄 짜리 입력상자
	TextField idField;
	
	Socket s;
	PrintWriter pr;
	BufferedReader br;
	
	private void printMsg(String msg) {
		Platform.runLater(() -> {
			textarea.appendText(msg + "\n"); // textarea 에 문자열을 추가한다.
		});
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		// Layout
		BorderPane root = new BorderPane();
		root.setPrefSize(700, 500); // 여기서는 pane의 크기가 곧 layout의 크기가 되겠지
		
		textarea = new TextArea();
		root.setCenter(textarea);

		// 서버 접속하기
		connBtn = new Button("서버접속!");
		connBtn.setPrefSize(150, 40);
		connBtn.setOnAction(e -> {
			// 소켓을 만든다는 것 자체가 IP와 Port를 찾아가겠다는 뜻이다.
			try {
				s = new Socket("127.0.0.1", 5000);
				printMsg("서버에 연결이 성공했습니다.");
				textField.setDisable(false);

				// stream 열자
				pr = new PrintWriter(s.getOutputStream()); // 소켓을 통해서 output stream을 연다.
				br = new BufferedReader(new InputStreamReader(s.getInputStream()));
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});
		
		idField = new TextField();
		idField.setPrefSize(200, 40);
		
		textField = new TextField();
		textField.setPrefSize(200, 40);
		textField.setDisable(true); // true일 때 비활성화(사용불가)
		textField.setOnAction(e -> {
			String msg = textField.getText();
			String id = idField.getText();
			
			pr.println(id + "> " + msg); // 통로를 통해서 메세지를 보낸다. 근데 얘는 단순 짐마차일 뿐이야.
			pr.flush(); // 짐마차에 실은 짐을 실제로 보낸다.
			
			if (!msg.equals("/exit")) {
				// echo 메시지 수신
				try {
					printMsg(br.readLine());
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			} else {
				printMsg("클라이언트가 서버와 연결이 종료되었습니다!");
			}
			
			textField.clear();
		});
		
		FlowPane flowPane = new FlowPane();
		flowPane.setPadding(new Insets(10, 10, 10, 10));
		flowPane.setColumnHalignment(HPos.CENTER); // 가로 방향에 대한 정렬
		flowPane.setHgap(10); // components들 사이의 가로 간격 설정
		
		flowPane.getChildren().add(connBtn);
		flowPane.getChildren().add(idField);
		flowPane.getChildren().add(textField);
		
		root.setBottom(flowPane);
		
		Scene scene = new Scene(root);
		
		primaryStage.setScene(scene);
		
		primaryStage.setTitle("Echo Client Program");
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch();
	}
	
}
