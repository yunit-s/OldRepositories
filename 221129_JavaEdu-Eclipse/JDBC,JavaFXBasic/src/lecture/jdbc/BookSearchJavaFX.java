package lecture.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
//import java.util.ArrayList;

import javafx.application.Application;
import javafx.collections.FXCollections;
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
//import javafx.util.Callback;
import lecture.jdbc.vo.BookVO;

public class BookSearchJavaFX extends Application {

	// TableView 안의 데이터는 VO를 가져와서 한 줄씩 표현한다. 이때 사용되는 VO의 클래스이름을 generic으로 지정한다.
	TableView<BookVO> tableView; 
	TextField textField;
	Button deleteBtn;
	
	String deleteISBN;

	// 생성자
	// 준비단계, 초기화단계 - JDBC 준비작업하기
	public BookSearchJavaFX() {
		try {
			// 1. JDBC Driver Loading 단계
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		
		// 1. layout 설정
		BorderPane root = new BorderPane();
		root.setPrefSize(700, 500);

		// 2. BorderPane 아래쪽에 붙일 판자(FlowPane) 하나 생성
		FlowPane flowPane = new FlowPane();
		flowPane.setPadding(new Insets(10, 10, 10, 10));
		flowPane.setColumnHalignment(HPos.CENTER);
		flowPane.setPrefSize(700, 40);
		flowPane.setHgap(10);

		// 3. 각각의 component 설정
		textField = new TextField();
		textField.setPrefSize(250, 40);
		textField.setOnAction(e -> {
			// 데이터베이스에서 데이터 검색해서 출력까지
			// 2. 데이터베이스 연결
			String jdbc_url = "jdbc:mysql://127.0.0.1:3306/library?characterEncoding=UTF-8&serverTimezone=UTC&useSSL=false&allowPublicKeyRetrieval=true";
			String id = "root";
			String pw = "qwer1234";
			Connection con = null;
			try {
				con = DriverManager.getConnection(jdbc_url, id, pw);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			// 3. 실행할 SQL문장을 가지고 있는 Statement 생성하기
			StringBuffer sql = new StringBuffer();
			sql.append("select bisbn, btitle, bauthor, bprice ");
			sql.append("from book ");
			sql.append("where btitle like ?");
			sql.append("order by bprice desc");
			
			try {
			    PreparedStatement pstmt = con.prepareStatement(sql.toString());
				pstmt.setString(1, "%" + textField.getText() + "%");
				
			    // 4. 실행
			    ResultSet rs = pstmt.executeQuery();

			    // 5. 결과처리
//			    ArrayList<BookVO> list = new ArrayList<BookVO>();
			    ObservableList<BookVO> list = FXCollections.observableArrayList();
				while (rs.next()) {
			    	// VO를 생성해야 한다.
					BookVO book = new BookVO(rs.getString("bisbn"), rs.getString("btitle"), rs.getString("bauthor"), rs.getInt("bprice"));
					// arraylist에 추가하기
					list.add(book);
			    }

				// 데이터 세팅하기
				tableView.setItems(list);
				
			    // 6. 사용한 리소스 해제
			    rs.close();
			    pstmt.close();
			    con.close();

			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		});

		// 삭제 버튼 생성
		deleteBtn = new Button("선택된 책 삭제");
		deleteBtn.setPrefSize(150, 40);
		deleteBtn.setDisable(true); // true를 하면, 버튼이 disable(비활성화)된다.
		deleteBtn.setOnAction(e -> {
			// 버튼을 누르면 여기가 실행된다.

			// 1. JDBC Driver Loading 단계
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
			} catch (ClassNotFoundException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
			String jdbc_url = "jdbc:mysql://127.0.0.1:3306/library?characterEncoding=UTF-8&serverTimezone=UTC&useSSL=false&allowPublicKeyRetrieval=true";
			String id = "root";
			String pw = "qwer1234";
			
			// 2. Database 접속
			Connection con = null;
			try {
				con = DriverManager.getConnection(jdbc_url, id, pw);
			} catch (SQLException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
			
			StringBuffer sql = new StringBuffer();
			sql.append("DELETE ");
			sql.append("FROM book ");
			sql.append("WHERE bisbn = ?");
			
			try {
				// transaction 시작
				con.setAutoCommit(false); // Auto commit 기능을 끄면서, 이때부터는 트랜잭션이 걸리게 된
				
				PreparedStatement pstmt = con.prepareStatement(sql.toString());
				pstmt.setString(1, deleteISBN);
				
				int count = pstmt.executeUpdate();
				System.out.println("영향받은 row : " + count + " 줄");
				
				// transaction을 종료하고, 지금까지 실행한 SQL문을 모두 무효화시킴
//				if (count == 1) {
//					con.commit();
//				} else {
//					con.rollback();
//				}
				con.rollback();
				System.out.println("delete 에 대한 rollback 실행함.");
				
				// 6. 사용한 자원 반납
				pstmt.close();
				con.close();
				
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
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
		
		// 나중에 TableView 안에 데이터가 표현된다.
		// 이때 각 행들에 대해서 이벤트를 설정할 수 있다.
		// 좀 더 정확히 말해서, 각 행들에 대한 특정 설정을 할 수 있다.
		// callback 객체
		// setRowFactory() : tableView.setItems(list); 를 실행하면 자동으로 실행되는 메소드
//		tableView.setRowFactory(new Callback<TableView<BookVO>, TableRow<BookVO>>() {
//			
//			@Override
//			public TableRow<BookVO> call(TableView<BookVO> arg0) {
//				// TODO Auto-generated method stub
//				TableRow<BookVO> row = new TableRow<>();
//				return row;
//			}
//		});
		tableView.setRowFactory(e -> {
			// TableRow(테이블의 각 행)을 만들어서 해당 행에 이벤트 처리를 설정한 다음, 해당 행을 리턴
			TableRow<BookVO> row = new TableRow<>(); // TableRow 생성해서 행을 만듦
			// 해당 행에 이벤트 처리 설정하기
			row.setOnMouseClicked(e1 -> {
				// 해당 행을 클릭했을 때 실행되는 부분
				deleteBtn.setDisable(false); // false니까 삭제 버튼 활성화
				// 내가 어떤 행을 클릭했는지 확인하기 위해서
				BookVO book = row.getItem(); // 현재 row의 데이터를 갖고 있는 VO 리턴
				// 선택한 책의 ISBN 번호를 얻어야 한다.
//				System.out.println(book.getBtitle());
				deleteISBN = book.getBisbn();
			});
			
			// 해당 행 리턴하기
			return row;
		});

		flowPane.getChildren().add(textField);
		flowPane.getChildren().add(deleteBtn);
		
		root.setCenter(tableView);
		root.setBottom(flowPane);
		
		Scene scene = new Scene(root);
		
		primaryStage.setScene(scene);
		primaryStage.setTitle("Simple JavaFX Table View");

		// 창을 닫을 때 실행할 내용
		primaryStage.setOnCloseRequest(e -> {
//			System.out.println("창 닫힘");
		});
		
		primaryStage.show();
		
	}

	public static void main(String[] args) {
		// JavaFX 실행
		launch();
	}
}
