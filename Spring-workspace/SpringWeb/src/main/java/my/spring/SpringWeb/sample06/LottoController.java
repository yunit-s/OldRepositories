package my.spring.SpringWeb.sample06;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import my.spring.SpringWeb.sample06.service.LottoService;
import my.spring.SpringWeb.sample06.vo.Lotto;

@Controller
public class LottoController {

	// service Bean을 찾아서 주입시켜주기
	@Autowired
	private LottoService service;
	
	@GetMapping(value="/lotto")
	public String lottoProcess(@ModelAttribute Lotto lotto) {
		
		// 서비스 객체를 만들어서 로직을 처리해야 한다.
//		LottoService service = new LottoService();
			// ㅍㅍㅍㅍㅍㅍㅍㅍㅍㅍㅍㅍㅍㅍㅍㅍㅍㅍㅍㅍㅍ
		boolean result = service.checkLottoNumber(lotto);
		if (result) {
			lotto.setResult("당첨되었습니다. 행복 시작!!");
		} else {
			lotto.setResult("될 리가 없죠 ㅋ");
		}
		
		return "sample06/lottoView";
	}
}
