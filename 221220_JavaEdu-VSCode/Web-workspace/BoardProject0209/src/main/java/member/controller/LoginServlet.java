package member.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import board.service.BoardService;
import board.vo.Board;
import member.service.MemberService;
import member.vo.Member;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
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
		// Servlet은 MVC(Model-View-Controller) pattern에서 Controller의 역할을 한다.
		// Model
		//		1. Data Model
		//			우리가 사용하는 데이터를 관리하는 모델.
		//			데이터베이스 안에 들어가있는 데이터를 이용하기 위해서, 우리는 VO를 만든다.
		//			VO class 가 이 역할을 담당한다.
		//		2. Business Logic Model
		//			Service class 가 이 역할을 담당한다.
		//			이때 데이터베이스 처리가 들어올 수 있는데, 이 데이터베이스 처리는 DAO가 담당한다.
		// View : 프로그램과 상호작용하기 위한 창구.
		//		1. HTML
		//			정적인 경우
		//		2. JSP
		//			동적인 경우
		//			jsp의 내부에 HTML이 들어가 있는데, 이것은 controller가 아니라 view다.
		// Controller
		//		View와 Model을 연결해주는 역할을 담당한다. -> Servlet
		//		View로부터 사용자데이터를 받아서 Model(Service)에게 전달해서 로직처리를 시키고,
		//		로직처리된 결과를 Model(Service)로부터 받아온다.
		//		그 결과를 보고 특정 View를 선택(HTML, JSP)해서 그 View를 클라이언트에게 전달하도록 시킨다.
		
		// 1. 입력받기
		request.setCharacterEncoding("UTF-8");
		String userId = request.getParameter("userID"); // HTML에 명시된 이름으로 값 가져오기
		String userPw = request.getParameter("userPW"); // HTML에 명시된 이름으로 값 가져오기
		
		// 입력받은 데이터로 VO 생성하기
		// 		VO는 데이터베이스의 테이블을 기준으로 만들어져야 한다. DB table을 만들고, VO를 선언하자.
		//		데이터 세팅해서 Service에게 넘겨줄 준비하기
		Member member = new Member();
		member.setMemberId(userId);
		member.setMemberPw(userPw);
		
		
		// 2. 로직처리
		// 로직처리를 하기 위해 Service객체를 생성해야 한다.
		MemberService service = new MemberService();
		// 객체 생성 후, 일 시키기
		// 만약 로그인이 성공하면 VO안에 회원의 이름까지 포함해서 들고 온다.
		// 만약 로그인이 실패하면 null을 리턴받는다.
		//		ㅍㅍㅍㅍㅍㅍㅍㅍㅍㅍㅍㅍ VO를 가지고서 이동하는 것이 좋다.?
		Member result = service.login(member);
		
		List<Board> list = null;
		
		if (result != null) {
			BoardService bservice = new BoardService();
			list = bservice.getAllBoard(); // 모든 글 불러오기
		}
		
		// 3. 출력처리
		if (result != null) {
			// 로그인 성공
			// session에는 로그인했다는 흔적을 남거야한다.
			//		-> session에 남겨놓는게 좋다.
			// service는 일반 java 클래스다. service에서 남기는 거 아님.
			HttpSession session = request.getSession(true);
			session.setAttribute("member", result);
			
			// 불러온 게시판 목록을 session에 저장해도 될까?
			//		이러면 session에 저장하는 파일 용량이 엄청 커져. 그리고 이 게시판 목록은 1회성 데이터일 뿐이야.
			//		session이 편하고 좋긴 하지만, 괜히 session의 공간만 차지하게 되기 때문에 서버에 부하를 많이 주게 된다.
			//		따라서 여기에 저장하지 않는 게 좋다.
			//		여기 말고도 저장할 수 있는 공간이 있다. 바로 request 객체다.
//			session.setAttribute("boardList", list);
			
			// 게시판 HTML 페이지를 클라이언트에게 전송한다.
			// 여기서는 JSP로 전송한다. 왜? JSP는 프로그램적 요소를 전달할 수 있기 때문
			// JSP의 실체는 Servlet이다.
			//		프로세스 과정 : html -> servlet -> service -> dao -> service -> controller -> jsp(servlet) -> client
			//		servlet에서 다른 servlet(jsp)를 불러서 일을 시키게 된다.
			RequestDispatcher dispatcher = request.getRequestDispatcher("loginSuccess.jsp"); // 다음에 실행할 jsp를 명시
			
			// request 객체에 게시판 목록 저장하기
			// 현재 필요한 데이터는 1회성으로써, jsp가 출력할 수 있도록 데이터를 jsp에게 전달만 하면 된다.
			// 따라서 request 객체에 데이터를 붙여서 jsp에게 보낸다.
			request.setAttribute("boardList", list); // request 객체에 boardList라는 이름으로 list를 저장하기
			dispatcher.forward(request, response); // request 객체와 response 객체를 dispatcher에게 넘겨주기
			
			
		} else {
			// 로그인 실패
			// 오류 HTML 페이지를 클라이언트에게 전송하기
			// 여기서는 JSP가 아니라 HTML로 전송한다.
			response.sendRedirect("loginFail.html"); // html 파일을 response로 보내준다.
		}
		
	}

}
