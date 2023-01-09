package example.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import example.vo.BookVO;

public class BookDAO {

	private SqlSessionFactory factory;
	
	public BookDAO(SqlSessionFactory factory) {
		this.factory = factory;
	}

	public HashMap<String, Object> selectByISBNHashMap(String isbn) {
		HashMap<String, Object> map = null;
		SqlSession session = factory.openSession(); // connection pool에서 connection을 들고 왔다고 이해하면 편하다.
		map = session.selectOne("example.myBook.selectBookByISBNHashMap", isbn); // example.myBook : namespace / selectBookByISBNHashMap : ID 
		return map;
	}

	public List<HashMap<String, Object>> selectAllHashMap() {

		List<HashMap<String, Object>> list = null;
		SqlSession session = factory.openSession(); // connection pool에서 connection을 들고 왔다고 이해하면 편하다.
		list = session.selectList("example.myBook.selectAllHashMap");
		return list;
	}

	public BookVO selectByISBNBookVO(String isbn) {
		BookVO book = null;
		SqlSession session = factory.openSession(); // connection pool에서 connection을 들고 왔다고 이해하면 편하다.
		book = session.selectOne("example.myBook.selectBookByISBNBookVO", isbn);
		return book;
	}

	public BookVO selectByISBNResultMap(String isbn) {
		BookVO book = null;
		SqlSession session = factory.openSession(); // connection pool에서 connection을 들고 왔다고 이해하면 편하다.
		
		try {
			book = session.selectOne("example.myBook.selectBookByISBNResultMap", isbn);
		} finally {
			session.close();
		}
		return book;
	}

	public int updateByISBN(BookVO book) {
		int result = 0;
		SqlSession session = factory.openSession(); // connection pool에서 connection을 들고 왔다고 이해하면 편하다.
		
		try {
			result = session.update("example.myBook.update", book);
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
//			session.commit(); // commit을 명시하지 않으면 트랜잭션 제대로 반영되지 않는다.
			session.close();
		}
		return result;
	}

}
