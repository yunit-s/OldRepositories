package MVC.Service;

import java.sql.Connection;
import java.sql.SQLException;

import MVC.DAO.BookDAO;
import MVC.DAO.DBCP_Apache;
import MVC.VO.BookVO;
import javafx.collections.ObservableList;

public class BookService {

	public ObservableList<BookVO> searchBook(String searchCategory, String searchText) {
		// TODO Auto-generated method stub
		
		Connection con = null;
		
		ObservableList<BookVO> list = null;
		try {
			con = DBCP_Apache.getDataSource().getConnection();
			
			BookDAO bookDao = new BookDAO(con);
			
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		return null;
	}

}
