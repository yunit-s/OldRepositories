package MVC.View;

import MVC.VO.ShareVO;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;

public class HeadlineView {

	public BorderPane getRootPane(ShareVO share) {

		// Declare variables -----
		
		// Layout
		BorderPane rootPane;
		FlowPane leftPane;
		FlowPane rightPane;
		
		// Components
		Button goToHomeButton;
		
		Button loginButton;
		
		
		
		
		
		// Initialize -----
		
		// Layout
		rootPane = new BorderPane();
		leftPane = new FlowPane();
		rightPane = new FlowPane();
		
		// Components
		goToHomeButton = new Button();
		
		loginButton = new Button();
		
		
		
		
		
		// View -----

		// Components
		goToHomeButton.setText("『Online Library』");
		goToHomeButton.setPrefSize(130, 30);
		goToHomeButton.setOnAction(e -> {
			share.getMainPane().setCenter(share.getBookSearchView().getRootPane(share));
			// 실험 중
//			share.getMainPane().setCenter(share.getMypageView().getRootPane(share));
//			share.getMainPane().setCenter(share.getMypageMenuView().getRootPane(share));
//			share.getMainPane().setCenter(share.getMypageBorrowStatView().getRootPane(share));
		});
		
		loginButton.setText("로그인");
		loginButton.setPrefSize(80, 30);
		loginButton.setOnAction(e -> {
			share.getMainPane().setCenter(share.getLoginView().getRootPane(share));
		});

		
		
		// Layout
		leftPane.getChildren().add(goToHomeButton);
		leftPane.setPadding(new Insets(5));
		leftPane.setAlignment(Pos.CENTER_LEFT);
		
//		rightPane.setColumnHalignment(HPos.RIGHT); // 이건 안 되네
		rightPane.setPadding(new Insets(5));
		rightPane.setAlignment(Pos.CENTER_RIGHT);
		rightPane.getChildren().add(loginButton);
		
		rootPane.setLeft(leftPane);
		rootPane.setRight(rightPane);
		
		return rootPane;
	}
	
}
