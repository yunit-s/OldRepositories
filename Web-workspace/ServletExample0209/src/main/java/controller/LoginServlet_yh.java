package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;

import MyBatis.MyBatisConnectionFactory;
import vo.Member;

/**
 * Servlet implementation class LoginServlet_yh
 */
@WebServlet("/login")
public class LoginServlet_yh extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet_yh() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		
		// 1. 입력처리
		String inputId = request.getParameter("userID");
		String inputPw = request.getParameter("userPW");
		
		// 2. 로직처리
		Member member = new Member();
		member.setId(inputId);
		member.setPassword(inputPw);
		
		SqlSession sqlSession = MyBatisConnectionFactory.getSqlSessionFactory().openSession();
		
		Member result = sqlSession.selectOne("exampleMember.login", member); // myMember라는 namespace에서 id가 login인 select 구문 활용
		
		if (result != null) {
			// 로그인 성공
			// servlet container에게 session 객체를 요청해요!
			// request.getSession(true); 의 의미는..
			// 만약 기존에 내가 할당받은 세션객체가 있으면 그거 주세요!
			// 기존에 할당받은 세션객체가 없으면 만들어주세요!
			HttpSession session = request.getSession(true);
			// 이 세션 객체는 Map형태다.
			session.setAttribute("loginName", result.getName());
		}
		
		// 3. 결과처리
		response.setContentType("text/html; charset=UTF-8"); // 설정
		PrintWriter out = response.getWriter(); // 연결통로 뚫기
		
		out.println("<html><head></head>");
		out.println("<body>");
		out.println("ID : " + inputId + ", PW : " + inputPw);
		if (result != null) {
			out.println(result.getName() + "님 환영합니다.!!");
			out.println("<br><br>");
			out.println("<a href='BoardServlet'>게시판 들어가기</a>");
		} else {
			out.println("로그인에 실패했습니다.");
		}
		out.println("</body></html>");
		
		out.close();
	}

}
