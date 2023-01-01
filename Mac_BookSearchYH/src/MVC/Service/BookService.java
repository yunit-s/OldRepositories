package MVC.Service;

import MVC.DAO.BookDAO;
import MVC.VO.BookVO;
import javafx.collections.ObservableList;

public class BookService {

	public ObservableList<BookVO> selectBooks(String searchKeyword) {
		// TODO Auto-generated method stub
		System.out.println("@@ Bookservice selectBooks");
		
		// BookDAO 의 select() 를 호출해서 리스트 정보 획득
		// 그 리스트를 리턴해주기
		BookDAO dao = new BookDAO();
		ObservableList<BookVO> list = dao.select(searchKeyword);
		return list;
	}

}
