package boardncmt.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import boardncmt.dao.BoardNCmtDAO;
import boardncmt.vo.BoardNCmt;
import common.mybatis.MyBatisConnectionFactory;
import like.dao.LikeDAO;
import like.vo.Like;

public class BoardNCmtService {

	public List<BoardNCmt> getArticleAll() {
		System.out.println("!! BoardNCmtService.getArticleAll() 실행");
		SqlSession sqlSession = MyBatisConnectionFactory.getSqlSessionFactory().openSession();
		
		BoardNCmtDAO bncDao = new BoardNCmtDAO(sqlSession);
		List<BoardNCmt> bncList = bncDao.selectAll();
		
		LikeDAO lDao = new LikeDAO(sqlSession);
		List<Like> lList = lDao.getLikeCount();
		
		for (BoardNCmt item : bncList) {
			for (Like lItem : lList) {
				if (item.getBoardNum() == lItem.getLikeArticleNum()) {
					item.setBoardLikeNum(lItem.getLikeNum());
					break;
				}
			}
		}
		
		sqlSession.close();
		return bncList;
	}

}
