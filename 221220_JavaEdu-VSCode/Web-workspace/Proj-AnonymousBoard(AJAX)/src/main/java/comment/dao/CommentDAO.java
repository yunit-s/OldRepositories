package comment.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import comment.vo.Comment;

public class CommentDAO {

	SqlSession sqlSession;
	
	public CommentDAO() {
		// TODO Auto-generated constructor stub
	}
	
	public CommentDAO(SqlSession sqlSession) {
		super();
		this.sqlSession = sqlSession;
	}

	public List<Comment> selectAll(int boardNum) {
		System.out.println("!! CommentDAO.selectAll() 실행");
		List<Comment> cList = sqlSession.selectList("commentXml.selectAll", boardNum);
		return cList;
	}

	public Comment selectOne(int commentNum) {
		System.out.println("!! CommentDAO.selectOne() 실행");
		Comment rsComment = sqlSession.selectOne("commentXml.selectOne", commentNum);
		return rsComment;
	}

	public Comment selectNewOne(Comment newComment) {
		System.out.println("!! CommentDAO.selectNewOne() 실행");
		Comment rsComment = sqlSession.selectOne("commentXml.selectNewOne", newComment);
		return rsComment;
	}
	
	public int insert(Comment newComment) {
		System.out.println("!! CommentDAO.insert() 실행");
		int result = sqlSession.insert("commentXml.insertOne", newComment);
		return result;
	}

	public int update(Comment tgComment) {
		System.out.println("!! CommentDAO.update() 실행");
		int result = sqlSession.update("commentXml.updateOne", tgComment);
		return result;
	}

	public int delete(Comment tgComment) {
		System.out.println("!! CommentDAO.delete() 실행");
		int result = sqlSession.delete("commentXml.deleteOne", tgComment);
		return result;
	}

}
