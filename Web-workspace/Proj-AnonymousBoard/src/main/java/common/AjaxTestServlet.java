package common;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONObject;

import comment.vo.Comment;

/**
 * Servlet implementation class AjaxTestServlet
 */
@WebServlet("/AjaxTest")
public class AjaxTestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AjaxTestServlet() {
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
		System.out.println("# AjaxTestServlet.doPost() 실행");
		
		// input data
		request.setCharacterEncoding("UTF-8");
		String data1 = request.getParameter("data1");
		String data2 = request.getParameter("data2");
		System.out.println("# AJAX test servlet. data1 = " + data1 + ", data2 = " + data2);
		
		
		
		// CDN 추가하면 JSONObject 와 JSONArray 클래스를 활용할 수 있다.
		// JSONObject
		//		: json 형태로 문자열을 저장한다. 데이터 전송은 이 클래스 타입을 사용할 것.
		//		{"key1":"value1","key2":"value2"}
		// JSONArray
		//		json에서 배열 데이터를 저장할 때 활용.
		//		["value1","value2","value3"]
		
		data1 = "데이터 이걸로 변환하기";
		data2 = "str2도 데이터 변환하기";
		JSONArray jsonArr = new JSONArray();
		for (int i = 0; i < 5; i++) {
			jsonArr.put("arr " + i);
			System.out.println("# jsonArr = " + jsonArr);
		}
		
		JSONObject jsonObj = new JSONObject();
		jsonObj.put("data1_str", data1);
		jsonObj.put("data2_str", data2);
		System.out.println(jsonObj.toString());
		jsonObj.append("data3_arr", jsonArr);
		jsonObj.append("data4_arr", data1);
		jsonObj.append("data4_arr", data2);
		System.out.println(jsonObj.toString());
		
		
		
		// output data
		response.setContentType("text/json; charset=utf-8"); // MIME type
		PrintWriter out = response.getWriter();
		out.print(jsonObj);
		out.close();
		System.out.println("# PrintWriter closed.");
	}

}
