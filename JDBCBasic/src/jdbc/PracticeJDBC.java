package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class PracticeJDBC {

	public static void main(String[] args) {

		// 책 목록 검색하는 프로그램
		try {
			// 1. 드라이버 로딩
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			// 2. 데이터베이스 연결
			String jdbc_url = "jdbc:mysql://127.0.0.1:3306/library?characterEncoding=UTF-8&serverTimezone=UTC&useSSL=false&allowPublicKeyRetrieval=true";
			String id = "root";
			String pw = "qwer1234";
			Connection con = DriverManager.getConnection(jdbc_url, id, pw);
			System.out.println("데이터베이스 접속 성공!!");
			
			// 3. PreparedStatement 생성
			String sql = "SELECT btitle, bauthor, bprice FROM book WHERE btitle LIKE ?"; // 특정 키워드가 들어가있는 책은 전부 지우기
			PreparedStatement pstmt = con.prepareStatement(sql);
			
			Scanner sc = new Scanner(System.in);
			String input = sc.next();
//			String input = "여행";
			pstmt.setString(1, "%" + input + "%");
			
			// 4. 실행
			ResultSet rs = pstmt.executeQuery(); // pstmt가 이미 sql 정보를 가지고 있기 때문에, sql 인자를 따로 설정할 필요 없음.
			
			// 5. 결과처리
			System.out.println("title / author / price");
			while (rs.next()) {
				String title = rs.getString("btitle");
				String author = rs.getString("bauthor");
				int price = rs.getInt("bprice");
				System.out.println("제목 : " + title + ", \t\t저자 : " + author + ",\t\t가격 : " + price);
			}
			
			// 6. 사용한 자원 반납
			rs.close();
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
