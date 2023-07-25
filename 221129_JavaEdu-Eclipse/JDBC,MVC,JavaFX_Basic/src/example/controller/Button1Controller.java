package example.controller;

import example.service.ButtonService;

public class Button1Controller {

	public String getResult() {
		// Service를 이용해서 로직처리를 부탁한다.
		ButtonService service = new ButtonService();
		String result = service.clickButton();
		
		return null;
	}

}
