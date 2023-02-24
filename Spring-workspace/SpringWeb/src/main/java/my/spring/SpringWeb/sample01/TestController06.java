package my.spring.SpringWeb.sample01;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.InternalResourceView;

@Controller
@RequestMapping(value="testController06")
public class TestController06 {

	private static final Logger logger = LoggerFactory.getLogger(TestController06.class);
	
	// 이게 진짜로 Bean으로 생성되는 걸까?
	public TestController06() {
		logger.debug("TestController06() 생성자 호출. Bean 생성");
	}
	
	// 동적으로 Controller를 통해 html에 접근하는 URL : http://localhost:8080/SpringWeb/testController06
	// 정적 리소스 html에 접근하는 URL : http://localhost:8080/SpringWeb/resources/sample01/testController06.html
	@GetMapping
	public ModelAndView showStaticView() {
		logger.debug("testController06.showStaticView() 호출");
		
		InternalResourceView view = new InternalResourceView("/resources/sample01/testController06.html");
			// 원래 jsp 만들 때 많이 사용되는데, html을 만들 때도 사용된다.
			// 인자 : view 객체에 대한 경로 전달하기
			//		html인 경우, webapp의 하단부터 절대경로를 이용하면 편하다.
		ModelAndView mav = new ModelAndView(view);
			// 인자로는 view 객체가 있으면 view를 주고, model 객체가 있으면 model을 주면 된다.
		return mav;
	}
}
