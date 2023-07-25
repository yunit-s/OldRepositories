package comment.controller;

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
 * Servlet implementation class NewCommentCallServlet
 */
@WebServlet("/newCommentCall")
public class NewCommentCallServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NewCommentCallServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("NewCommentCallServlet.doGet() 실행");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// input data
		HttpSession session = request.getSession();
		Member loginMember = (Member)session.getAttribute("loginMember");
		request.setCharacterEncoding("UTF-8");
		int cArticleNum = Integer.parseInt(request.getParameter("cArticleNum"));
		String cAuthor = request.getParameter("cAuthor");
		String cContent = request.getParameter("cContent");
		
		
		
		// process
		Comment newComment = new Comment();
		newComment.setCommentArticleNum(cArticleNum);
		newComment.setCommentAuthor(cAuthor);
		newComment.setCommentContent(cContent);
		CommentService cService = new CommentService();
		int result = cService.addComment(newComment);
		
		
		
		// get data for request attribute
		Board tgBoard = new Board();
		tgBoard.setBoardNum(cArticleNum);
		BoardService bService = new BoardService();
		tgBoard = bService.getArticleOne(tgBoard);
		List<Comment> cList = cService.getCommentAll(tgBoard.getBoardNum());
		
		// like 정보
		boolean isLiked = bService.isLiked(tgBoard.getBoardNum(), loginMember.getMemberId());
		
		
		
		// switch page
		request.setAttribute("tgBoard", tgBoard);
		request.setAttribute("cList", cList);
		request.setAttribute("isLiked", isLiked);
		RequestDispatcher dispatcher = request.getRequestDispatcher("articleDetails.jsp");
		dispatcher.forward(request, response);
		
	}

}
