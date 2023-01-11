package MVC.View;

import MVC.Controller.LoginController;
import MVC.VO.ShareVO;
import MVC.VO.UserVO;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Popup;

public class LoginView {

	public BorderPane getRootPane(ShareVO share) {

		// Declare variables -----
		
		// Layout
		BorderPane rootPane;
		VBox centerPane;
		HBox idPane;
		HBox pwPane;
		
		// Components
		Label idLabel;
		TextField idTextField;
		Label pwLabel;
		PasswordField pwPwField;
		Button loginButton;
		Button signUpButton;
		
		
		
		
		
		// Initialize -----
		
		// Layout
		rootPane = new BorderPane();
		centerPane = new VBox();
		idPane = new HBox();
		pwPane = new HBox();
		
		// Components
		idLabel = new Label();
		idTextField = new TextField();
		pwLabel = new Label();
		pwPwField = new PasswordField();
		loginButton = new Button();
		signUpButton = new Button();

		
		
		
		
		// View -----

		// Components
		idLabel.setText("아이디");
		idLabel.setPrefSize(60, 30);
		idLabel.setAlignment(Pos.CENTER_RIGHT);
		idTextField.setText("admin");
		idTextField.setPrefSize(130, 30);
		idTextField.setOnAction(e -> {
			// ID, PW 확인하기
			String id = idTextField.getText();
			String pw = pwPwField.getText();
			System.out.println("@@ 로그인 시도. id = " + id + ", pw = " + pw);
			
			LoginController controller = new LoginController();
			UserVO user = controller.login(id, pw); 
			if (user != null) {
				// 로그인 성공 시
				System.out.println("@@ 로그인 성공. id = " + user.getId());
				share.setUser(user);
				// 검색 화면으로 이동
				share.getMainPane().setTop(share.getHeadlineLoggedinView().getRootPane(share));
				share.getMainPane().setCenter(share.getBookSearchView().getRootPane(share));
				
			} else {
				// 로그인 실패 시
				System.out.println("@@ 로그인 실패");
			}
			
		});
		
		pwLabel.setText("비밀번호");
		pwLabel.setPrefSize(60, 30);
		pwLabel.setAlignment(Pos.CENTER_RIGHT);
		pwPwField.setText("qwer1234");
		pwPwField.setPrefSize(130, 30);
		pwPwField.setOnAction(e -> {
			// ID, PW 확인하기
			String id = idTextField.getText();
			String pw = pwPwField.getText();
			System.out.println("@@ 로그인 시도. id = " + id + ", pw = " + pw);
			
			LoginController controller = new LoginController();
			UserVO user = controller.login(id, pw); 
			if (user != null) {
				// 로그인 성공 시
				System.out.println("@@ 로그인 성공. id = " + user.getId());
				share.setUser(user);
				// 검색 화면으로 이동
				share.getMainPane().setTop(share.getHeadlineLoggedinView().getRootPane(share));
				share.getMainPane().setCenter(share.getBookSearchView().getRootPane(share));
				
			} else {
				// 로그인 실패 시
				System.out.println("@@ 로그인 실패");
			}
			
		});
		
		loginButton.setText("Login");
		loginButton.setPrefSize(200, 30);
		loginButton.setOnAction(e -> {
			// ID, PW 확인하기
			String id = idTextField.getText();
			String pw = pwPwField.getText();
			System.out.println("@@ 로그인 시도. id = " + id + ", pw = " + pw);
			
			LoginController controller = new LoginController();
			UserVO user = controller.login(id, pw); 
			if (user != null) {
				// 로그인 성공 시
				System.out.println("@@ 로그인 성공. id = " + user.getId());
				share.setUser(user);
				// 검색 화면으로 이동
				share.getMainPane().setTop(share.getHeadlineLoggedinView().getRootPane(share));
				share.getMainPane().setCenter(share.getBookSearchView().getRootPane(share));
				
			} else {
				// 로그인 실패 시
				System.out.println("@@ 로그인 실패");
			}
			
		});

		signUpButton.setText("Sign Up");
		signUpButton.setPrefSize(90, 30);
		signUpButton.setOnAction(e -> {
			// 회원가입
			System.out.println("@@ 회원가입");
			share.getMainPane().setCenter(share.getSignUpView().getRootPane(share));
			
		});

		
		
		// Layout
		idPane.setSpacing(10);
		idPane.setAlignment(Pos.BASELINE_CENTER);
		idPane.getChildren().add(idLabel);
		idPane.getChildren().add(idTextField);
		
		pwPane.setSpacing(10);
		pwPane.setAlignment(Pos.CENTER);
		pwPane.getChildren().add(pwLabel);
		pwPane.getChildren().add(pwPwField);

		centerPane.setSpacing(10);
		centerPane.setAlignment(Pos.CENTER);
		centerPane.getChildren().add(idPane);
		centerPane.getChildren().add(pwPane);
		centerPane.getChildren().add(loginButton);
		centerPane.getChildren().add(signUpButton);
		
		rootPane.setCenter(centerPane);
		
		return rootPane;
	}
	
}
