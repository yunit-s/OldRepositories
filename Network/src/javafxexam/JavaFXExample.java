package javafxexam;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class JavaFXExample extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		// 화면 구성하는 작업을 여기서 해요!
		// 창의 크기, 위치를 설정해야 한다.
		Button btn = new Button(); // Button : event source
		btn.setText("안녕!!");
		// button에 이벤트 처리를 해야 한다.
		// Java는 delegation model을 이용한다. (Web의 JavaScript도 이 방식을 이용함)
		
		// button에 Action이라는 Event를 처리할 수 있는 Listener 객체를 붙이자.
		// Action이라는 이벤트를 이용해서 ㅁㅁㅁ를 set 한다는 의미.
		btn.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				// event가 발생하면 자동으로 호출된다.
				System.out.println("안녕하세요!!");
			}
			
		});
		
		// Layout을 설정하자.(컴포넌트가 붙는 방식을 결정하는 객체)
		// StackPane 레이아웃 : Layout 중 추가되는 순서대로 덧붙여서 시각화해주는 Layout
		StackPane root = new StackPane();
		
		root.getChildren().add(btn);
		
		// Scene 객체를 생성하자
		Scene scene = new Scene(root, 300, 150); // root 레이아웃, 가로 300, 세로 150
		// 이 장면을 윈도우 객체에 보내야지. 이때 primaryStage 가 바로 창이야. 이 인자는 우리한테 기본적으로 제공돼.
		primaryStage.setTitle("연습입니다."); // 윈도우 제목
		primaryStage.setScene(scene); // 윈도우 안에 넣을 scene
		primaryStage.show(); // 화면에 띄우기. 이거 안 쓰면 안 보여
		
	}
	
	public static void main(String[] args) {
		// launch()는 static 메소드고, Application 안에 있겠지
		// launch()를 통해 내부에 GUI 쓰레드를 만들고, 그 쓰레드를 통해 화면에 출력할 수 있게 된다.
		launch();
	}
}
