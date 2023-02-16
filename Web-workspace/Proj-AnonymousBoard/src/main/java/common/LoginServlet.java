package common;

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

import board.service.BoardService;
import board.vo.Board;
import member.service.MemberService;
import member.vo.Member;

/**
 * Servlet implementation class MainView
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("LoginServlet.doGet() 실행");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// input data
		request.setCharacterEncoding("UTF-8"); // request 자료들을 UTF-8 로 인코딩. 이 작업 안 하면 내부 자료들 한글 깨진다.
		String userId = request.getParameter("userId"); // HTML에 명시된 이름으로 값 가져오기
		String userPw = request.getParameter("userPw"); // HTML에 명시된 이름으로 값 가져오기
		
		
		
		// process
		Member loginMember = new Member();
		loginMember.setMemberId(userId);
		loginMember.setMemberPw(userPw);
		MemberService service = new MemberService();
		loginMember = service.login(loginMember);
		
		

		// output data
		response.setContentType("text/html; charset=UTF-8"); // MIME Type으로 ContentType 설정
		if (loginMember != null) {
			// login successful

			// session에 로그인 정보 저장
			loginMember.setMemberPw(null);
			HttpSession session = request.getSession(true);
			session.setAttribute("loginMember", loginMember);

			// get data for request attribute			
			BoardService bService = new BoardService();
			List<Board> bList = bService.getArticleAll(); // select 전체 게시글
			
			
			
			// switch page
			request.setAttribute("bList", bList);
			RequestDispatcher dispatcher = request.getRequestDispatcher("allArticlesView.jsp");
			dispatcher.forward(request, response); // request 객체와 response 객체를 dispatcher에게 넘겨주기
			
//			// debug
//			PrintWriter out = response.getWriter();
//			out.println("<html><head></head><body>");
//			out.println("<h3>MainView.java - doPost() - login success</h3>");
//			out.println("<div>request.getContextPath() 실행 결과 : " + request.getContextPath() + "</div>");
//			out.println("<div>loginMember Id = " + loginMember.getMemberId() + ", loginMember Pw = " + loginMember.getMemberPw() + "</div>");
//			out.println("</body></html>");
			
		} else {
			// login failed

			// switch page
			request.setAttribute("userId", userId);
			request.setAttribute("userPw", userPw);
			RequestDispatcher dispatcher = request.getRequestDispatcher("loginFailed.jsp");
			dispatcher.forward(request, response); // request 객체와 response 객체를 dispatcher에게 넘겨주기
			
		}
	}

}
