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
 * Servlet implementation class delCommentCallServlet
 */
@WebServlet("/delCommentCall")
public class DelCommentCallServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DelCommentCallServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("!! DelCommentCallServlet.doGet() 실행");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// input data
		int bNum = Integer.parseInt(request.getParameter("bNum"));
		int cNum = Integer.parseInt(request.getParameter("cNum"));
		
		
		
		// process
		Comment tgComment = new Comment();
		tgComment.setCommentNum(cNum);
		CommentService cService = new CommentService();
		int result = cService.delCommentOne(tgComment);
		
		

		// get data for request attribute
		Board tgBoard = new Board();
		tgBoard.setBoardNum(bNum);
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
