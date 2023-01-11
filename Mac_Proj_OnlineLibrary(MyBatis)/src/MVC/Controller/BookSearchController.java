package MVC.Controller;

import MVC.Service.BookService;
import MVC.VO.BookVO;
import javafx.collections.ObservableList;

public class BookSearchController {

	public ObservableList<BookVO> searchBook(String searchCategory, String searchWord) {
		// service 생성
		// service의 searchBook 호출
		// 리턴받은 list 리턴

		BookService bookService = new BookService();
		ObservableList<BookVO> list = bookService.searchBook_mybatis(searchCategory, searchWord);
		return list;
	}

}
