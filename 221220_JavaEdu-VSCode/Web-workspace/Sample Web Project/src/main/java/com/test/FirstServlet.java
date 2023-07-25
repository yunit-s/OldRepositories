package com.test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FirstServlet
 */
// 이 이름으로 client가 이 servlet을 호출할 수 있다.
@WebServlet("/myservlet")
public class FirstServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public FirstServlet() {
        // TODO Auto-generated constructor stub
    }
    
    // init() method의 목적
    // 		servlet instance를 초기화한다.
    // 		초기화할 내용이 없으면 생략해도 된다.
    // servlet instance가 만들어지고 난 후, 자동으로 init() method가 호출된다.
    // 그 다음에야 doGet() 같은 메소드가 호출된다.
    @Override
    public void init() throws ServletException {
    	// TODO Auto-generated method stub
//    	super.init();
    	System.out.println("init() 호출됨");
    }
    
    // Thread가 호출하는 service method
    // HttpServletRequest req, : Request 객체
    // HttpServletResponse resp : Response 객체
    // 그런데 이거는 우리가 직접 작성할 필요 없다.
    // 		이미 할 일이 정해져있기 때문.
//    @Override
//    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//    	// TODO Auto-generated method stub
//    	super.service(req, resp);
//    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());

		// 클라이언트가 GET 방식으로 이 servlet을 호출하면, 이 doGet() method가 호출된다.
		// 클라이언트의 호출 URL => http://127.0.0.1:8080/sample/myservlet
		// 127.0.0.1 : 이 컴퓨터
		// 8080 : web server
		// sample : 우리 project
		// myservlet : 맵핑
		// 이 클래스 안에 있는 doGet() 이 호출된다.
		// 여기에는 클라이언트가 서버를 호출했을 때, 서버쪽에서 해야할 일을 작성하면 된다.
		// 프로그램의 처리방식대로 작성하자.
		// 		1. 입력 받기 -> 없다. 넘어가자.
		// 		2. 로직 처리하기 -> 없다. 넘어가자.
		// 		3. 출력
		// 			1. 내가 클라이언트에게 전달한 데이터가 어떤 데이터인지 설정하기
		response.setContentType("text/html; charset=UTF-8"); // 작성 방식이 정해져있다. html 문서를 가리키는 방식
			// filename/jpeg 라고 쓰면, filename.jpeg 파일을 가리키는 것.
			// 지금부터 만들어지는 결과는 html 내용이고, 그 안의 문자셋은 유니코드다. 라는 의미
		// 			2. 클라이언트에게 데이터를 전달하기 위한 stream 열기
		PrintWriter out = response.getWriter(); // 데이터 통로 뚫기
		// 			3. 통로를 통해서 데이터 전달하기
		out.println("<html>");
		out.println("<head></head>");
		out.println("<body>");
		out.println("<div>이건 서블릿의 결과다. 소리없는 아우성!!</div>");
		out.println("<div>브라우저에서는 http://127.0.0.1:8080/sample/myservlet 에 접속하면 확인할 수 있다.</div></body>");
		out.println("<div>만약 404 not found 오류가 뜨면, Tomcat을 재시작해볼 것.</div></body>");
		out.println("</body>");
		out.println("</html>");
		
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
