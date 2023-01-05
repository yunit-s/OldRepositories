package MVC.Service;

import java.sql.Connection;
import java.sql.SQLException;

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
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// dao에서 select 실행
		BookDAO bookDao = new BookDAO(con);
		ObservableList<BookVO> list = bookDao.select(searchCategory, searchWord);

		try {
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}

}
