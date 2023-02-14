package board.service;

import java.util.List;

import board.dao.BoardDAO;
import board.vo.Board;

public class BoardService {

	public List<Board> getArticleAll() {
		System.out.println("!! BoardService.getArticleAll() 실행");
		BoardDAO bDao = new BoardDAO();
		List<Board> bList = bDao.selectAll();
		return bList;
	}

	public Board getArticleOne(Board tgBoard) {
		System.out.println("!! BoardService.getArticleOne() 실행");
		BoardDAO bDao = new BoardDAO();
		Board board = bDao.selectOne(tgBoard);
		return board;
	}

	public int addArticle(Board newBoard) {
		System.out.println("!! BoardService.addArticle() 실행");
		BoardDAO bDao = new BoardDAO();
		int result = bDao.insert(newBoard);
		return result;
	}

}
