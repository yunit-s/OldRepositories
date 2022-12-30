package lecture.jdbc.service;

import java.sql.Connection;
import java.sql.SQLException;

import javafx.collections.ObservableList;
import lecture.jdbc.dao.BookDAO;
import lecture.jdbc.dao.DBCPConnectionPool;
import lecture.jdbc.vo.BookVO;

public class BookService {

	public ObservableList<BookVO> selectBooksByKeyword(String text) {

		// 여기에서 Database Connection을 얻어와야 한다.
		Connection con = null;
		try {
			con = (DBCPConnectionPool.getDataSource()).getConnection();
			con.setAutoCommit(false); // transaction 시작
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		BookDAO dao = new BookDAO(con);
		ObservableList<BookVO> list = dao.select(text);
		try {
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	public ObservableList<BookVO> deleteByISBN(String deleteISBN, String searchKeyword) {
		
		// 여기서부터 Transaction 시작
		// Connection에 대해서 setAutocommit() 을 false로 지정해야 Transaction이 시작된다.
		
		// 여기에서 Database Connection을 얻어와야 한다.
		Connection con = null;
		try {
			con = (DBCPConnectionPool.getDataSource()).getConnection();
			con.setAutoCommit(false); // transaction 시작
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		BookDAO dao = new BookDAO(con);
		
		int count = dao.delete(deleteISBN);
		ObservableList<BookVO> list = dao.select(searchKeyword);
		
		// 여기가 Transaction의 끝이다.
		// 서비스의 메소드 맨 마지막에 이 메소드가 잘 처리되었으면, transaction을 commit해야 하고, 그렇지 않으면 rollback 해야 한다.
		// 이제 commit을 할 지, rollback을 할 지에 대한 로직은 우리가 처리해야 한다.
//		if (count == 1 && list != null) {
//			try {
//				con.commit();
//				con.close();
//			} catch (SQLException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		} else {
//			try {
//				con.rollback();
//				con.close();
//			} catch (SQLException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}
		
		System.out.println("delete에 대한 rollback 실행");
		try {
			con.rollback();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return list;
	}

}
