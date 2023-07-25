package MVC.View;

import MVC.Controller.BookSearchController;
import MVC.VO.BookVO;
import javafx.collections.ObservableList;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class BookVODetailView {

	Stage getRootStage(String selectedBookIsbn) {

		// Declare variables -----
		
		// Layout
		Stage primaryStage;
		Scene scene;

		GridPane rootPane;

		// Components
		Label bisbnLabel;
		TextField bisbnTextField;
		Label btitleLabel;
		TextField btitleTextField;
		Label bdateLabel;
		TextField bdateTextField;
		Label bpageLabel;
		TextField bpageTextField;
		Label bpriceLabel;
		TextField bpriceTextField;
		Label bauthorLabel;
		TextField bauthorTextField;
		Label bpublisherLabel;
		TextField bpublisherTextField;
		Label bimgurlLabel;
		TextField bimgurlTextField;
		Label bimgbase64Label;
		TextField bimgbase64TextField;
		Label bborrowableLabel;
		TextField bborrowableTextField;
		Label breturndateLabel;
		TextField breturndateTextField;
		Button okButton;
		
		BookSearchController bookSearchController;
		ObservableList<BookVO> tmplist;
		BookVO book;
		
		
		
		
		
		// Initialize -----
		
		// Layout
		primaryStage = new Stage();
		scene = null;

		rootPane = new GridPane();

		// Components
		bisbnLabel = new Label();
		bisbnTextField = new TextField();
		btitleLabel = new Label();
		btitleTextField = new TextField();
		bdateLabel = new Label();
		bdateTextField = new TextField();
		bpageLabel = new Label();
		bpageTextField = new TextField();
		bpriceLabel = new Label();
		bpriceTextField = new TextField();
		bauthorLabel = new Label();
		bauthorTextField = new TextField();
		bpublisherLabel = new Label();
		bpublisherTextField = new TextField();
		bimgurlLabel = new Label();
		bimgurlTextField = new TextField();
		bimgbase64Label = new Label();
		bimgbase64TextField = new TextField();
		bborrowableLabel = new Label();
		bborrowableTextField = new TextField();
		breturndateLabel = new Label();
		breturndateTextField = new TextField();
		okButton = new Button();
		
		bookSearchController = new BookSearchController();
		tmplist = bookSearchController.searchBook("bisbn", selectedBookIsbn);
		book = tmplist.get(0);
		
		
		
		
		
		// View -----

		// Components
		bisbnLabel.setText("ISBN");
		bisbnLabel.setPrefSize(80, 30);
		bisbnLabel.setAlignment(Pos.CENTER_RIGHT);
		bisbnTextField.setText(book.getBisbn());
		bisbnTextField.setPrefSize(250, 30);
		bisbnTextField.setDisable(true);
		
		btitleLabel.setText("제목");
		btitleLabel.setPrefSize(80, 30);
		btitleLabel.setAlignment(Pos.CENTER_RIGHT);
		btitleTextField.setText(book.getBtitle());
		btitleTextField.setPrefSize(250, 30);
		btitleTextField.setDisable(true);
		
		bdateLabel.setText("출판일");
		bdateLabel.setPrefSize(80, 30);
		bdateLabel.setAlignment(Pos.CENTER_RIGHT);
		bdateTextField.setText(book.getBdate());
		bdateTextField.setPrefSize(250, 30);
		bdateTextField.setDisable(true);
		
		bpageLabel.setText("쪽수");
		bpageLabel.setPrefSize(80, 30);
		bpageLabel.setAlignment(Pos.CENTER_RIGHT);
		bpageTextField.setText(String.valueOf(book.getBpage()));
		bpageTextField.setPrefSize(250, 30);
		bpageTextField.setDisable(true);
		
		bpriceLabel.setText("가격");
		bpriceLabel.setPrefSize(80, 30);
		bpriceLabel.setAlignment(Pos.CENTER_RIGHT);
		bpriceTextField.setText(String.valueOf(book.getBprice()));
		bpriceTextField.setPrefSize(250, 30);
		bpriceTextField.setDisable(true);
		
		bauthorLabel.setText("저자");
		bauthorLabel.setPrefSize(80, 30);
		bauthorLabel.setAlignment(Pos.CENTER_RIGHT);
		bauthorTextField.setText(book.getBauthor());
		bauthorTextField.setPrefSize(250, 30);
		bauthorTextField.setDisable(true);
		
		bpublisherLabel.setText("출판사");
		bpublisherLabel.setPrefSize(80, 30);
		bpublisherLabel.setAlignment(Pos.CENTER_RIGHT);
		bpublisherTextField.setText(book.getBpublisher());
		bpublisherTextField.setPrefSize(250, 30);
		bpublisherTextField.setDisable(true);
		
		bimgurlLabel.setText("이미지 url");
		bimgurlLabel.setPrefSize(80, 30);
		bimgurlLabel.setAlignment(Pos.CENTER_RIGHT);
		bimgurlTextField.setText(book.getBimgurl());
		bimgurlTextField.setPrefSize(250, 30);
		bimgurlTextField.setDisable(true);
		bimgurlTextField.setDisable(true);
		
		bimgbase64Label.setText("이미지 변환");
		bimgbase64Label.setPrefSize(80, 30);
		bimgbase64Label.setAlignment(Pos.CENTER_RIGHT);
		bimgbase64TextField.setText(book.getBimgbase64());
		bimgbase64TextField.setPrefSize(250, 30);
		bimgbase64TextField.setDisable(true);
		
		bborrowableLabel.setText("대출 가능 여부");
		bborrowableLabel.setPrefSize(80, 30);
		bborrowableLabel.setAlignment(Pos.CENTER_RIGHT);
		bborrowableTextField.setText(book.getBborrowable());
		bborrowableTextField.setPrefSize(250, 30);
		bborrowableTextField.setDisable(true);
		
		breturndateLabel.setText("반납 기한");
		breturndateLabel.setPrefSize(80, 30);
		breturndateLabel.setAlignment(Pos.CENTER_RIGHT);
		breturndateTextField.setText(book.getBreturndate());
		breturndateTextField.setPrefSize(250, 30);
		breturndateTextField.setDisable(true);
		
		okButton.setText("확인");
		okButton.setPrefSize(100, 30);
		okButton.setOnAction(e -> {
			System.out.println("@@ 도서 상세정보 확인");
			primaryStage.close();
		});

		// Layout
		rootPane.setAlignment(Pos.CENTER);
		rootPane.setHgap(10);
		rootPane.setVgap(10);
		rootPane.setPadding(new Insets(30));
		rootPane.add(bisbnLabel, 0, 0);
		rootPane.add(bisbnTextField, 1, 0);
		rootPane.add(btitleLabel, 0, 1);
		rootPane.add(btitleTextField, 1, 1);
		rootPane.add(bdateLabel, 0, 2);
		rootPane.add(bdateTextField, 1, 2);
		rootPane.add(bpageLabel, 0, 3);
		rootPane.add(bpageTextField, 1, 3);
		rootPane.add(bpriceLabel, 0, 4);
		rootPane.add(bpriceTextField, 1, 4);
		rootPane.add(bauthorLabel, 0, 5);
		rootPane.add(bauthorTextField, 1, 5);
		rootPane.add(bpublisherLabel, 0, 6);
		rootPane.add(bpublisherTextField, 1, 6);
		rootPane.add(bimgurlLabel, 0, 7);
		rootPane.add(bimgurlTextField, 1, 7);
		rootPane.add(bimgbase64Label, 0, 8);
		rootPane.add(bimgbase64TextField, 1, 8);
		rootPane.add(bborrowableLabel, 0, 9);
		rootPane.add(bborrowableTextField, 1, 9);
		rootPane.add(breturndateLabel, 0, 10);
		rootPane.add(breturndateTextField, 1, 10);
		rootPane.add(okButton, 1, 11);
		rootPane.setHalignment(okButton, HPos.RIGHT);
		
		scene = new Scene(rootPane);
		primaryStage.setTitle("도서 상세 정보");
		primaryStage.setScene(scene);
//		primaryStage.setOnCloseRequest(e -> {
//			System.out.println("@@ 회원 수정 창 닫힘 1");
//		});
		
		return primaryStage;
	}
	
}
