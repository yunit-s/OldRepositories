package MVC.Service;

import java.time.LocalDate;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import MVC.DAO.BookDAO;
import MVC.MyBatis.MyBatisConnectionFactory;
import MVC.VO.BookVO;
import MVC.VO.SearchObjectVO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class BookService {

	private SqlSessionFactory factory;
	
	public BookService() {
		factory = MyBatisConnectionFactory.getSqlSessionFactory();
	}
	
	public ObservableList<BookVO> searchBook_mybatis(String searchCategory, String searchWord) {
		System.out.println("@@ BookService.searchBook_mybatis() 실행");
		
		SqlSession session = null;
		BookDAO bookDao = null;
		ObservableList<BookVO> list = FXCollections.observableArrayList();
		SearchObjectVO searchObjectVO = null;
		try {
			session = factory.openSession();
			bookDao = new BookDAO(session);
			searchObjectVO = new SearchObjectVO(searchCategory, "%" + searchWord + "%");
			list = bookDao.select_mybatis(searchObjectVO);
		} catch (Exception e) {
			System.out.println("@@@ searchBook_mybatis() 오류");
		} finally {
			session.close();
		}
		return list;
	}

	public int insertBookOneByBookVO_mybatis(BookVO newBook) {
		System.out.println("@@ BookService.insertBookOneByBookVO_mybatis() 실행");
		
		SqlSession session = null;
		BookDAO bookDao = null;
		int rows = 0;
		try {
			session = factory.openSession();
			bookDao = new BookDAO(session);
			rows = bookDao.insertBook_mybatis(newBook);
			if (rows == 1)
				session.commit();
		} catch (Exception e) {
			System.out.println("@@@ insertBookOneByBookVO_mybatis() 오류. rollback");
			session.rollback();
		} finally {
			session.close();
		}
		return rows;
	}
	
	public int editBookOneByBookVO_mybatis(BookVO book) {
		System.out.println("@@ BookService.editBookOneByBookVO_mybatis() 실행");
		
		SqlSession session = null;
		BookDAO bookDao = null;
		int rows = 0;
		try {
			session = factory.openSession();
			bookDao = new BookDAO(session);
			rows = bookDao.updateBook_mybatis(book);
			if (rows == 1)
				session.commit();
		} catch (Exception e) {
			System.out.println("@@@ editBookOneByBookVO_mybatis() 오류. rollback");
			session.rollback();
		} finally {
			session.close();
		}
		return rows;
	}

	public int deteleBookOneByBisbn_mybatis(String selectedBookBisbn) {
		System.out.println("@@ BookService.deteleBookOneByBisbn_mybatis() 실행");
		
		SqlSession session = null;
		BookDAO bookDao = null;
		int rows = 0;
		try {
			session = factory.openSession();
			bookDao = new BookDAO(session);
			rows = bookDao.deleteBookByBisbn_mybatis(selectedBookBisbn);
			if (rows == 1)
				session.commit();
		} catch (Exception e) {
			System.out.println("@@@ deteleBookOneByBisbn_mybatis() 오류. rollback");
			session.rollback();
		} finally {
			session.close();
		}
		return rows;
	}
	
	public int setBorrowedBookOneByBisbn_mybatis(BookVO book) {
		System.out.println("@@ BookService.setBorrowedBookOneByBisbn_mybatis() 실행");
		
		SqlSession session = null;
		BookDAO bookDao = null;
		int rows = 0;
		try {
			session = factory.openSession();
			bookDao = new BookDAO(session);
			LocalDate now = LocalDate.now();
			String returndate = now.plusDays(7).toString();
			book.setBborrowable("x");
			book.setBreturndate(returndate);
			rows = bookDao.updateBook_mybatis(book);
			if (rows == 1)
				session.commit();
		} catch (Exception e) {
			System.out.println("@@@ setBorrowedBookOneByBisbn_mybatis() 오류. rollback");
			session.rollback();
		} finally {
			session.close();
		}
		return rows;
	}

	public int setReturnedBookOneByBisbn_mybatis(BookVO book) {
		System.out.println("@@ BookService.setReturnedBookOneByBisbn_mybatis() 실행");
		
		SqlSession session = null;
		BookDAO bookDao = null;
		int rows = 0;
		try {
			session = factory.openSession();
			bookDao = new BookDAO(session);
			book.setBborrowable("o");
			book.setBreturndate(null);
			rows = bookDao.updateBook_mybatis(book);
			if (rows == 1)
				session.commit();
		} catch (Exception e) {
			System.out.println("@@@ setReturnedBookOneByBisbn_mybatis() 오류. rollback");
			session.rollback();
		} finally {
			session.close();
		}
		return rows;
	}

}
