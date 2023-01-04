package MVC.View;

import MVC.VO.ShareVO;
import MVC.VO.UserVO;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class SignUpView {

	public GridPane getRootPane(ShareVO share) {

		// Declare variables -----
		
		// Layout
		GridPane rootPane;
		
		// Components
		Label idLabel;
		TextField idTextField;
		Label nicknameLabel;
		TextField nicknameTextField;
		Label pwLabel;
		PasswordField pwPwField;
		Label pwcheckLabel;
		PasswordField pwcheckPwField;
		Label emailLabel;
		TextField emailTextField;
		Label phoneLabel;
		TextField phoneTextField;
		Label identquestLabel;
		TextField identquestTextField;
		Label identanswerLabel;
		TextField identanswerTextField;
		Button signUpButton;
		
		
		
		
		
		// Initialize -----
		
		// Layout
		rootPane = new GridPane();
		
		// Components
		idLabel = new Label();
		idTextField = new TextField();
		nicknameLabel = new Label();
		nicknameTextField = new TextField();
		pwLabel = new Label();
		pwPwField = new PasswordField();
		pwcheckLabel = new Label();
		pwcheckPwField = new PasswordField();
		emailLabel = new Label();
		emailTextField = new TextField();
		phoneLabel = new Label();
		phoneTextField = new TextField();
		identquestLabel = new Label();
		identquestTextField = new TextField();
		identanswerLabel = new Label();
		identanswerTextField = new TextField();
		signUpButton = new Button();

		
		
		
		
		// View -----
		
		idLabel.setText("아이디");
		idLabel.setPrefSize(80, 30);
		idLabel.setAlignment(Pos.CENTER_RIGHT);
		idTextField.setText("이종석");
		idTextField.setPrefSize(250, 30);
		
		nicknameLabel.setText("닉네임");
		nicknameLabel.setPrefSize(80, 30);
		nicknameLabel.setAlignment(Pos.CENTER_RIGHT);
		nicknameTextField.setText("창호");
		nicknameTextField.setPrefSize(250, 30);
		
		pwLabel.setText("비밀번호");
		pwLabel.setPrefSize(80, 30);
		pwLabel.setAlignment(Pos.CENTER_RIGHT);
		pwPwField.setText("qwer1234");
		pwPwField.setPrefSize(250, 30);
		
		pwcheckLabel.setText("비밀번호확인");
		pwcheckLabel.setPrefSize(80, 30);
		pwcheckLabel.setAlignment(Pos.CENTER_RIGHT);
		pwcheckPwField.setText("qwer123");
		pwcheckPwField.setPrefSize(250, 30);
		
		emailLabel.setText("e-mail");
		emailLabel.setPrefSize(80, 30);
		emailLabel.setAlignment(Pos.CENTER_RIGHT);
		emailTextField.setText("jslee@gmail.com");
		emailTextField.setPrefSize(250, 30);
		
		phoneLabel.setText("전화번호");
		phoneLabel.setPrefSize(80, 30);
		phoneLabel.setAlignment(Pos.CENTER_RIGHT);
		phoneTextField.setText("010-1234-5678");
		phoneTextField.setPrefSize(250, 30);
		
		identquestLabel.setText("본인 확인 질문");
		identquestLabel.setPrefSize(80, 30);
		identquestLabel.setAlignment(Pos.CENTER_RIGHT);
		identquestTextField.setText("당신의 이름은?");
		identquestTextField.setPrefSize(250, 30);
		
		identanswerLabel.setText("본인 확인 답변");
		identanswerLabel.setPrefSize(80, 30);
		identanswerLabel.setAlignment(Pos.CENTER_RIGHT);
		identanswerTextField.setText("이종석");
		identanswerTextField.setPrefSize(250, 30);
		
		signUpButton.setText("회원가입");
		signUpButton.setPrefSize(100, 30);
		signUpButton.setOnAction(e -> {
			// 기존 데이터와 중복 여부 확인
			
//			LoginController controller = new LoginController();
			if (true) {
				// 중복이 아니면, 회원 가입
				System.out.println("@@ 회원가입 완료");
				
				UserVO user = new UserVO(idTextField.getText(), nicknameTextField.getText(), pwPwField.getText(), emailTextField.getText(),
						phoneTextField.getText(), identquestTextField.getText(), identanswerTextField.getText());
				// 검색 화면으로 이동
				share.getMainPane().setCenter(share.getBookSearchView().getRootPane(share));
			} else {
				// 로그인 실패 시
				System.out.println("@@ 회원가입 실패");
			}
			
		});

		rootPane.setAlignment(Pos.CENTER);
		rootPane.setHgap(10);
		rootPane.setVgap(10);
		rootPane.add(idLabel, 0, 0);
		rootPane.add(idTextField, 1, 0);
		rootPane.add(nicknameLabel, 0, 1);
		rootPane.add(nicknameTextField, 1, 1);
		rootPane.add(pwLabel, 0, 2);
		rootPane.add(pwPwField, 1, 2);
		rootPane.add(pwcheckLabel, 0, 3);
		rootPane.add(pwcheckPwField, 1, 3);
		rootPane.add(emailLabel, 0, 4);
		rootPane.add(emailTextField, 1, 4);
		rootPane.add(phoneLabel, 0, 5);
		rootPane.add(phoneTextField, 1, 5);
		rootPane.add(identquestLabel, 0, 6);
		rootPane.add(identquestTextField, 1, 6);
		rootPane.add(identanswerLabel, 0, 7);
		rootPane.add(identanswerTextField, 1, 7);
		rootPane.add(signUpButton, 1, 8);
		rootPane.setHalignment(signUpButton, HPos.RIGHT);
		
		return rootPane;
	}
}
