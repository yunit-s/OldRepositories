package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AddServlet
 */
@WebServlet("/sum")
public class AddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 이 서블릿을 호출하려면, Query String으로 URL을 작성한다.
		// 		http://127.0.0.1:8080/first/sum?num1=10&num2=20
		
		// 1. 입력 처리
		// 		Query String으로부터 데이터를 받으려면?
		// 			입력받는 데이터는 무조건 문자열이다.
//		String num1 = request.getParameter("num1"); // num1 = 10
//		String num2 = request.getParameter("num2"); // num1 = 20
		
		String num1 = request.getParameter("myNum1");
		String num2 = request.getParameter("myNum2");
		
		// 2. 로직 처리
		int sum = Integer.parseInt(num1) + Integer.parseInt(num2); // 문자열 num1과 num2를 숫자로 바꿔서 더한다.
		
		// 3. 출력 처리
		response.setContentType("text/html; charset=UTF-8"); // mine type. text : ??, html : html 형식, plain : 일반 문자열 형식
		PrintWriter out = response.getWriter();
		out.println("<html>" + "<head></head>" + "<body>" + sum
				+ "진웅이의 소리없는 아우성</body></html>");
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
