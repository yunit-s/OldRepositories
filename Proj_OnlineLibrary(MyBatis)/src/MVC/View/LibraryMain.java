package MVC.View;


import MVC.VO.ShareVO;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class LibraryMain extends Application{

	@Override
	public void start(Stage primaryStage) throws Exception {
		
		// Declare variables -----
		
		ShareVO share;
		Scene homeScene;
		
		
		
		
		
		// Initialize -----
		
		share = new ShareVO();
		homeScene = new Scene(share.getMainPane());
		
		
		
		
		
		// View -----
		
		share.getMainPane().setPrefSize(700, 600);
		share.getMainPane().setTop(share.getHeadlineView().getRootPane(share));
//		share.getMainPane().setCenter(share.getLoginView().getRootPane(share));
		share.getMainPane().setCenter(share.getBookSearchView().getRootPane(share));
		
		
		
		primaryStage.setScene(homeScene);
		primaryStage.setTitle("Online Library");
		primaryStage.setOnCloseRequest(e -> {
			System.out.println("@@ primary stage 종료");
		});
		primaryStage.show();
		
	}

	public static void main(String[] args) {
		launch();
	}
	
}
