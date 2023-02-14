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
 * Servlet implementation class ArticleDetailsCallServlet
 */
@WebServlet("/articleDetailsCall")
public class ArticleDetailsCallServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ArticleDetailsCallServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		response.setContentType("text/html; charset=UTF-8"); // ContentType 설정
		
		// input data
		String bNum = request.getParameter("bNum");
		
		
		
		// process
		Board tgBoard = new Board();
		tgBoard.setBoardNum(Integer.parseInt(bNum));
		
		BoardService bService = new BoardService();
		tgBoard = bService.getArticleOne(tgBoard);
		
		
		
		// switch page
		RequestDispatcher dispatcher = request.getRequestDispatcher("articleDetails.jsp");
		request.setAttribute("tgBoard", tgBoard); // DB에서 검색해온 board 데이터를 request로 넘겨주기
		dispatcher.forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("articleDetailsCallServlet.doPost() 실행");
	}

}
