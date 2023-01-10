package MVC.Controller;

import MVC.Service.BookService;
import MVC.Service.BorrBookService;
import MVC.Service.UserService;
import MVC.VO.BorrBookVO;
import MVC.VO.UserVO;

public class ReturnBookController {

	public int returnBookOneFromBorrBookDBByBisbn(String selectedBookBisbn, UserVO user) {
		
		// 반납 시기에 따른 포인트 변경
		BorrBookService borrBookService = new BorrBookService();
		String returndate = borrBookService.getReturndateOneByBisbn(selectedBookBisbn);
		UserService userService = new UserService();
		int rows = userService.changePointToUserByReturndate(user, returndate);
		
		// borrbook 데이터베이스에서 반납 도서 삭제
		rows = borrBookService.deleteBookOneByBisbn(selectedBookBisbn);
		
		// book 데이터베이스에서 반납 반영
		BookService bookService = new BookService();
		rows = bookService.setReturnedBookOneByBisbn(selectedBookBisbn);
		
		return rows;
	}

}
