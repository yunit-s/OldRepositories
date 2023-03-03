package my.spring.springweb.sample11.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import my.spring.springweb.sample11.vo.Book;

@Repository
public class BookDaoImpl implements BookDao {

	@Autowired
	private SqlSession session;
	
	@Override
	public int getBookCount() {
		
		return session.selectOne("myBook.countBooks");
	}

	@Override
	public List<Book> getAllBooks() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Book> getSearchBooks() {
		// TODO Auto-generated method stub
		return null;
	}

	
}
