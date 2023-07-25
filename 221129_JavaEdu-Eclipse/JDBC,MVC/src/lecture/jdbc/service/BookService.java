package lecture.jdbc.service;

import javafx.collections.ObservableList;
import lecture.jdbc.dao.BookDAO;
import lecture.jdbc.vo.BookVO;

// 이 service 클래스가 로직을 담당하는 클래스다.
public class BookService {

	public ObservableList<BookVO> selectBooksByKeyword(String text) {
		// TODO Auto-generated method stub
		// 검색 키워드를 받아서, ObservableList<BookVO>를 리턴하는 하나의 작업(transaction)을 처리.
		// 이 작업을 하기 위해서, 로직 처리가 필요하다.
		// 일반적인 경우라면 여기에 로직 처리와 데이터베이스 처리 코드가 같이 있지만, 우리는 코드가 간단해서 데이터베이스 뒤져보기만 한다. 결과만 가져오면 끝남.
		
		// 일단 데이터베이스 처리하자.
		// 그런데 여기서 하면 안 돼. 그럼 어떻게 해?
		// DAO(Data Access Object) 한테 시킨다.
		BookDAO dao = new BookDAO();
		// DAO 가 하는 일이 뭐야? CRUD 작업하는 거야. DB에 데이터 넣고 삭제하고 수정하고 그런 것들 하는 거야.
		// DAO 본연의 역할은 로직같은 거 몰라. 그냥 시키는 DB 처리만 하는 거야.
		ObservableList<BookVO> list = dao.select(text);
		
		return list;
	}

	public ObservableList<BookVO> deleteByISBN(String deleteISBN, String searchKeyword) {
		// TODO Auto-generated method stub
		// 이거는 서비스니까, 로직처리를 넣자.
		// 단, 우리 프로그램에서는 필요한 로직이 없기 때문에, DB 처리만 하면 된다.
		BookDAO dao = new BookDAO();
		
		int count = dao.delete(deleteISBN);
		ObservableList<BookVO> list =  dao.select(searchKeyword); // 검색 키워드가 필요하다.
		
		return list;
	}

}
