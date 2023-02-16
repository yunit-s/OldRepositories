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

}
