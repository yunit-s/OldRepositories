package like.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import like.vo.Like;

public class LikeDAO {

	SqlSession sqlSession;
	
	public LikeDAO() {
		// TODO Auto-generated constructor stub
	}

	public LikeDAO(SqlSession sqlSession) {
		super();
		this.sqlSession = sqlSession;
	}

	public Like selectOne(Like tgLike) {
		System.out.println("!! LikeDAO.selectOne() 실행");
		Like rsLike = sqlSession.selectOne("likeXml.selectOne", tgLike);
		return rsLike;
	}

	public int deleteOne(Like tgLike) {
		System.out.println("!! LikeDAO.deleteOne() 실행");
		int result = sqlSession.delete("likeXml.deleteOne", tgLike);
		return result;
	}

	public int insertOne(Like tgLike) {
		System.out.println("!! LikeDAO.insertOne() 실행");
		int result = sqlSession.insert("likeXml.insertOne", tgLike);
		return result;
	}
	
	public List<Like> getLikeCount() {
		System.out.println("!! LikeDAO.getLikeCount() 실행");
		List<Like> lList = sqlSession.selectList("likeXml.getLikeCount");
		return lList;
	}
	
}
