package member.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import member.service.MemberService;
import member.vo.Member;

/**
 * Servlet implementation class SignoutCallServlet
 */
@WebServlet("/signoutCall")
public class SignoutCallServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SignoutCallServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("SignoutCallServlet.doGet() 실행");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// input data
		HttpSession session = request.getSession(true);
		
		
		
		// process
		try {
			Member loginMember = (Member)session.getAttribute("loginMember");
			MemberService mService = new MemberService();
			int result = mService.delMember(loginMember);
			
			session.removeAttribute("loginMember");
			System.out.println("!!! signout! id : " + loginMember.getMemberId());
		} catch (Exception e) {
			System.out.println("!!! SignoutCallServlet.doPost() 오류발생 : " + e);
			
			session.removeAttribute("loginMember");
		}
		
		
		
		// get data for request attribute
		
		
		
		// switch page
		response.sendRedirect("login.html");
		
	}

}
