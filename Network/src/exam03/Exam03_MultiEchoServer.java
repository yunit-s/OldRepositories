package exam03;

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

//// 서버가 accept()를 무한 반복하게 만들어줄 쓰레드
//// 특별한 이유가 있지 않는 한, Thread 클래스를 상속하는 방법은 안 써. Runnable 인터페이스 구현할 거야.
//class MyServerRunnable implements Runnable {
//
//	@Override
//	public void run() {
//		// TODO Auto-generated method stub
//		
//	}
//	
//}

// 새 클라이언트와 연결된 소켓을 가지고서 독자적으로 통신하는 쓰레드
class MyRunnable implements Runnable {

	Socket socket; // 클라이언트와의 통신을 담당하는 소켓
	PrintWriter pr;
	BufferedReader br;
	
	public MyRunnable() {
	}
	public MyRunnable(Socket socket) {
		this.socket = socket;
		try {
			this.pr = new PrintWriter(socket.getOutputStream());
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
				String msg = br.readLine(); // 데이터 들어오는 걸 기다린다.
				
				// echo해주는 코드
				pr.println(msg);
				pr.flush();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}

public class Exam03_MultiEchoServer extends Application {
	
	TextArea textArea;
	Button startBtn;
	Button stopBtn; // 서버 중지
	
	ServerSocket server;
	
	private void printMsg(String msg) {
		Platform.runLater(() -> {
			textArea.appendText(msg + "\n");
		});
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		// 화면 구성하기. 매개변수 arg0 이 바로 창 을 의미해. 근데 arg0는 뭔가 성의가 없잖아. 그러니까 이름을 바꾸자. primaryStage.
		// primaryStage 가 실제 window가 되는 거지.
		
		// 화면을 구성할 Layout 만들기
		// 우리는 BorderPane (5분할 레이아웃) 사용할 예정
		BorderPane root = new BorderPane();
		root.setPrefSize(700, 500);
		
		// 실제 화면 구성하기
		textArea = new TextArea();
		root.setCenter(textArea);
		
		startBtn = new Button("서버기동!!");
		startBtn.setPrefSize(150, 40);
		
//		// 버튼의 이벤트 처리코드
//		// 인터페이스 어쩌구 저쩌구... ㅍㅍㅍㅍㅍㅍㅍㅍㅍㅍㅍㅍㅍㅍㅍㅍㅍㅍㅍㅍㅍㅍㅍㅍㅍㅍㅍㅍㅍㅍㅍㅍㅍㅍㅍㅍㅍㅍㅍㅍㅍㅍㅍ
//		startBtn.setOnAction(new EventHandler<ActionEvent>() {
//			
//			@Override
//			public void handle(ActionEvent arg0) {
//				// TODO Auto-generated method stub
//				
//			}
//		});
		
		// Java Lambda 식 (Arrow Function) 활용해서 코드 간소화시키기
		// lambda는 Java8 이후에 나왔어. 이걸 활용할 수만 있다면, 무조건 이 방식을 채용해서 작성한다.
		// lambda는 호출 시 실행할 메소드가 딱 하나만 있는 경우에만 쓸 수 있다.
		startBtn.setOnAction(e -> {
			// 버튼을 누르면 실행되는 내용
			// accept() 에서 blocking되는 것을 피하기 위해, accept() 를 새 쓰레드가 처리하도록 하자.
			
			// 새 쓰레드 클래스를 직접 만들어서 가져오는 방법으로 구현해보자
			
//			// 가장 원칙적인 방법
//			MyServerRunnable r = new MyServerRunnable();
//			Thread t = new Thread(r);
//			t.start();
			
//			// 위에 3줄이 너무 길어! 줄여보자.
//			Thread t = new Thread(new MyServerRunnable());
//			t.start();
			
//			// Runnable 객체를 만들어보고 싶은데...
//			new Runnable(); // Runnable은 인터페이스라서 이렇게는 못 써
//			new Runnable() {
//				// run() 추상 메소드를 바로 오버라이딩해주면, 새 클래스를 꼭 정의해줄 필요 없이 Runnable객체를 만들 수 있어.
//				@Override
//				public void run() {
//					// TODO Auto-generated method stub
//					
//				}
//			};
			
//			// 위 두 가지를 종합해보면, 아래처럼 써지겠지
//			Thread t = new Thread(new Runnable() {
//				
//				@Override
//				public void run() {
//					// TODO Auto-generated method stub
//					
//				}
//			});
//			t.start(); // 쓰레드 t의 run() 을 수행하기 시작해.
			
//			// 위 코드를 lambda를 활용해서 더욱 줄여보면 아래와 같지
//			Thread t = new Thread(() -> {});
//			t.start();
			
			// 그런데 우리가 t라는 레퍼런스 변수를 활용해서, yield() 같은 제어를 계속 할 거야? 아니야 안 해. 딱 start() 한 번만 하면 돼.
			// 그렇기 때문에 레퍼런스 변수 t를 굳이 쓰지 않아도 돼. 익명 class의 Thread를 생성하자.
			// 결국 코드를 또 간소화시키면, 최종적으로 아래 코드가 된다.
//			(new Thread(() -> {})).start();
			(new Thread(() -> {
				// 서버 소켓 생성(근데 이거는 꼭 여기서 할 필요는 없긴 해)
				try {
					server = new ServerSocket(7777); // port가 다른 프로그램에서 사용되고 있는 중일 수 있기 때문에, 예외상황이 발생할 수 있다.
							// 그래서 예외처리가 강제된다.
					
					// 무한 반복 - 새 클라이언트를 받는 것부터 새 쓰레드를 만들어서 소켓을 넘겨주기까지
					while (true) {
						Socket socket = server.accept(); // 클라이언트의 접속 대기
								// 대기 중이었다가 새 클라이언트가 접속하면, 해당 클라이언트의 소켓과 연결된 Socket 객체 하나를 생성한다.
								// 이 소켓을 새 쓰레드가 가지고 있어야해. 새 Thread가 socket을 이용해서 직접 클라이언트와 통신하는 것.
						
						printMsg("새로운 클라이언트 접속!");

						// Thread를 만들기 위한 클래스가 하나 필요애. 이번에는 클래스를 직접 구현해서 쓰는게 좋아.
						MyRunnable r = new MyRunnable(socket); // Runnable 객체 안에 socket을 넘겨준다.
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
		
		// BorderPane 의 아랫부분(Bottom)에 버튼을 부착시키고 싶다.
		// 공간은 하나인데 버튼은 2개..? 붙일 수가 없는데?
		// 이를 해결하기 위해서 새로운 판자(FlowPane)을 하나 만들어서 버튼 2개를 차례대로 붙이고, 이 FlowPane을 BorderPane의 아랫부분(bottom)에 붙인다.
		FlowPane flowPane = new FlowPane();
		// 이 판자에 버튼을 2개 붙일 건데, 정렬하는 방식을 설정해줘야 보기가 좋겠지?
		flowPane.setPadding(new Insets(10, 10, 10, 10)); // padding(여백) 설정
		flowPane.setColumnHalignment(HPos.CENTER); // 정렬과 관련된 것
		flowPane.setPrefSize(700, 40);
		flowPane.setHgap(10);
		// 판자 설정이 끝났으니 이제 판자에 버튼을 붙이자.
		flowPane.getChildren().add(startBtn);
		flowPane.getChildren().add(stopBtn);
		
		// 완성된 판자 flowPane을 BorderPane의 아랫부분(bottom)에 붙인다.
		root.setBottom(flowPane);
		
		// 장면 만들기
		Scene scene = new Scene(root); // 레이아웃(root)을 이용해서 화면에 보여줄 장면을 만들자. 그게 Scene이야.
		
		// 윈도우(stage) 띄우기
		primaryStage.setScene(scene); // 이렇게 만들어진 장면(scene)을 윈도우(stage)에 넣는다.
		primaryStage.setTitle("Echo Server Program");
		primaryStage.show(); // 창에 대한 내용을 완성한 뒤, show()로 윈도우를 띄운다.
	}

	public static void main(String[] args) {
		// main thread에 의해서 최초로 실행되는 method
		// 여기가 entry point
		// GUI Thread를 하나 생성하자.
		// 원래는 새 쓰레드를 만드니까 new Thread 어쩌구~~ 해야하지만, 이거를 하는 static method가 하나 있지. 그게 launch()야.
		launch();
		// main thread는 이 launch()만 실행하면 끝나. 종료돼. 그리고 창을 만드는 GUI 쓰레드가 동작하는 거야.
	}
}
