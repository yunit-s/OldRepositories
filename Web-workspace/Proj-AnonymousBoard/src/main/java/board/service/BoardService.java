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
		Board rsBoard = bDao.selectOne(tgBoard);
		return rsBoard;
	}

	public int addArticle(Board newBoard) {
		System.out.println("!! BoardService.addArticle() 실행");
		BoardDAO bDao = new BoardDAO();
		int result = bDao.insert(newBoard);
		return result;
	}

	public int editArticle(Board tgBoard) {
		System.out.println("!! BoardService.editArticle() 실행");
		BoardDAO bDao = new BoardDAO();
		int result = bDao.update(tgBoard);
		return result;
	}

	public int delArticleOne(Board tgBoard) {
		System.out.println("!! BoardService.delArticleOne() 실행");
		BoardDAO bDao = new BoardDAO();
		int result = bDao.deleteOne(tgBoard);
		return result;
	}

}
