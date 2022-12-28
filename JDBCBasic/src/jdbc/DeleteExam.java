package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DeleteExam {

	public static void main(String[] args) {

		// 특정 책을 지운다.
		try {
			// 1. 드라이버 로딩
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			// 2. 데이터베이스 연결
			String jdbc_url = "jdbc:mysql://127.0.0.1:3306/library?characterEncoding=UTF-8&serverTimezone=UTC&useSSL=false&allowPublicKeyRetrieval=true";
			String id = "root";
			String pw = "qwer1234";
			Connection con = DriverManager.getConnection(jdbc_url, id, pw);
			
			// 트랜잭션 세팅하기
			con.setAutoCommit(false); // Auto commit 기능을 끄면서, 이때부터는 트랜잭션이 걸리게 된다.

			// 3. PreparedStatement 생성
			String sql = "DELETE FROM book WHERE btitle LIKE ?"; // 특정 키워드가 들어가있는 책은 전부 지우기
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, "%여행%");
			
			// 4. 실행
			int count = pstmt.executeUpdate(); // 리턴값으로, 영향을 받은 row의 수(정수값)를 받는다.
			
			// 5. 결과처리
			System.out.println("삭제한 row의 수는 : " + count);
			
			// 트랜잭션 결과 선택하기
			// 만약 transaction을 종료하지 않고 connection을 close 할 경우, transaction을 자동으로 commit하고 transaction이 종료된다.
//			con.commit(); // transaction을 종료하고, 지금까지 실행한 SQL문을 실제로 데이터베이스에 적용
			con.rollback(); // transaction을 종료하고, 지금까지 실행한 SQL문을 모두 무효화시킴
			
			// 6. 사용한 자원 반납
			pstmt.close();
			con.close();
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
