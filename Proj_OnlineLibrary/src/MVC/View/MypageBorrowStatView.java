package MVC.View;

import MVC.VO.BookVO;
import MVC.VO.ShareVO;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

public class MypageBorrowStatView {

	public BorderPane getRootPane(ShareVO share) {

		// Declare variables -----
		
		// Layout
		BorderPane rootPane;
		
		// Components
		TableView<BookVO> bookTableView;
		Button returnBookButton;
		
		
		
		
		
		// Initialize -----
		
		// Layout
		rootPane = new BorderPane();
		
		// Components
		bookTableView = new TableView<BookVO>();
		returnBookButton = new Button();

		
		
		
		
		// View -----

		returnBookButton.setText("반납하기");
		returnBookButton.setPrefSize(200, 30);
		returnBookButton.setOnAction(e -> {
			
		});

		// 컬럼 객체 생성
//		tableView.setPrefSize(700, 600);
		TableColumn<BookVO, String> isbnColumn = new TableColumn<>("ISBN");
		isbnColumn.setMinWidth(150);
		isbnColumn.setCellValueFactory(new PropertyValueFactory<>("bisbn"));
		TableColumn<BookVO, String> titleColumn = new TableColumn<>("TITLE");
		titleColumn.setMinWidth(300);
		titleColumn.setCellValueFactory(new PropertyValueFactory<>("btitle"));
		TableColumn<BookVO, String> authorColumn = new TableColumn<>("AUTHOR");
		authorColumn.setMinWidth(150);
		authorColumn.setCellValueFactory(new PropertyValueFactory<>("bauthor"));
		TableColumn<BookVO, Integer> priceColumn = new TableColumn<>("PRICE");
		priceColumn.setMinWidth(150);
		priceColumn.setCellValueFactory(new PropertyValueFactory<>("bprice"));
		// 위에서 만든 컬럼 객체를 TableView에 붙인다.
		bookTableView.getColumns().addAll(isbnColumn, titleColumn, authorColumn, priceColumn);
		
		bookTableView.setRowFactory(e -> {
			TableRow<BookVO> row = new TableRow<>();
			row.setOnMouseClicked(e1 -> {
				
				BookVO book = row.getItem();
				if (book == null) {
					System.out.println("@@ 빈 칸 클릭함");
					return;
				}
				
				if(e1.getClickCount() == 2) {
					System.out.println("@@ 행 더블클릭. title = " + row.getItem().getBtitle());

//					Dialog<String> dialog = new Dialog<String>();
//  			        dialog.setTitle("책 세부정보");
//				    ButtonType type = new ButtonType("Ok", ButtonData.OK_DONE);
//				    dialog.setContentText(" 다이얼로그 테스트 ");
//				    dialog.getDialogPane().getButtonTypes().add(type);
//				    dialog.getDialogPane().setMinHeight(300);
//		            dialog.showAndWait();
				} else {
					System.out.println("@@ 행 클릭. title = " + row.getItem().getBtitle());
					
				}
			});
			
			return row;

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
		rootPane.setPadding(new Insets(5));
		rootPane.setCenter(bookTableView);
		rootPane.setBottom(returnBookButton);
		
		return rootPane;
	}
}
