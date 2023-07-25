package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {

	public static void main(String[] args) {
		
		try {
			// 1. JDBC Driver Loading 단계
			Class.forName("com.mysql.cj.jdbc.Driver"); // forName : 스태틱 메소드. 클래스 이름 찾아서 loading하라는 기능. 패키지 명까지 포함시켜서 적어야 한다.
			System.out.println("Driver Loading 성공!");
			
			// 2. Database 접속
			String jdbc_url = "jdbc:mysql://127.0.0.1:3306/library?characterEncoding=UTF-8&serverTimezone=UTC&useSSL=false&allowPublicKeyRetrieval=true";
				// 이거는 DBMS마다 약속이 다르다. jdbc 프로토콜 / mysql에 접속 / IP, port / 데이터베이스 이름 / ?는 속성에 대한 내용. 인증방식같은 것들.
			String id = "root";
			String pw = "qwer1234";
			Connection con = DriverManager.getConnection(jdbc_url, id, pw); // ㅍㅍㅍㅍㅍㅍㅍㅍㅍ url, id, pw 는 상식이야.
				// 이것도 소켓처럼, 연결에 성공하면 객체가 하나 리턴된다.
			System.out.println("데이터베이스 접속 성공!!");
			
/*
			// 일반 Statement 를 사용하는 방법
			// 3. Statement 생성
			Statement stmt = con.createStatement(); // Statement 관련 import 할 때, 다른 거 하지 말고 java가 기본적으로 제공한 java.sql 을 선택한다.
			
			// 4. Query를 작성해서 실행시키자.
//			String sql = "SELECT bisbn, btitle, bauthor, bprice FROM book"; // sql 문장 넣기. 세미콜론은 sql 문장에 포함되지 않는다. 단순히 delimiter 역할만 하는 거지
//			String sql = "SELECT bisbn, btitle, bauthor, bprice FROM book WHERE btitle like '%여행%'";
			String keyword = "자바";
			String sql = "SELECT bisbn, btitle, bauthor, bprice FROM book WHERE btitle like '%" + keyword + "%'";
			ResultSet rs = stmt.executeQuery(sql); // select 계열의 sql문이니까 executeQuery() 메소드 사용
			
			// 5. 결과처리!
//			rs.next(); // 커서를 다음 줄로 내린다.
//			String title = rs.getString("btitle"); // btitle 이라는 컬럼에 있는 데이터를 문자열로 가져온다.
//			System.out.println("책 제목은 : " + title);
//			int price = rs.getInt("bprice");
//			System.out.println("책 가격은 : " + price);
//			String price = rs.getString("bprice"); // 숫자를 문자열로 받아오는 것도 가능하다.
//			System.out.println("책 제목은 : " + price);
//			String price = rs.getString(4); // 컬럼 명 대신에 숫자로 컬럼을 지정해줄 수도 있다. 다만, 데이터베이스 기준이니까 1부터 시작한다.
//			System.out.println("책 제목은 : " + price);
			
			while (rs.next()) {
				String title = rs.getString("btitle");
				System.out.println("책 제목은 : " + title);
			}
*/

			// Prepared Statement 를 사용하는 방법
			// Prepared Statement는 SQL을 가지고 생성한다.
			// Prepared Statement는 IN Parameter를 이용할 수 있다. -> 해당 부분은 ? 로 표현한다.
			// 주의. Keyword 부분에는 ?(IN Parameter)를 사용할 수 없다. 즉, 테이블명 같은 곳은 안 되고, 조건절 에 사용 가능한 것.
			// 3. PreparedStatement 생성
			String sql = "SELECT bisbn, btitle, bauthor, bprice FROM book WHERE btitle like ?"; // ? 부분은 아직 다 채우지 않았다는 의미
			PreparedStatement pstmt = con.prepareStatement(sql);
			
			// 4. Query 실행하기 전에, ?를 채워야 한다. sql문 완성해야지
			String keyword = "자바";
			pstmt.setString(1, "%" + keyword + "%"); // 1번째 ? 의 위치에 두 번째 인자값을 넣어준다. 
			ResultSet rs = pstmt.executeQuery(); // pstmt가 이미 sql 정보를 가지고 있기 때문에, sql 인자를 따로 설정할 필요 없음.
			
			// 5. 결과처리!
			while (rs.next()) {
				String title = rs.getString("btitle");
				System.out.println("책 제목은 : " + title);
			}
			
			// 6. 사용한 자원 해제
			rs.close();
			pstmt.close();
			con.close();
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			// DriverManager.getConnection() 을 위한 예외처리 공간.
			// 여기서 잡는 것은 sql exception이다. Add catch clause to surrounding try. 누르면 자동으로 생성된다.
			e.printStackTrace();
		}
		
	}
}
