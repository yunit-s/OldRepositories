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
 * Servlet implementation class SecondServlet
 */
@WebServlet("/secondServlet")
public class SecondServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SecondServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 1. 입력받기
		
		// 2. 로직처리
		ServletContext context = this.getServletContext();
		
		String name = (String)context.getAttribute("memberName"); // context에 저장되어있던 value 가져오기
			// 꺼낼 때는 Object 타입으로만 꺼내진다. 따라서 String으로 캐스팅해야한다.
		
		// 3. 결과처리
		response.setContentType("text/html; charset=UTF-8"); // 설정
		PrintWriter out = response.getWriter(); // 연결통로 뚫기
		
		out.println("<html><head></head>");
		out.println("<body>");
		out.println("가져온 이름은 : " + name); // 링크를 누르는 거니까 GET 방식으로 호출하게 된다.
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
