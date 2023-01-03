package MVC.Controller;

import MVC.Service.BookService;
import MVC.VO.BookVO;
import javafx.collections.ObservableList;

public class BookSearchController {

	public ObservableList<BookVO> searchBook(String searchCategory, String searchWord) {
		// TODO Auto-generated method stub
		
		// service 생성
		// service의 searchBook 호출
		// 리턴받은 list 리턴

		System.out.println("@@ check3 " + searchCategory + searchWord);
		BookService bookService = new BookService();
		ObservableList<BookVO> list = bookService.searchBook(searchCategory, searchWord);
		return list;
	}

}
