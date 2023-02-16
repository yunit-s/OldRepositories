package boardncmt.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import boardncmt.dao.BoardNCmtDAO;
import boardncmt.vo.BoardNCmt;
import common.mybatis.MyBatisConnectionFactory;

public class BoardNCmtService {

	public List<BoardNCmt> getArticleAll() {
		System.out.println("!! BoardNCmtService.getArticleAll() 실행");
		SqlSession sqlSession = MyBatisConnectionFactory.getSqlSessionFactory().openSession();
		BoardNCmtDAO bncDao = new BoardNCmtDAO(sqlSession);
		List<BoardNCmt> bncList = bncDao.selectAll();
		sqlSession.close();
		return bncList;
	}

}
