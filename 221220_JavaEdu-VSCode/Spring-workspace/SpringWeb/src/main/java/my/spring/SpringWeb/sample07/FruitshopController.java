package my.spring.SpringWeb.sample07;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import my.spring.SpringWeb.sample07.vo.FruitshopBasket;

@SessionAttributes(value= {"basket"})
@Controller
public class FruitshopController {

	Logger log = LogManager.getLogger("case3");
	
	// Model과 Session에 basket VO 데이터 할당하기
	@ModelAttribute(value="basket")
	public FruitshopBasket createBasket() {
		log.debug("FruitshopController.createBasket() 장바구니 만들기");
		
		FruitshopBasket basket = new FruitshopBasket();
		return basket;
	}
	
	
	
	
	
	// Get방식으로 3개의 핸들러 사용하는 방법
	@GetMapping(value="addApple")
	public String addApple(@ModelAttribute(value="basket") FruitshopBasket basket) {
		log.debug("FruitshopController.addApple() 호출");
		
//		basket.setAppleNum(basket.getAppleNum() + 1);
		basket.setAppleNum(0);
		return "sample07/fruitshopBasket";
	}
	
	@GetMapping(value="addBanana")
	public String addBanana(@ModelAttribute(value="basket") FruitshopBasket basket) {
		log.debug("FruitshopController.addBanana() 호출");
		
//		basket.setBananaNum(basket.getBananaNum() + 1);
		basket.setBananaNum(0);
		return "sample07/fruitshopBasket";
	}
	
	@GetMapping(value="addHalabong")
	public String addHalabong(@ModelAttribute(value="basket") FruitshopBasket basket) {
		log.debug("FruitshopController.addHalabong() 호출");
		
//		basket.setHalabongNum(basket.getHalabongNum() + 1);
		basket.setHalabongNum(0);
		return "sample07/fruitshopBasket";
	}

	
	
	
	
	// Get방식으로 1개의 핸들러와 자동으로 호출되는 setter메소드를 활용하는 방법
	@GetMapping(value="addFruit")
	public String addFruit(@ModelAttribute(value="basket") FruitshopBasket basket) {
		log.debug("FruitshopController.addHalabong() 호출");
		
		return "sample07/fruitshopBasket";
	}
	
	
	
	
	
	// 공통 기능
	@PostMapping(value="emptyBasket")
	public String emptyBasket(SessionStatus sessionStatus) {
		log.debug("FruitshopController.emptyBasket() 호출");

		sessionStatus.setComplete();
		return "sample07/fruitshopList";
	}
	
	@PostMapping(value="showList")
	public String showList(@ModelAttribute(value="basket") FruitshopBasket basket) {
		log.debug("FruitshopController.showList() 호출");

		log.debug(basket);
		return "sample07/fruitshopList";
	}
}
