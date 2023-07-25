package board.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import board.vo.Board;

public class BoardDAO {

	SqlSession sqlSession;

	public BoardDAO() {
		// TODO Auto-generated constructor stub
	}

	public BoardDAO(SqlSession sqlSession) {
		super();
		this.sqlSession = sqlSession;
	}

	public List<Board> selectAll() {
		System.out.println("!! BoardDAO.selectAll() 실행");
		List<Board> bList = sqlSession.selectList("boardXml.selectAll");
		return bList;
	}

	public Board selectOne(Board tgBoard) {
		System.out.println("!! BoardDAO.selectOne() 실행");
		Board rsBoard = sqlSession.selectOne("boardXml.selectOne", tgBoard);
		return rsBoard;
	}

	public int insert(Board newBoard) {
		System.out.println("!! BoardDAO.insert() 실행");
		int result = sqlSession.insert("boardXml.insertOne", newBoard);
		return result;
	}

	public int update(Board tgBoard) {
		System.out.println("!! BoardDAO.update() 실행");
		int result = sqlSession.update("boardXml.updateOne", tgBoard);
		return result;
	}

	public int updateLikeNum(Board tgBoard) {
		System.out.println("!! BoardDAO.updateLikeNum() 실행");
		int result = sqlSession.update("boardXml.updateLikeNum", tgBoard);
		return result;
	}

	public int deleteOne(Board tgBoard) {
		System.out.println("!! BoardDAO.deleteOne() 실행");
		int result = sqlSession.delete("boardXml.deleteOne", tgBoard);
		return result;
	}

}
