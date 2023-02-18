package comment.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import board.service.BoardService;
import board.vo.Board;
import comment.service.CommentService;
import comment.vo.Comment;

/**
 * Servlet implementation class DelCommentBtnClickedAJAXServlet
 */
@WebServlet("/delCommentBtnClickedAJAX")
public class DelCommentBtnClickedAJAXServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DelCommentBtnClickedAJAXServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("DelCommentBtnClickedAJAXServlet.doGet() 실행");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// input data
		int cNum = Integer.parseInt(request.getParameter("cNum"));
		
		
		
		// process
		Comment tgComment = new Comment();
		tgComment.setCommentNum(cNum);
		CommentService cService = new CommentService();
		int result = cService.delCommentOne(tgComment);
		
		
		
		// output data
		JSONObject jsonObj = new JSONObject();
		jsonObj.put("result", result);
		
		response.setContentType("text/json; charset=utf-8"); // MIME type
		PrintWriter out = response.getWriter();
		out.print(jsonObj);
		out.close();
		
	}

}
