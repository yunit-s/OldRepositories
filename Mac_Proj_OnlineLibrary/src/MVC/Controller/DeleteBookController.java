package MVC.Controller;

import MVC.Service.BookService;

public class DeleteBookController {

	public int deleteBookOneFromBookDBByBisbn(String selectedBookBisbn) {
		
		BookService bookService = new BookService();
		int rows = bookService.deteleBookOneByBisbn(selectedBookBisbn);
		return rows;
	}

}
