package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class NameServlet
 */
@WebServlet("/saveName")
public class NameServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NameServlet() {
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
		String name = request.getParameter("userName");
		
		// 2. 로직처리
		// ServletContext를 가져와서 여기에 이름을 저장해 놓자.
		ServletContext context = this.getServletContext(); // ServletContext 저장공간 생성하기

		// ServletContext는 Map 구조다. key와 value의 쌍으로 저장하는 구조.
		// put 이 아니다. setAttribute()를 활용한다.
		context.setAttribute("memberName", name); // 앞 : key, 뒤 : 저장하고 싶은 객체
		
		// 3. 결과처리
		response.setContentType("text/html; charset=UTF-8"); // 설정
		PrintWriter out = response.getWriter(); // 연결통로 뚫기
		
		out.println("<html><head></head>");
		out.println("<body>");
		out.println("<a href='secondServlet'>두 번째 서블릿 호출</a>"); // 링크를 누르는 거니까 GET 방식으로 호출하게 된다.
		out.println("</body></html>");
		
		out.close();
	}

}
