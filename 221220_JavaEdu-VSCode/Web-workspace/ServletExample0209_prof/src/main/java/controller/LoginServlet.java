package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;

import mybatis.MyBatisConnectionFactory;
import vo.Member;

/**
 * Servlet implementation class LoginServlet
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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		String id = request.getParameter("userID");
		String pw = request.getParameter("userPW");

		Member member = new Member();
		member.setId(id);
		member.setPassword(pw);

		SqlSession sqlSession = MyBatisConnectionFactory.getSqlSessionFactory().openSession();

		Member result = sqlSession.selectOne("myMember.login", member);
		
		if(result != null) {
			// 로그인 성공
			// servlet container에게 session객체를 요청해요!
			// request.getSession(true);의 의미는..
			// 만약 기존에 내가 할당받은 세션객체가 있으면 그거 주세요!
			// 기존에 할당받은 세션객체가 없으면 만들어 주세요!
			HttpSession session = request.getSession(true);
			// 이 세션객체는 Map형태예요..
			session.setAttribute("loginName", result.getName());
		}

		// 3. 결과처리
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();

		out.println("<html><head></head>");
		out.println("<body>");
		if(result != null) {
			out.println(result.getName() + "님 환영합니다.!!");
			out.println("<br><br>");
			out.println("<a href='board'>게시판 들어가기</a>");
			// 로그인이 성공한 상태
		} else {
			// 로그인이 실패한 상태
			out.println("로그인에 실패했습니다.");
		}		
		out.println("</body></html>");

	}

}
