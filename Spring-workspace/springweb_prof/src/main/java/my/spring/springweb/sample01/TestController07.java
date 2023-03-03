package my.spring.springweb.sample01;

//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("testController07")
public class TestController07 {

//	private static final Logger logger = 
//			LoggerFactory.getLogger(TestController06.class);	

	@GetMapping
	public String myMethod1(Model model) {
		
		// Model 객체가 주입되요! (ApplicationContext에 의해서)
		// Model은 Map으로 되어 있어요. - key:value형태로 데이터를 저장!
//		logger.debug("TestController07 호출되었어요!");
		
		model.addAttribute("myName", "홍길동");
		model.addAttribute("myAge", 20);
		
		return "sample01/testController07";
		
		
	}
}
