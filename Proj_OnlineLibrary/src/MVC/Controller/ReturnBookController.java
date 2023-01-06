package MVC.Controller;

import MVC.Service.BookService;
import MVC.Service.BorrBookService;
import MVC.VO.BorrBookVO;
import MVC.VO.UserVO;

public class ReturnBookController {

	public int returnBookOneFromBorrBookDBByBisbn(String selectedBookBisbn, UserVO user) {
		BorrBookService borrBookService = new BorrBookService();
		int rows = borrBookService.deleteBookOneByBisbn(selectedBookBisbn);
		
		BookService bookService = new BookService();
		rows = bookService.setReturnedBookOneByBisbn(selectedBookBisbn);
		
		return rows;
	}

}
