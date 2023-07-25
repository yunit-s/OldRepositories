package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class BoardServlet
 */
@WebServlet("/BoardServlet")
public class BoardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 두 가지 문제가 있다.
		// 로그인한 사람만 접근 가능해야 한다.
		
		// request.getSession(boolean); 의 의미
		//		false인 경우
		//			나(기존 클라이언트)에게 기존에 할당된 세션객체가 있으면 그걸 주고,
		//			만약 없으면 만들지 말고 null을 리턴한다.
		//		true인 경우
		//			기존에 없으면 새 세션객체를 만든다.
		HttpSession session = request.getSession(false);
		
		
		// 1. 입력받기
		// 2. 로직처리
		// 3. 결과처리
		response.setContentType("text/html; charset=UTF-8"); // 설정
		PrintWriter out = response.getWriter(); // 연결통로 뚫기
		
		out.println("<html><head></head>");
		out.println("<body>");
		if (session != null) {
			String name = (String)session.getAttribute("loginName");
			out.println("<h1>" + name + "님, 게시판에 오신 것을 환영합니다.</h1>");
		} else {
			out.println("<h1>로그인을 해야 사용할 수 있다. 로그인 페이지로 페이지 재설정</h1>");
				// 로그인 페이지로 돌아가는 것은 나중에 할 예정
		}
		out.println("</body></html>");
		
		out.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
