package MVC.View;

import java.sql.SQLException;

import org.apache.commons.dbcp2.BasicDataSource;

import MVC.Controller.BookSearchController;
import MVC.DAO.DBCP_Apache;
import MVC.VO.BookVO;
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class LibraryMain extends Application{

	// JavaFX main view components
	TableView<BookVO> tableView;
	TextField categoryTextField;
	TextField searchTextField;

	TextField topleftTextField;
	Button searchButton;
	
	
	TextField testTextField1;
	TextField testTextField2;
	TextField testTextField3;
	Button testButton1;
	Button testButton2;
	Button testButton3;
	
	// Business fields
	String searchCategory;
	String searchText;
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		// layout
//		VBox vBox = new VBox();
//		vBox.setPrefWidth(500);
//		vBox.setPrefSize(700, 500);
		
		
		BorderPane mainLayout = new BorderPane();
		
		// layout - top
		
		BorderPane topLayout = new BorderPane();
		
//		TextArea textArea = new TextArea();
//		textArea.setPrefSize(700, 30);

		topleftTextField = new TextField("topleft");
		topleftTextField.setPrefSize(150, 30);
		
		topLayout.setLeft(topleftTextField);
		
		
		
		// layout - center
		
		BorderPane centerLayout = new BorderPane();
		FlowPane centertopLayout = new FlowPane();

		categoryTextField = new TextField("btitle");
		categoryTextField.setPrefSize(150, 30);

		searchTextField = new TextField("%java%");
		searchTextField.setPrefSize(150, 30);
		searchTextField.setOnAction(e -> {
			System.out.println("@@ search textfield 실행");
			
			searchCategory = categoryTextField.getText();
			searchText = searchTextField.getText();
			
			BookSearchController controller = new BookSearchController();
			ObservableList<BookVO> list = controller.searchBook(searchCategory, searchText);
			tableView.setItems(list);
		});
		searchButton = new Button("검색");
		searchButton.setPrefSize(50, 30);
		searchButton.setOnAction(e -> {
			System.out.println("@@ 검색 버튼 클릭");
		});

		// 컬럼 객체 생성
		tableView = new TableView<BookVO>();
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
		tableView.getColumns().addAll(isbnColumn, titleColumn, authorColumn, priceColumn);

		centertopLayout.setPadding(new Insets(5));
		centertopLayout.setHgap(5);
		centertopLayout.getChildren().add(categoryTextField);
		centertopLayout.getChildren().add(searchTextField);
		centertopLayout.getChildren().add(searchButton);
		
		centerLayout.setTop(centertopLayout);
		centerLayout.setCenter(tableView);
		
		

		
		
		// layout - bottom
		
		FlowPane bottomLayout = new FlowPane();
		bottomLayout.setPadding(new Insets(5));
		
		searchTextField = new TextField();
		searchTextField.setPrefSize(200, 30);
		bottomLayout.getChildren().add(searchTextField);
		
		// layout 구성
		mainLayout.setTop(topLayout);
		mainLayout.setCenter(centerLayout);
		mainLayout.setBottom(bottomLayout);
		
//		vBox.getChildren().add(textArea);
//		vBox.getChildren().add(tableView);
		
		// scene
		Scene scene = new Scene(mainLayout);
		
		// stage
		primaryStage.setScene(scene);
		primaryStage.setTitle("Online Library Main");
		primaryStage.setOnCloseRequest(e -> {
			// close connection pool
			System.out.println("@@ connection pool 할당해제");
			try {
				((BasicDataSource)DBCP_Apache.getDataSource()).close();
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
