package boardncmt.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import boardncmt.vo.BoardNCmt;
import common.mybatis.MyBatisConnectionFactory;

public class BoardNCmtDAO {

	SqlSession sqlSession;
	
	public BoardNCmtDAO() {
		// TODO Auto-generated constructor stub
	}
	
	public BoardNCmtDAO(SqlSession sqlSession) {
		super();
		this.sqlSession = sqlSession;
	}

	public List<BoardNCmt> selectAll() {
		System.out.println("!! BoardNCmtDAO.selectAll() 실행");
		List<BoardNCmt> bncList = sqlSession.selectList("boardncmtXml.selectAll");
		return bncList;
	}

}
