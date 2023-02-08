package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;

import mybatis.MyBatisConnectionFactory;
import vo.Book;

/**
 * Servlet implementation class BookSearchServlet
 */
@WebServlet("/bookSearch")
public class BookSearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BookSearchServlet() {
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
		// 한글 처리
		request.setCharacterEncoding("UTF-8"); // 이걸 해야 한글을 제대로 받아올 수 있다.
		
		// 1. 입력 받기
		String keyword = request.getParameter("keyword"); // html에 적어뒀던 키워드와 매칭해야 한다.
		String price = request.getParameter("price"); // html에 적어뒀던 키워드와 매칭해야 한다.
		
		// 2. 로직 처리 (데이터베이스 처리도 포함)
		// Query문을 활용하기 위해 MyBatis 세팅
		//		1. sqlSessionFactory 설정(SqlMapConfig.xml)
		//		2. 연결정보 따로 분리해서 설정(driver.properties)
		//		3. SQL을 실행하기 위한 mapper 설정(sqlmap/Book.xml)
		
		// 클라이언트가 보내준 데이터를 이용해서 VO 생성
		Book book = new Book();
		book.setBtitle(keyword);
		book.setBprice(Integer.parseInt(price));
		
		SqlSession session = MyBatisConnectionFactory.getSqlSessionFactory().openSession();
			// 이 session 이 있어야만 mapper의 CDATA 내용(query문)을 실행시킬 수가 있다.
		List<Book> result = session.selectList("myBook.selectBookByKeyword", book); // myBook : namespace, book : parameter로 쓰일 VO객체 
		
		// 사용 다 했으니 닫기
		session.close();
		
		// 3. 결과 출력
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<html><head></head><body>");
		out.println("<h1>검색결과입니다.</h1>");
		out.println("<h3>검색키워드: " + keyword + "</h3>");
		out.println("<h3>검색가격: " + price + "</h3>");
		out.println("<ul>");

		for(Book tmp: result) {
			out.println("<li>" + tmp.getBtitle() + "," + tmp.getBprice() + "</li>");
		}

		out.println("</ul>");
		out.println("</body></html>");
		
		out.close();
	}

}
