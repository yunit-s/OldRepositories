package example.view;

import example.controller.Button1Controller;
import example.controller.Button2Controller;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class MainView extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		// Stage(창) 준비됨.
		// 화면 구성할 차례
		
		// Layout으로 BorderPane 활용
		BorderPane root = new BorderPane();
		root.setPrefSize(700, 500);
		
		Button btn1 = new Button("위쪽 버튼이에요!");
		// 원래 setOnAction 이벤트처리 코드는 View가 아니라 Controller에서 나와야 한다.
		// 하지만 지금같은 경우는 방법이 없다. 어쩔 수 없이 View에서 이벤트 처리 코드가 나온다.
		btn1.setOnAction(e -> {
			// 컨트롤러를 만들어서, 실제 일을 시킨다.
			Button1Controller controller = new Button1Controller();
			String str = controller.getResult();
			
			// 결과로 받은 str을 이용해서 화면을 제어한다.
			
		});
		
		Button btn2 = new Button("아래쪽 버튼이에요!");
		btn2.setOnAction(e -> {
			Button2Controller controller = new Button2Controller();
			String str = controller.getResult();
			
		});
		
		root.setTop(btn1);
		root.setBottom(btn2);
		
		Scene scene = new Scene(root);
		
		primaryStage.setScene(scene);
		
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch();
	}
}
