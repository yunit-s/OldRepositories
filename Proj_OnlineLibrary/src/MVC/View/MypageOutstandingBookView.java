package MVC.View;

import MVC.Controller.BookSearchController;
import MVC.VO.BookVO;
import MVC.VO.ShareVO;
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

public class MypageOutstandingBookView {

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
		TableView<BookVO> bookTableView;
		Button returnBookButton;
		
		
		
		
		
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
		bookTableView = new TableView<BookVO>();
		returnBookButton = new Button();

		
		
		
		
		// View -----

		// Components
		categoryLabel.setText("btitle");
		categoryLabel.setPrefSize(60, 30);
		categoryLabel.setAlignment(Pos.CENTER);
		
		searchWordTextField.setText("java");
		searchWordTextField.setPrefSize(400, 30);
		searchWordTextField.setOnAction(e -> {
			// 책 검색 (혹은 searchButton action 실행시키기)
			System.out.println("@@ 책 검색");
			BookSearchController controller = new BookSearchController();
			ObservableList<BookVO> list = controller.searchBook(categoryLabel.getText(), searchWordTextField.getText());
			bookTableView.setItems(list);
		});
		
		searchButton.setText("검색");
		searchButton.setPrefSize(60, 30);
		searchButton.setOnAction(e -> {
			// 책 검색
			// 일단은 위에 내용 복붙함
			BookSearchController controller = new BookSearchController();
			ObservableList<BookVO> list = controller.searchBook(categoryLabel.getText(), searchWordTextField.getText());
			bookTableView.setItems(list);
		});

		// 컬럼 객체 생성
//		tableView.setPrefSize(700, 600);
		TableColumn<BookVO, String> isbnColumn = new TableColumn<>("ISBN");
		isbnColumn.setMinWidth(120);
		isbnColumn.setCellValueFactory(new PropertyValueFactory<>("bisbn"));
		TableColumn<BookVO, String> titleColumn = new TableColumn<>("제목");
		titleColumn.setMinWidth(200);
		titleColumn.setCellValueFactory(new PropertyValueFactory<>("btitle"));
		TableColumn<BookVO, String> idColumn = new TableColumn<>("대출고객 ID");
		idColumn.setMinWidth(50);
		idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
		TableColumn<BookVO, String> borrdateColumn = new TableColumn<>("대출일");
		borrdateColumn.setMinWidth(30);
		borrdateColumn.setCellValueFactory(new PropertyValueFactory<>("borrdate"));
		TableColumn<BookVO, String> returndeadlineColumn = new TableColumn<>("반납기한");
		returndeadlineColumn.setMinWidth(30);
		returndeadlineColumn.setCellValueFactory(new PropertyValueFactory<>("returndeadline"));
		
		
//		TableColumn<BookVO, String> Column = new TableColumn<>("");
//		Column.setMinWidth(150);
//		Column.setCellValueFactory(new PropertyValueFactory<>(""));
//		TableColumn<BookVO, Integer> priceColumn = new TableColumn<>("전화번호");
//		priceColumn.setMinWidth(100);
//		priceColumn.setCellValueFactory(new PropertyValueFactory<>("phone"));
		// 위에서 만든 컬럼 객체를 TableView에 붙인다.
		bookTableView.getColumns().addAll(isbnColumn, titleColumn, idColumn, borrdateColumn, returndeadlineColumn);
		
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
		
		returnBookButton.setText("반납처리");
		returnBookButton.setPrefSize(100, 30);
		returnBookButton.setOnAction(e -> {
			System.out.println("@@ 반납처리");
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
		bottomPane.getChildren().add(returnBookButton);
		
		rootPane.setPadding(new Insets(5));
		rootPane.setTop(topPane);
		rootPane.setCenter(bookTableView);
		rootPane.setBottom(bottomPane);
		
		return rootPane;
	}
	
}
