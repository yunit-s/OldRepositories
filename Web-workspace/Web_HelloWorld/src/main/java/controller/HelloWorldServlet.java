package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HelloWorldServlet
 */
@WebServlet("/sayHello")
public class HelloWorldServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HelloWorldServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		// GET 방식으로 호출되면, 결국은 돌고 돌아서 Thread에 의해 이 method가 호출된다.
		// 		1. 클라이언트가 보내준 데이터를 받는다.
		// 			-> request 객체를 이용해서 데이터 받기
		// 		2. 로직 처리 (DB 처리 포함)
		//		3. 출력 처리
		// 			-> response 객체를 이용해서 데이터 출력
		//			1. 처리된 결과를 보내주기 전에, 먼저 처리한 결과가 어떤 데이터인지 알려줘야 한다.
		response.setContentType("text/html; charset=UTF-8"); // mine type. text : ??, html : html 형식, plain : 일반 문자열 형식
		// 			2. 실제 결과 데이터를 전송하면 된다.
		// 				네트워크를 통해서 전송해야 하기 때문에, stream을 열어서 데이터를 전송한다.
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<head></head>");
		out.println("<body>진웅이의 소리없는 아우성</body></html>");
		out.close();
		// Get 방식으로 request를 보내야한다.
		// 접속 : http:// ip / Context root / URL mapping
		// 		http://127.0.0.1:8080/first/sayHello
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
