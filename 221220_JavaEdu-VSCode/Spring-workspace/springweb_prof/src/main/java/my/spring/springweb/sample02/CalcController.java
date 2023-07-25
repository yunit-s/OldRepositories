package my.spring.springweb.sample02;

//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import my.spring.springweb.sample01.TestController08;

@Controller
@RequestMapping("/calc.do")
public class CalcController {

//	private static final Logger logger = 
//			LoggerFactory.getLogger(TestController08.class);

	@PostMapping
	public ModelAndView process(@RequestParam("firstNum") int num1,
			int secondNum, String operator) {
		
		// 사용자가 보내준 데이터를 받아야 해요!
		// @RequestParam("")를 이용해서 받아요! (String포함해서 primitive type인 경우)
		ModelAndView mav = new ModelAndView();
		String viewName = "";

		if(operator.equals("div") && secondNum == 0) {
			// 나눗셈을 하는데 분모가 0이예요 => 무한대.. 무한대개념이 없어요. Exception
			viewName = "sample02/errorResult";
			mav.addObject("msg","0으로 나눌 수 없어요!");
		} else {
			int result = 0;
			if(operator.equals("plus")) {
				result = num1 + secondNum;
			} else if(operator.equals("minus")) {
				result = num1 - secondNum;
			} else if(operator.equals("mul")) {
				result = num1 * secondNum;
			} else {
				result = num1 / secondNum;
			}
			viewName = "sample02/calcResult";
			mav.addObject("msg",result);
		}
		
		mav.setViewName(viewName);
		return mav;
	}
}
