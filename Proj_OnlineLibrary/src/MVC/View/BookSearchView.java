package MVC.View;

import MVC.Controller.BookSearchController;
import MVC.Controller.LoginController;
import MVC.VO.BookVO;
import MVC.VO.ShareVO;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class BookSearchView {

	public BorderPane getRootPane(ShareVO share) {

		// Declare variables -----

		// Layout
		BorderPane rootPane;
		HBox topPane;
		VBox centerPane;
		HBox bottomPane;
		
		// Components
		Label categoryLabel; // 콤보박스면 최고
//		ComboBox<String> categoryCombo;
		TextField searchWordTextField;
		Button searchButton;
		TableView<BookVO> bookTableView;
		Button borrowButton;
		
		
		
		
		
		// Initialize -----

		// Layout
		rootPane = new BorderPane();
		topPane = new HBox();
		centerPane = new VBox();
		bottomPane = new HBox();
		
		// Components
		categoryLabel = new Label(); // 콤보박스면 최고
//		ComboBox<String> category;
		searchWordTextField = new TextField();
		searchButton = new Button();
		bookTableView = new TableView<BookVO>();
		borrowButton = new Button();

		
		
		
		
		// View -----
		
		categoryLabel.setText("btitle");
		categoryLabel.setPrefSize(60, 40);
		categoryLabel.setAlignment(Pos.CENTER);
		
		searchWordTextField.setText("검색어 입력");
		searchWordTextField.setPrefSize(400, 40);
		searchWordTextField.setOnAction(e -> {
			// 책 검색 (혹은 searchButton action 실행시키기)
			System.out.println("@@ 책 검색");
			BookSearchController controller = new BookSearchController();
			ObservableList<BookVO> list = controller.searchBook(categoryLabel.getText(), searchWordTextField.getText());
			bookTableView.setItems(list);
		});
		
		searchButton.setText("검색");
		searchButton.setPrefSize(60, 40);
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
			if (row == null) {
				return row;
			} else {
				row.setOnMouseClicked(e1 -> {
					
					BookVO book = row.getItem();
					if (book == null) {
						System.out.println("@@ 빈 칸 클릭함");
						return;
					}
					
					if(e1.getClickCount() == 2) {
						System.out.println("@@ 행 더블클릭. title = " + row.getItem().getBtitle());
	
//						Dialog<String> dialog = new Dialog<String>();
//	  			        dialog.setTitle("책 세부정보");
//					    ButtonType type = new ButtonType("Ok", ButtonData.OK_DONE);
//					    dialog.setContentText(" 다이얼로그 테스트 ");
//					    dialog.getDialogPane().getButtonTypes().add(type);
//					    dialog.getDialogPane().setMinHeight(300);
//			            dialog.showAndWait();
					} else {
						System.out.println("@@ 행 클릭. title = " + row.getItem().getBtitle());
						
					}
				});
				
				return row;
			}
		});

		borrowButton.setText("대여하기");
		borrowButton.setPrefSize(100, 40);
		borrowButton.setOnAction(e -> {
			System.out.println("@@ 책 대여하기");
		});
		
		
		
		// Layout
		
		topPane.setSpacing(10);
		topPane.setAlignment(Pos.CENTER);
		topPane.setPadding(new Insets(10));
		topPane.getChildren().add(categoryLabel);
		topPane.getChildren().add(searchWordTextField);
		topPane.getChildren().add(searchButton);

		centerPane.setAlignment(Pos.CENTER);
		centerPane.setSpacing(10);
		centerPane.getChildren().add(bookTableView);
		
		bottomPane.setSpacing(10);
		bottomPane.setAlignment(Pos.CENTER_RIGHT);
		bottomPane.getChildren().add(borrowButton);
		
		rootPane.setTop(topPane);
		rootPane.setCenter(centerPane);
		rootPane.setBottom(bottomPane);
		
		return rootPane;
	}
}
