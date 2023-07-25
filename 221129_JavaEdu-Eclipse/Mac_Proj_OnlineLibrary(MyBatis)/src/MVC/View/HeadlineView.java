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

public class HeadlineView {

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
		Button loginButton;
		
		
		
		
		
		// Initialize -----
		
		// Layout
		rootPane = new BorderPane();
		leftPane = new FlowPane();
		centerPane = new FlowPane();
		rightPane = new FlowPane();
		
		// Components
		goToHomeButton = new Button();
		libraryBanner = new Label();
		loginButton = new Button();
		
		
		
		
		
		// View -----

		// Components
		goToHomeButton.setText("『 Home 』");
		goToHomeButton.setPrefSize(100, 30);
		goToHomeButton.setOnAction(e -> {
			share.getMainPane().setCenter(share.getBookSearchView().getRootPane(share));
		});
		
		libraryBanner.setText("Online Library");
		libraryBanner.setFont(Font.font("Viner Hand ITC", FontWeight.BOLD, 25));
		
		loginButton.setText("로그인");
		loginButton.setPrefSize(80, 30);
		loginButton.setOnAction(e -> {
			share.getMainPane().setCenter(share.getLoginView().getRootPane(share));
		});

		
		
		// Layout
		leftPane.getChildren().add(goToHomeButton);
		leftPane.setPadding(new Insets(5));
		leftPane.setAlignment(Pos.CENTER_LEFT);
		
		centerPane.getChildren().add(libraryBanner);
		centerPane.setPadding(new Insets(5));
		centerPane.setAlignment(Pos.CENTER);
		
		rightPane.setPadding(new Insets(5));
		rightPane.setAlignment(Pos.CENTER_RIGHT);
		rightPane.getChildren().add(loginButton);
		
		rootPane.setLeft(leftPane);
		rootPane.setCenter(centerPane);
		rootPane.setRight(rightPane);
		
		return rootPane;
	}
	
}
