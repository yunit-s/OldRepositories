package boardncmt.service;

import java.util.List;

import boardncmt.dao.BoardNCmtDAO;
import boardncmt.vo.BoardNCmt;

public class BoardNCmtService {

	public List<BoardNCmt> getArticleAll() {
		System.out.println("!! BoardNCmtService.getArticleAll() 실행");
		BoardNCmtDAO bncDao = new BoardNCmtDAO();
		List<BoardNCmt> bncList = bncDao.selectAll();
		return bncList;
	}

}
