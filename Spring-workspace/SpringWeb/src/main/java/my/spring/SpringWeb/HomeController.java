package my.spring.SpringWeb;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	// annotation을 이용해서 설정을 변경할 수 있다.
	// GET 방식으로 타고 들어오면, home.jsp 로 빠져나가게 된다.
	// 접속 URL : http://localhost:8080/SpringWeb/
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model, HttpServletRequest request) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate ); // map이기 때문에 key, value 형태로 저장하게 된다.
			// model을 따로 forwarding하지 않는다. 단지 저장만 해두면, jsp가 알아서 데이터를 가져가게 된다.
		
		request.setAttribute("attr_key", "attr_value");
		logger.debug("HomeController.home() 실행");
		
		return "home";
	}
	
//	// POST 방식으로 선언하는 방법
//	@RequestMapping(value = "/", method = RequestMethod.POST)
//	public String homePost(Locale locale, Model model) {
//		logger.info("Welcome home! The client locale is {}.", locale);
//		
//		Date date = new Date();
//		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
//		
//		String formattedDate = dateFormat.format(date);
//		
//		model.addAttribute("serverTime", formattedDate );
//		
//		return "home";
//	}
	
}
