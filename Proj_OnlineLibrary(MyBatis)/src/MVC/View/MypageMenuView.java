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
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.util.Callback;

public class MypageMenuView {

	public BorderPane getRootPane(ShareVO share) {

		// Declare variables -----
		
		// Layout
		BorderPane rootPane;
		VBox topPane;
		FlowPane topInfoPane;
		FlowPane topPointPane;
		FlowPane topTierPane;
		VBox centerPane;
		
		// Components
		Label infoLabel;
		Label pointLabel;
		Label userPointLabel;
		Label tierLabel;
		Label userTierLabel;
		
		Button myBorrowStatButton;
//		Button myBorrowLogButton;
//		Button myInterBookButton;
		Button modifyMyInfoButton;
		Button withdrawButton;
		
		Button modifyBookDBButton;
		Button outstandingBookButton;
		Button customerListButton;
//		Button modifyWebsiteButton;
		
		
		
		
		
		// Initialize -----
		
		// Layout
		rootPane = new BorderPane();
		topPane = new VBox();
		topInfoPane = new FlowPane();
		topPointPane = new FlowPane();
		topTierPane = new FlowPane();
		centerPane = new VBox();
		
		// Components
		infoLabel = new Label();
		pointLabel = new Label();
		userPointLabel = new Label();
		tierLabel = new Label();
		userTierLabel = new Label();
		
		myBorrowStatButton = new Button();
//		myBorrowLogButton = new Button();
//		myInterBookButton = new Button();
		modifyMyInfoButton = new Button();
		withdrawButton = new Button();
		
		modifyBookDBButton = new Button();
		outstandingBookButton = new Button();
		customerListButton = new Button();
//		modifyWebsiteButton = new Button();

		
		
		
		
		// View -----

		// Components
		infoLabel.setText("- 내 정보 -");
		infoLabel.setPrefSize(160, 30);
		infoLabel.setAlignment(Pos.CENTER);
		infoLabel.setFont(Font.font(15));
		
		pointLabel.setText("포인트 : ");
		pointLabel.setPrefSize(70, 30);
		userPointLabel.setText(String.valueOf(share.getUser().getPoint()));
		userPointLabel.setPrefSize(90, 30);
		userPointLabel.setFont(Font.font("Arial", FontWeight.BOLD, 12));
		
		tierLabel.setText("등급 : ");
		tierLabel.setPrefSize(70, 30);
		userTierLabel.setText(share.getUser().getTier());
		userTierLabel.setPrefSize(90, 30);
//		userTierLabel.setFont(Font.font("Viner Hand ITC", FontWeight.BOLD, 25));
		userTierLabel.setFont(Font.font("Arial", FontWeight.BOLD, 12));
		if (share.getUser().getId().equals("admin")) {
			userTierLabel.setTextFill(Color.DARKRED);
		}
		
		myBorrowStatButton.setText("내 대여 현황 & 반납");
		myBorrowStatButton.setPrefSize(160, 30);
		myBorrowStatButton.setOnAction(e -> {
			System.out.println("@@ 내 대여 현황 & 반납");
			BorderPane pane = share.getMypageView().getRootPane(share);
			pane.setCenter(share.getMypageBorrowStatView().getRootPane(share));
			share.getMainPane().setCenter(pane);
			
		});
		
//		myBorrowLogButton.setText("내 대여 기록");
//		myBorrowLogButton.setPrefSize(160, 30);
//		myBorrowLogButton.setOnAction(e -> {
//			
//		});
		
//		myInterBookButton.setText("내 관심 도서");
//		myInterBookButton.setPrefSize(160, 30);
//		myInterBookButton.setOnAction(e -> {
//			
//		});
		
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
		
//		modifyWebsiteButton.setText("사이트 편집");
//		modifyWebsiteButton.setPrefSize(160, 30);
//		modifyWebsiteButton.setOnAction(e -> {
//			
//		});
		


		
		
		// Layout
		topInfoPane.getChildren().add(infoLabel);
		topPointPane.getChildren().add(pointLabel);
		topPointPane.getChildren().add(userPointLabel);
		topTierPane.getChildren().add(tierLabel);
		topTierPane.getChildren().add(userTierLabel);
		
		topPane.getChildren().add(topInfoPane);
		topPane.getChildren().add(topPointPane);
		topPane.getChildren().add(topTierPane);
//		topPane.setPrefSize(160, 200);
		topPane.setMaxSize(160, 100);
		
		centerPane.setSpacing(10);
		centerPane.setPadding(new Insets(5));
		centerPane.setAlignment(Pos.TOP_CENTER);
		centerPane.getChildren().add(topPane);
		if (share.getUser().getId().equals("admin")) {
//			System.out.println("@@ Mypage menu - admin 계정");
			Label adminLabel = new Label();
			adminLabel.setText("- 관리자 메뉴 -");
			adminLabel.setPrefSize(160, 30);
			adminLabel.setAlignment(Pos.BOTTOM_CENTER);
			adminLabel.setFont(Font.font(15));
			
			centerPane.getChildren().add(adminLabel);
			centerPane.getChildren().add(modifyBookDBButton);
			centerPane.getChildren().add(outstandingBookButton);
			centerPane.getChildren().add(customerListButton);
//			rootPane.getChildren().add(modifyWebsiteButton);
		} else {
//			System.out.println("@@ Mypage menu - 일반회원 계정");
			Label userLabel = new Label();
			userLabel.setText("- 회원 메뉴 -");
			userLabel.setPrefSize(160, 30);
			userLabel.setAlignment(Pos.BOTTOM_CENTER);
			userLabel.setFont(Font.font(15));
			
			centerPane.getChildren().add(userLabel);
			centerPane.getChildren().add(myBorrowStatButton);
//			rootPane.getChildren().add(myBorrowLogButton);
//			rootPane.getChildren().add(myInterBookButton);
			centerPane.getChildren().add(modifyMyInfoButton);
			centerPane.getChildren().add(withdrawButton);
		}
		
		rootPane.setTop(topPane);
		rootPane.setCenter(centerPane);
		
		return rootPane;
	}
	
}
