package my.spring.springweb.sample01;

//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.InternalResourceView;

@Controller
@RequestMapping(value="testController06")
public class TestController06 {

//	private static final Logger logger = 
//			LoggerFactory.getLogger(TestController06.class);	
	
	// 이거 진짜로 Bean으로 생성되는 건가요?
	public TestController06() {
//		logger.debug("TestController06 Bean 생성!");
	}
	
	@GetMapping
	public ModelAndView showStaticView() {
		
//		logger.debug("testController06 호출!");
		
		// html인 경우 webapp하단부터 절대경로를 이용하면 편해요!
		InternalResourceView view = 
				new InternalResourceView("/resources/sample01/testController06.html");
		
		ModelAndView mav = new ModelAndView(view);
		
		return mav;
		
	}
}
