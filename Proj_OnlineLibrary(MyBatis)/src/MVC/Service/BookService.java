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
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class BookService {

	private SqlSessionFactory factory;
	
	public BookService() {
		factory = MyBatisConnectionFactory.getSqlSessionFactory();
	}
	
	public ObservableList<BookVO> searchBook_mybatis(String searchCategory, String searchWord) {
		System.out.println("@@ BookService.searchBook_mybatis() 실행");
		
		SqlSession session = factory.openSession();
		ObservableList<BookVO> list = FXCollections.observableArrayList();
		try {
			BookDAO bookDao = new BookDAO(session);
			list = bookDao.select_mybatis(searchCategory, searchWord);
			
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			
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

	public int editBookOneByBookVO(BookVO book) {
		System.out.println("@@ bookService.editBookOneByBookVO() 실행");
		
		Connection con = null;
		try {
			con = DBCP_Apache.getDataSource().getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		BookDAO bookDao = new BookDAO(con);
		int rows = bookDao.updateBook(book);
		
		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return rows;
	}

	public int deteleBookOneByBisbn(String selectedBookBisbn) {
		System.out.println("@@ bookService.deteleBookOneByBisbn() 실행");
		
		Connection con = null;
		try {
			con = DBCP_Apache.getDataSource().getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		BookDAO bookDao = new BookDAO(con);
		int rows = bookDao.deleteBookByBisbn(selectedBookBisbn);
		
		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return rows;
	}

	public int insertBookOneByBookVO(BookVO newBook) {
		System.out.println("@@ bookService.insertBookOneByBookVO() 실행");
		
		Connection con = null;
		try {
			con = DBCP_Apache.getDataSource().getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		BookDAO bookDao = new BookDAO(con);
		int rows = bookDao.insertBook(newBook);
		
		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return rows;
	}

	public int setBorrowedBookOneByBisbn(String selectedBookBisbn) {
		System.out.println("@@ bookService.setBorrowedBookOneByBisbn() 실행");
		
		Connection con = null;
		try {
			con = DBCP_Apache.getDataSource().getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		BookDAO bookDao = new BookDAO(con);
		int rows = bookDao.editBorrowableByBisbn(selectedBookBisbn, "x");
		LocalDate now = LocalDate.now();
		String returndate = now.plusDays(7).toString();
		rows = bookDao.editReturndateByBisbn(selectedBookBisbn, returndate);
		
		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return rows;
	}

	public int setReturnedBookOneByBisbn(String selectedBookBisbn) {
		System.out.println("@@ bookService.setReturnedBookOneByBisbn() 실행");
		
		Connection con = null;
		try {
			con = DBCP_Apache.getDataSource().getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		BookDAO bookDao = new BookDAO(con);
		int rows = bookDao.editBorrowableByBisbn(selectedBookBisbn, "o");
//		LocalDate now = LocalDate.now();
//		String returndate = now.plusDays(7).toString();
		rows = bookDao.editReturndateByBisbn(selectedBookBisbn, null);
		
		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return rows;
	}

}
