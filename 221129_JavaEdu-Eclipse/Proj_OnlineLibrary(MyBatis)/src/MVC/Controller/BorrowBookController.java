package MVC.Controller;

import java.time.LocalDate;

import MVC.Service.BookService;
import MVC.Service.BorrBookService;
import MVC.VO.BookVO;
import MVC.VO.BorrBookVO;
import MVC.VO.UserVO;
import javafx.collections.ObservableList;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;

public class BorrowBookController {

	public int borrowBookOneFromBookDBByBisbn(String selectedBookBisbn, UserVO user) {
		// book 데이터베이스에 대여 기록 남기기
		BookService bookService = new BookService();
		ObservableList<BookVO> list = bookService.searchBook_mybatis("bisbn", selectedBookBisbn);
		BookVO book = list.get(0);
		int rows = bookService.setBorrowedBookOneByBisbn_mybatis(book);
		
		// BookVO를 토대로 BorrBookVO를 생성하고, borrbook데이터베이스에 추가
		LocalDate now = LocalDate.now();
		BorrBookVO borrBook = new BorrBookVO(book.getBisbn(), book.getBtitle(), user.getId(), now.toString(), now.plusDays(7).toString());
		BorrBookService borrBookService = new BorrBookService();
		rows = borrBookService.insertBookOneByBorrBookVO_mybatis(borrBook);
		
		// 안내 메시지 출력
		StringBuffer dialogMsg = new StringBuffer();
		dialogMsg.append("- 도서 대출 완료 -");
		dialogMsg.append("\n도서 제목 : " + book.getBtitle());
		dialogMsg.append("\n도서 저자 : " + book.getBauthor());
		dialogMsg.append("\n반납 기한 : " + borrBook.getReturndate());
		Dialog<String> dialog = new Dialog<String>();
        dialog.setTitle("도서 대출");
        ButtonType typeOk= new ButtonType("확인", ButtonData.OK_DONE);
	    dialog.setContentText(dialogMsg.toString());
	    dialog.getDialogPane().getButtonTypes().add(typeOk);
	    dialog.showAndWait();
	    
		return rows;
	}

}
