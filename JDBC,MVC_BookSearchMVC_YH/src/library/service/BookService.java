package library.service;

import javafx.collections.ObservableList;
import library.dao.BookDAO;
import library.vo.BookVO;

public class BookService {

	public ObservableList<BookVO> selectBooks(String searchKeyword) {
		// TODO Auto-generated method stub
		
		// dao에 키워드 전달
		// list 리턴받고
		// 그 리스트를 또 리턴하고
		BookDAO dao = new BookDAO();
		ObservableList<BookVO> list = dao.select(searchKeyword);
		return list;
	}

	public ObservableList<BookVO> deleteBook(String isbnOfSelectedBook, String searchKeyword) {
		// TODO Auto-generated method stub
		
		// dao 생성
		// dao에 isbn 넘기면서 삭제 메소드 실행
		// 검색했던 키워드 그대로 재검색해서 결과물 list를 리턴
		BookDAO dao = new BookDAO();
		int rows = dao.delete(isbnOfSelectedBook);
		System.out.println("@@ deleteBook rows = " + rows);
		ObservableList<BookVO> list = dao.select(searchKeyword);
		return list;
	}

}
