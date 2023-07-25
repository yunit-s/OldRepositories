package my.spring.SpringWeb.sample11.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import my.spring.SpringWeb.sample11.vo.Book;

//@Controller
//@RequestMapping(value="book")
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
		return session.selectList("myBook.selectAll");
	}

	@Override
	@PostMapping
	public List<Book> getSearchBooks(String keyword) {
		return session.selectList("myBook.selectBookByKeyword", keyword);
	}
	
}
