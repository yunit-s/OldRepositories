package member.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import boardncmt.service.BoardNCmtService;
import boardncmt.vo.BoardNCmt;
import member.service.MemberService;
import member.vo.Member;

/**
 * Servlet implementation class EditMemberResultServlet
 */
@WebServlet("/editMemberResult")
public class EditMemberResultServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditMemberResultServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("EditMemberResultServlet.doGet() 실행");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// input data
		request.setCharacterEncoding("UTF-8");
		String memberId = (String)request.getParameter("mId");
		String memberPw = (String)request.getParameter("mPw");
		String memberName = (String)request.getParameter("mName");
		
		
		
		// process
		Member tgMember = new Member();
		tgMember.setMemberId(memberId);
		tgMember.setMemberPw(memberPw);
		tgMember.setMemberName(memberName);
		MemberService mService = new MemberService();
		int result = mService.editMember(tgMember);
		
		HttpSession session = request.getSession(true);
		session.setAttribute("loginMember", tgMember);
		
		
		
		// get data for request attribute
		BoardNCmtService bncService = new BoardNCmtService();
		List<BoardNCmt> bncList = bncService.getArticleAll(); // select 전체 게시글
		
		
		
		// switch page
		request.setAttribute("bncList", bncList);
		RequestDispatcher dispatcher = request.getRequestDispatcher("allArticlesView.jsp");
		dispatcher.forward(request, response);
	}

}
