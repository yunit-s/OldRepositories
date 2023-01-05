package MVC.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import MVC.VO.BookVO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;


public class BookDAO {

	Connection con;
	
	public BookDAO() {
		// TODO Auto-generated constructor stub
	}

	public BookDAO(Connection con) {
		this.con = con;
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
//		StringBuffer sql = new StringBuffer();
//		sql.append("SELECT bisbn, btitle, bauthor, bprice ");
//		sql.append("FROM book ");
//		sql.append("WHERE " + searchCategory + " LIKE ? ");
//		sql.append("ORDER BY btitle");
//
//		System.out.println("@@ check1 " + searchCategory + searchWord);
//		ObservableList<BookVO> list = FXCollections.observableArrayList();
//		try {
//			PreparedStatement pstmt = con.prepareStatement(sql.toString());
////			pstmt.setString(1, searchCategory);
//			pstmt.setString(1, "%" + searchWord + "%");
//			System.out.println("@@ pstmt = " + pstmt.toString());
//			
//			ResultSet rs = pstmt.executeQuery();
//			
//			while (rs.next()) {
//				BookVO book = new BookVO(rs.getString("bisbn"), rs.getString("btitle"), rs.getString("bauthor"), rs.getInt("bprice"));
//				list.add(book);
//			}
//			
//			rs.close();
//			pstmt.close();
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		System.out.println("@@ check2");
//		
//		return list;
//	}
	
	// 검색을 전체로 바꿔보자
	public ObservableList<BookVO> select(String searchCategory, String searchWord) {
		// TODO Auto-generated method stub
		// sql 문 완성하기
		// con에서 pstmt 생성
		// execute
		// list에 저장하기
		// 할당 해제
		// 리턴

		System.out.println("@@ BookDAO select() - " + searchCategory + searchWord);
		
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT * ");
		sql.append("FROM book ");
		sql.append("WHERE " + searchCategory + " LIKE ? ");
		sql.append("ORDER BY btitle");
		
		ObservableList<BookVO> list = FXCollections.observableArrayList();
		try {
			PreparedStatement pstmt = con.prepareStatement(sql.toString());
//			pstmt.setString(1, searchCategory);
			pstmt.setString(1, "%" + searchWord + "%");
			System.out.println("@@ pstmt = " + pstmt.toString());
			
			ResultSet rs = pstmt.executeQuery();
			
			while (rs.next()) {
				BookVO book = new BookVO(rs.getString("bisbn"), rs.getString("btitle"), rs.getString("bdate"), rs.getInt("bpage"), rs.getInt("bprice"),
						rs.getString("bauthor"), rs.getString("btranslator"), rs.getString("bsupplement"), rs.getString("bpublisher"));
				list.add(book);
			}
			
			rs.close();
			pstmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
		
	}
	
}
