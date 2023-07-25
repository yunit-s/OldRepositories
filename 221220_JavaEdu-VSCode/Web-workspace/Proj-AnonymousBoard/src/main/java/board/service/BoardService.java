package board.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import board.dao.BoardDAO;
import board.vo.Board;
import common.mybatis.MyBatisConnectionFactory;

public class BoardService {

	public List<Board> getArticleAll() {
		System.out.println("!! BoardService.getArticleAll() 실행");
		SqlSession sqlSession = MyBatisConnectionFactory.getSqlSessionFactory().openSession();
		BoardDAO bDao = new BoardDAO(sqlSession);
		List<Board> bList = bDao.selectAll();
		sqlSession.close();
		return bList;
	}

	public Board getArticleOne(Board tgBoard) {
		System.out.println("!! BoardService.getArticleOne() 실행");
		SqlSession sqlSession = MyBatisConnectionFactory.getSqlSessionFactory().openSession();
		BoardDAO bDao = new BoardDAO(sqlSession);
		Board rsBoard = bDao.selectOne(tgBoard);
		sqlSession.close();
		return rsBoard;
	}

	public int addArticle(Board newBoard) {
		System.out.println("!! BoardService.addArticle() 실행");
		SqlSession sqlSession = MyBatisConnectionFactory.getSqlSessionFactory().openSession();
		BoardDAO bDao = new BoardDAO(sqlSession);
		int result = bDao.insert(newBoard);
		sqlSession.commit();
		sqlSession.close();
		return result;
	}

	public int editArticle(Board tgBoard) {
		System.out.println("!! BoardService.editArticle() 실행");
		SqlSession sqlSession = MyBatisConnectionFactory.getSqlSessionFactory().openSession();
		BoardDAO bDao = new BoardDAO(sqlSession);
		int result = bDao.update(tgBoard);
		sqlSession.commit();
		sqlSession.close();
		return result;
	}

	public int delArticleOne(Board tgBoard) {
		System.out.println("!! BoardService.delArticleOne() 실행");
		SqlSession sqlSession = MyBatisConnectionFactory.getSqlSessionFactory().openSession();
		BoardDAO bDao = new BoardDAO(sqlSession);
		int result = bDao.deleteOne(tgBoard);
		sqlSession.commit();
		sqlSession.close();
		return result;
	}

}
