package common;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import board.service.BoardService;
import board.vo.Board;
import member.service.MemberService;
import member.vo.Member;

/**
 * Servlet implementation class SignupResultServlet
 */
@WebServlet("/signupResult")
public class SignupResultServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SignupResultServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("SignupResultServlet.doGet() 실행");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// input data
		request.setCharacterEncoding("UTF-8");
		String userId = request.getParameter("userId");
		String userPw = request.getParameter("userPw");
		String userName = request.getParameter("userName");
		
		
		
		// process
		// members DB에서 기존 id가 종복되는 지 체크 후 회원가입 진행
		MemberService mService = new MemberService();
		boolean dupResult = mService.isDuplicatedId(userId);
		String nextPageUrl = null;
		if (dupResult == true) {
			// signup failed
			
			// set switch page
			request.setAttribute("userId", userId);
			nextPageUrl = "signupFailed.jsp";
		} else {
			// signup successful

			// add new member
			Member newMember = new Member();
			newMember.setMemberId(userId);
			newMember.setMemberPw(userPw);
			newMember.setMemberName(userName);
			int result = mService.addMember(newMember);
			
			// session에 회원가입 정보 저장
			newMember.setMemberPw(null);
			HttpSession session = request.getSession(true);
			session.setAttribute("loginMember", newMember);

			// get data for request attribute			
			BoardService bService = new BoardService();
			List<Board> bList = bService.getArticleAll(); // select 전체 게시글
			
			// set switch page
			request.setAttribute("bList", bList);
			nextPageUrl = "allArticlesView.jsp";
		}
		
		
		
		// switch page
		RequestDispatcher dispatcher = request.getRequestDispatcher(nextPageUrl);
		dispatcher.forward(request, response);
		
	}

}
