package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CheckServlet
 */
@WebServlet("/myhobby")
public class CheckServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CheckServlet() {
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

		// 1. 입력받기
		String[] data = request.getParameterValues("myCheck");
				
		// 2. 로직 처리
		
		// 3. 출력 처리
		//		1. contentType 설정
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter(); // stream 연결하기 
		out.println("<html><head></head><body>");
		for(String tmp: data) {
			out.println("취미는 : " + tmp + "<br>");
		}
		out.println("POST 방식 호출. checkbox 테스트");
		out.println("</body></html>");
		
		out.close(); // memory lick(메모리 유실) 이 나지 않도록 close() 실행
	}

}
