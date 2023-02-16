package boardncmt.service;

import java.util.List;

import board.dao.BoardDAO;
import board.vo.Board;
import boardncmt.dao.BoardNCmtDAO;
import boardncmt.vo.BoardNCmt;

public class BoardNCmtService {

	public List<BoardNCmt> getArticleAll() {
		System.out.println("!! BoardNCmtService.getArticleAll() 실행");
		BoardNCmtDAO bncDao = new BoardNCmtDAO();
		List<BoardNCmt> bncList = bncDao.selectAll();
		return bncList;
	}

//	public BoardNCmt getArticleOne(BoardNCmt tgBoardNCmt) {
//		System.out.println("!! BoardNCmtService.getArticleOne() 실행");
//		BoardNCmtDAO bncDao = new BoardNCmtDAO();
//		BoardNCmt rsBoardNCmt = bncDao.selectOne(tgBoardNCmt);
//		return rsBoardNCmt;
//	}

}
