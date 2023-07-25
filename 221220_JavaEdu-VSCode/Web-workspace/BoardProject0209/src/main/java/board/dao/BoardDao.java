package board.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import board.vo.Board;
import common.mybatis.MyBatisConnectionFactory;

public class BoardDao {

	public List<Board> selectAll() {

		// Database 처리
		// MyBatis 활용해서 session 만들기
		SqlSession sqlSession = MyBatisConnectionFactory.getSqlSessionFactory().openSession();
		List<Board> result = sqlSession.selectList("myBoard.allBoards");
		sqlSession.close();
		return result;
	}
}
