package lecture.jdbc;

//import java.util.ArrayList;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
//import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;
import lecture.jdbc.vo.BookVO;

public class SimpleJavaFXTableView extends Application {

	// TableView 안의 데이터는 VO를 가져와서 한 줄씩 표현한다. 이때 사용되는 VO의 클래스이름을 generic으로 지정한다.
	TableView<BookVO> tableView; 
	TextField textField;
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		// primaryStage : 화면에 띄우는 실제 창. arg0라고 하면 직관적이지 않으니까 이름 바꿈
		
		// 1. layout 설정
		BorderPane root = new BorderPane();
		root.setPrefSize(700, 500);
		
		// 2. BorderPane 아래쪽에 붙일 판자(FlowPane) 하나 생성
		FlowPane flowPane = new FlowPane();
		flowPane.setPadding(new Insets(10, 10, 10, 10));
		flowPane.setColumnHalignment(HPos.CENTER);
		flowPane.setPrefSize(700, 40);
		flowPane.setHgap(10);
		
		// 3. 각각의 componenet 설정
		textField = new TextField();
		textField.setPrefSize(250, 40);
		flowPane.getChildren().add(textField);

		// 컬럼 객체 생성
		// TableColumn<해당 컬럼에 나오는 데이터의 출처 VO, 해당 컬럼에 저장할 데이터타입(레퍼런스 타입)> 
		TableColumn<BookVO, String> isbnColumn = new TableColumn<>("ISBN"); // "ISBN" : 화면에 보여지는 컬럼의 이름 지정
		isbnColumn.setMinWidth(150); // 최소 가로 길이
		isbnColumn.setCellValueFactory(new PropertyValueFactory<>("bisbn")); // 해당 컬럼의 데이터를 VO의 어떤 field에서 가져올지 설정
		TableColumn<BookVO, String> titleColumn = new TableColumn<>("TITLE");
		titleColumn.setMinWidth(150);
		titleColumn.setCellValueFactory(new PropertyValueFactory<>("btitle"));
		TableColumn<BookVO, String> authorColumn = new TableColumn<>("AUTHOR");
		authorColumn.setMinWidth(150);
		authorColumn.setCellValueFactory(new PropertyValueFactory<>("bauthor"));
		TableColumn<BookVO, Integer> priceColumn = new TableColumn<>("PRICE");
		priceColumn.setMinWidth(150);
		priceColumn.setCellValueFactory(new PropertyValueFactory<>("bprice"));
		
		// TableView에 표현할 데이터 만들기
		// TableView에 데이터를 넣을 때는, ArrayList는 아니고 이와 유사한 list를 사용한다. 사실상 똑같은데, 이름만 다른 개념.
//		ArrayList<BookVO> list = new ArrayList<>();
		ObservableList<BookVO> list = FXCollections.observableArrayList();
		list.add(new BookVO("123", "java 30일 완성", "홍길동", 22000));
		list.add(new BookVO("456", "java 이제 그만", "신사임당", 25000));
		list.add(new BookVO("789", "java 너무 어려워요", "강감찬", 28000));
		
		tableView = new TableView<BookVO>();
		
		// 위에서 만든 컬럼 객체를 TableView에 붙인다.
		tableView.getColumns().addAll(isbnColumn, titleColumn, authorColumn, priceColumn);
		
		// 데이터 세팅하기
		tableView.setItems(list);
		
		root.setCenter(tableView);
		root.setBottom(flowPane);
		
		Scene scene = new Scene(root);
		
		primaryStage.setScene(scene);
		primaryStage.setTitle("Simple JavaFX Table View");
		
		primaryStage.show();
		
	}

	public static void main(String[] args) {
		launch(); // 스태틱 메소드. 호출하면, start()를 실행하게 된다.
	}
}
