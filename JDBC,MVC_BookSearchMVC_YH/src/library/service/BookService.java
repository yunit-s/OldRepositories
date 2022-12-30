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

}
