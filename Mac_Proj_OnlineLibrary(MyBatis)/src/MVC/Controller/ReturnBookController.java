package MVC.Controller;

import MVC.Service.BookService;
import MVC.Service.BorrBookService;
import MVC.Service.UserService;
import MVC.VO.BookVO;
import MVC.VO.BorrBookVO;
import MVC.VO.UserVO;
import javafx.collections.ObservableList;

public class ReturnBookController {

	public int returnBookOneFromBorrBookDBByBisbn(String selectedBookBisbn, UserVO user) {
		
		// 책 정보 받아오기
		BookService bookService = new BookService();
		ObservableList<BookVO> list = bookService.searchBook_mybatis("bisbn", selectedBookBisbn);
		BookVO book = list.get(0);
		
		// 반납 시기에 따른 포인트 변경
		BorrBookService borrBookService = new BorrBookService();
		String returndate = borrBookService.getReturndateOneByBisbn_mybatis(selectedBookBisbn);
		UserService userService = new UserService();
		int rows = userService.changePointToUserByReturndate_mybatis(user, returndate);
		
		// borrbook 데이터베이스에서 반납 도서 삭제
		rows = borrBookService.deleteBookOneByBisbn_mybatis(selectedBookBisbn);
		
		// book 데이터베이스에서 반납 반영
		rows = bookService.setReturnedBookOneByBisbn_mybatis(book);
		
		return rows;
		
//		// 반납 시기에 따른 포인트 변경
//		BorrBookService borrBookService = new BorrBookService();
//		String returndate = borrBookService.getReturndateOneByBisbn(selectedBookBisbn);
//		UserService userService = new UserService();
//		int rows = userService.changePointToUserByReturndate_mybatis(user, returndate);
//		
//		// borrbook 데이터베이스에서 반납 도서 삭제
//		rows = borrBookService.deleteBookOneByBisbn(selectedBookBisbn);
//		
//		// book 데이터베이스에서 반납 반영
//		BookService bookService = new BookService();
//		rows = bookService.setReturnedBookOneByBisbn_mybatis(selectedBookBisbn);
//		
//		return rows;
	}
	
}
