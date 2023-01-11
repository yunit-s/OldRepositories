package MVC.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import MVC.VO.BookVO;
import MVC.VO.SearchObjectVO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;


public class BookDAO {

	SqlSession session;
	
	public BookDAO() {
	}
	public BookDAO(SqlSession session) {
		this.session = session;
	}

	public ObservableList<BookVO> select_mybatis(SearchObjectVO searchObjectVO) {
		System.out.println("@@ BookDAO.select_mybatis() 실행");
		
		List<BookVO> list = session.selectList("OnlineLibrary.BookXml.selectBookByCategoryBookVO", searchObjectVO);
		ObservableList<BookVO> oList = FXCollections.observableArrayList();
		for (BookVO book : list) {
			oList.add(book);
		}
		return oList;
	}
	
//	public ObservableList<BookVO> select(String searchCategory, String searchWord) {
//		// TODO Auto-generated method stub
//		// sql 문 완성하기
//		// con에서 pstmt 생성
//		// execute
//		// list에 저장하기
//		// 할당 해제
//		// 리턴
//
//		System.out.println("@@ BookDAO - select() - " + searchCategory + ", " + searchWord);
//		
//		StringBuffer sql = new StringBuffer();
//		sql.append("SELECT * ");
//		sql.append("FROM book ");
//		sql.append("WHERE " + searchCategory + " LIKE ? ");
//		sql.append("ORDER BY btitle");
//		
//		ObservableList<BookVO> list = FXCollections.observableArrayList();
//		try {
//			PreparedStatement pstmt = con.prepareStatement(sql.toString());
//			pstmt.setString(1, "%" + searchWord + "%");
//			System.out.println("@@ pstmt = " + pstmt.toString());
//			
//			ResultSet rs = pstmt.executeQuery();
//			
//			while (rs.next()) {
//				BookVO book = new BookVO(rs.getString("bisbn"), rs.getString("btitle"), rs.getString("bdate"), rs.getInt("bpage"),
//						rs.getInt("bprice"), rs.getString("bauthor"), rs.getString("bpublisher"), rs.getString("bimgurl"),
//						rs.getString("bimgbase64"), rs.getString("bborrowable"), rs.getString("breturndate"));
//				list.add(book);
//			}
//			
//			rs.close();
//			pstmt.close();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		
//		return list;
//		
//	}

	public int updateBook_mybatis(BookVO book) {
		System.out.println("@@ BookDAO.updateBook_mybatis() 실행");

		int rows = session.update("OnlineLibrary.BookXml.updateBookByBookVO", book);
		return rows;
	}
	
//	public int updateBook(BookVO book) {
//		// sql 문 작성
//		// con을 이용해서 pstmt 생성
//		// execute
//		// 영향받은 row 수 리턴
//		System.out.println("@@ BookDAO - updateBook() 실행");
//		
//		String bisbn = book.getBisbn();
//		String btitle = book.getBtitle();
//		String bdate = book.getBdate();
//		int bpage = book.getBpage();
//		int bprice = book.getBprice();
//		String bauthor = book.getBauthor();
//		String bpublisher = book.getBpublisher();
//		String bimgurl = book.getBimgurl();
//		String bimgbase64 = book.getBimgbase64();
//		String bborrowable = book.getBborrowable();
//		String breturndate = book.getBreturndate();
//		
//		StringBuffer sql = new StringBuffer();
//		sql.append("UPDATE book ");
//		sql.append("SET btitle = ?, bdate = ?, bpage = ?, bprice = ?, ");
//		sql.append("bauthor = ?, bpublisher = ?, bimgurl = ?, bimgbase64 = ?, ");
//		sql.append("bborrowable = ?, breturndate = ? ");
//		sql.append("WHERE bisbn = ?");
//		
//		int rows = 0;
//		try {
//			PreparedStatement pstmt = con.prepareStatement(sql.toString());
//			pstmt.setString(1, btitle);
//			pstmt.setString(2, bdate);
//			pstmt.setInt(3, bpage);
//			pstmt.setInt(4, bprice);
//			pstmt.setString(5, bauthor);
//			pstmt.setString(6, bpublisher);
//			pstmt.setString(7, bimgurl);
//			pstmt.setString(8, bimgbase64);
//			pstmt.setString(9, bborrowable);
//			pstmt.setString(10, breturndate);
//			pstmt.setString(11, bisbn);
//			
//			System.out.println("@@ 도서 정보 수정 pstmt = " + pstmt.toString());
//			rows = pstmt.executeUpdate();
//			
//			pstmt.close();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		
//		return rows;
//	}

