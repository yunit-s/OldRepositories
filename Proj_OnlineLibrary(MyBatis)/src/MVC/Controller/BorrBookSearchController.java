package MVC.Controller;

import MVC.Service.BorrBookService;
import MVC.VO.BorrBookVO;
import javafx.collections.ObservableList;

public class BorrBookSearchController {

	public ObservableList<BorrBookVO> searchBook(String searchCategory, String searchWord) {
		// service 생성
		// service의 searchBook 호출
		// 리턴받은 list 리턴

		BorrBookService borrBookService = new BorrBookService();
		ObservableList<BorrBookVO> list = borrBookService.searchBook(searchCategory, searchWord);
		return list;
	}

}
