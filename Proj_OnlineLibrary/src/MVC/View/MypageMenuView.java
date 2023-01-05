package MVC.View;

import MVC.Controller.LoginController;
import MVC.VO.ShareVO;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class MypageMenuView {

	public VBox getRootPane(ShareVO share) {

		// Declare variables -----
		
		// Layout
		VBox rootPane;
		
		// Components
		Button myBorrowStatButton;
		Button myBorrowLogButton;
		Button myInterBookButton;
		Button modifyMyInfoButton;
		Button withdrawButton;
		
		Button modifyBookDBButton;
		Button customerListButton;
		Button modifyWebsiteButton;
		
		
		
		
		
		// Initialize -----
		
		// Layout
		rootPane = new VBox();
		
		// Components
		myBorrowStatButton = new Button();
		myBorrowLogButton = new Button();
		myInterBookButton = new Button();
		modifyMyInfoButton = new Button();
		withdrawButton = new Button();
		
		modifyBookDBButton = new Button();
		customerListButton = new Button();
		modifyWebsiteButton = new Button();

		
		
		
		
		// View -----

		// Components
		myBorrowStatButton.setText("내 대여 현황 & 반납");
		myBorrowStatButton.setPrefSize(160, 30);
		myBorrowStatButton.setOnAction(e -> {
			System.out.println("@@ 내 대여 현황 & 반납");
			BorderPane pane = share.getMypageView().getRootPane(share);
			pane.setCenter(share.getMypageBorrowStatView().getRootPane(share));
			share.getMainPane().setCenter(pane);
			
		});
		
		myBorrowLogButton.setText("내 대여 기록");
		myBorrowLogButton.setPrefSize(160, 30);
		myBorrowLogButton.setOnAction(e -> {
			
		});
		
		myInterBookButton.setText("내 관심 도서");
		myInterBookButton.setPrefSize(160, 30);
		myInterBookButton.setOnAction(e -> {
			
		});
		
		modifyMyInfoButton.setText("개인 정보 수정");
		modifyMyInfoButton.setPrefSize(160, 30);
		modifyMyInfoButton.setOnAction(e -> {
			System.out.println("@@ 개인 정보 수정");
			BorderPane pane = share.getMypageView().getRootPane(share);
			pane.setCenter(share.getMypageModifyMyInfoView().getRootPane(share));
			share.getMainPane().setCenter(pane);
//			share.getMypageView().getRootPane(share).setCenter(share.getModifyMyInfoView().getRootPane(share)); // 이건 동작 안 됨
		});
		
		withdrawButton.setText("회원탈퇴");
		withdrawButton.setPrefSize(160, 30);
		withdrawButton.setOnAction(e -> {
			
		});
		
		modifyBookDBButton.setText("도서 데이터베이스 수정");
		modifyBookDBButton.setPrefSize(160, 30);
//		if (!share.getUser().getId().equals("admin")) {
//			modifyBookDBButton.setVisible(false);
//		}
		modifyBookDBButton.setOnAction(e -> {
			
		});
		
		customerListButton.setText("회원 목록");
		customerListButton.setPrefSize(160, 30);
		customerListButton.setOnAction(e -> {
			
		});
		
		modifyWebsiteButton.setText("사이트 편집");
		modifyWebsiteButton.setPrefSize(160, 30);
		modifyWebsiteButton.setOnAction(e -> {
			
		});
		


		
		
		// Layout
		
//		idPane.setSpacing(10);
//		idPane.setAlignment(Pos.BASELINE_CENTER);
//		idPane.getChildren().add(idLabel);
//		idPane.getChildren().add(idTextField);
//		
//		pwPane.setSpacing(10);
//		pwPane.setAlignment(Pos.CENTER);
//		pwPane.getChildren().add(pwLabel);
//		pwPane.getChildren().add(pwPwField);
//
//		centerPane.setSpacing(10);
//		centerPane.setAlignment(Pos.CENTER);
//		centerPane.getChildren().add(idPane);
//		centerPane.getChildren().add(pwPane);
//		centerPane.getChildren().add(loginButton);
//		centerPane.getChildren().add(signUpButton);
		
//		rootPane.setCenter(centerPane);
		rootPane.setSpacing(10);
		rootPane.setPadding(new Insets(5));
		rootPane.setAlignment(Pos.CENTER);
		rootPane.getChildren().add(myBorrowStatButton);
		rootPane.getChildren().add(myBorrowLogButton);
		rootPane.getChildren().add(myInterBookButton);
		rootPane.getChildren().add(modifyMyInfoButton);
		rootPane.getChildren().add(withdrawButton);
		if (share.getUser().getId().equals("admin")) {
			System.out.println("@@ admin 계정");
			rootPane.getChildren().add(modifyBookDBButton);
			rootPane.getChildren().add(customerListButton);
			rootPane.getChildren().add(modifyWebsiteButton);
		} else {
			System.out.println("@@ 일반회원 계정");
		}
		
		return rootPane;
	}
	
}
