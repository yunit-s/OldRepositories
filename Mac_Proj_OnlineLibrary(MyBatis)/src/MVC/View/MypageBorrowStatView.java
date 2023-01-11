package MVC.View;

import MVC.Controller.BookSearchController;
import MVC.Controller.BorrBookSearchController;
import MVC.Controller.ReturnBookController;
import MVC.VO.BookVO;
import MVC.VO.BorrBookVO;
import MVC.VO.ShareVO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class MypageBorrowStatView {

	// Business Logic
	String selectedBookBisbn;
	
	public BorderPane getRootPane(ShareVO share) {

		// Declare variables -----
		
		// Layout
		BorderPane rootPane;
		HBox bottomPane;
		
		// Components
		TableView<BorrBookVO> bookTableView;
		Button returnBookButton;

		BorrBookSearchController borrBookSearchController;
		ObservableList<BorrBookVO> tmplist;
		
		
		
		
		// Initialize -----
		
		// Layout
		rootPane = new BorderPane();
		bottomPane = new HBox();
		
		// Components
		bookTableView = new TableView<BorrBookVO>();
		returnBookButton = new Button();

		borrBookSearchController = new BorrBookSearchController();
		tmplist = FXCollections.observableArrayList();
		
		
		
		// View -----

		// Components
		
		// 컬럼 객체 생성
//		tableView.setPrefSize(700, 600);
		TableColumn<BorrBookVO, String> isbnColumn = new TableColumn<>("ISBN");
		isbnColumn.setMinWidth(120);
		isbnColumn.setCellValueFactory(new PropertyValueFactory<>("bisbn"));
		TableColumn<BorrBookVO, String> titleColumn = new TableColumn<>("제목");
		titleColumn.setMinWidth(300);
		titleColumn.setCellValueFactory(new PropertyValueFactory<>("btitle"));
		TableColumn<BorrBookVO, String> borrdateColumn = new TableColumn<>("대여 날짜");
		borrdateColumn.setMinWidth(60);
		borrdateColumn.setCellValueFactory(new PropertyValueFactory<>("borrdate"));
		TableColumn<BorrBookVO, Integer> returndateColumn = new TableColumn<>("반납 기한");
		returndateColumn.setMinWidth(60);
		returndateColumn.setCellValueFactory(new PropertyValueFactory<>("returndate"));
		// 위에서 만든 컬럼 객체를 TableView에 붙인다.
		bookTableView.getColumns().addAll(isbnColumn, titleColumn, borrdateColumn, returndateColumn);
		
		bookTableView.setRowFactory(e -> {
			TableRow<BorrBookVO> row = new TableRow<>();
			row.setOnMouseClicked(e1 -> {
				
				BorrBookVO borrBook = row.getItem();
				if (borrBook == null) {
					System.out.println("@@ 빈 칸 클릭함");
					return;
				}
				selectedBookBisbn = borrBook.getBisbn();
				
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
		// 화면 초기값 - 모든 리스트 불러오기
		tmplist = borrBookSearchController.searchBook("id", share.getUser().getId());
		bookTableView.setItems(tmplist);

		returnBookButton.setText("반납하기");
		returnBookButton.setPrefSize(150, 30);
		returnBookButton.setOnAction(e -> {
			System.out.println("@@ 반납하기");
			
			// book, borrbook 테이블 수정
			ReturnBookController returnBookController = new ReturnBookController();
			int rows = returnBookController.returnBookOneFromBorrBookDBByBisbn(selectedBookBisbn, share.getUser());
			
			// 목록 갱신
//			BorrBookSearchController controller = new BorrBookSearchController();
//			ObservableList<BorrBookVO> list = controller.searchBook("id", share.getUser().getId());
//			bookTableView.setItems(list);
			
			// 좌측 메뉴, 우측 테이블뷰 동시 갱신
			share.getMainPane().setCenter(share.getMypageView().getRootPane(share));
		});

		
		
		// Layout
		bottomPane.setPadding(new Insets(5));
		bottomPane.setAlignment(Pos.CENTER_RIGHT);
		bottomPane.getChildren().add(returnBookButton);
		
		rootPane.setPadding(new Insets(5));
		rootPane.setCenter(bookTableView);
		rootPane.setBottom(bottomPane);
		
		return rootPane;
	}
	
}
