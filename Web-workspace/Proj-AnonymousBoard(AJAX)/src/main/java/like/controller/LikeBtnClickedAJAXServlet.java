package like.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONObject;

import board.service.BoardService;
import board.vo.Board;
import like.vo.Like;
import member.vo.Member;

/**
 * Servlet implementation class LikeBtnClickedAJAXServlet
 */
@WebServlet("/likeBtnClickedAJAX")
public class LikeBtnClickedAJAXServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LikeBtnClickedAJAXServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("LikeBtnClickedAJAXServlet.doGet() 실행");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// input data
		request.setCharacterEncoding("UTF-8");
		int bNum = Integer.parseInt((String)request.getParameter("boardNum"));
		HttpSession session = request.getSession();
		Member loginMember = (Member)session.getAttribute("loginMember");
		
		
		
		// process
		// 기존 likes 테이블에 좋아요 기록이 있는지 확인
		Board tgBoard = new Board();
		tgBoard.setBoardNum(bNum);
		BoardService bService = new BoardService();
		tgBoard = bService.getArticleOne(tgBoard);
		boolean isLiked = bService.isLiked(tgBoard.getBoardNum(), loginMember.getMemberId());
		
		// 기존 isLiked값에 따라 다른 결과 적용
		if (isLiked) {
			// 기존에 좋아요가 눌러진 상태일 때
			Like tgLike = new Like();
			tgLike.setLikeArticleNum(bNum);
			tgLike.setLikeMemberId(loginMember.getMemberId());
			int dResult = bService.deleteLikeOne(tgLike);
			tgBoard.setBoardLikeNum(tgBoard.getBoardLikeNum() - 1);
		} else {
			// 기존에 좋아요를 누른 적 없는 상태일 때
			Like tgLike = new Like();
			tgLike.setLikeArticleNum(bNum);
			tgLike.setLikeMemberId(loginMember.getMemberId());
			int iResult = bService.insertLikeOne(tgLike);
			tgBoard.setBoardLikeNum(tgBoard.getBoardLikeNum() + 1);
		}
		int result = bService.editArticleLikeNum(tgBoard);
		isLiked = !isLiked;
		
		
		
		// output data
		JSONObject jsonObj = new JSONObject();
		jsonObj.put("bLikeNum", tgBoard.getBoardLikeNum());
		jsonObj.put("isLiked", isLiked);
		
		response.setContentType("text/json; charset=utf-8"); // MIME type
		PrintWriter out = response.getWriter();
		out.print(jsonObj);
		out.close();
		
	}

}
