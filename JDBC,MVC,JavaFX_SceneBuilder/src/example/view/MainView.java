package example.view;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainView extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		// 기존에는 화면 구성을 일일이 다 java 코드로 작성했다.
		// 이번에는 이미 XML로 화면을 만들어 두었다. 그걸 가져오자.
		
		// Scene Builder 로 만들어진 XML 한번 확인해보자.
		Parent root = null;
		// FXML 을 로드해야 하기 때문에 Loader를 만들어야 한다.
		FXMLLoader loader = new FXMLLoader(getClass().getResource("myView.fxml")); // loader에게 어떤 FXML 파일을 넘겨줄 지 명시
			// getClass() : 내가 지금 사용하고 있는 클래스
			// getResource() : 해당 파일에서 리소스 읽어들이기
		root = loader.load();
		
		Scene scene = new Scene(root);
		primaryStage.setScene(scene);
		
		primaryStage.show();
		
	}

	public static void main(String[] args) {
		launch();
	}
}
