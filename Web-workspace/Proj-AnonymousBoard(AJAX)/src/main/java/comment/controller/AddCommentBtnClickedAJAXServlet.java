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
import javax.servlet.http.HttpSession;

import org.json.JSONObject;

import board.service.BoardService;
import board.vo.Board;
import comment.service.CommentService;
import comment.vo.Comment;
import member.vo.Member;

/**
 * Servlet implementation class AddCommentBtnClickedAJAXServlet
 */
@WebServlet("/addCommentBtnClickedAJAX")
public class AddCommentBtnClickedAJAXServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddCommentBtnClickedAJAXServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("AddCommentBtnClickedAJAXServlet.doGet() 실행");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// input data
		HttpSession session = request.getSession();
		Member loginMember = (Member)session.getAttribute("loginMember");
		request.setCharacterEncoding("UTF-8");
		int cArticleNum = Integer.parseInt(request.getParameter("bNum"));
		String cAuthor = loginMember.getMemberId();
		String cContent = request.getParameter("newCommentContent");
		System.out.println("@@@ 1");
		
		
		
		// process
		Comment newComment = new Comment();
		newComment.setCommentArticleNum(cArticleNum);
		newComment.setCommentAuthor(cAuthor);
		newComment.setCommentContent(cContent);
		CommentService cService = new CommentService();
		int result = cService.addComment(newComment);
		newComment = cService.getCommentNewOne(newComment);
//		int result = 1;
		System.out.println("@@@ 2 : " + newComment.getCommentContent() + newComment.getCommentDate());
		
		
		
		// output data
		JSONObject jsonObj = new JSONObject();
		jsonObj.put("cNum", newComment.getCommentNum());
		jsonObj.put("cArticleNum", newComment.getCommentArticleNum());
		jsonObj.put("cAuthor", newComment.getCommentAuthor());
		jsonObj.put("cContent", newComment.getCommentContent());
		jsonObj.put("cDate", newComment.getCommentDate());
		
		response.setContentType("text/json; charset=utf-8"); // MIME type
		PrintWriter out = response.getWriter();
		out.print(jsonObj);
		out.close();
		
	}

}
