package MVC.Controller;

import MVC.Service.BookService;
import MVC.VO.BookVO;
import javafx.collections.ObservableList;

public class BookSearchController {

	public ObservableList<BookVO> searchBook(String searchCategory, String searchWord) {
		BookService bookService = new BookService();
		ObservableList<BookVO> list = bookService.searchBook_mybatis(searchCategory, searchWord);
		return list;
	}

}
