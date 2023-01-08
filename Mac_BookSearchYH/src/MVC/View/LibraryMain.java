package MVC.View;

import java.sql.SQLException;

import org.apache.commons.dbcp2.BasicDataSource;

import MVC.Controller.BookSearchController;
import MVC.Controller.LoginController;
import MVC.DAO.DBCP_Apache;
import MVC.VO.BookVO;
import MVC.VO.ShareVO;
import MVC.VO.UserVO;
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class LibraryMain extends Application{

	@Override
	public void start(Stage primaryStage) throws Exception {
		
		// Declare variables -----
		
		ShareVO share;
		Scene homeScene;
		
		
		
		
		
		// Initialize -----
		
		share = new ShareVO();
		homeScene = new Scene(share.getMainPane());
		
		
		
		
		
		// View -----
		
		share.getMainPane().setPrefSize(700, 500);
		share.getMainPane().setTop(share.getHeadlineView().getRootPane(share));
//		share.getMainPane().setCenter(share.getLoginView().getRootPane(share));
		share.getMainPane().setCenter(share.getBookSearchView().getRootPane(share));
		
		
		
		primaryStage.setScene(homeScene);
		primaryStage.setTitle("Online Library");
		primaryStage.setOnCloseRequest(e -> {
			// close connection pool
			System.out.println("@@ primary stage 종료");
			try {
				((BasicDataSource)DBCP_Apache.getDataSource()).close();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			System.out.println("@@ connection pool 할당해제");
		});
		primaryStage.show();
		

	
	
	
	
	
//	// JavaFX main view components
//	Stage Window;
//	Scene homeScene, loginScene;
//
//	
//	// Scene Login
//	BorderPane scnLoginMainLayout;
//	BorderPane scnLoginTopLayout;
//	VBox scnLoginCenterLayout;
//	HBox loginIdLayout;
//	HBox loginPwLayout;
//	
//	Button scnLoginGoToHome;
//	Label scnLoginUsernameLabel;
//	
//	Label loginIdLabel;
//	TextField loginIdTextField;
//	Label loginPwLabel;
//	PasswordField loginPwPwField;
//	Button scnLoginLoginButton;
//	
//	
//	
//	
//	
//	// Scene Home
//	BorderPane scnHomeMainLayout;
//	BorderPane scnHomeTopLayout;
//	BorderPane scnHomeCenterLayout;
//	FlowPane scnHomeCenterTopLayout;
//	FlowPane scnHoneBottomLayout;
//	
//	Button scnHomeGoToHome;
//	Label scnHomeUsernameLabel;
//	Button scnHomeLogoutButton;
//	
//	TextField topleftTextField;
//	
//	TableView<BookVO> tableView;
//	TextField searchCategoryTextField;
//	TextField searchWordTextField;
//	Button searchButton;
//
//
//	
//	TextField testTextField1;
//	TextField testTextField2;
//	TextField testTextField3;
//	Button changeSceneHomeToLogin;
//	Button changeSceneLoginToHome;
//	Button testButton3;
//	
//	
//	// Business fields
//	String searchCategory;
//	String searchWord;
//	
//	UserVO user;
//	
//	@Override
//	public void start(Stage primaryStage) throws Exception {
//		
//		// TODO Auto-generated method stub
//		Window = primaryStage;
//
//		// Login Scene
//		
//		// Login Scene - top
//		
//		scnLoginGoToHome = new Button();
//		scnLoginGoToHome.setText("go to Home");
//		scnLoginGoToHome.setPrefSize(100, 30);
//		
//		scnLoginUsernameLabel = new Label();
//		if (user != null) {
//			scnLoginUsernameLabel.setText(user.getNickname() + " 님");
//		} else {
//			scnLoginUsernameLabel.setText("로그인");
//		}
//		
//		
//		
//		// Login Scene - center
//		
//		loginIdLabel = new Label();
//		loginIdLabel.setText("아이디");
//		loginIdLabel.setPrefSize(60, 30);
//		loginIdLabel.setAlignment(Pos.CENTER_RIGHT);
//		
//		loginIdTextField = new TextField();
//		loginIdTextField.setText("admin");
//		loginIdTextField.setPrefSize(130, 30);
//		
//		loginPwLabel = new Label();
//		loginPwLabel.setText("비밀번호");
//		loginPwLabel.setPrefSize(60, 30);
//		loginPwLabel.setAlignment(Pos.CENTER_RIGHT);
//		
//		loginPwPwField = new PasswordField();
//		loginPwPwField.setText("qwer1234");
//		loginPwPwField.setPrefSize(130, 30);
//		
//		scnLoginLoginButton = new Button();
//		scnLoginLoginButton.setText("Login");
//		scnLoginLoginButton.setPrefSize(200, 30);
//		scnLoginLoginButton.setOnAction(e -> {
//			// ID, PW 확인하기
//			String id = loginIdTextField.getText();
//			String pw = loginPwPwField.getText();
//			System.out.println("@@ 로그인 시도. id = " + id + ", pw = " + pw);
//			
//			LoginController controller = new LoginController();
//			if (controller.tryLogin(id, pw) == true) {
//				// 로그인 성공 시
//				System.out.println("@@ 로그인 성공");
//				user = new UserVO(id, "관리자", pw);
//				Window.setScene(homeScene);
//				
//			} else {
//				// 로그인 실패 시
//				System.out.println("@@ 로그인 실패");
//			}
//			
//		});
//
//		
//		
//		// Login Scene - bottom
//		
//		changeSceneLoginToHome = new Button();
//		changeSceneLoginToHome.setText("temp button");
//		changeSceneLoginToHome.setPrefSize(200, 30);
//		changeSceneLoginToHome.setOnAction(e -> {
//
//		});
//
//		
//		
//		// Login Scene - layout
//		
//		loginIdLayout = new HBox();
//		loginIdLayout.setSpacing(10);
//		loginIdLayout.setAlignment(Pos.BASELINE_CENTER);
//		loginIdLayout.getChildren().add(loginIdLabel);
//		loginIdLayout.getChildren().add(loginIdTextField);
//		
//		loginPwLayout = new HBox();
//		loginPwLayout.setSpacing(10);
//		loginPwLayout.setAlignment(Pos.CENTER);
//		loginPwLayout.getChildren().add(loginPwLabel);
//		loginPwLayout.getChildren().add(loginPwPwField);
//
//		scnLoginTopLayout = new BorderPane();
//		scnLoginTopLayout.setPadding(new Insets(5));
//		scnLoginTopLayout.setLeft(scnLoginGoToHome);
//		scnLoginTopLayout.setRight(scnLoginUsernameLabel);
//		
//		scnLoginCenterLayout = new VBox();
//		scnLoginCenterLayout.setAlignment(Pos.CENTER);
//		scnLoginCenterLayout.setSpacing(10);
//		scnLoginCenterLayout.getChildren().add(loginIdLayout);
//		scnLoginCenterLayout.getChildren().add(loginPwLayout);
//		scnLoginCenterLayout.getChildren().add(scnLoginLoginButton);
//		
//		scnLoginMainLayout = new BorderPane();
//		scnLoginMainLayout.setTop(scnLoginTopLayout);
//		scnLoginMainLayout.setCenter(scnLoginCenterLayout);
//		scnLoginMainLayout.setBottom(changeSceneLoginToHome);
//		
//		loginScene = new Scene(scnLoginMainLayout, 400, 300);
//		
//		
//		
//		
//		
//		// Home Scene
//		
//		// Home Scene - top
//
//		scnHomeGoToHome = new Button();
//		scnHomeGoToHome.setText("FX Online Library");
//		scnHomeGoToHome.setPrefSize(150, 30);
//		scnHomeGoToHome.setOnAction(e -> {
//			// Home scene의 첫 화면으로 scene 변경
//			System.out.println("@@ Home page");
//		});
//		
//		scnHomeUsernameLabel = new Label();
//		scnHomeUsernameLabel.setText("관리자" + " 님 ");
//		scnHomeUsernameLabel.setPrefSize(80, 30);
//		scnHomeUsernameLabel.setPadding(new Insets(10));
//		
//		scnHomeLogoutButton = new Button();
//		scnHomeLogoutButton.setText("로그아웃");
//		scnHomeLogoutButton.setPrefSize(100, 30);
//		scnHomeLogoutButton.setOnAction(e -> {
//			// 로그아웃하고, home page 로 이동
//			System.out.println("@@ 로그아웃 (scnHomeLogoutButton)");
//			Window.setScene(loginScene);
//		});
//		 
//		
//		
//		
//		
//		// Home Scene - center
//
//		searchCategoryTextField = new TextField("btitle");
//		searchCategoryTextField.setPrefSize(150, 30);
//
//		searchWordTextField = new TextField("java");
//		searchWordTextField.setPrefSize(250, 30);
//		searchWordTextField.setOnAction(e -> {
//			System.out.println("@@ search textfield 실행");
//			
//			searchCategory = searchCategoryTextField.getText();
//			searchWord = searchWordTextField.getText();
//
//			System.out.println("@@ check4 " + searchCategory + searchWord);
//			BookSearchController controller = new BookSearchController();
//			ObservableList<BookVO> list = controller.searchBook(searchCategory, searchWord);
//			tableView.setItems(list);
//		});
//		searchButton = new Button("검색");
//		searchButton.setPrefSize(50, 30);
//		searchButton.setOnAction(e -> {
//			System.out.println("@@ 검색 버튼 클릭");
//		});
//
//		// 컬럼 객체 생성
//		tableView = new TableView<BookVO>();
////		tableView.setPrefSize(700, 600);
//		TableColumn<BookVO, String> isbnColumn = new TableColumn<>("ISBN");
//		isbnColumn.setMinWidth(150);
//		isbnColumn.setCellValueFactory(new PropertyValueFactory<>("bisbn"));
//		TableColumn<BookVO, String> titleColumn = new TableColumn<>("TITLE");
//		titleColumn.setMinWidth(300);
//		titleColumn.setCellValueFactory(new PropertyValueFactory<>("btitle"));
//		TableColumn<BookVO, String> authorColumn = new TableColumn<>("AUTHOR");
//		authorColumn.setMinWidth(150);
//		authorColumn.setCellValueFactory(new PropertyValueFactory<>("bauthor"));
//		TableColumn<BookVO, Integer> priceColumn = new TableColumn<>("PRICE");
//		priceColumn.setMinWidth(150);
//		priceColumn.setCellValueFactory(new PropertyValueFactory<>("bprice"));
//		// 위에서 만든 컬럼 객체를 TableView에 붙인다.
//		tableView.getColumns().addAll(isbnColumn, titleColumn, authorColumn, priceColumn);
//		
//		tableView.setRowFactory(e -> {
//
//			TableRow<BookVO> row = new TableRow<>();
//
//			row.setOnMouseClicked(e1 -> {
//
//				if(e1.getClickCount() == 2) {
//					System.out.println("@@ 더블클릭. title = " + row.getItem().getBtitle());
//
//					Dialog<String> dialog = new Dialog<String>();
//  			        dialog.setTitle("책 세부정보");
//				    ButtonType type = new ButtonType("Ok", ButtonData.OK_DONE);
//				    dialog.setContentText(" 다이얼로그 테스트 ");
//				    dialog.getDialogPane().getButtonTypes().add(type);
//				    dialog.getDialogPane().setMinHeight(300);
//		            dialog.showAndWait();
//				} else {
//					
//					
//				}
//			});
//			
//			return row;
//		});
//
//		
//		
//
//		// Home Scene - bottom
//		
//		changeSceneHomeToLogin = new Button();
//		changeSceneHomeToLogin.setPrefSize(100, 30);
//		changeSceneHomeToLogin.setOnAction(e -> {
//			Window.setScene(loginScene);
//		});
//		
//		
//		
//		
//		// Home Scene - layout
//
//		scnHomeTopLayout = new BorderPane();
//		scnHomeTopLayout.setLeft(scnHomeGoToHome);
//		scnHomeTopLayout.setCenter(scnHomeUsernameLabel);
//		scnHomeTopLayout.setRight(scnHomeLogoutButton);
//		
//		scnHomeCenterTopLayout = new FlowPane();
//		scnHomeCenterTopLayout.setPadding(new Insets(5));
//		scnHomeCenterTopLayout.setHgap(5);
//		scnHomeCenterTopLayout.getChildren().add(searchCategoryTextField);
//		scnHomeCenterTopLayout.getChildren().add(searchWordTextField);
//		scnHomeCenterTopLayout.getChildren().add(searchButton);
//
//		scnHomeCenterLayout = new BorderPane();
//		scnHomeCenterLayout.setTop(scnHomeCenterTopLayout);
//		scnHomeCenterLayout.setCenter(tableView);
//		
//		scnHoneBottomLayout = new FlowPane();
//		scnHoneBottomLayout.setPadding(new Insets(5));
//		scnHoneBottomLayout.getChildren().add(changeSceneHomeToLogin);
//		
//		scnHomeMainLayout = new BorderPane();
//		scnHomeMainLayout.setTop(scnHomeTopLayout);
//		scnHomeMainLayout.setCenter(scnHomeCenterLayout);
//		scnHomeMainLayout.setBottom(scnHoneBottomLayout);
//		
//		homeScene = new Scene(scnHomeMainLayout);
//		
//		
//		
//		
//		
//		// stage start
//		Window.setScene(loginScene);
//		Window.setTitle("Online Library");
//		Window.setOnCloseRequest(e -> {
//			// close connection pool
//			System.out.println("@@ main stage 종료");
//			try {
//				((BasicDataSource)DBCP_Apache.getDataSource()).close();
//			} catch (SQLException e1) {
//				// TODO Auto-generated catch block
//				e1.printStackTrace();
//			}
//			System.out.println("@@ connection pool 할당해제");
//		});
//		
//		Window.show();
	}

	public static void main(String[] args) {
		launch();
	}
	
}
