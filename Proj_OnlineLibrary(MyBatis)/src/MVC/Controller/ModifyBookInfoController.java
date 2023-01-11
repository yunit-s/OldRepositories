package MVC.Controller;

import MVC.Service.BookService;
import MVC.VO.BookVO;
import javafx.collections.ObservableList;

public class ModifyBookInfoController {

	public BookVO getBookOneFromBookDBByBisbn(String searchWord) {
		BookService bookService = new BookService();
		ObservableList<BookVO> list = bookService.searchBook_mybatis("bisbn", searchWord);
		return list.get(0);
	}

	public int editBookOneFromBookDB(BookVO book) {
		BookService bookService = new BookService();
		int rows = bookService.editBookOneByBookVO_mybatis(book);
		return rows;
	}
	
}
