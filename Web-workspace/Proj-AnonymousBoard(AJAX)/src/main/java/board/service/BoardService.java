package board.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import board.dao.BoardDAO;
import board.vo.Board;
import common.mybatis.MyBatisConnectionFactory;
import like.dao.LikeDAO;
import like.vo.Like;
import member.vo.Member;

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

	public boolean isLiked(int boardNum, String memberId) {
		// 좋아요 정보가 likes 테이블에 존재하는지 여부 확인
		System.out.println("!! BoardService.isLiked() 실행");
		SqlSession sqlSession = MyBatisConnectionFactory.getSqlSessionFactory().openSession();
		Like tgLike = new Like();
		tgLike.setLikeArticleNum(boardNum);
		tgLike.setLikeMemberId(memberId);
		LikeDAO lDao = new LikeDAO(sqlSession);
		tgLike = lDao.selectOne(tgLike);
		sqlSession.close();
		if (tgLike != null)
			return true;
		else
			return false;
	}

	public int editArticleLikeNum(Board tgBoard) {
		// 글의 좋아요 수 수정하기
		System.out.println("!! BoardService.editArticleLikeNum() 실행");
		SqlSession sqlSession = MyBatisConnectionFactory.getSqlSessionFactory().openSession();
		BoardDAO bDao = new BoardDAO(sqlSession);
		int result = bDao.updateLikeNum(tgBoard);
		sqlSession.commit();
		sqlSession.close();
		return result;
	}

	public int deleteLikeOne(Like tgLike) {
		// likes 테이블에서 데이터 하나 삭제
		System.out.println("!! BoardService.deleteLikeOne() 실행");
		SqlSession sqlSession = MyBatisConnectionFactory.getSqlSessionFactory().openSession();
		LikeDAO lDao = new LikeDAO(sqlSession);
		int result = lDao.deleteOne(tgLike);
		sqlSession.commit();
		sqlSession.close();
		return result;
	}

	public int insertLikeOne(Like tgLike) {
		// likes 테이블에서 데이터 하나 추가
		System.out.println("!! BoardService.insertLikeOne() 실행");
		SqlSession sqlSession = MyBatisConnectionFactory.getSqlSessionFactory().openSession();
		LikeDAO lDao = new LikeDAO(sqlSession);
		int result = lDao.insertOne(tgLike);
		sqlSession.commit();
		sqlSession.close();
		return result;
	}

}
