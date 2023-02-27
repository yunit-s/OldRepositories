package my.spring.SpringWeb.sample02;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class JSTLExampleController {

//	@RequestMapping(value="/sample02/jstlExample", method=RequestMethod.GET)
	// value도 있고 name도 있는데, value는 배열로 사용할 수 있다.
	// value에는 핸들러로 사용되는 url을 적어주자
	// method(방식)을 명시하지 않으면 디폴트값은 Get 방식이다.
	public void myMethod1() {
		
		// 리턴형이 void? 이러면 디스패처가 어떻게 한다고?
		//		RequestMapping 의 url 이름(경로)을 따라가서 View 객체를 사용한다.
		//		src/main/webapp/WEB-INF/views/sample02/
		//			여기에 jstlExample.jsp 파일을 만들면 여기에 자동으로 연결되게 된다.
		
	}
	
	@RequestMapping(value="/jstlExample", method=RequestMethod.GET)
	public String myMethod2(Model model) {
		ArrayList<String> list = new ArrayList<String>();
		list.add("홍길동");
		list.add("신사임당");
		list.add("강감찬");
		
		model.addAttribute("myNum", 100);
		model.addAttribute("myList", list);
		
		return "sample02/jstlExample";
	}
	
}
