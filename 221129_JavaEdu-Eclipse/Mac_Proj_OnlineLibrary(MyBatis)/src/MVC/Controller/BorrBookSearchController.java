package MVC.Controller;

import MVC.Service.BorrBookService;
import MVC.VO.BorrBookVO;
import javafx.collections.ObservableList;

public class BorrBookSearchController {

	public ObservableList<BorrBookVO> searchBook(String searchCategory, String searchWord) {
		BorrBookService borrBookService = new BorrBookService();
		ObservableList<BorrBookVO> list = borrBookService.searchBook_mybatis(searchCategory, searchWord);
		return list;
	}

}
