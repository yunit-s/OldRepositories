package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TextInputServlet
 */
@WebServlet("/inputText")
public class TextInputServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	// field를 만들 수 있다.
	// 이 field는 client thread에 의해서 공유된다. 
	int count = 0;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	// 생성자
    public TextInputServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// GET 방식에서는 Encoding 절차가 필요 없다.
		// request.setCharacterEncoding("UTF-8");
		
		// 1. 입력받기
		String data = request.getParameter("userID");
				
		// 2. 로직 처리
		
		// 3. 출력 처리
		//		1. contentType 설정
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter(); // stream 연결하기 
		out.println("<html><head></head><body>");
		out.println("GET 방식 호출 테스트 2");
		out.println("</body></html>");
		
		out.close(); // memory lick(메모리 유실) 이 나지 않도록 close() 실행
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//클라이언트의 요청 처리하기
		
		// POST 방식인 경우
		//		클라이언트로부터 servlet으로 전송된 문자데이터는 ISO_8859_1 인코딩으로 되어 있다.
		//		그래서 기본적으로는 한글처리가 안 된다.
		//		인코딩을 바꿔서 한글 처리를 해줘야 한다.
		//		다른 작업보다 우선적으로 인코딩을 해주자.
		request.setCharacterEncoding("UTF-8");
		
		// stateful 방식. 사용하지 말 것.
		//		편하게 데이터를 공유한다는 장점도 있다.
		//		100퍼센트 싱글톤이라면 이것도 좋지만, 100%가 아닐 수 있기 때문에 stateless 방식이 좋다.
		count += 1;
		
		// 여기서 할 일 : 프로그램이 할 일
		// 1. 입력받기
		String data = request.getParameter("userID");
				
		// 2. 로직 처리
		
		// 3. 출력 처리
		//		1. contentType 설정
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter(); // stream 연결하기 
		out.println("<html><head></head><body>");
		out.println(data + "님 환영합니다.");
		out.println("</body></html>");
		
		out.close(); // memory lick(메모리 유실) 이 나지 않도록 close() 실행
	}

}
