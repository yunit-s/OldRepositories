package lecture.jdbc;

import java.sql.Connection;
//import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;

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
import lecture.jdbc.vo.BookVO;

public class BookSearchJavaFXConnectionPool extends Application {

	// JavaFX fields
	TableView<BookVO> tableView; 
	TextField textField;
	Button deleteBtn;
	String deleteISBN;

	// JDBC fields
	private static BasicDataSource basicDS;

	static {
		// Connection Pool 생성
		basicDS = new BasicDataSource();
		basicDS.setDriverClassName("com.mysql.cj.jdbc.Driver");
		basicDS.setUrl("jdbc:mysql://127.0.0.1:3306/library?characterEncoding=UTF-8&serverTimezone=UTC&useSSL=false&allowPublicKeyRetrieval=true");
		basicDS.setUsername("root");
		basicDS.setPassword("qwer1234");
		basicDS.setInitialSize(10);
		basicDS.setMaxTotal(20);
	}

	public static DataSource getDataSource() {
		// DataSource 는 BasicDataSource 의 상위 인터페이스 개념이다. IS-A 관계를 활용하자.
		return basicDS;
	}

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
		textField = new TextField();
		textField.setPrefSize(250, 40);
		textField.setOnAction(e -> {
			// 2. 데이터베이스 연결
			DataSource ds = getDataSource();
			Connection con = null;
			try {
				con = ds.getConnection();
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
			
			PreparedStatement pstmt = null;
			try {
			    pstmt = con.prepareStatement(sql.toString());
				pstmt.setString(1, "%" + textField.getText() + "%");
				
			    // 4. 실행
			    ResultSet rs = pstmt.executeQuery();

			    // 5. 결과처리
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
		deleteBtn.setDisable(true);
		deleteBtn.setOnAction(e -> {
			// 2. Database 접속
			DataSource ds = getDataSource();
			Connection con = null;
			try {
				con = ds.getConnection();
			} catch (SQLException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
			
			StringBuffer sql = new StringBuffer();
			sql.append("DELETE ");
			sql.append("FROM book ");
			sql.append("WHERE bisbn = ?");
			
			try {
				con.setAutoCommit(false); // transaction 시작
				
				PreparedStatement pstmt = con.prepareStatement(sql.toString());
				pstmt.setString(1, deleteISBN);
				
				int count = pstmt.executeUpdate();
				System.out.println("영향받은 row : " + count + " 줄");
				
				// transaction에 대한 결과 처리
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
			
			// 화면 갱신
			try {
				con = ds.getConnection();
				
				StringBuffer sql2 = new StringBuffer();
				sql2.append("SELECT bisbn, btitle, bauthor, bprice ");
				sql2.append("FROM book ");
				sql2.append("WHERE btitle LIKE ?");
				sql2.append("ORDER BY bprice DESC");
				
				PreparedStatement pstmt = con.prepareStatement(sql2.toString());
				pstmt.setString(1, "%" + textField.getText() + "%");
				
				ResultSet rs = pstmt.executeQuery();
				
				ObservableList<BookVO> list = FXCollections.observableArrayList();
				while (rs.next()) {
					BookVO book = new BookVO(rs.getString("bisbn"), rs.getString("btitle"), rs.getString("bauthor"), rs.getInt("bprice"));
					list.add(book);
				}
				
				tableView.setItems(list);
				
				rs.close();
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
		
		// setRowFactory() : tableView.setItems(list); 를 실행하면 자동으로 실행되는 메소드
		tableView.setRowFactory(e -> {
			// TableRow(테이블의 각 행)을 만들어서 해당 행에 이벤트 처리를 설정한 다음, 해당 행을 리턴
			TableRow<BookVO> row = new TableRow<>(); // TableRow 생성해서 행을 만듦
			row.setOnMouseClicked(e1 -> {
				deleteBtn.setDisable(false);
				// 내가 어떤 행을 클릭했는지 확인하기 위해서
				BookVO book = row.getItem(); // 현재 row의 데이터를 갖고 있는 VO 리턴
				// 선택한 책의 ISBN 번호를 얻어야 한다.
				deleteISBN = book.getBisbn();
			});
			return row; // 해당 행 리턴하기
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
			// 프로그램이 종료될 때, Connection Pool 자체도 종료시켜서 연결을 모두 끊어줘야 한다.
			try {
				((BasicDataSource)getDataSource()).close();
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
