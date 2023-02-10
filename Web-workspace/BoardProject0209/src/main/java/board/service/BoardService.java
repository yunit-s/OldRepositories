package board.service;

import java.util.List;

import board.dao.BoardDao;
import board.vo.Board;

public class BoardService {

	public List<Board> getAllBoard() {
		// service니까 로직처리해야 한다.
		// 따로 할 일은 없고, 데이터베이스 처리만 해서 모든 글에 대한 글 목록 가져오면 된다.
		// Board 관련 DAO 불러오기
		BoardDao dao = new BoardDao();
		List<Board> list = dao.selectAll();
		return list;
	}

}
