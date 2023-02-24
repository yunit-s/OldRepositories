package my.spring.SpringWeb.sample01;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value="testController07")
public class TestController07 {

	private static final Logger logger = LoggerFactory.getLogger(TestController07.class);
	
	@GetMapping
	public String myMethod1(Model model) {
		
		// Model 객체가 주입된다.(ApplicationContext에 의해서)
		//		Model은 Map으로 되어 있다.
		//		key : value 형태로 저장한다.
		logger.debug("TestController07.myMethod1() 호출. Model 객체 주입됨");
		model.addAttribute("myName", "홍길동");
		model.addAttribute("myAge", 20); // 20은 primitive 타입이 아니라 Integer 타입으로 저장된다.
		
		return "sample01/testController07"; // 랜더링할 데이터
	}
}
