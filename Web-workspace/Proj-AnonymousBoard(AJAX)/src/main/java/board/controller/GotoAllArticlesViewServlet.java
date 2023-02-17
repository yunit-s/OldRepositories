package board.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import boardncmt.service.BoardNCmtService;
import boardncmt.vo.BoardNCmt;

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
		
		// input data

		
		
		// process
		
		

		// get data for request attribute
		BoardNCmtService bncService = new BoardNCmtService();
		List<BoardNCmt> bncList = bncService.getArticleAll(); // select 전체 게시글
		
		
		
		// switch page 
		request.setAttribute("bncList", bncList);
		RequestDispatcher dispatcher = request.getRequestDispatcher("allArticlesView.jsp");
		dispatcher.forward(request, response); // request 객체와 response 객체를 dispatcher에게 넘겨주기

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("GotoAllArticlesViewServlet.doPost() 실행");
	}

}
