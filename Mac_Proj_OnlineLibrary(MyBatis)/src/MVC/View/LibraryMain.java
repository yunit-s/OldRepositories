package MVC.View;


import java.sql.SQLException;

import org.apache.commons.dbcp2.BasicDataSource;

import MVC.DAO.DBCP_Apache;
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
			// close connection pool
			System.out.println("@@ primary stage 종료");
			try {
				((BasicDataSource)DBCP_Apache.getDataSource()).close();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			System.out.println("@@ connection pool 할당해제");
		});
		primaryStage.show();
		
	}

	public static void main(String[] args) {
		launch();
	}
	
}
