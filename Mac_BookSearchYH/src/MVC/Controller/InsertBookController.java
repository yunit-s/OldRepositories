package MVC.Controller;

import MVC.Service.BookService;
import MVC.VO.BookVO;
import javafx.collections.ObservableList;

public class InsertBookController {

	public BookVO getBookOneFromBookDBByBisbn(String searchWord) {
		BookService bookService = new BookService();
		ObservableList<BookVO> list = bookService.searchBook("bisbn", searchWord);
		if (list.isEmpty()) {
			return null;	
		} else {
			return list.get(0);
		}
	}

	public int insertBookOneToBookDB(BookVO newBook) {
		BookService bookService = new BookService();
		int rows = bookService.insertBookOneByBookVO(newBook);
		return rows;
	}

}
