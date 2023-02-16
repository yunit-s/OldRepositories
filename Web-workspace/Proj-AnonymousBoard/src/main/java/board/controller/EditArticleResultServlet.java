package board.controller;

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
 * Servlet implementation class EditArticleResultServlet
 */
@WebServlet("/editArticleResult")
public class EditArticleResultServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditArticleResultServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("EditArticleResultServlet.doGet() 실행");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// input data
		request.setCharacterEncoding("UTF-8");
		int bNum = Integer.parseInt(request.getParameter("bNum"));
		String bTitle = request.getParameter("bTitle");
		String bContent = request.getParameter("bContent");
		
		
		
		// process
		Board tgBoard = new Board();
		tgBoard.setBoardNum(bNum);
		tgBoard.setBoardTitle(bTitle);
		tgBoard.setBoardContent(bContent);
		BoardService bService = new BoardService();
		int result = bService.editArticle(tgBoard);
		
		

		// get data for request attribute
		tgBoard = bService.getArticleOne(tgBoard);
		CommentService cService = new CommentService();
		List<Comment> cList = cService.getCommentAll(tgBoard.getBoardNum());
		
		
		
		// switch page
		request.setAttribute("tgBoard", tgBoard);
		request.setAttribute("cList", cList);
		RequestDispatcher dispatcher = request.getRequestDispatcher("articleDetails.jsp");
		dispatcher.forward(request, response);
		
	}

}
