package lecture.jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import lecture.jdbc.vo.BookVO;

public class BookDAO {

	Connection con;
	
	public BookDAO() {
	}
	public BookDAO(Connection con) {
		// 생성자를 통해서 밖에서 커넥션을 하나 가져오게 됨
		this.con = con;
	}

	public ObservableList<BookVO> select(String text) {

		ObservableList<BookVO> list = null;
		
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT bisbn, btitle, bauthor, bprice ");
		sql.append("FROM book ");
		sql.append("WHERE btitle like ?");
		sql.append("ORDER BY bprice DESC");

		try {
			PreparedStatement pstmt = con.prepareStatement(sql.toString());
			pstmt.setString(1, "%" + text + "%");
			
			ResultSet rs = pstmt.executeQuery();
			
			list = FXCollections.observableArrayList();
			
			// 5. 결과처리!
			while(rs.next()) {
				BookVO book = new BookVO(rs.getString("bisbn"),
						rs.getString("btitle"),
						rs.getString("bauthor"),
						rs.getInt("bprice"));
				list.add(book);
			}
			
			// 6. 사용한 리소스 반납
			rs.close();
			pstmt.close();
//			con.close(); // 아직 트랜잭션 안 끝났기 때문에 close하면 안 된다.
			
		} catch (Exception e1) {
			// TODO: handle exception
		}
		
		return list;
	}

	public int delete(String deleteISBN) {
		
		StringBuffer sql = new StringBuffer();
		sql.append("DELETE ");
		sql.append("FROM book ");
		sql.append("WHERE bisbn = ?");

		int count = 0;
		
		try {
			
			PreparedStatement pstmt = con.prepareStatement(sql.toString());
			pstmt.setString(1, deleteISBN);
			
			count = pstmt.executeUpdate();
			
			// 6. 사용한 자원 반납
			pstmt.close();
//			con.close(); // 아직 트랜잭션 안 끝났기 때문에 close하면 안 된다.
			
		} catch (Exception e1) {
			// TODO: handle exception
		}
		
		return count;
	}

}
