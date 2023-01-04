package MVC.View;

import MVC.Controller.LoginController;
import MVC.VO.ShareVO;
import MVC.VO.UserVO;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class LoginView {

	// Layout
	private BorderPane rootPane;
	private VBox centerPane;
	private HBox idPane;
	private HBox pwPane;
	
	// View Components
	private Label idLabel;
	private TextField idTextField;
	private Label pwLabel;
	private PasswordField pwPwField;
	private Button loginButton;
	
	// Logic Fields
	ShareVO share;
	
	public LoginView(ShareVO share) {
		
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

		// Share object
		this.share = share;
	}
	
	public BorderPane getRootPane() {

		// View Components
		
		idLabel = new Label();
		idLabel.setText("아이디");
		idLabel.setPrefSize(60, 40);
		idLabel.setAlignment(Pos.CENTER_RIGHT);
		
		idTextField = new TextField();
		idTextField.setText("admin");
		idTextField.setPrefSize(130, 40);
		
		pwLabel = new Label();
		pwLabel.setText("비밀번호");
		pwLabel.setPrefSize(60, 40);
		pwLabel.setAlignment(Pos.CENTER_RIGHT);
		
		pwPwField = new PasswordField();
		pwPwField.setText("qwer1234");
		pwPwField.setPrefSize(130, 40);
		
		loginButton = new Button();
		loginButton.setText("Login");
		loginButton.setPrefSize(200, 40);
		loginButton.setOnAction(e -> {
			// ID, PW 확인하기
			String id = idTextField.getText();
			String pw = pwPwField.getText();
			System.out.println("@@ 로그인 시도. id = " + id + ", pw = " + pw);
			
			LoginController controller = new LoginController();
			if (controller.tryLogin(id, pw) == true) {
				// 로그인 성공 시
				System.out.println("@@ 로그인 성공");
//				user = new UserVO(id, "관리자", pw);
//				Window.setScene(homeScene);
				
				// 검색 화면으로 이동
				share.getMainPane().setCenter(share.getBookSearchView().getRootPane());
				
			} else {
				// 로그인 실패 시
				System.out.println("@@ 로그인 실패");
			}
			
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
		
		rootPane.setCenter(centerPane);
		
		return rootPane;
	}
}
