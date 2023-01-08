package MVC.Controller;

import java.time.LocalDate;

import MVC.Service.BookService;
import MVC.Service.BorrBookService;
import MVC.VO.BookVO;
import MVC.VO.BorrBookVO;
import MVC.VO.UserVO;
import javafx.collections.ObservableList;

public class BorrowBookController {

	public int borrowBookOneFromBookDBByBisbn(String selectedBookBisbn, UserVO user) {
		BookService bookService = new BookService();
		int rows = bookService.setBorrowedBookOneByBisbn(selectedBookBisbn);
		ObservableList<BookVO> list = bookService.searchBook("bisbn", selectedBookBisbn);
		
		// BookVO 를 BorrBookVO 로 변경
		BookVO book = list.get(0);
		LocalDate now = LocalDate.now();
		BorrBookVO borrBook = new BorrBookVO(book.getBisbn(), book.getBtitle(), user.getId(), now.toString(), now.plusDays(7).toString());
		
		BorrBookService borrBookService = new BorrBookService();
		rows = borrBookService.insertBookOneByBorrBookVO(borrBook);
		return rows;
	}

}
