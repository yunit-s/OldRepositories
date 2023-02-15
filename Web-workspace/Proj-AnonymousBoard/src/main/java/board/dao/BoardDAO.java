package board.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import board.vo.Board;
import common.mybatis.MyBatisConnectionFactory;

public class BoardDAO {

	public List<Board> selectAll() {
		System.out.println("!! BoardDAO.selectAll() 실행");
		SqlSession sqlSession = MyBatisConnectionFactory.getSqlSessionFactory().openSession();
		List<Board> bList = sqlSession.selectList("boardXml.selectAll");
		sqlSession.close();
		return bList;
	}

	public Board selectOne(Board tgBoard) {
		System.out.println("!! BoardDAO.selectOne() 실행");
		SqlSession sqlSession = MyBatisConnectionFactory.getSqlSessionFactory().openSession();
		Board rsBoard = sqlSession.selectOne("boardXml.selectOne", tgBoard);
		sqlSession.close();
		return rsBoard;
	}

	public int insert(Board newBoard) {
		System.out.println("!! BoardDAO.insert() 실행");
		SqlSession sqlSession = MyBatisConnectionFactory.getSqlSessionFactory().openSession();
		int result = sqlSession.insert("boardXml.insertOne", newBoard);
		sqlSession.commit();
		sqlSession.close();
		return result;
	}

	public int update(Board tgBoard) {
		System.out.println("!! BoardDAO.update() 실행");
		SqlSession sqlSession = MyBatisConnectionFactory.getSqlSessionFactory().openSession();
		int result = sqlSession.update("boardXml.updateOne", tgBoard);
		sqlSession.commit();
		sqlSession.close();
		return result;
	}

	public int deleteOne(Board tgBoard) {
		System.out.println("!! BoardDAO.deleteOne() 실행");
		SqlSession sqlSession = MyBatisConnectionFactory.getSqlSessionFactory().openSession();
		int result = sqlSession.update("boardXml.deleteOne", tgBoard);
		sqlSession.commit();
		sqlSession.close();
		return result;
	}

}
