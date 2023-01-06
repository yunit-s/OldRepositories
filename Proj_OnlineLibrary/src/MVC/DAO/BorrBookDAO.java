package MVC.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import MVC.VO.BookVO;
import MVC.VO.BorrBookVO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class BorrBookDAO {

	Connection con;
	
	public BorrBookDAO() {
		// TODO Auto-generated constructor stub
	}

	public BorrBookDAO(Connection con) {
		this.con = con;
	}
	
	public int insertBook(BorrBookVO book) {
		// sql 문 작성
		// con을 이용해서 pstmt 생성
		// execute
		// 영향받은 row 수 리턴

		String bisbn = book.getBisbn();
		String btitle = book.getBtitle();
		String id = book.getId();
		String borrdate = book.getBorrdate();
		String returndate = book.getReturndate();
		
		StringBuffer sql = new StringBuffer();
		sql.append("INSERT ");
		sql.append("INTO borrbook (bisbn, btitle, id, borrdate, returndate) ");
		sql.append("VALUES ");
		sql.append("(?, ?, ?, ?, ?)");
		
		int rows = 0;
		try {
			PreparedStatement pstmt = con.prepareStatement(sql.toString());
			pstmt.setString(1, bisbn);
			pstmt.setString(2, btitle);
			pstmt.setString(3, id);
			pstmt.setString(4, borrdate);
			pstmt.setString(5, returndate);
			
			System.out.println("@@ 빌린 도서 추가 pstmt = " + pstmt.toString());
			rows = pstmt.executeUpdate();
			
			pstmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return rows;
	}

	public ObservableList<BorrBookVO> select(String searchCategory, String searchWord) {
		// TODO Auto-generated method stub
		// sql 문 완성하기
		// con에서 pstmt 생성
		// execute
		// list에 저장하기
		// 할당 해제
		// 리턴

		System.out.println("@@ BorrBookDAO select() - " + searchCategory + searchWord);
		
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT * ");
		sql.append("FROM borrbook ");
		sql.append("WHERE " + searchCategory + " LIKE ? ");
		sql.append("ORDER BY btitle");
		
		ObservableList<BorrBookVO> list = FXCollections.observableArrayList();
		try {
			PreparedStatement pstmt = con.prepareStatement(sql.toString());
			pstmt.setString(1, "%" + searchWord + "%");
			System.out.println("@@ pstmt = " + pstmt.toString());
			
			ResultSet rs = pstmt.executeQuery();
			
			while (rs.next()) {
				BorrBookVO borrBook = new BorrBookVO(rs.getString("bisbn"), rs.getString("btitle"), rs.getString("id"), rs.getString("borrdate"),
						rs.getString("returndate"));
				list.add(borrBook);
			}
			
			rs.close();
			pstmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;
		
	}

	public int deleteBookByBisbn(String selectedBookBisbn) {
		// sql 문 작성
		// con을 이용해서 pstmt 생성
		// execute
		// 영향받은 row 수 리턴

		StringBuffer sql = new StringBuffer();
		sql.append("DELETE FROM borrbook ");
		sql.append("WHERE bisbn = ?");
		
		int rows = 0;
		try {
			PreparedStatement pstmt = con.prepareStatement(sql.toString());
			pstmt.setString(1, selectedBookBisbn);
			
			System.out.println("@@ 도서 반납 pstmt = " + pstmt.toString());
			rows = pstmt.executeUpdate();
			
			pstmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return rows;
	}

}
