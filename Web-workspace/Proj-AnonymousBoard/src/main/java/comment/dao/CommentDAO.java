package comment.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import comment.vo.Comment;
import common.mybatis.MyBatisConnectionFactory;

public class CommentDAO {

	public List<Comment> selectAll(int boardNum) {
		System.out.println("!! CommentDAO.selectAll() 실행");
		SqlSession sqlSession = MyBatisConnectionFactory.getSqlSessionFactory().openSession();
		List<Comment> cList = sqlSession.selectList("commentXml.selectAll", boardNum);
		sqlSession.close();
		return cList;
	}

	public Comment selectOne(int commentNum) {
		System.out.println("!! CommentDAO.selectOne() 실행");
		SqlSession sqlSession = MyBatisConnectionFactory.getSqlSessionFactory().openSession();
		Comment rsComment = sqlSession.selectOne("commentXml.selectOne", commentNum);
		sqlSession.close();
		return rsComment;
	}
	
	public int insert(Comment newComment) {
		System.out.println("!! CommentDAO.insert() 실행");
		SqlSession sqlSession = MyBatisConnectionFactory.getSqlSessionFactory().openSession();
		int result = sqlSession.insert("commentXml.insertOne", newComment);
		sqlSession.commit();
		sqlSession.close();
		return result;
	}

	public int update(Comment tgComment) {
		System.out.println("!! CommentDAO.update() 실행");
		SqlSession sqlSession = MyBatisConnectionFactory.getSqlSessionFactory().openSession();
		int result = sqlSession.update("commentXml.updateOne", tgComment);
		sqlSession.commit();
		sqlSession.close();
		return result;
	}

	public int delete(Comment tgComment) {
		System.out.println("!! CommentDAO.delete() 실행");
		SqlSession sqlSession = MyBatisConnectionFactory.getSqlSessionFactory().openSession();
		int result = sqlSession.delete("commentXml.deleteOne", tgComment);
		sqlSession.commit();
		sqlSession.close();
		return result;
	}

}
