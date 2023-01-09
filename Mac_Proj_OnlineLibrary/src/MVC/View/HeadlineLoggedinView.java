package MVC.View;

import MVC.VO.ShareVO;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class HeadlineLoggedinView {

	public BorderPane getRootPane(ShareVO share) {

		// Declare variables -----
		
		// Layout
		BorderPane rootPane;
		FlowPane leftPane;
		FlowPane centerPane;
		FlowPane rightPane;
		
		// Components
		Button goToHomeButton;
		Label libraryBanner;
		Label nicknameLabel;
		Button logoutButton;
		Button mypageButton;
		
		
		
		
		
		// Initialize -----
		
		// Layout
		rootPane = new BorderPane();
		leftPane = new FlowPane();
		centerPane = new FlowPane();
		rightPane = new FlowPane();
		
		// Components
		goToHomeButton = new Button();
		libraryBanner = new Label();
		nicknameLabel = new Label();
		logoutButton = new Button();
		mypageButton = new Button();
		
		
		
		
		
		// View -----
		
		// Components
		goToHomeButton.setText("『 Home 』");
		goToHomeButton.setPrefSize(100, 30);
		goToHomeButton.setOnAction(e -> {
			share.getMainPane().setCenter(share.getBookSearchView().getRootPane(share));
		});

		libraryBanner.setText("Online Library");
		libraryBanner.setFont(Font.font("Viner Hand ITC", FontWeight.BOLD, 25));
		
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
		
		centerPane.getChildren().add(libraryBanner);
		centerPane.setPadding(new Insets(5));
		centerPane.setAlignment(Pos.CENTER);
		
//		rightPane.setColumnHalignment(HPos.RIGHT); // 이건 안 되네
		rightPane.setPadding(new Insets(5));
		rightPane.setHgap(10);
		rightPane.setAlignment(Pos.CENTER_RIGHT);
		rightPane.getChildren().add(nicknameLabel);
		rightPane.getChildren().add(logoutButton);
		rightPane.getChildren().add(mypageButton);
		
		rootPane.setLeft(leftPane);
		rootPane.setCenter(centerPane);
		rootPane.setRight(rightPane);
		
		return rootPane;
	}
	
}
