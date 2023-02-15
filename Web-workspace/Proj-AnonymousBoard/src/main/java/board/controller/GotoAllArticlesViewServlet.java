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
 * Servlet implementation class GotoAllArticlesViewServlet
 */
@WebServlet("/gotoAllArticlesView")
public class GotoAllArticlesViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GotoAllArticlesViewServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// select 전체 게시글
		BoardService bService = new BoardService();
		List<Board> bList = bService.getArticleAll();
		
		// 페이지 전환 - 전체 게시글 보기 
		RequestDispatcher dispatcher = request.getRequestDispatcher("allArticlesView.jsp");
		request.setAttribute("bList", bList);
		dispatcher.forward(request, response); // request 객체와 response 객체를 dispatcher에게 넘겨주기

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("GotoAllArticlesViewServlet.doPost() 실행");
	}

}
