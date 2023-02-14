package board.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.service.BoardService;
import board.vo.Board;

/**
 * Servlet implementation class EditArticleCallServlet
 */
@WebServlet("/editArticleCall")
public class EditArticleCallServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditArticleCallServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("editArticleCallServlet.doGet() 실행");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// input data
		int bNum = Integer.parseInt(request.getParameter("bNum"));
		
		
		
		// process
		Board tgBoard = new Board();
		tgBoard.setBoardNum(bNum);
		
		BoardService bService = new BoardService();
		tgBoard = bService.getArticleOne(tgBoard);
		
		
		
		// switch page
		RequestDispatcher dispatcher = request.getRequestDispatcher("editArticle.jsp");
		request.setAttribute("tgBoard", tgBoard);
		dispatcher.forward(request, response);
		
	}

}
