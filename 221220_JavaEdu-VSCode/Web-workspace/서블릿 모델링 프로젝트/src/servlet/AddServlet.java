package servlet;

import arguments.HttpServletRequest;
import arguments.HttpServletResponse;

// Servlet(서블릿)이라고 불리는 이 클래스는 원래 특정 클래스 (HttpServlet)를 상속해서 만들어야 한다.
public class AddServlet {

	public void init() {
		// Servlet Instance의 초기화 담당
		// 생성자에서 하지 않고 여기서 한다.
	}
	
	public void service(HttpServletRequest request, HttpServletResponse response) {
		// 이 메소드는 이미 하는 일이 정해져 있다.
		// request 객체를 뒤져서, 클라이언트의 요청 방식이 어떤 방식인지 알아낸다.
		// 		만약 GET 방식이면
		doGet(request, response);
		// 		만약 POST 방식이면
		doPost(request, response);
	}
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) {
		// 여기에서 request 객체와 response 객체를 이용해서 입력처리, 로직처리, 출력처리를 진행한다.
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) {
		
	}
	
	
}
