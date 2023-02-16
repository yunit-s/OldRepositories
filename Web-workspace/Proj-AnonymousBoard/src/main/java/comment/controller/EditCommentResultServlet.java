package comment.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.service.BoardService;
import board.vo.Board;
import comment.service.CommentService;
import comment.vo.Comment;

/**
 * Servlet implementation class editCommentResultServlet
 */
@WebServlet("/editCommentResult")
public class EditCommentResultServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditCommentResultServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("EditCommentResultServlet.doGet() 실행");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// input data
		request.setCharacterEncoding("UTF-8");
		int cNum = Integer.parseInt((String)request.getParameter("cNum"));
		int cArticleNum = Integer.parseInt((String)request.getParameter("cArticleNum"));
		String cContent = (String)request.getParameter("cContent");
		
		
		
		// process
		Comment tgComment = new Comment();
		tgComment.setCommentNum(cNum);
		tgComment.setCommentContent(cContent);
		CommentService cService = new CommentService();
		int result = cService.editComment(tgComment);
		
		
		
		// get data for request attribute
		Board tgBoard = new Board();
		tgBoard.setBoardNum(cArticleNum);
		BoardService bService = new BoardService();
		tgBoard = bService.getArticleOne(tgBoard);
		List<Comment> cList = cService.getCommentAll(tgBoard.getBoardNum());
		
		
		
		// switch page
		request.setAttribute("tgBoard", tgBoard);
		request.setAttribute("cList", cList);
		RequestDispatcher dispatcher = request.getRequestDispatcher("articleDetails.jsp");
		dispatcher.forward(request, response);
		
	}

}
