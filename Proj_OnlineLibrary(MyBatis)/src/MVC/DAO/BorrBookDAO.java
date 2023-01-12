package MVC.DAO;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import MVC.VO.BorrBookVO;
import MVC.VO.SearchObjectVO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class BorrBookDAO {

	SqlSession session;
	
	public BorrBookDAO(SqlSession session) {
		this.session = session;
	}

	public ObservableList<BorrBookVO> selectBorrBook_mybatis(SearchObjectVO searchObjectVO) {
		System.out.println("@@ BorrBookDAO.selectBorrBook_mybatis() 실행");
		
		List<BorrBookVO> list = session.selectList("OnlineLibrary.BorrBookXml.selectBorrBook", searchObjectVO);
		ObservableList<BorrBookVO> oList = FXCollections.observableList(list);
		return oList;
	}

	public int insertBorrBook_mybatis(BorrBookVO borrBook) {
		System.out.println("@@ BorrBookDAO.insertBook_mybatis() 실행");
		
		int rows = session.insert("OnlineLibrary.BorrBookXml.insertBorrBook", borrBook);
		return rows;
	}
	
	public int deleteBorrBookByBisbn_mybatis(String selectedBookBisbn) {
		System.out.println("@@ BorrBookDAO.deleteBookByBisbn_mybatis() 실행");
		
		int rows = session.delete("OnlineLibrary.BorrBookXml.deleteBorrBook", selectedBookBisbn);
		return rows;
	}

}
