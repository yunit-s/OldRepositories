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
 * Servlet implementation class NewArticleResultServlet
 */
@WebServlet("/newArticleResult")
public class NewArticleResultServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NewArticleResultServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("newArticleResultServlet.doGet() 실행");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// input data
		request.setCharacterEncoding("UTF-8");
		String bTitle = request.getParameter("bTitle");
		String bAuthor = request.getParameter("bAuthor");
		String bContent = request.getParameter("bContent");
		
		// process
		Board newBoard = new Board();
		newBoard.setBoardTitle(bTitle);
		newBoard.setBoardAuthor(bAuthor);
		newBoard.setBoardContent(bContent);
		
		BoardService bService = new BoardService();
		int result = bService.addArticle(newBoard);

		// select 전체 게시글
		List<Board> bList = bService.getArticleAll();
		
		// switch page
		RequestDispatcher dispatcher = request.getRequestDispatcher("allArticlesView.jsp");
		request.setAttribute("bList", bList);
		dispatcher.forward(request, response); // request 객체와 response 객체를 dispatcher에게 넘겨주기
		
	}

}
