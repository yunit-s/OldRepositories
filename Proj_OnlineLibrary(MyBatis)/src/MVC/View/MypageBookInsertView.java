package MVC.View;

import java.time.LocalDate;

import MVC.Controller.InsertBookController;
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

public class MypageBookInsertView {

	Stage getRootStage() {

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
		Button insertButton;
		
//		ModifyBookInfoController modifyBookInfoController;
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
		insertButton = new Button();
		
//		modifyBookInfoController = new ModifyBookInfoController();
//		book = modifyBookInfoController.getBookOneFromBookDBByBisbn(selectedBookIsbn);
		book = new BookVO(null, null, null, 0, 0, null, null, null, null, null, null);
		
		
		
		
		// View -----

		// Components
		bisbnLabel.setText("ISBN");
		bisbnLabel.setPrefSize(80, 30);
		bisbnLabel.setAlignment(Pos.CENTER_RIGHT);
		bisbnTextField.setText("1234-1234-4321");
		bisbnTextField.setPrefSize(250, 30);
		
		btitleLabel.setText("제목");
		btitleLabel.setPrefSize(80, 30);
		btitleLabel.setAlignment(Pos.CENTER_RIGHT);
		btitleTextField.setText("책 이름 어떻게 지으면 좋을까");
		btitleTextField.setPrefSize(250, 30);
		
		bdateLabel.setText("출판일");
		bdateLabel.setPrefSize(80, 30);
		bdateLabel.setAlignment(Pos.CENTER_RIGHT);
		bdateTextField.setText(String.valueOf(LocalDate.now()));
		bdateTextField.setPrefSize(250, 30);
		
		bpageLabel.setText("쪽수");
		bpageLabel.setPrefSize(80, 30);
		bpageLabel.setAlignment(Pos.CENTER_RIGHT);
		bpageTextField.setText("999");
		bpageTextField.setPrefSize(250, 30);
		
		bpriceLabel.setText("가격");
		bpriceLabel.setPrefSize(80, 30);
		bpriceLabel.setAlignment(Pos.CENTER_RIGHT);
		bpriceTextField.setText("99999");
		bpriceTextField.setPrefSize(250, 30);
		
		bauthorLabel.setText("저자");
		bauthorLabel.setPrefSize(80, 30);
		bauthorLabel.setAlignment(Pos.CENTER_RIGHT);
		bauthorTextField.setText("yunit");
		bauthorTextField.setPrefSize(250, 30);
		
		bpublisherLabel.setText("출판사");
		bpublisherLabel.setPrefSize(80, 30);
		bpublisherLabel.setAlignment(Pos.CENTER_RIGHT);
		bpublisherTextField.setText("한국도서관");
		bpublisherTextField.setPrefSize(250, 30);
		
		bimgurlLabel.setText("이미지 url");
		bimgurlLabel.setPrefSize(80, 30);
		bimgurlLabel.setAlignment(Pos.CENTER_RIGHT);
		bimgurlTextField.setText("https://www.유알엘.com/bimgurl");
		bimgurlTextField.setPrefSize(250, 30);
		
		bimgbase64Label.setText("이미지 변환");
		bimgbase64Label.setPrefSize(80, 30);
		bimgbase64Label.setAlignment(Pos.CENTER_RIGHT);
		bimgbase64TextField.setText("https://www.유알엘.com/bimgbase64");
		bimgbase64TextField.setPrefSize(250, 30);
		
		bborrowableLabel.setText("대출 가능 여부");
		bborrowableLabel.setPrefSize(80, 30);
		bborrowableLabel.setAlignment(Pos.CENTER_RIGHT);
		bborrowableTextField.setText("o");
		bborrowableTextField.setPrefSize(250, 30);
		
		breturndateLabel.setText("반납 기한");
		breturndateLabel.setPrefSize(80, 30);
		breturndateLabel.setAlignment(Pos.CENTER_RIGHT);
//		breturndateTextField.setText(String.valueOf(LocalDate.now().plusDays(7)));
		breturndateTextField.setPrefSize(250, 30);
		
		insertButton.setText("도서 추가");
		insertButton.setPrefSize(100, 30);
		insertButton.setOnAction(e -> {
			System.out.println("@@ 도서 추가");
			InsertBookController controller = new InsertBookController();
			if (controller.getBookOneFromBookDBByBisbn(bisbnTextField.getText()) == null) {
				System.out.println("@@ 도서 추가 완료");
				
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
				int rows = controller.insertBookOneToBookDB(newBook);
//			} else {
//				// 아이디가 이미 존재할 시
//				System.out.println("@@ 도서 추가 실패. isbn 중복");
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
		rootPane.add(insertButton, 1, 11);
		rootPane.setHalignment(insertButton, HPos.RIGHT);
		
		scene = new Scene(rootPane);
		primaryStage.setTitle("도서 추가");
		primaryStage.setScene(scene);
//		primaryStage.setOnCloseRequest(e -> {
//			System.out.println("@@ 회원 수정 창 닫힘 1");
//		});
		
		return primaryStage;
	}
	
}
