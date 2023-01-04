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
		
		
		
		
		
		// Initialize -----
		
		// Layout
		rootPane = new VBox();
		
		// Components
		myBorrowStatButton = new Button();
		myBorrowLogButton = new Button();
		myInterBookButton = new Button();
		modifyMyInfoButton = new Button();
		withdrawButton = new Button();

		
		
		
		
		// View -----
		
		myBorrowStatButton.setText("내 대여 현황 & 반납");
		myBorrowStatButton.setPrefSize(160, 30);
		myBorrowStatButton.setOnAction(e -> {
			
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
			
		});
		
		withdrawButton.setText("회원탈퇴");
		withdrawButton.setPrefSize(160, 30);
		withdrawButton.setOnAction(e -> {
			
		});
		
		
//		loginButton.setText("Login");
//		loginButton.setPrefSize(200, 30);
//		loginButton.setOnAction(e -> {
//			// ID, PW 확인하기
//			String id = idTextField.getText();
//			String pw = pwPwField.getText();
//			System.out.println("@@ 로그인 시도. id = " + id + ", pw = " + pw);
//			
//			LoginController controller = new LoginController();
//			if (controller.tryLogin(id, pw) == true) {
//				// 로그인 성공 시
//				System.out.println("@@ 로그인 성공");
////				user = new UserVO(id, "관리자", pw);
////				Window.setScene(homeScene);
//				
//				// 검색 화면으로 이동
//				share.getMainPane().setCenter(share.getBookSearchView().getRootPane(share));
//				
//			} else {
//				// 로그인 실패 시
//				System.out.println("@@ 로그인 실패");
//			}
//			
//		});


		
		
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
		rootPane.getChildren().add(myBorrowStatButton);
		rootPane.getChildren().add(myBorrowLogButton);
		rootPane.getChildren().add(myInterBookButton);
		rootPane.getChildren().add(modifyMyInfoButton);
		rootPane.getChildren().add(withdrawButton);
		
		return rootPane;
	}
}
