package boardncmt.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import boardncmt.vo.BoardNCmt;
import common.mybatis.MyBatisConnectionFactory;

public class BoardNCmtDAO {

	public List<BoardNCmt> selectAll() {
		System.out.println("!! BoardNCmtDAO.selectAll() 실행");
		SqlSession sqlSession = MyBatisConnectionFactory.getSqlSessionFactory().openSession();
		List<BoardNCmt> bncList = sqlSession.selectList("boardncmtXml.selectAll");
		sqlSession.close();
		return bncList;
	}

//	public BoardNCmt selectOne(BoardNCmt tgBoardNCmt) {
//		System.out.println("!! BoardNCmtDAO.selectOne() 실행");
//		SqlSession sqlSession = MyBatisConnectionFactory.getSqlSessionFactory().openSession();
//		BoardNCmt rsBoardNCmt = sqlSession.selectOne("boardncmtXml.selectOne", tgBoardNCmt);
//		sqlSession.close();
//		return rsBoardNCmt;
//	}

}
