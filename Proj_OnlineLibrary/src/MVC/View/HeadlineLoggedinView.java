package MVC.View;

import MVC.VO.ShareVO;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;

public class HeadlineLoggedinView {

	public BorderPane getRootPane(ShareVO share) {

		// Declare variables -----
		
		// Layout
		BorderPane rootPane;
		FlowPane leftPane;
		FlowPane rightPane;
		
		// Components
		Button goToHomeButton;
		
		Label nicknameLabel;
		Button logoutButton;
		Button mypageButton;
		
		
		
		
		
		// Initialize -----
		
		// Layout
		rootPane = new BorderPane();
		leftPane = new FlowPane();
		rightPane = new FlowPane();
		
		// Components
		goToHomeButton = new Button();

		nicknameLabel = new Label();
		logoutButton = new Button();
		mypageButton = new Button();
		
		
		
		
		
		// View -----
		
		// Components
		goToHomeButton.setText("Home");
		goToHomeButton.setPrefSize(70, 30);
		goToHomeButton.setOnAction(e -> {
			// 실험 중
			share.getMainPane().setCenter(share.getBookSearchView().getRootPane(share));
		});
		
		nicknameLabel.setText(share.getUser().getNickname() + " 님");
		nicknameLabel.setPrefSize(80, 30);
		nicknameLabel.setAlignment(Pos.BASELINE_RIGHT);
		nicknameLabel.setPadding(new Insets(5));
		
		logoutButton.setText("Logout");
		logoutButton.setPrefSize(80, 30);
		logoutButton.setOnAction(e -> {
			System.out.println("@@ 로그아웃");

			share.setUser(null);
			share.getMainPane().setTop(share.getHeadlineView().getRootPane(share));
			share.getMainPane().setCenter(share.getBookSearchView().getRootPane(share));
//			share.getMainPane().setCenter(share.getLoginView().getRootPane(share));
		});

		mypageButton.setText("My page");
		mypageButton.setPrefSize(80, 30);
		mypageButton.setOnAction(e -> {
			share.getMainPane().setCenter(share.getMypageView().getRootPane(share));
		});
		
		
		
		// Layout
		leftPane.getChildren().add(goToHomeButton);
		leftPane.setPadding(new Insets(5));
		leftPane.setAlignment(Pos.CENTER_LEFT);
		
//		rightPane.setColumnHalignment(HPos.RIGHT); // 이건 안 되네
		rightPane.setPadding(new Insets(5));
		rightPane.setHgap(10);
		rightPane.setAlignment(Pos.CENTER_RIGHT);
		rightPane.getChildren().add(nicknameLabel);
		rightPane.getChildren().add(logoutButton);
		rightPane.getChildren().add(mypageButton);
		
		rootPane.setLeft(leftPane);
		rootPane.setRight(rightPane);
		
		return rootPane;
	}
	
}
