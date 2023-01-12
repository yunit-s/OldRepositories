package MVC.Service;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import MVC.DAO.BorrBookDAO;
import MVC.MyBatis.MyBatisConnectionFactory;
import MVC.VO.BorrBookVO;
import MVC.VO.SearchObjectVO;
import javafx.collections.ObservableList;

public class BorrBookService {

	private SqlSessionFactory factory;
	
	public BorrBookService() {
		factory = MyBatisConnectionFactory.getSqlSessionFactory();
	}

	public ObservableList<BorrBookVO> searchBook_mybatis(String searchCategory, String searchWord) {
		System.out.println("@@ BorrBookService.searchBook_mybatis() 실행");
		
		SqlSession session = null;
		BorrBookDAO borrBookDao = null;
		ObservableList<BorrBookVO> list = null;
		try {
			session = factory.openSession();
			borrBookDao = new BorrBookDAO(session);
			SearchObjectVO searchObjectVO = new SearchObjectVO(searchCategory, "%" + searchWord + "%");
			list = borrBookDao.selectBorrBook_mybatis(searchObjectVO);
		} catch (Exception e) {
			System.out.println("@@@ searchBook_mybatis() 오류");
		} finally {
			session.close();
		}
		return list;
	}

	public String getReturndateOneByBisbn_mybatis(String selectedBookBisbn) {
		System.out.println("@@ BorrBookService.getReturndateOneByBisbn_mybatis() 실행");

		SqlSession session = null;
		BorrBookDAO borrBookDao = null;
		ObservableList<BorrBookVO> list = null;
		try {
			session = factory.openSession();
			borrBookDao = new BorrBookDAO(session);
			SearchObjectVO searchObjectVO = new SearchObjectVO("bisbn", selectedBookBisbn);
			list = borrBookDao.selectBorrBook_mybatis(searchObjectVO);
		} catch (Exception e) {
			System.out.println("@@@ getReturndateOneByBisbn_mybatis() 오류");
		} finally {
			session.close();
		}
		return list.get(0).getReturndate();
	}

	public int insertBookOneByBorrBookVO_mybatis(BorrBookVO borrBook) {
		System.out.println("@@ BorrBookService.insertBookOneByBorrBookVO_mybatis() 실행");
		
		SqlSession session = null;
		BorrBookDAO borrBookDao = null;
		int rows = 0;
		try {
			session = factory.openSession();
			borrBookDao = new BorrBookDAO(session);
			rows = borrBookDao.insertBorrBook_mybatis(borrBook);
			if (rows == 1)
				session.commit();
		} catch (Exception e) {
			System.out.println("@@@ insertBookOneByBorrBookVO_mybatis() 오류. rollback");
			session.rollback();
		} finally {
			session.close();
		}
		return rows;
	}

	public int deleteBookOneByBisbn_mybatis(String selectedBookBisbn) {
		System.out.println("@@ BorrBookService.deleteBookOneByBisbn_mybatis() 실행");
		
		SqlSession session = null;
		BorrBookDAO borrBookDao = null;
		int rows = 0;
		try {
			session = factory.openSession();
			borrBookDao = new BorrBookDAO(session);
			rows = borrBookDao.deleteBorrBookByBisbn_mybatis(selectedBookBisbn);
			if (rows == 1)
				session.commit();
		} catch (Exception e) {
			System.out.println("@@@ deleteBookOneByBisbn_mybatis() 오류. rollback");
			session.rollback();
		} finally {
			session.close();
		}
		return rows;
	}

}
