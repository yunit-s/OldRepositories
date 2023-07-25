package library.view;

import java.sql.SQLException;

import org.apache.commons.dbcp2.BasicDataSource;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;
import library.controller.BookDeleteController;
import library.controller.BookSearchController;
import library.dao.BookDAO;
import library.vo.BookVO;

public class LibraryView_YH extends Application{

	// JavaFX fields
	TableView<BookVO> tableView; 
	TextField searchTextField;
	Button deleteBtn;
	String deleteISBN;
	
	// database keyword
	String searchKeyword;
	String isbnOfSelectedBook;
	
	@Override
	public void start(Stage primaryStage) throws Exception {

		// layout 설정
		BorderPane root = new BorderPane();
		root.setPrefSize(700, 500);

		FlowPane flowPane = new FlowPane();
		flowPane.setPadding(new Insets(10, 10, 10, 10));
		flowPane.setColumnHalignment(HPos.CENTER);
		flowPane.setPrefSize(700, 40);
		flowPane.setHgap(10);

		// component 설정
		searchTextField = new TextField();
		searchTextField.setPrefSize(250, 40);
		searchTextField.setOnAction(e -> {
			// search for books by keyword
			searchKeyword = searchTextField.getText();
			
			BookSearchController controller = new BookSearchController();
			ObservableList<BookVO> list = controller.getResult(searchKeyword);
			tableView.setItems(list);
			
			searchTextField.clear();
		});

		// 삭제 버튼 생성
		deleteBtn = new Button("선택된 책 삭제");
		deleteBtn.setPrefSize(150, 40);
		deleteBtn.setDisable(true);
		deleteBtn.setOnAction(e -> {
			// delete a book from list
			BookDeleteController controller = new BookDeleteController();
			ObservableList<BookVO> list = controller.deleteBookByIsbn(isbnOfSelectedBook, searchKeyword);
			tableView.setItems(list);
			
			deleteBtn.setDisable(true);
		});
		
		// 컬럼 객체 생성
		tableView = new TableView<BookVO>();
		TableColumn<BookVO, String> isbnColumn = new TableColumn<>("ISBN");
		isbnColumn.setMinWidth(150);
		isbnColumn.setCellValueFactory(new PropertyValueFactory<>("bisbn"));
		TableColumn<BookVO, String> titleColumn = new TableColumn<>("TITLE");
		titleColumn.setMinWidth(150);
		titleColumn.setCellValueFactory(new PropertyValueFactory<>("btitle"));
		TableColumn<BookVO, String> authorColumn = new TableColumn<>("AUTHOR");
		authorColumn.setMinWidth(150);
		authorColumn.setCellValueFactory(new PropertyValueFactory<>("bauthor"));
		TableColumn<BookVO, Integer> priceColumn = new TableColumn<>("PRICE");
		priceColumn.setMinWidth(150);
		priceColumn.setCellValueFactory(new PropertyValueFactory<>("bprice"));
		// 위에서 만든 컬럼 객체를 TableView에 붙인다.
		tableView.getColumns().addAll(isbnColumn, titleColumn, authorColumn, priceColumn);
		
		// setRowFactory() : tableView.setItems(list); 를 실행하면 자동으로 실행되는 메소드
		tableView.setRowFactory(e -> {

			TableRow<BookVO> row = new TableRow<>(); // TableRow 생성해서 행을 만듦
			
			// row 를 클릭하면, 해당 도서의 isbn값 저장하기. 빈 칸 선택에 대한 예외처리도 할 것
			row.setOnMouseClicked(ce -> {
				BookVO book = row.getItem();
				if (book == null) {
					// click empty row
					System.out.println("@@ 빈 칸 클릭됨");
					return;
				}
				isbnOfSelectedBook = book.getBisbn();
				deleteBtn.setDisable(false);
				System.out.println("@@ 선택된 책 제목 : " + book.getBtitle());
			});
			
			return row; // row setting complete
		});

		flowPane.getChildren().add(searchTextField);
		flowPane.getChildren().add(deleteBtn);
		
		root.setCenter(tableView);
		root.setBottom(flowPane);
		
		Scene scene = new Scene(root);
		
		primaryStage.setScene(scene);
		primaryStage.setTitle("Simple JavaFX Table View");

		// 창을 닫을 때 실행할 내용
		primaryStage.setOnCloseRequest(e -> {
			System.out.println("@@ Window closed");
			// 프로그램이 종료될 때, Connection Pool 자체도 종료시켜서 연결을 모두 끊어줘야 한다.
			try {
				((BasicDataSource)BookDAO.getDataSource()).close();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});
		
		primaryStage.show();
		
	}

	public static void main(String[] args) {
		launch();
	}
	
}
