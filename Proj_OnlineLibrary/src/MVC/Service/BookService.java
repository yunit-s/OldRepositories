package MVC.Service;

import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;

import MVC.DAO.BookDAO;
import MVC.DAO.DBCP_Apache;
import MVC.VO.BookVO;
import javafx.collections.ObservableList;

public class BookService {

	public ObservableList<BookVO> searchBook(String searchCategory, String searchWord) {
		
		Connection con = null;
		try {
			con = DBCP_Apache.getDataSource().getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		// dao에서 select 실행
		BookDAO bookDao = new BookDAO(con);
		ObservableList<BookVO> list = bookDao.select(searchCategory, searchWord);

		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}

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

}
