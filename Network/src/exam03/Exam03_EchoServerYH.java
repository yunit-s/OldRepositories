package exam03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

class EchoRunnable extends Exam03_EchoServerYH implements Runnable {

	// constructors
	public EchoRunnable() {
	}
	public EchoRunnable(Socket s) {
		this.s = s;
	}
	
	// fields
	Socket s;
	PrintWriter pr;
	BufferedReader br;
	
	@Override
	public void run() {
		try {
			pr = new PrintWriter(s.getOutputStream());
			br = new BufferedReader(new InputStreamReader(s.getInputStream()));

			while (true) {
				String msg = br.readLine();
				printMsg("클라이언트의 메시지 : " + msg);
				
				if (msg.equals("/exit")) {
					break;
				}
				pr.println(msg);
				pr.flush();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		printMsg("클라이언트 연결 해제");
	}
	
}

public class Exam03_EchoServerYH extends Application{

	TextArea textarea;
	Button startBtn;
	Button stopBtn;
	ServerSocket server;
	Socket s;
	
	PrintWriter pr;
	BufferedReader br;
	
	protected void printMsg(String msg) {
		Platform.runLater(() -> {
			textarea.appendText(msg + "\n");
		});
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		BorderPane root = new BorderPane();
		root.setPrefSize(700, 500);
		
		textarea = new TextArea();
		root.setCenter(textarea);

		startBtn = new Button("서버시작!");
		startBtn.setPrefSize(150, 40);
		startBtn.setOnAction(e -> {
			printMsg("서버가 시작되었어요!");
			try {
				server = new ServerSocket(5000);
				printMsg("클라이언트 접속 대기 중!");
				
				(new Thread(() -> {
					try {
						while (true) {
							s = server.accept();
							printMsg("새로운 클라이언트 접속 성공!");
							// 새 쓰레드 생성
							(new Thread(new EchoRunnable(s))).start();
						}
						
						
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}

					printMsg("클라이언트 종료! & 서버 Process 종료!");
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
		flowPane.setColumnHalignment(HPos.CENTER);
		flowPane.setHgap(10);
		flowPane.getChildren().add(startBtn);
		flowPane.getChildren().add(stopBtn);
		
		root.setBottom(flowPane);
		
		Scene scene = new Scene(root);
		
		primaryStage.setScene(scene);
		primaryStage.setTitle("Echo Server Program");
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch();
	}
}
