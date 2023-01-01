package MVC.Controller;

import MVC.Service.BookService;
import MVC.VO.BookVO;
import javafx.collections.ObservableList;

public class BookSearchController {

	public ObservableList<BookVO> getResult(String searchKeyword) {
		// TODO Auto-generated method stub
		BookService service = new BookService();
		ObservableList<BookVO> list = service.selectBooks(searchKeyword);
		return list;
	}

}
