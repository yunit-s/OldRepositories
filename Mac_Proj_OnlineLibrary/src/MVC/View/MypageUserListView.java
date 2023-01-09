package MVC.View;

import MVC.Controller.UserSearchController;
import MVC.Controller.WithdrawController;
import MVC.VO.ShareVO;
import MVC.VO.UserVO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class MypageUserListView {

	// Business Logic
	String selectedUserId;
	
	public BorderPane getRootPane(ShareVO share) {

		// Declare variables -----
		
		// Layout
		BorderPane rootPane;
		HBox topPane;
		FlowPane bottomPane;
		
		// Components
		Label categoryLabel; // 콤보박스면 최고
//		ComboBox<String> categoryCombo;
		TextField searchWordTextField;
		Button searchButton;
		TableView<UserVO> usersTableView;
		Button modifyUserButton;
		Button deleteUserButton;

		UserSearchController tmpcontroller;
		ObservableList<UserVO> tmplist;

		
		
		
		
		// Initialize -----
		
		// Layout
		rootPane = new BorderPane();
		topPane = new HBox();
		bottomPane = new FlowPane();
		
		// Components
		categoryLabel = new Label(); // 콤보박스면 최고
//		ComboBox<String> category;
		searchWordTextField = new TextField();
		searchButton = new Button();
		usersTableView = new TableView<UserVO>();
		modifyUserButton = new Button();
		deleteUserButton = new Button();

		tmpcontroller = new UserSearchController();
		tmplist = FXCollections.observableArrayList();
		
		
		
		
		// View -----

		// Components
		categoryLabel.setText("id");
		categoryLabel.setPrefSize(60, 30);
		categoryLabel.setAlignment(Pos.CENTER);
		
		searchWordTextField.setText("jelee");
		searchWordTextField.setPrefSize(400, 30);
		searchWordTextField.setOnAction(e -> {
			// 회원 검색 (혹은 searchButton action 실행시키기)
			System.out.println("@@ 사용자 검색");
			UserSearchController controller = new UserSearchController();
			ObservableList<UserVO> list = controller.searchUser(categoryLabel.getText(), searchWordTextField.getText());
			usersTableView.setItems(list);
		});
		
		searchButton.setText("검색");
		searchButton.setPrefSize(60, 30);
		searchButton.setOnAction(e -> {
			// 회원 검색
			// 일단은 위에 내용 복붙함
			UserSearchController controller = new UserSearchController();
			ObservableList<UserVO> list = controller.searchUser(categoryLabel.getText(), searchWordTextField.getText());
			usersTableView.setItems(list);
		});


		// 컬럼 객체 생성
//		tableView.setPrefSize(700, 600);
		TableColumn<UserVO, String> idColumn = new TableColumn<>("ID");
		idColumn.setMinWidth(100);
		idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
		TableColumn<UserVO, String> nicknameColumn = new TableColumn<>("닉네임");
		nicknameColumn.setMinWidth(100);
		nicknameColumn.setCellValueFactory(new PropertyValueFactory<>("nickname"));
		TableColumn<UserVO, String> emailColumn = new TableColumn<>("E-mail");
		emailColumn.setMinWidth(150);
		emailColumn.setCellValueFactory(new PropertyValueFactory<>("email"));
		TableColumn<UserVO, Integer> phoneColumn = new TableColumn<>("전화번호");
		phoneColumn.setMinWidth(100);
		phoneColumn.setCellValueFactory(new PropertyValueFactory<>("phone"));
		// 위에서 만든 컬럼 객체를 TableView에 붙인다.
		usersTableView.getColumns().addAll(idColumn, nicknameColumn, emailColumn, phoneColumn);
		
		usersTableView.setRowFactory(e -> {
			TableRow<UserVO> row = new TableRow<>();
			row.setOnMouseClicked(e1 -> {
				
				UserVO user = row.getItem();
				if (user == null) {
					System.out.println("@@ 빈 칸 클릭함");
					return;
				}
				selectedUserId = user.getId();
				System.out.println("@@ selectedUserId = " + selectedUserId);
				if(e1.getClickCount() == 2) {
					System.out.println("@@ 행 더블클릭. title = " + row.getItem().getId());

				} else {
					System.out.println("@@ 행 클릭. title = " + row.getItem().getId());
					
				}
			});
			
			return row;

		});
		// 화면 초기값 - 모든 리스트 불러오기
		tmplist = tmpcontroller.searchUser(categoryLabel.getText(), "");
		usersTableView.setItems(tmplist);
		
		modifyUserButton.setText("회원 수정");
		modifyUserButton.setPrefSize(100, 30);
		modifyUserButton.setOnAction(e -> {
			System.out.println("@@ 회원 수정");
			
			// 새 stage에서 수정 작업 진행
			MypageUserModifyView mypageUserModifyView = new MypageUserModifyView();
			Stage userModifyStage = mypageUserModifyView.getRootStage(selectedUserId);
			userModifyStage.setOnCloseRequest(e2 -> {
				System.out.println("@@ 회원 수정 창 닫힘");
				
				// 회원 테이블 갱신
				UserSearchController controller = new UserSearchController();
				ObservableList<UserVO> list = controller.searchUser(categoryLabel.getText(), searchWordTextField.getText());
				usersTableView.setItems(list);
			});
			userModifyStage.show();
			
		});
		
		deleteUserButton.setText("회원 삭제");
		deleteUserButton.setPrefSize(100, 30);
		deleteUserButton.setOnAction(e -> {
			System.out.println("@@ 회원 삭제");
			
			// 회원 삭제
			WithdrawController wcontroller = new WithdrawController();
			int rows = wcontroller.withdrawAccount(selectedUserId);

			// 회원 테이블 갱신
			UserSearchController ucontroller = new UserSearchController();
			ObservableList<UserVO> list = ucontroller.searchUser(categoryLabel.getText(), searchWordTextField.getText());
			usersTableView.setItems(list);
		});

		
		
		// Layout
		topPane.setSpacing(10);
		topPane.setAlignment(Pos.CENTER);
		topPane.setPadding(new Insets(5));
		topPane.getChildren().add(categoryLabel);
		topPane.getChildren().add(searchWordTextField);
		topPane.getChildren().add(searchButton);

		bottomPane.setAlignment(Pos.BASELINE_RIGHT);
		bottomPane.setHgap(10);
		bottomPane.getChildren().add(modifyUserButton);
		bottomPane.getChildren().add(deleteUserButton);
		
		rootPane.setPadding(new Insets(5));
		rootPane.setTop(topPane);
		rootPane.setCenter(usersTableView);
		rootPane.setBottom(bottomPane);
		
		return rootPane;
	}
	
}
