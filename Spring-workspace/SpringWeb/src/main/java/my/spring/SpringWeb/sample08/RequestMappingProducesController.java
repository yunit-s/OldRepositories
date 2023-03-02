package my.spring.SpringWeb.sample08;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.google.gson.Gson;

import my.spring.SpringWeb.common.ApplicationContextProvider;

@Controller
public class RequestMappingProducesController {

	Logger log = LogManager.getLogger("case3");
//	LibraryComponent gson = new LibraryComponent();
	
//	// Gson을 Library Component에서 Bean으로 등록한 뒤 가져오자.
//	@Autowired
//	private Gson gson;
	// Application Context에 직접적으로 접근해서 Gson을 빈으로 가져와보자.
	
	@RequestMapping(value="testProducesController1")
	public String producesMethod01(Model model) {
		log.debug("단순 Get방식 호출");
		model.addAttribute("msg", "producesMethod01");
		
		// jsp 에 직접 출력
		return "sample08/requestMappingProducesView";
	}
	
//	@RequestMapping(value="testProducesController2", produces="text/plain; charset=UTF-8")
	@RequestMapping(value="testProducesController2", produces="application/json; charset=UTF-8")
		// ㅍㅍㅍㅍㅍㅍㅍㅍㅍㅍㅍㅍㅍㅍㅍㅍㅍㅍㅍㅍㅍㅍㅍㅍㅍ
		//		text/plain 을 쓰든, application/json을 쓰든
		//		결국은 produces를 뭘로 정해도 의미가 없다?
		//		결국 Response Headers 의 Content-type 은 text/html;charset=UTF-8 값이 된다.
	public String producesMethod02(Model model) {
		log.debug("produces 속성을 통해 출력물에 대한 형식을 명시해줌");
		model.addAttribute("msg", "producesMethod02");
		
		// jsp 에 직접 출력
		return "sample08/requestMappingProducesView";
	}
	
	@RequestMapping(value="testProducesController3", produces="text/html; charset=UTF-8")
		// 예전에 PrintWriter 스트림 열 때 뭐 필요했어? response 객체 필요했지? 그걸 활용하자.
	public void producesMethod03(HttpServletResponse response) {
		log.debug("produces 속성을 지정하고, 직접 Stream을 열어줌");
		
		try {
			response.setContentType("text/html; charset=UTF-8"); // response의 content-type이 아래에서 정해지지 않기 때문에 미리 수동으로 정해줘야 한다.
			
			PrintWriter out = response.getWriter(); // stream 열기
			out.println("<html><head></head><body>");
			out.println("<h4>소리없는 아우성! 파싱 잘 됐니? 한글은 잘 뜨니?</h4>");
			out.println("</body></html>");
			out.close(); // stream 닫기
				// 한글이 왜 깨질까?
				//		jsp 출력을 정한 게 아니라, 스트림을 직접 뚫어서 별개의 결과를 직접 만든 거야.
				//		그러니까 PrintWriter의 설정이 그대로 넘어가는 거고, produces가 영향을 주지 못하는 거야.
				//		그래서 맨 위에 setContentType() 을 주는 거야.
			// 결국 보면, jsp에 출력하게 되면 jsp에 맞는 형식으로 출력되고, stream을 직접 가져와서 쓰면 그 스트림의 설정을 따라야만 한다.
			// 이렇기 때문에 @Produces 어노테이션 단독으로는 쓰이지 않는다.
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@RequestMapping(value="testProducesController4", produces="application/json; charset=UTF-8")
	public void producesMethod04(HttpServletResponse response) {
		log.debug("produces 속성을 지정하고, GSON으로 JSON 형식의 문자열을 Stream에 직접 출력해줌");
		
		try {

			response.setContentType("application/json; charset=UTF-8"); // response의 content-type이 아래에서 정해지지 않기 때문에 미리 수동으로 정해줘야 한다.
			
			PrintWriter out = response.getWriter(); // stream 열기
			
			// json으로 넘길 자료구조 데이터 하나 만들기
			Map<String, String> map = new HashMap<String, String>();
			map.put("userName", "홍길동");
			map.put("userAge", "20");
			map.put("userAddr", "서울");
			
			// 데이터를 JSON 문자열로 변형하기
			
//			// 기존 방법 - Gson 클래스 직접 사용
//			Gson gson = new Gson();
//			String str = gson.toJson(map);
			
			// 새로운 방법 - Gson 을 Bean으로 등록해서 사용
			ApplicationContext ctx = ApplicationContextProvider.getApplicationContext();
			Gson gson = ctx.getBean("getGson", Gson.class);
			String str = gson.toJson(map);
			
			// Stream을 통해 Client에게 JSON 형식의 데이터 보내기
			out.println(str);
			
			out.close(); // stream 닫기
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
