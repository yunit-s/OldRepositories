package comment.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import comment.service.CommentService;
import comment.vo.Comment;

/**
 * Servlet implementation class EditCommentCompleteBtnClickedAJAXServlet
 */
@WebServlet("/editCommentCompleteBtnClickedAJAX")
public class EditCommentCompleteBtnClickedAJAXServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditCommentCompleteBtnClickedAJAXServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("EditCommentCompleteBtnClickedAJAXServlet.doGet() 실행");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// input data
		request.setCharacterEncoding("UTF-8");
		int cNum = Integer.parseInt(request.getParameter("cNum"));
//		String cAuthor = request.getParameter("cAuthor");
		String cContent = request.getParameter("cContent");
//		String cDate = request.getParameter("cDate");
		
		
		
		// process
		Comment tgComment = new Comment();
		tgComment.setCommentNum(cNum);
		tgComment.setCommentContent(cContent);
		CommentService cService = new CommentService();
		int result = cService.editComment(tgComment);
		
		
		
		// output data
		JSONObject jsonObj = new JSONObject();
		jsonObj.put("result", result);
		
		response.setContentType("text/json; charset=utf-8"); // MIME type
		PrintWriter out = response.getWriter();
		out.print(jsonObj);
		out.close();
	}

}
