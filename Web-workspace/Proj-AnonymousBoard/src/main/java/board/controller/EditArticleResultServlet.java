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
		System.out.println("editArticleResultServlet.doGet() 실행");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// input data
		request.setCharacterEncoding("UTF-8");
		String bNum = request.getParameter("bNum");
		String bTitle = request.getParameter("bTitle");
		String bContent = request.getParameter("bContent");
		
		
		
		// process
		Board tgBoard = new Board();
		tgBoard.setBoardNum(Integer.parseInt(bNum));
		tgBoard.setBoardTitle(bTitle);
		tgBoard.setBoardContent(bContent);
		
		BoardService bService = new BoardService();
		int result = bService.editArticle(tgBoard);
		
		
		
		// switch page
		tgBoard = bService.getArticleOne(tgBoard);
		request.setAttribute("tgBoard", tgBoard);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("articleDetails.jsp");
		dispatcher.forward(request, response);
		
	}

}
