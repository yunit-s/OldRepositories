package MVC.View;

import MVC.Controller.ModifyUserInfoController;
import MVC.VO.UserVO;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class MypageUserModifyView {

	Stage getRootStage(String selectedUserId) {

		// Declare variables -----
		
		// Layout
		Stage primaryStage;
		Scene scene;

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
		Button modifyButton;
		
		ModifyUserInfoController modifyUserInfoController;
		UserVO user;
		
		
		
		
		
		// Initialize -----
		// Layout
		primaryStage = new Stage();
		scene = null;

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
		modifyButton = new Button();
		
		modifyUserInfoController = new ModifyUserInfoController();
		user = modifyUserInfoController.checkIdInUsersDB(selectedUserId);
		
		
		
		
		
		// View -----

		// Components
		idLabel.setText("아이디");
		idLabel.setPrefSize(80, 30);
		idLabel.setAlignment(Pos.CENTER_RIGHT);
		idTextField.setText(user.getId());
		idTextField.setPrefSize(250, 30);
		idTextField.setDisable(true);
		
		nicknameLabel.setText("닉네임");
		nicknameLabel.setPrefSize(80, 30);
		nicknameLabel.setAlignment(Pos.CENTER_RIGHT);
		nicknameTextField.setText(user.getNickname());
		nicknameTextField.setPrefSize(250, 30);
		
		pwLabel.setText("비밀번호");
		pwLabel.setPrefSize(80, 30);
		pwLabel.setAlignment(Pos.CENTER_RIGHT);
		pwPwField.setText(user.getPw());
		pwPwField.setPrefSize(250, 30);
		
		pwcheckLabel.setText("비밀번호확인");
		pwcheckLabel.setPrefSize(80, 30);
		pwcheckLabel.setAlignment(Pos.CENTER_RIGHT);
		pwcheckPwField.setText(user.getPw());
		pwcheckPwField.setPrefSize(250, 30);
		
		emailLabel.setText("e-mail");
		emailLabel.setPrefSize(80, 30);
		emailLabel.setAlignment(Pos.CENTER_RIGHT);
		emailTextField.setText(user.getEmail());
		emailTextField.setPrefSize(250, 30);
		
		phoneLabel.setText("전화번호");
		phoneLabel.setPrefSize(80, 30);
		phoneLabel.setAlignment(Pos.CENTER_RIGHT);
		phoneTextField.setText(user.getPhone());
		phoneTextField.setPrefSize(250, 30);
		
		identquestLabel.setText("본인 확인 질문");
		identquestLabel.setPrefSize(80, 30);
		identquestLabel.setAlignment(Pos.CENTER_RIGHT);
		identquestTextField.setText(user.getIdentquest());
		identquestTextField.setPrefSize(250, 30);
		
		identanswerLabel.setText("본인 확인 답변");
		identanswerLabel.setPrefSize(80, 30);
		identanswerLabel.setAlignment(Pos.CENTER_RIGHT);
		identanswerTextField.setText(user.getIdentanswer());
		identanswerTextField.setPrefSize(250, 30);
		
		modifyButton.setText("수정");
		modifyButton.setPrefSize(100, 30);
		modifyButton.setOnAction(e -> {

			StringBuffer dialogMsg = new StringBuffer();
			if (modifyUserInfoController.checkIdInUsersDB(idTextField.getText()) != null) {
				System.out.println("@@ 회원 정보 수정 완료");
				
				String id = idTextField.getText();
				String nickname = nicknameTextField.getText();
				String pw = pwPwField.getText();
				String email = emailTextField.getText();
				String phone = phoneTextField.getText();
				String identquest = identquestTextField.getText();
				String identanswer = identanswerTextField.getText();
				String tier = user.getTier();
				int point = user.getPoint();
				UserVO newUser = new UserVO(id, nickname, pw, email, phone, identquest, identanswer, tier, point);
				int rows = modifyUserInfoController.editUserToUsersDB(newUser);
				
				dialogMsg.append("- 회원 정보 수정 완료 -");
				dialogMsg.append("\n정상적으로 수정되었습니다.");
				
			} else {
				// 아이디 검색 실패 시
				System.out.println("@@ 회원 정보 수정 실패. 아이디 불일치");
				
				dialogMsg.append("- 회원 정보 수정 실패 -");
//				dialogMsg.append("\n아이디 입력 오류");
			}

			// 안내 메시지 출력
			Dialog<String> dialog = new Dialog<String>();
	        dialog.setTitle("회원 정보 수정");
	        ButtonType typeOk= new ButtonType("확인", ButtonData.OK_DONE);
		    dialog.setContentText(dialogMsg.toString());
		    dialog.getDialogPane().getButtonTypes().add(typeOk);
		    dialog.showAndWait();
		    
		});

		// Layout
		rootPane.setAlignment(Pos.CENTER);
		rootPane.setHgap(10);
		rootPane.setVgap(10);
		rootPane.setPadding(new Insets(30));
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
		rootPane.add(modifyButton, 1, 8);
		rootPane.setHalignment(modifyButton, HPos.RIGHT);
		
		scene = new Scene(rootPane);
		primaryStage.setScene(scene);
//		primaryStage.setOnCloseRequest(e -> {
//			System.out.println("@@ 회원 정보 수정 창 닫힘");
//			primaryStage.close();
//		});
		
		return primaryStage;
	}
	
}
