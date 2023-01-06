package MVC.View;

import MVC.Controller.WithdrawController;
import MVC.VO.ShareVO;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.util.Callback;

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
		Button outstandingBookButton;
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
		outstandingBookButton = new Button();
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
			System.out.println("@@ 회원 탈퇴");
			
//			Alert alert = new Alert(AlertType.INFORMATION);
//			alert.setTitle("회원탈퇴");
//			alert.setHeaderText("회원 탈퇴");
//			alert.setContentText(share.getUser().getNickname() + " 님의 계정이 탈퇴되었습니다.");
//			alert.setOnCloseRequest(e2 -> {
//				System.out.println("@@ alert 창 닫힘");
//				// 여기에 회원 탈퇴하는 코드 넣을 것
//				WithdrawController controller = new WithdrawController();
//				int rows = controller.withdrawAccount(share.getUser().getId());
//				share.setUser(null);
//				share.getMainPane().setTop(share.getHeadlineView().getRootPane(share));
//				share.getMainPane().setCenter(share.getBookSearchView().getRootPane(share));
//			});
//			alert.show();
			
			// Dialog로 구현하기
			Dialog<String> dialog = new Dialog<String>();
	        dialog.setTitle("회원 탈퇴");
	        ButtonType typeYes = new ButtonType("예", ButtonData.YES);
		    ButtonType typeNo = new ButtonType("아니오", ButtonData.NO);
		    dialog.setContentText("탈퇴하시겠습니까?");
		    dialog.getDialogPane().getButtonTypes().add(typeYes);
		    dialog.getDialogPane().getButtonTypes().add(typeNo);
//		    dialog.setOnCloseRequest(e2 -> {
//		    	System.out.println("@@ dialog 닫힘");
//		    });
		    dialog.setResultConverter(new Callback<ButtonType, String>() {
				
				@Override
				public String call(ButtonType param) {
					if (param.getButtonData() == ButtonData.YES) {
						System.out.println("@@ 회원 탈퇴 승인");
						WithdrawController controller = new WithdrawController();
						int rows = controller.withdrawAccount(share.getUser().getId());
						share.setUser(null);
						share.getMainPane().setTop(share.getHeadlineView().getRootPane(share));
						share.getMainPane().setCenter(share.getBookSearchView().getRootPane(share));
					} else if (param.getButtonData() == ButtonData.NO) {
						System.out.println("@@ 회원 탈퇴 취소");
					}
//					else if (param.getButtonData() == ButtonData.CANCEL_CLOSE) {
//						System.out.println("@@ Dialog param = cancel_close"); // 이건 창 닫힐 때 무조건 눌리네
//					}
					return null;
				}
			});
		    dialog.showAndWait();

		});
		
		modifyBookDBButton.setText("도서 데이터베이스 수정");
		modifyBookDBButton.setPrefSize(160, 30);
		modifyBookDBButton.setOnAction(e -> {
			System.out.println("@@ 도서 데이터베이스 수정");
			BorderPane pane = share.getMypageView().getRootPane(share);
			pane.setCenter(share.getMypageModifyBookDBView().getRootPane(share));
			share.getMainPane().setCenter(pane);
		});

		outstandingBookButton.setText("미납 도서");
		outstandingBookButton.setPrefSize(160, 30);
		outstandingBookButton.setOnAction(e -> {
			System.out.println("@@ 미납 도서");
			BorderPane pane = share.getMypageView().getRootPane(share);
			pane.setCenter(share.getMypageOutstandingBookView().getRootPane(share));
			share.getMainPane().setCenter(pane);
		});
		
		customerListButton.setText("회원 목록");
		customerListButton.setPrefSize(160, 30);
		customerListButton.setOnAction(e -> {
			System.out.println("@@ 회원 목록");
			BorderPane pane = share.getMypageView().getRootPane(share);
			pane.setCenter(share.getMypageUserListView().getRootPane(share));
			share.getMainPane().setCenter(pane);
		});
		
		modifyWebsiteButton.setText("사이트 편집");
		modifyWebsiteButton.setPrefSize(160, 30);
		modifyWebsiteButton.setOnAction(e -> {
			
		});
		


		
		
		// Layout
		
		rootPane.setSpacing(10);
		rootPane.setPadding(new Insets(5));
		rootPane.setAlignment(Pos.CENTER);
		rootPane.getChildren().add(myBorrowStatButton);
//		rootPane.getChildren().add(myBorrowLogButton);
//		rootPane.getChildren().add(myInterBookButton);
		rootPane.getChildren().add(modifyMyInfoButton);
		rootPane.getChildren().add(withdrawButton);
		if (share.getUser().getId().equals("admin")) {
			System.out.println("@@ Mypage menu - admin 계정");
			Label empty1 = new Label();
			empty1.setText("관리자 메뉴");
			empty1.setPrefSize(160, 30);
			empty1.setAlignment(Pos.BOTTOM_CENTER);
			
			rootPane.getChildren().add(empty1);
			rootPane.getChildren().add(modifyBookDBButton);
			rootPane.getChildren().add(outstandingBookButton);
			rootPane.getChildren().add(customerListButton);
//			rootPane.getChildren().add(modifyWebsiteButton);
		} else {
			System.out.println("@@ 일반회원 계정");
		}
		
		return rootPane;
	}
	
}
