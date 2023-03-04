package board.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import board.service.BoardService;
import board.vo.Board;
import comment.service.CommentService;
import comment.vo.Comment;
import member.vo.Member;

/**
 * Servlet implementation class ArticleDetailsCallServlet
 */
@WebServlet("/articleDetailsCall")
public class ArticleDetailsCallServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ArticleDetailsCallServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// input data
		HttpSession session = request.getSession();
		Member loginMember = (Member)session.getAttribute("loginMember");
//		request.setCharacterEncoding("UTF-8");
		int bNum = Integer.parseInt(request.getParameter("bNum"));
		int bLikeNum = Integer.parseInt(request.getParameter("bLikeNum"));
		
		
		
		// process
		
		

		// get data for request attribute
		Board tgBoard = new Board();
		tgBoard.setBoardNum(bNum);
		BoardService bService = new BoardService();
		tgBoard = bService.getArticleOne(tgBoard);
		tgBoard.setBoardLikeNum(bLikeNum);
		CommentService cService = new CommentService();
		List<Comment> cList = cService.getCommentAll(tgBoard.getBoardNum());
		
		// like 정보
		boolean isLiked = bService.isLiked(tgBoard.getBoardNum(), loginMember.getMemberId());
		
		
		
		// switch page
//		response.setContentType("text/html; charset=UTF-8"); // MIME Type으로 ContentType 설정
		request.setAttribute("tgBoard", tgBoard); // DB에서 검색해온 board 데이터를 request로 넘겨주기
		request.setAttribute("cList", cList);
		request.setAttribute("isLiked", isLiked);
		RequestDispatcher dispatcher = request.getRequestDispatcher("articleDetails.jsp");
		dispatcher.forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("ArticleDetailsCallServlet.doPost() 실행");
	}

}
