package library.controller;

import javafx.collections.ObservableList;
import library.service.BookService;
import library.vo.BookVO;

public class BookSearchController {

	public ObservableList<BookVO> getResult(String searchKeyword) {
		// TODO Auto-generated method stub
		BookService service = new BookService();
		ObservableList<BookVO> list = service.selectBooks(searchKeyword);
		return list;
	}

}
