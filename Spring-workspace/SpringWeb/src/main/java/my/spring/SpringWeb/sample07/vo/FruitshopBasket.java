package my.spring.SpringWeb.sample07.vo;

import lombok.AllArgsConstructor;
//import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class FruitshopBasket {

	private int appleNum;
	private int bananaNum;
	private int halabongNum;

	// setter 메소드에 사용자 로직을 적용해서 구현
	// @ModelAttribute 를 활용하여 인자에 데이터를 받을 경우, 자동으로 setter 메소드를 실행하게 된다.
	//		지금 코드는 이를 실험해보는 코드임
	public void setAppleNum(int appleNum) {
		this.appleNum += 1;
	}

	public void setBananaNum(int bananaNum) {
		this.bananaNum += 1;
	}

	public void setHalabongNum(int halabongNum) {
		this.halabongNum += 1;
	}
	
}
