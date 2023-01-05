package MVC.View;

import MVC.Controller.BookSearchController;
import MVC.VO.BookVO;
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;
import javafx.util.Callback;

public class BookSearchMain extends Application {

	// JavaFX fields
	TableView<BookVO> tableView; 
	TextField searchTextField;
	Button deleteBtn;
	Button testBtn1;
	String deleteISBN;
	
	// database keyword
	String searchKeyword;
	
	@Override
	public void start(Stage primaryStage) throws Exception {

		// Declare Variables
		BorderPane root = new BorderPane();
		FlowPane flowPane = new FlowPane();
		Scene scene = new Scene(root);
		
		searchTextField = new TextField();
		deleteBtn = new Button("선택된 책 삭제");
		testBtn1 = new Button("새 Stage");
		tableView = new TableView<BookVO>();
		
		// Set Components
		searchTextField.setPrefSize(250, 40);
		searchTextField.setOnAction(e -> {
			// search for books by keyword
			searchKeyword = searchTextField.getText();
			
			BookSearchController controller = new BookSearchController();
			ObservableList<BookVO> list = controller.getResult(searchKeyword);
			tableView.setItems(list);
			
			searchTextField.clear();
		});

		deleteBtn.setPrefSize(150, 40);
//		deleteBtn.setDisable(true);
		deleteBtn.setOnAction(e -> {
			
			Dialog<String> dialog = new Dialog<String>();
	        dialog.setTitle("책 세부정보");
		    ButtonType type = new ButtonType("ok_done", ButtonData.OK_DONE);
		    ButtonType type2 = new ButtonType("cancel", ButtonData.CANCEL_CLOSE);
		    ButtonType type3 = new ButtonType("help", ButtonData.HELP);
		    ButtonType type4 = new ButtonType("yes", ButtonData.YES);
		    ButtonType type5 = new ButtonType("no", ButtonData.NO);
		    dialog.setContentText("dialog 에서 setContentText");
		    dialog.getDialogPane().getButtonTypes().add(type);
		    dialog.getDialogPane().getButtonTypes().add(type2);
		    dialog.getDialogPane().getButtonTypes().add(type3);
		    dialog.getDialogPane().getButtonTypes().add(type4);
		    dialog.getDialogPane().getButtonTypes().add(type5);
		    dialog.setOnShown(e2 -> {
		    	System.out.println("@@ dialog 열림");
		    });
		    dialog.setOnCloseRequest(e2 -> {
		    	System.out.println("@@ dialog 닫힘");
		    });
		    dialog.setResultConverter(new Callback<ButtonType, String>() {
				
				@Override
				public String call(ButtonType param) {
					// TODO Auto-generated method stub
					if (param.getButtonData() == ButtonData.OK_DONE) {
						System.out.println("@@ param = ok_done");
					} else if (param.getButtonData() == ButtonData.CANCEL_CLOSE) {
						System.out.println("@@ param = cancel_close"); // 이건 창 닫힐 때 무조건 눌리네
					} else if (param.getButtonData() == ButtonData.YES) {
						System.out.println("@@ param = yes");
					} else if (param.getButtonData() == ButtonData.HELP) {
						System.out.println("@@ param = help");
					} else if (param.getButtonData() == ButtonData.NO) {
						System.out.println("@@ param = no");
					}
					return null;
				}
			});
//		    dialog.getDialogPane().setMinHeight(300);
            dialog.showAndWait();
		});
		
		testBtn1.setPrefSize(150, 40);
		testBtn1.setOnAction(e -> {
			
			Stage newstage = new Stage();
			BorderPane pane = new BorderPane();
			TableView<BookVO> tViewtest = new TableView<BookVO>();
			pane.setCenter(tViewtest);
			Scene scenetest = new Scene(pane);
			newstage.setScene(scenetest);
			newstage.show();
		});
		
		// 컬럼 객체 생성
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
		tableView.setRowFactory(new Callback<TableView<BookVO>, TableRow<BookVO>>() {
			
			@Override
			public TableRow<BookVO> call(TableView<BookVO> param) {
				// TODO Auto-generated method stub
				return null;
			}
		});
		tableView.setRowFactory(e -> {

			TableRow<BookVO> row = new TableRow<>(); // TableRow 생성해서 행을 만듦
			return row; // 해당 행 리턴하기
		});
		
		flowPane.setPadding(new Insets(10, 10, 10, 10));
		flowPane.setColumnHalignment(HPos.CENTER);
		flowPane.setPrefSize(700, 40);
		flowPane.setHgap(10);
		flowPane.getChildren().add(searchTextField);
		flowPane.getChildren().add(deleteBtn);
		flowPane.getChildren().add(testBtn1);
		
		root.setPrefSize(700, 500);
		root.setCenter(tableView);
		root.setBottom(flowPane);

		
		primaryStage.setScene(scene);
		primaryStage.setTitle("Simple JavaFX Table View");
		primaryStage.setOnCloseRequest(e -> {
//			System.out.println("창 닫힘");
			// 프로그램이 종료될 때, Connection Pool 자체도 종료시켜서 연결을 모두 끊어줘야 한다.
//			try {
//				((BasicDataSource)getDataSource()).close();
//			} catch (SQLException e1) {
//				// TODO Auto-generated catch block
//				e1.printStackTrace();
//			}
		});
		primaryStage.show();
		
	}

	public static void main(String[] args) {
		launch();
	}
	
}
