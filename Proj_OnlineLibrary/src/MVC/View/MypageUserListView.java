package MVC.View;

import MVC.Controller.UserSearchController;
import MVC.VO.ShareVO;
import MVC.VO.UserVO;
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

public class MypageUserListView {

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
		Button modifyCustomerButton;
		Button deleteCustomerButton;
		
		
		
		
		
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
		modifyCustomerButton = new Button();
		deleteCustomerButton = new Button();

		
		
		
		
		// View -----

		// Components
		categoryLabel.setText("id");
		categoryLabel.setPrefSize(60, 30);
		categoryLabel.setAlignment(Pos.CENTER);
		
		searchWordTextField.setText("jelee");
		searchWordTextField.setPrefSize(400, 30);
		searchWordTextField.setOnAction(e -> {
			// 책 검색 (혹은 searchButton action 실행시키기)
			System.out.println("@@ 사용자 검색");
//			BookSearchController controller = new BookSearchController();
//			ObservableList<BookVO> list = controller.searchBook(categoryLabel.getText(), searchWordTextField.getText());
//			usersTableView.setItems(list);
			UserSearchController controller = new UserSearchController();
			ObservableList<UserVO> list = controller.searchUser(categoryLabel.getText(), searchWordTextField.getText());
			usersTableView.setItems(list);
		});
		
		searchButton.setText("검색");
		searchButton.setPrefSize(60, 30);
		searchButton.setOnAction(e -> {
			// 책 검색
			// 일단은 위에 내용 복붙함
//			BookSearchController controller = new BookSearchController();
//			ObservableList<BookVO> list = controller.searchBook(categoryLabel.getText(), searchWordTextField.getText());
//			usersTableView.setItems(list);
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
				
				if(e1.getClickCount() == 2) {
					System.out.println("@@ 행 더블클릭. title = " + row.getItem().getId());

//					Dialog<String> dialog = new Dialog<String>();
//  			        dialog.setTitle("책 세부정보");
//				    ButtonType type = new ButtonType("Ok", ButtonData.OK_DONE);
//				    dialog.setContentText(" 다이얼로그 테스트 ");
//				    dialog.getDialogPane().getButtonTypes().add(type);
//				    dialog.getDialogPane().setMinHeight(300);
//		            dialog.showAndWait();
				} else {
					System.out.println("@@ 행 클릭. title = " + row.getItem().getId());
					
				}
			});
			
			return row;

		});
		
		modifyCustomerButton.setText("회원 수정");
		modifyCustomerButton.setPrefSize(100, 30);
		modifyCustomerButton.setOnAction(e -> {
			System.out.println("@@ 회원 수정");
		});
		
		deleteCustomerButton.setText("회원 삭제");
		deleteCustomerButton.setPrefSize(100, 30);
		deleteCustomerButton.setOnAction(e -> {
			System.out.println("@@ 회원 삭제");
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
		bottomPane.getChildren().add(modifyCustomerButton);
		bottomPane.getChildren().add(deleteCustomerButton);
		
		rootPane.setPadding(new Insets(5));
		rootPane.setTop(topPane);
		rootPane.setCenter(usersTableView);
		rootPane.setBottom(bottomPane);
		
		return rootPane;
	}
	
}
