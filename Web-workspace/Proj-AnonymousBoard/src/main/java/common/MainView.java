package common;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.service.MemberService;
import member.vo.Member;

/**
 * Servlet implementation class MainView
 */
@WebServlet("/mainview")
public class MainView extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MainView() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8"); // ContentType 설정
		PrintWriter out = response.getWriter();
		out.println("<html><head></head><body>");
		out.println("<h3>MainView.java - doGet() 실행됨</h3>");
		out.println("<div>request.getContextPath() 실행 결과 : " + request.getContextPath() + "</div>");
		out.println("</body></html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		doGet(request, response);
		
		// input data
		request.setCharacterEncoding("UTF-8"); // request 자료들을 UTF-8 로 인코딩. 이 작업 안 하면 내부 자료들 한글 깨진다.
		String userId = request.getParameter("userId"); // HTML에 명시된 이름으로 값 가져오기
		String userPw = request.getParameter("userPw"); // HTML에 명시된 이름으로 값 가져오기

		Member loginMember = new Member();
		loginMember.setMemberId(userId);
		loginMember.setMemberPw(userPw);
		
		// data process
		MemberService service = new MemberService();
		loginMember = service.login(loginMember);
		
		
		
		// output data
		response.setContentType("text/html; charset=UTF-8"); // ContentType 설정
		
		// Debug - 직접적인 화면 출력
		PrintWriter out = response.getWriter();
		out.println("<html><head></head><body>");
		out.println("<h3>MainView.java - doPost() 실행됨</h3>");
		out.println("<div>request.getContextPath() 실행 결과 : " + request.getContextPath() + "</div>");
		out.println("<div>loginMember Id = " + loginMember.getMemberId() + ", loginMember Pw = " + loginMember.getMemberPw() + "</div>");
		out.println("</body></html>");
	}

}
