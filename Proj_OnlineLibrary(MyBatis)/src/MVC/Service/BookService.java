package MVC.Service;

import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import MVC.DAO.BookDAO;
import MVC.DAO.DBCP_Apache;
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
	
//	public ObservableList<BookVO> searchBook(String searchCategory, String searchWord) {
//		
//		Connection con = null;
//		try {
//			con = DBCP_Apache.getDataSource().getConnection();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//
//		// dao에서 select 실행
//		BookDAO bookDao = new BookDAO(con);
//		ObservableList<BookVO> list = bookDao.select(searchCategory, searchWord);
//
//		try {
//			con.close();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		
//		return list;
//	}

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
	
//	public int editBookOneByBookVO(BookVO book) {
//		System.out.println("@@ bookService.editBookOneByBookVO() 실행");
//		
//		Connection con = null;
//		try {
//			con = DBCP_Apache.getDataSource().getConnection();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		
//		BookDAO bookDao = new BookDAO(con);
//		int rows = bookDao.updateBook(book);
//		
//		try {
//			con.close();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		
//		return rows;
//	}

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
	
//	public int deteleBookOneByBisbn(String selectedBookBisbn) {
//		System.out.println("@@ bookService.deteleBookOneByBisbn() 실행");
//		
//		Connection con = null;
//		try {
//			con = DBCP_Apache.getDataSource().getConnection();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		
//		BookDAO bookDao = new BookDAO(con);
//		int rows = bookDao.deleteBookByBisbn(selectedBookBisbn);
//		
//		try {
//			con.close();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		
//		return rows;
//	}

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
			System.out.println("@@ insertBookOneByBookVO_mybatis() 오류. rollback");
			session.rollback();
		} finally {
			session.close();
		}
		return rows;
	}

//	public int insertBookOneByBookVO(BookVO newBook) {
//		System.out.println("@@ bookService.insertBookOneByBookVO() 실행");
//		
//		Connection con = null;
//		try {
//			con = DBCP_Apache.getDataSource().getConnection();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		
//		BookDAO bookDao = new BookDAO(con);
//		int rows = bookDao.insertBook(newBook);
//		
//		try {
//			con.close();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		
//		return rows;
//	}
	
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
	
//	public int setBorrowedBookOneByBisbn(String selectedBookBisbn) {
//		System.out.println("@@ bookService.setBorrowedBookOneByBisbn() 실행");
//		
//		Connection con = null;
//		try {
//			con = DBCP_Apache.getDataSource().getConnection();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		
//		BookDAO bookDao = new BookDAO(con);
//		int rows = bookDao.editBorrowableByBisbn(selectedBookBisbn, "x");
//		LocalDate now = LocalDate.now();
//		String returndate = now.plusDays(7).toString();
//		rows = bookDao.editReturndateByBisbn(selectedBookBisbn, returndate);
//		
//		try {
//			con.close();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		
//		return rows;
//	}

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
	
//	public int setReturnedBookOneByBisbn(String selectedBookBisbn) {
//		System.out.println("@@ bookService.setReturnedBookOneByBisbn() 실행");
//		
//		Connection con = null;
//		try {
//			con = DBCP_Apache.getDataSource().getConnection();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		
//		BookDAO bookDao = new BookDAO(con);
//		int rows = bookDao.editBorrowableByBisbn_mybatis(selectedBookBisbn, "o");
//		rows = bookDao.editReturndateByBisbn(selectedBookBisbn, null);
//		
//		try {
//			con.close();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		
//		return rows;
//	}

}
