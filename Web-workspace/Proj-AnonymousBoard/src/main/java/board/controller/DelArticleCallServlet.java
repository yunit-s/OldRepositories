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

/**
 * Servlet implementation class DelArticleCallServlet
 */
@WebServlet("/delArticleCall")
public class DelArticleCallServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DelArticleCallServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("DelArticleCallServlet.doGet() 실행");
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
		int result = bService.delArticleOne(tgBoard);
		
		
		
		// get data for request attribute
		List<Board> bList = bService.getArticleAll(); // select 전체 게시글
		
		
		
		// switch page
		request.setAttribute("bList", bList);
		RequestDispatcher dispatcher = request.getRequestDispatcher("allArticlesView.jsp");
		dispatcher.forward(request, response);
		
	}

}
