package MVC.View;

import MVC.Controller.ModifyBookInfoController;
import MVC.VO.BookVO;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class MypageBookModifyView {

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
		Button modifyButton;
		
		ModifyBookInfoController modifyBookInfoController;
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
		modifyButton = new Button();
		
		modifyBookInfoController = new ModifyBookInfoController();
		book = modifyBookInfoController.getBookOneFromBookDBByBisbn(selectedBookIsbn);
		
		
		
		
		
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
		
		bdateLabel.setText("출판일");
		bdateLabel.setPrefSize(80, 30);
		bdateLabel.setAlignment(Pos.CENTER_RIGHT);
		bdateTextField.setText(book.getBdate());
		bdateTextField.setPrefSize(250, 30);
		
		bpageLabel.setText("쪽수");
		bpageLabel.setPrefSize(80, 30);
		bpageLabel.setAlignment(Pos.CENTER_RIGHT);
		bpageTextField.setText(String.valueOf(book.getBpage()));
		bpageTextField.setPrefSize(250, 30);
		
		bpriceLabel.setText("가격");
		bpriceLabel.setPrefSize(80, 30);
		bpriceLabel.setAlignment(Pos.CENTER_RIGHT);
		bpriceTextField.setText(String.valueOf(book.getBprice()));
		bpriceTextField.setPrefSize(250, 30);
		
		bauthorLabel.setText("저자");
		bauthorLabel.setPrefSize(80, 30);
		bauthorLabel.setAlignment(Pos.CENTER_RIGHT);
		bauthorTextField.setText(book.getBauthor());
		bauthorTextField.setPrefSize(250, 30);
		
		bpublisherLabel.setText("출판사");
		bpublisherLabel.setPrefSize(80, 30);
		bpublisherLabel.setAlignment(Pos.CENTER_RIGHT);
		bpublisherTextField.setText(book.getBpublisher());
		bpublisherTextField.setPrefSize(250, 30);
		
		bimgurlLabel.setText("이미지 url");
		bimgurlLabel.setPrefSize(80, 30);
		bimgurlLabel.setAlignment(Pos.CENTER_RIGHT);
		bimgurlTextField.setText(book.getBimgurl());
		bimgurlTextField.setPrefSize(250, 30);
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
		
		breturndateLabel.setText("반납 기한");
		breturndateLabel.setPrefSize(80, 30);
		breturndateLabel.setAlignment(Pos.CENTER_RIGHT);
		breturndateTextField.setText(book.getBreturndate());
		breturndateTextField.setPrefSize(250, 30);
		
		modifyButton.setText("수정");
		modifyButton.setPrefSize(100, 30);
		modifyButton.setOnAction(e -> {
			System.out.println("@@ 도서 정보 수정");
			ModifyBookInfoController controller = new ModifyBookInfoController();
			if (controller.getBookOneFromBookDBByBisbn(bisbnTextField.getText()) != null) {
				System.out.println("@@ 도서 정보 수정 완료");
				
				String bisbn = bisbnTextField.getText();
				String btitle = btitleTextField.getText();
				String bdate = bdateTextField.getText();
				int bpage = Integer.parseInt(bpageTextField.getText());
				int bprice = Integer.parseInt(bpriceTextField.getText());
				String bauthor = bauthorTextField.getText();
				String bpublisher = bpublisherTextField.getText();
				String bimgurl = bimgurlTextField.getText();
				String bimgbase64 = bimgbase64TextField.getText();
				String bborrowable = bborrowableTextField.getText();
				String breturndate = breturndateTextField.getText();
				if (breturndate == "") breturndate = null;
				BookVO newBook = new BookVO(bisbn, btitle, bdate, bpage, bprice, bauthor, bpublisher, bimgurl, bimgbase64, bborrowable, breturndate);
				int rows = controller.editBookOneFromBookDB(newBook);
			} else {
				// 아이디 검색 실패 시
				System.out.println("@@ 도서 정보 수정 실패. isbn 불일치");
			}
			
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
		rootPane.add(modifyButton, 1, 11);
		rootPane.setHalignment(modifyButton, HPos.RIGHT);
		
		scene = new Scene(rootPane);
		primaryStage.setTitle("도서 수정");
		primaryStage.setScene(scene);
//		primaryStage.setOnCloseRequest(e -> {
//			System.out.println("@@ 회원 수정 창 닫힘 1");
//		});
		
		return primaryStage;
	}
	
}
