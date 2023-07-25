package container;

import ThreadInvoker.ClientThread;
import arguments.HttpServletRequest;
import arguments.HttpServletResponse;
import servlet.AddServlet;

// Tomcat(WAS) 안의 Servlet Container 역할을 하는 클래스
public class ServletContainer {

	// 일반 자바 프로그램이기 때문에 있는 거고, 실제로 Servlet Container는 가지고 있지 않다.
	public static void main(String[] args) {
		
		// 1. 사용자의 요청사항(request)을 분석
		// 		어떤 서블릿을 실행하는 지 알아내기.
		// 		ㄴ> Add Servlet 실행
		// 2. Add 라는 서블릿의 instance가 있는 지를 확인한다.
		// 		Container 안에 객체가 있는 지를 확인한다.
		
		// 3. 객체가 없기 때문에 AddServlet을 찾아서 객체를 생성한다.
		AddServlet servlet = new AddServlet();
		
		// 4. Servlet instance 가 생성되면 바로 다음에 해당 서블릿의 init()을 호출한다.
		servlet.init();
		
		// 5. 클라이언트가 보내준 request 내용을 기반으로 객체를 하나 생성한다.
		// 		당연히 이 객체에는 클라이언트가 보내준 데이터가 들어가 있다.
		HttpServletRequest request = new HttpServletRequest();
		
		// 6. 클라이언트에게 최종 결과를 보내주기 위해서 response 객체를 하나 만들어야 한다.
		HttpServletResponse response = new HttpServletResponse();
		
		// 7. 클라이언트의 요청을 실제로 처리하기 위해서 Thread가 있어야 한다.
		ClientThread thread = new ClientThread(servlet, request, response);
		thread.start();
		// ㅍㅍㅍㅍㅍㅍㅍㅍㅍㅍㅍㅍㅍㅍ
		
	}
}
