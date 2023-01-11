package MVC.Service;

import java.sql.Connection;
import java.sql.SQLException;

import MVC.DAO.BookDAO;
import MVC.DAO.BorrBookDAO;
import MVC.DAO.DBCP_Apache;
import MVC.VO.BookVO;
import MVC.VO.BorrBookVO;
import javafx.collections.ObservableList;

public class BorrBookService {

	public int insertBookOneByBorrBookVO(BorrBookVO borrBook) {
		System.out.println("@@ BorrBookService.insertBookOneByBookVO() 실행");
		
		Connection con = null;
		try {
			con = DBCP_Apache.getDataSource().getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		BorrBookDAO borrBookDao = new BorrBookDAO(con);
		int rows = borrBookDao.insertBook(borrBook);
		
		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return rows;
	}

	public ObservableList<BorrBookVO> searchBook(String searchCategory, String searchWord) {
		
		Connection con = null;
		try {
			con = DBCP_Apache.getDataSource().getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		// dao에서 select 실행
		BorrBookDAO borrBookDao = new BorrBookDAO(con);
		ObservableList<BorrBookVO> list = borrBookDao.select(searchCategory, searchWord);

		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}

	public int deleteBookOneByBisbn(String selectedBookBisbn) {
		System.out.println("@@ BorrBookService.deleteBookOneByBorrBookVO() 실행");
		
		Connection con = null;
		try {
			con = DBCP_Apache.getDataSource().getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		BorrBookDAO borrBookDao = new BorrBookDAO(con);
		int rows = borrBookDao.deleteBookByBisbn(selectedBookBisbn);
		
		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return rows;
	}

	public String getReturndateOneByBisbn(String selectedBookBisbn) {
		System.out.println("@@ BorrBookService.getReturndateOneByBisbn() 실행");
		
		Connection con = null;
		try {
			con = DBCP_Apache.getDataSource().getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		BorrBookDAO borrBookDao = new BorrBookDAO(con);
		ObservableList<BorrBookVO> list = borrBookDao.select("bisbn", selectedBookBisbn);
		
		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list.get(0).getReturndate();
	}

}
