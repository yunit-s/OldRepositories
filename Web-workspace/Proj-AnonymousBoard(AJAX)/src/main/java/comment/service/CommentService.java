package comment.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import comment.dao.CommentDAO;
import comment.vo.Comment;
import common.mybatis.MyBatisConnectionFactory;

public class CommentService {

	public List<Comment> getCommentAll(int boardNum) {
		System.out.println("!! CommentService.getCommentAll() 실행");
		SqlSession sqlSession = MyBatisConnectionFactory.getSqlSessionFactory().openSession();
		CommentDAO cDao = new CommentDAO(sqlSession);
		List<Comment> cList = cDao.selectAll(boardNum);
		sqlSession.close();
		return cList;
	}

	public Comment getCommentOne(int commentNum) {
		System.out.println("!! CommentService.getCommentOne() 실행");
		SqlSession sqlSession = MyBatisConnectionFactory.getSqlSessionFactory().openSession();
		CommentDAO cDao = new CommentDAO(sqlSession);
		Comment rsComment = cDao.selectOne(commentNum);
		sqlSession.close();
		return rsComment;
	}

	public int addComment(Comment newComment) {
		System.out.println("!! CommentService.addComment() 실행");
		SqlSession sqlSession = MyBatisConnectionFactory.getSqlSessionFactory().openSession();
		CommentDAO cDao = new CommentDAO(sqlSession);
		int result = cDao.insert(newComment);
		sqlSession.commit();
		sqlSession.close();
		return result;
	}

	public int editComment(Comment tgComment) {
		System.out.println("!! CommentService.editComment() 실행");
		SqlSession sqlSession = MyBatisConnectionFactory.getSqlSessionFactory().openSession();
		CommentDAO cDao = new CommentDAO(sqlSession);
		int result = cDao.update(tgComment);
		sqlSession.commit();
		sqlSession.close();
		return result;
	}

	public int delCommentOne(Comment tgComment) {
		System.out.println("!! CommentService.delCommentOne() 실행");
		SqlSession sqlSession = MyBatisConnectionFactory.getSqlSessionFactory().openSession();
		CommentDAO cDao = new CommentDAO(sqlSession);
		int result = cDao.delete(tgComment);
		sqlSession.commit();
		sqlSession.close();
		return result;
	}

}