	public int deleteBookByBisbn_mybatis(String selectedBookBisbn) {
		System.out.println("@@ BookDAO.deleteBookByBisbn_mybatis() 실행");
		
		int rows = session.delete("OnlineLibrary.BookXml.deleteBookByBookVO", selectedBookBisbn);
		return rows;
	}
	
//	public int deleteBookByBisbn(String selectedBookBisbn) {
//		// sql 문 작성
//		// con을 이용해서 pstmt 생성
//		// execute
//		// 영향받은 row 수 리턴
//		System.out.println("@@ BookDAO - deleteBookByBisbn() 실행");
//		
//		StringBuffer sql = new StringBuffer();
//		sql.append("DELETE ");
//		sql.append("FROM book ");
//		sql.append("WHERE bisbn = ?");
//		
//		int rows = 0;
//		try {
//			PreparedStatement pstmt = con.prepareStatement(sql.toString());
//			pstmt.setString(1, selectedBookBisbn);
//			
//			System.out.println("@@ 도서 정보 삭제 pstmt = " + pstmt.toString());
//			rows = pstmt.executeUpdate();
//			
//			pstmt.close();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		
//		return rows;
//	}

	public int insertBook_mybatis(BookVO book) {
		System.out.println("@@ BookDAO.insertBook_mybatis() 실행");

		int rows = session.insert("OnlineLibrary.BookXml.insertBookByBookVO", book);
		return rows;
	}

//	public int insertBook(BookVO book) {
//		// sql 문 작성
//		// con을 이용해서 pstmt 생성
//		// execute
//		// 영향받은 row 수 리턴
//		System.out.println("@@ BookDAO - insertBook() 실행");
//
//		String bisbn = book.getBisbn();
//		String btitle = book.getBtitle();
//		String bdate = book.getBdate();
//		int bpage = book.getBpage();
//		int bprice = book.getBprice();
//		String bauthor = book.getBauthor();
//		String bpublisher = book.getBpublisher();
//		String bimgurl = book.getBimgurl();
//		String bimgbase64 = book.getBimgbase64();
//		String bborrowable = book.getBborrowable();
//		String breturndate = book.getBreturndate();
//		
//		StringBuffer sql = new StringBuffer();
//		
//		sql.append("INSERT ");
//		sql.append("INTO book (bisbn, btitle, bdate, bpage, ");
//		sql.append("bprice, bauthor, bpublisher, bimgurl, ");
//		sql.append("bimgbase64, bborrowable, breturndate) ");
//		sql.append("VALUES ");
//		sql.append("(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
//		
//		int rows = 0;
//		try {
//			PreparedStatement pstmt = con.prepareStatement(sql.toString());
//			pstmt.setString(1, bisbn);
//			pstmt.setString(2, btitle);
//			pstmt.setString(3, bdate);
//			pstmt.setInt(4, bpage);
//			pstmt.setInt(5, bprice);
//			pstmt.setString(6, bauthor);
//			pstmt.setString(7, bpublisher);
//			pstmt.setString(8, bimgurl);
//			pstmt.setString(9, bimgbase64);
//			pstmt.setString(10, bborrowable);
//			pstmt.setString(11, breturndate);
//			
//			System.out.println("@@ 도서 추가 pstmt = " + pstmt.toString());
//			rows = pstmt.executeUpdate();
//			
//			pstmt.close();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		
//		return rows;
//	}
	
//	public int editBorrowableByBisbn(String selectedBookBisbn, String bborrowable) {
//		// sql 문 작성
//		// con을 이용해서 pstmt 생성
//		// execute
//		// 영향받은 row 수 리턴
//		System.out.println("@@ BookDAO - editBorrowableByBisbn() 실행");
//		
//		StringBuffer sql = new StringBuffer();
//		sql.append("UPDATE book ");
//		sql.append("SET bborrowable = ? ");
//		sql.append("WHERE bisbn = ?");
//		
//		int rows = 0;
//		try {
//			PreparedStatement pstmt = con.prepareStatement(sql.toString());
//			pstmt.setString(1, bborrowable);
//			pstmt.setString(2, selectedBookBisbn);
//			
//			System.out.println("@@ 도서 borrowable 변경 pstmt = " + pstmt.toString());
//			rows = pstmt.executeUpdate();
//			
//			pstmt.close();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		
//		return rows;
//	}

//	public int editReturndateByBisbn(String selectedBookBisbn, String returndate) {
//		// sql 문 작성
//		// con을 이용해서 pstmt 생성
//		// execute
//		// 영향받은 row 수 리턴
//		System.out.println("@@ BookDAO - editReturndateByBisbn() 실행");
//		
//		StringBuffer sql = new StringBuffer();
//		sql.append("UPDATE book ");
//		sql.append("SET breturndate = ? ");
//		sql.append("WHERE bisbn = ?");
//		
//		int rows = 0;
//		try {
//			PreparedStatement pstmt = con.prepareStatement(sql.toString());
//			pstmt.setString(1, returndate);
//			pstmt.setString(2, selectedBookBisbn);
//			
//			System.out.println("@@ 도서 반납기한 설정 pstmt = " + pstmt.toString());
//			rows = pstmt.executeUpdate();
//			
//			pstmt.close();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		
//		return rows;
//	}
	
}
