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

	// Layout
	private BorderPane rootPane;
	private FlowPane leftPane;
	private FlowPane rightPane;
	
	// View Components
	private Button goToHomeButton;
	
	private Button loginButton;
//	private Label userNickname;
//	private Button logoutButton;
//	private Button myPageButton;
	
	// Logic Fields
	ShareVO share;
	
	public HeadlineView(ShareVO share) {
		
		// Layout
		rootPane = new BorderPane();
		leftPane = new FlowPane();
		rightPane = new FlowPane();
		
		// Components
		goToHomeButton = new Button();
		
		loginButton = new Button();
//		userNickname = new Label();
//		logoutButton = new Button();
//		myPageButton = new Button();
		
		// Share Object
		this.share = share;
	}
	
	public BorderPane getRootPane() {
		goToHomeButton.setText("Home");
		goToHomeButton.setPrefSize(50, 30);
		goToHomeButton.setOnAction(e -> {
//			share.getMainPane().setCenter(share.getBookSearchView().getRootPane());
			share.getMainPane().setCenter(share.getBookSearchView().getRootPane());
		});
		
		loginButton.setText("로그인");
		loginButton.setPrefSize(80, 30);
		loginButton.setOnAction(e -> {
			share.getMainPane().setCenter(share.getLoginView().getRootPane());
		});
		
//		userNickname.setText("누구누구" + " 님");
//		userNickname.setPrefSize(80, 40);
//		
//		logoutButton.setText("로그아웃");
//		logoutButton.setPrefSize(80, 40);
//		
//		myPageButton.setText("마이페이지");
//		myPageButton.setPrefSize(80, 40);
		
		
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
