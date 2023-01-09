package example.main;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSessionFactory;

import example.dao.BookDAO;
import example.mybatis.MyBatisConnectionFactory;
import example.vo.BookVO;

public class Main {

	public static void main(String[] args) {
		// 간단하게 책을 조회하고 삭제하는 데이터베이스 처리를 MyBatis로 작성해보기
		// DAO만 만들어서 처리해보자. (MVC 중간 단계인 Controller와 Service 건너뛰기)
		// 1. 책의 ISBN을 이용해서 책 1권의 데이터를 가져와서 출력하기
		// DAO를 따로 만들어서 처리하자.
		// 기존에는 DAO에게 connection을 넘겨줬다. 이번에는 DAO에게 SqlSessionFactory를 넘겨주자.
		SqlSessionFactory factory = MyBatisConnectionFactory.getSqlSessionFactory();
		BookDAO dao = new BookDAO(factory);
		
//		HashMap<String, Object> map = dao.selectByISBNHashMap("89-7914-206-4"); // 두 번재 제네릭 타입은 최상위 객체인 Object로 해야 여러 타입의 테이터를 받아올 수 있다.
//		for (String key : map.keySet()) {
//			System.out.println(key + ", " + map.get(key));
//		}
		
		// 2. 조건 없이 모든 책의 데이터를 가져와서 출력하기
		// DAO부터 생성
		// DAO에게 SqlSessionFactory 넘겨주기
//		List<HashMap<String, Object>> list = dao.selectAllHashMap(); // 두 번재 제네릭 타입은 최상위 객체인 Object로 해야 여러 타입의 테이터를 받아올 수 있다.
//		for (HashMap<String, Object> map : list) {
//			for (String key : map.keySet()) {
//				System.out.println(key + ", " + map.get(key));
//			}
//		}

		// 3. 책의 ISBN을 이용해서 책 1권의 데이터를 가져와서 출력하기
		// 이번에는 HashMap으로 가져오는 것이 아니라 VO로 리턴을 받아보자.
//		BookVO book = dao.selectByISBNBookVO("89-7914-206-4"); // 두 번재 제네릭 타입은 최상위 객체인 Object로 해야 여러 타입의 테이터를 받아올 수 있다.
//		System.out.println(book.getBtitle() + ", " + book.getBauthor());

		// 4. 책의 ISBN을 이용해서 책 1권의 데이터를 가져와서 출력하기
		// 이번에는 HashMap으로 가져오는 것이 아니라 VO로 리턴을 받아보자.
//		BookVO book = dao.selectByISBNResultMap("89-7914-206-4"); // 두 번재 제네릭 타입은 최상위 객체인 Object로 해야 여러 타입의 테이터를 받아올 수 있다.
//		System.out.println(book.getBtitle() + ", " + book.getBauthor());

		// 5. 책의 ISBN을 이용해서 책 1권의 데이터를 업데이트
		// update의 결과는 int값으로 나온다.
		// 이럴 때는 VO를 만들어서 넘겨준다.
		BookVO book = new BookVO(); // 빈 vo 생성
		book.setBisbn("89-7914-206-4");
		book.setBtitle("자바 30일 완성!!");
		book.setBauthor("신사임당");
		book.setBprice(3000);
		int result = dao.updateByISBN(book);
		System.out.println("영향을 받은 행의 수 : " + result);

	}
}
