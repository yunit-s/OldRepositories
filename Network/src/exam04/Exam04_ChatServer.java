package exam04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;

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

// 공유 객체
class Shared {
	ArrayList<Socket> list = new ArrayList<Socket>(); //
	HashMap<Socket, PrintWriter> map = new HashMap<Socket, PrintWriter>(); // key값 : 소켓, value : PrintWriter
	
	// method
	public synchronized void addClient(Socket socket) {
		// 서버에 새로운 클라이언트가 접속했을 때, 해당 클라이언트에 대한 소켓이 서버쪽에 만들어지고, 이 소켓을 공유 객체에 저장해야 한다.
		list.add(socket); // 소켓 저장하기
		
		try {
			map.put(socket, new PrintWriter(socket.getOutputStream())); // 소켓과 연결하는 통로 저장하기
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public synchronized void broadcast(String msg) {
		// 전달받은 문자열을 모든 클라이언트 PrinterWriter를 통해 데이터 송신
		for (Socket s: list) {
			(map.get(s)).println(msg);
			(map.get(s)).flush();
		}
	}
}

class MyRunnable implements Runnable {

	Socket socket;
//	PrintWriter pr; // 모든 송신은 공유 객체가 관리함
	BufferedReader br;
	Shared shared;
	
	public MyRunnable() {
	}
	public MyRunnable(Socket socket, Shared shared) {
		this.socket = socket;
		this.shared = shared;
		try {
//			this.pr = new PrintWriter(socket.getOutputStream());
			this.br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		// 쓰레드 시작
		try {
			while (true) {
				String msg = br.readLine();
				
				// 공유 객체를 통해서 모든 클라이언트에게 데이터 송신
				shared.broadcast(msg);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}

public class Exam04_ChatServer extends Application {
	
	TextArea textArea;
	Button startBtn;
	Button stopBtn; // 서버 중지
	
	Shared shared; // 공유 변수를 필드로 설정하자
	ServerSocket server;
	
	private void printMsg(String msg) {
		Platform.runLater(() -> {
			textArea.appendText(msg + "\n");
		});
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		// 화면 구성하기
		
		// 화면을 구성할 Layout 만들기
		BorderPane root = new BorderPane();
		root.setPrefSize(700, 500);
		
		// 실제 화면 구성하기
		textArea = new TextArea();
		root.setCenter(textArea);
		
		startBtn = new Button("서버기동!!");
		startBtn.setPrefSize(150, 40);
		
//		// 버튼의 이벤트 처리코드
		startBtn.setOnAction(e -> {
			// 새로운 공유 객체 생성
			shared = new Shared();
			
			(new Thread(() -> {
				try {
					server = new ServerSocket(7777);
					
					while (true) {
						Socket socket = server.accept(); // 클라이언트의 접속 대기
						
						printMsg("새로운 클라이언트 접속!");

						// 공유객체에 클라이언트 소켓을 저장한다.
						shared.addClient(socket);
						
						MyRunnable r = new MyRunnable(socket, shared); // Runnable 객체에 shared 공유객체도 같이 넘겨준다.
						Thread t = new Thread(r);
						t.start();
					}
					
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			})).start();
			
		});
		
		stopBtn = new Button("서버중지!!");
		stopBtn.setPrefSize(150, 40);
		stopBtn.setOnAction(e -> {
			
		});
		
		FlowPane flowPane = new FlowPane();

		flowPane.setPadding(new Insets(10, 10, 10, 10));
		flowPane.setColumnHalignment(HPos.CENTER);
		flowPane.setPrefSize(700, 40);
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
