package MVC.View;

import MVC.Controller.ModifyUserInfoController;
import MVC.VO.ShareVO;
import MVC.VO.UserVO;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.layout.GridPane;

public class MypageModifyMyInfoView {

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
		Button modifyButton;
		
		
		
		
		
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
		modifyButton = new Button();

		
		
		
		
		// View -----

		// Components
		idLabel.setText("아이디");
		idLabel.setPrefSize(80, 30);
		idLabel.setAlignment(Pos.CENTER_RIGHT);
		idTextField.setText(share.getUser().getId());
		idTextField.setPrefSize(250, 30);
		idTextField.setDisable(true);
		
		nicknameLabel.setText("닉네임");
		nicknameLabel.setPrefSize(80, 30);
		nicknameLabel.setAlignment(Pos.CENTER_RIGHT);
		nicknameTextField.setText(share.getUser().getNickname());
		nicknameTextField.setPrefSize(250, 30);
		
		pwLabel.setText("비밀번호");
		pwLabel.setPrefSize(80, 30);
		pwLabel.setAlignment(Pos.CENTER_RIGHT);
		pwPwField.setText("qwer1234");
		pwPwField.setPrefSize(250, 30);
		
		pwcheckLabel.setText("비밀번호확인");
		pwcheckLabel.setPrefSize(80, 30);
		pwcheckLabel.setAlignment(Pos.CENTER_RIGHT);
		pwcheckPwField.setText("qwer1234");
		pwcheckPwField.setPrefSize(250, 30);
		
		emailLabel.setText("e-mail");
		emailLabel.setPrefSize(80, 30);
		emailLabel.setAlignment(Pos.CENTER_RIGHT);
		emailTextField.setText(share.getUser().getEmail());
		emailTextField.setPrefSize(250, 30);
		
		phoneLabel.setText("전화번호");
		phoneLabel.setPrefSize(80, 30);
		phoneLabel.setAlignment(Pos.CENTER_RIGHT);
		phoneTextField.setText(share.getUser().getPhone());
		phoneTextField.setPrefSize(250, 30);
		
		identquestLabel.setText("본인 확인 질문");
		identquestLabel.setPrefSize(80, 30);
		identquestLabel.setAlignment(Pos.CENTER_RIGHT);
		identquestTextField.setText(share.getUser().getIdentquest());
		identquestTextField.setPrefSize(250, 30);
		
		identanswerLabel.setText("본인 확인 답변");
		identanswerLabel.setPrefSize(80, 30);
		identanswerLabel.setAlignment(Pos.CENTER_RIGHT);
		identanswerTextField.setText(share.getUser().getIdentanswer());
		identanswerTextField.setPrefSize(250, 30);
		
		modifyButton.setText("수정");
		modifyButton.setPrefSize(100, 30);
		modifyButton.setOnAction(e -> {
			// 기존 데이터와 중복 여부 확인

			StringBuffer dialogMsg = new StringBuffer();
			ModifyUserInfoController controller = new ModifyUserInfoController();
			if (controller.checkIdInUsersDB(idTextField.getText()) != null) {
				System.out.println("@@ 개인 정보 수정 완료");
				
				String id = idTextField.getText();
				String nickname = nicknameTextField.getText();
				String pw = pwPwField.getText();
				String email = emailTextField.getText();
				String phone = phoneTextField.getText();
				String identquest = identquestTextField.getText();
				String identanswer = identanswerTextField.getText();
				String tier = share.getUser().getTier();
				int point = share.getUser().getPoint();
				UserVO user = new UserVO(id, nickname, pw, email, phone, identquest, identanswer, tier, point);
				int rows = controller.editUserToUsersDB(user);
				share.setUser(user);
				// 헤드라인 갱신
				share.getMainPane().setTop(share.getHeadlineLoggedinView().getRootPane(share));
				
				dialogMsg.append("- 개인 정보 수정 완료 -");
				dialogMsg.append("\n정상적으로 수정되었습니다.");
				
			} else {
				// 아이디 검색 실패 시
				System.out.println("@@ 개인 정보 수정 실패. 아이디 불일치");
				dialogMsg.append("- 개인 정보 수정 실패 -");
			}

			// 안내 메시지 출력
			Dialog<String> dialog = new Dialog<String>();
	        dialog.setTitle("개인 정보 수정");
	        ButtonType typeOk= new ButtonType("확인", ButtonData.OK_DONE);
		    dialog.setContentText(dialogMsg.toString());
		    dialog.getDialogPane().getButtonTypes().add(typeOk);
		    dialog.showAndWait();
			
		});

		// Layout
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
		rootPane.add(modifyButton, 1, 8);
		rootPane.setHalignment(modifyButton, HPos.RIGHT);
		
		return rootPane;
	}
	
}
