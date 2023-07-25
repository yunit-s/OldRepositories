package MVC.DAO;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import MVC.VO.BookVO;
import MVC.VO.SearchObjectVO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;


public class BookDAO {

	SqlSession session;
	
	public BookDAO(SqlSession session) {
		this.session = session;
	}

	public ObservableList<BookVO> select_mybatis(SearchObjectVO searchObjectVO) {
		System.out.println("@@ BookDAO.select_mybatis() 실행");
		
		List<BookVO> list = session.selectList("OnlineLibrary.BookXml.selectBookByCategoryBookVO", searchObjectVO);
		ObservableList<BookVO> oList = FXCollections.observableArrayList(list);
		return oList;
	}
	
	public int insertBook_mybatis(BookVO book) {
		System.out.println("@@ BookDAO.insertBook_mybatis() 실행");

		int rows = session.insert("OnlineLibrary.BookXml.insertBookByBookVO", book);
		return rows;
	}
	
	public int updateBook_mybatis(BookVO book) {
		System.out.println("@@ BookDAO.updateBook_mybatis() 실행");

		int rows = session.update("OnlineLibrary.BookXml.updateBookByBookVO", book);
		return rows;
	}
	
	public int deleteBookByBisbn_mybatis(String selectedBookBisbn) {
		System.out.println("@@ BookDAO.deleteBookByBisbn_mybatis() 실행");
		
		int rows = session.delete("OnlineLibrary.BookXml.deleteBookByBookVO", selectedBookBisbn);
		return rows;
	}

}
