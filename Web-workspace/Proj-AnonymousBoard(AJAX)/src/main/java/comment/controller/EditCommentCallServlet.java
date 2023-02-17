package comment.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import comment.service.CommentService;
import comment.vo.Comment;

/**
 * Servlet implementation class editCommentCallServlet
 */
@WebServlet("/editCommentCall")
public class EditCommentCallServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditCommentCallServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("EditCommentCallServlet.doGet() 실행");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// input data
		int cNum = Integer.parseInt(request.getParameter("cNum"));
		
		
		
		// process
		
		

		// get data for request attribute
		CommentService cService = new CommentService();
		Comment tgComment = cService.getCommentOne(cNum);
		
		
		
		// switch page
		request.setAttribute("tgComment", tgComment);
		RequestDispatcher dispatcher = request.getRequestDispatcher("editComment.jsp");
		dispatcher.forward(request, response);
		
	}

}
