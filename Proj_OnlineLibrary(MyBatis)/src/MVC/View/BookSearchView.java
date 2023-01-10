package MVC.View;

import MVC.Controller.BookSearchController;
import MVC.Controller.BorrowBookController;
import MVC.VO.BookVO;
import MVC.VO.ShareVO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class BookSearchView {

	// Business Logic
	String selectedBookBisbn;
	
	public BorderPane getRootPane(ShareVO share) {

		// Declare variables -----

		// Layout
		BorderPane rootPane;
		HBox topPane;
		HBox bottomPane;
		
		// Components
//		Label categoryLabel; // 콤보박스면 최고
		ComboBox<String> categoryCombo;
		ObservableList<String> categoryList;
		TextField searchWordTextField;
		Button searchButton;
		TableView<BookVO> bookTableView;
		Button borrowButton;
		
		
		
		
		
		// Initialize -----

		// Layout
		rootPane = new BorderPane();
		topPane = new HBox();
//		centerPane = new VBox();
		bottomPane = new HBox();
		
		// Components
//		categoryLabel = new Label(); // 콤보박스면 최고
		categoryCombo = new ComboBox<String>();
		categoryList = FXCollections.observableArrayList();
		searchWordTextField = new TextField();
		searchButton = new Button();
		bookTableView = new TableView<BookVO>();
		borrowButton = new Button();

		
		
		
		
		// View -----

		// Components
//		categoryLabel.setText("btitle");
//		categoryLabel.setPrefSize(60, 30);
//		categoryLabel.setAlignment(Pos.CENTER);
		
		categoryList.addAll("btitle", "bauthor", "bisbn");
		categoryCombo.setItems(categoryList);
		categoryCombo.setValue("btitle");
		categoryCombo.setPrefSize(100, 30);
		
		searchWordTextField.setText("검색어 입력");
		searchWordTextField.setPrefSize(400, 30);
		searchWordTextField.setOnAction(e -> {
			// 책 검색 (혹은 searchButton action 실행시키기)
			System.out.println("@@ 책 검색");
			BookSearchController controller = new BookSearchController();
			ObservableList<BookVO> list = controller.searchBook(categoryCombo.getValue(), searchWordTextField.getText());
			bookTableView.setItems(list);
		});
		
		searchButton.setText("검색");
		searchButton.setPrefSize(60, 30);
		searchButton.setOnAction(e -> {
			// 책 검색
			// 일단은 위에 내용 복붙함
			BookSearchController controller = new BookSearchController();
			ObservableList<BookVO> list = controller.searchBook(categoryCombo.getValue(), searchWordTextField.getText());
			bookTableView.setItems(list);
		});

		// 컬럼 객체 생성
//		tableView.setPrefSize(700, 600);
		TableColumn<BookVO, String> isbnColumn = new TableColumn<>("ISBN");
		isbnColumn.setMinWidth(120);
		isbnColumn.setCellValueFactory(new PropertyValueFactory<>("bisbn"));
		TableColumn<BookVO, String> titleColumn = new TableColumn<>("제목");
		titleColumn.setMinWidth(300);
		titleColumn.setCellValueFactory(new PropertyValueFactory<>("btitle"));
		TableColumn<BookVO, String> authorColumn = new TableColumn<>("저자");
		authorColumn.setMinWidth(100);
		authorColumn.setCellValueFactory(new PropertyValueFactory<>("bauthor"));
		TableColumn<BookVO, Integer> priceColumn = new TableColumn<>("가격");
		priceColumn.setMinWidth(60);
		priceColumn.setCellValueFactory(new PropertyValueFactory<>("bprice"));
		TableColumn<BookVO, Integer> borrowableColumn = new TableColumn<>("대여 가능");
		borrowableColumn.setMinWidth(60);
		borrowableColumn.setCellValueFactory(new PropertyValueFactory<>("bborrowable"));
		TableColumn<BookVO, Integer> breturndateColumn = new TableColumn<>("반납 기한");
		breturndateColumn.setMinWidth(80);
		breturndateColumn.setCellValueFactory(new PropertyValueFactory<>("breturndate"));
		// 위에서 만든 컬럼 객체를 TableView에 붙인다.
		bookTableView.getColumns().addAll(isbnColumn, titleColumn, authorColumn, priceColumn, borrowableColumn, breturndateColumn);
		bookTableView.setPadding(new Insets(5));
		bookTableView.setRowFactory(e -> {

			TableRow<BookVO> row = new TableRow<>();
			if (row == null) {
				return row;
			} else {
				row.setOnMouseClicked(e1 -> {
					
					BookVO book = row.getItem();
					if (book == null) {
						System.out.println("@@ 빈 칸 클릭함");
						return;
					}
					selectedBookBisbn = book.getBisbn();
					if (book.getBborrowable().equals("x")) {
						borrowButton.setDisable(true);
					} else {
						borrowButton.setDisable(false);
						//왔다갑니다.
					}
					
					if(e1.getClickCount() == 2) {
						System.out.println("@@ 행 더블클릭. title = " + row.getItem().getBtitle());

						// 새 stage에서 상세정보 출력
						BookVODetailView bookVODetailView = new BookVODetailView();
						Stage detailStage = bookVODetailView.getRootStage(selectedBookBisbn);
						detailStage.show();
						
					} else {
						System.out.println("@@ 행 클릭. title = " + row.getItem().getBtitle());
						
					}
				});
				
				return row;
			}
		});

		borrowButton.setText("대여하기");
		borrowButton.setPrefSize(100, 30);
		borrowButton.setDisable(true);
		borrowButton.setOnAction(e -> {
			System.out.println("@@ 책 대여하기");
			
			if (share.getUser() != null) {
				// book, borrbook 테이블 수정
				BorrowBookController borrowBookController = new BorrowBookController();
				int rows = borrowBookController.borrowBookOneFromBookDBByBisbn(selectedBookBisbn, share.getUser());
				
				// 목록 갱신
				BookSearchController controller = new BookSearchController();
				ObservableList<BookVO> list = controller.searchBook(categoryCombo.getValue(), searchWordTextField.getText());
				bookTableView.setItems(list);
			} else {
				System.out.println("@@ 로그인 정보 없음");

				Alert alert = new Alert(AlertType.ERROR);
				alert.setTitle("로그인 정보 없음");
				alert.setHeaderText("로그인 정보 없음");
				alert.setContentText("로그인하십시오.");
//				alert.setOnCloseRequest(e2 -> {
//					System.out.println("@@ alert 창 닫힘");
//				});
				alert.show();
			}
		});
		
		
		
		// Layout
		topPane.setSpacing(10);
		topPane.setAlignment(Pos.CENTER);
		topPane.setPadding(new Insets(10));
		topPane.getChildren().add(categoryCombo);
		topPane.getChildren().add(searchWordTextField);
		topPane.getChildren().add(searchButton);
		
		bottomPane.setSpacing(10);
		bottomPane.setPadding(new Insets(5));
		bottomPane.setAlignment(Pos.CENTER_RIGHT);
		bottomPane.getChildren().add(borrowButton);
		
		rootPane.setTop(topPane);
		rootPane.setCenter(bookTableView);
		rootPane.setBottom(bottomPane);
		
		return rootPane;
	}
	
}
