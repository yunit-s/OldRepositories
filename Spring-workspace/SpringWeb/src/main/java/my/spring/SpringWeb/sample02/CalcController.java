package my.spring.SpringWeb.sample02;

import javax.servlet.http.HttpServletRequest;

//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/calc.do")
public class CalcController {
	
//	private static final Logger logger = LoggerFactory.getLogger(CalcController.class);

	// 기존 방식
	// request 객체를 통해서 데이터 입출력
	public ModelAndView process_request(HttpServletRequest request) {
		// 사용자가 보내준 데이터를 받아야 한다.
		String num1 = request.getParameter("firstNum");
		return null;
	}
	
	@PostMapping
//	public ModelAndView process(@RequestParam("firstNum") int num1, @RequestParam("secondNum") int num2, @RequestParam("operator") String operator, Model model) {
	public ModelAndView process(@RequestParam("firstNum") int num1, int secondNum, String operator) {
		// 사용자가 보내준 데이터를 받아야 한다.
		// 파라미터 자료형
		//		원래 firstNum 은 문자열로 저장되어 있어서 String으로 받아야 하지만,
		//			매개변수에서 자료형을 애초에 int로 설정하면, 자동으로 int로 형변환을 해준다.
		// 파라미터 표기법 간략화
		//		만약 저장된 파라미터 이름 firstNum과 매개변수 이름을 동일하게 사용할 경우,
		//			@RequestParam annotation을 아예 생략할 수 있다.
		// 파라미터로 VO가 전달될 경우는 또 다른 방식으로 사용해야하는데, 나중에 설명할 예정
		
		// @RequestParam("") 을 이용해서 받기
		//		primitive type인 경우(String도 여기에 포함됨)
		ModelAndView mav = new ModelAndView();
			// 이번엔 ModelAndView 객체를 사용하고, Model은 사용하지 말자.
		String viewName = "";
		
		if (operator.equals("div") && secondNum == 0) {
			// 나눗셈에서 분모가 0 인 경우
			//		java에서는 무한대를 표현할 수 없기 때문에 exception이 발생한다.
			//		이를 방지하자.
			viewName = "sample02/errorResult";
			mav.addObject("msg", "err. 0으로는 나눌 수 없다.");
		} else {
			int result = 0;
			if (operator.equals("plus")) {
				result = num1 + secondNum;
			} else if (operator.contentEquals("minus")) {
				result = num1 - secondNum;
			} else if (operator.contentEquals("mul")) {
				result = num1 * secondNum;
			} else {
				result = num1 / secondNum;
			}
			viewName = "sample02/calcResult";
			mav.addObject("msg", result); // 이 데이터는 request 객체에 담기게 된다.
		}
		mav.setViewName(viewName); // 우리가 사용할 뷰 객체 이름을 전달해주면, 알아서 그 뷰 이름을 가지고 있는 jsp 를 찾게 된다.
		return mav;
	}
}
