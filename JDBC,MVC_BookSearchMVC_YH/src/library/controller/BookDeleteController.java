package library.controller;

import javafx.collections.ObservableList;
import library.service.BookService;
import library.vo.BookVO;

public class BookDeleteController {

	public ObservableList<BookVO> deleteBookByIsbn(String isbnOfSelectedBook, String searchKeyword) {
		// TODO Auto-generated method stub
		// bookservice 에서 삭제 메소드 실행
		// 그 결과를 list로 받아옴.
		// 받아온 list 리턴
		BookService service = new BookService();
		ObservableList<BookVO> list = service.deleteBook(isbnOfSelectedBook, searchKeyword);
		return list;
	}

}
