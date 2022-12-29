package lecture.jdbc.controller;

import javafx.collections.ObservableList;
import lecture.jdbc.service.BookService;
import lecture.jdbc.vo.BookVO;

public class BookSearchByKeywordController {

	public ObservableList<BookVO> getResult(String text) {
		// TODO Auto-generated method stub
		// controller의 역할 : View와 Service(Service model) 와의 연결
		// 일을 해줄 Service 객체 생성
		BookService service = new BookService();
		// 이 service의 메소드는 하나의 트랜젝션이 되어야 해.
		// ㅁㅁㅁㅁㅁㅁㅁㅁㅁ 는 작업의 최소 단위거든.
		// 이름 자체를 트랜잭션임을 알려줘야해.
		ObservableList<BookVO> list = service.selectBooksByKeyword(text);
		
		return list;
	}

}
