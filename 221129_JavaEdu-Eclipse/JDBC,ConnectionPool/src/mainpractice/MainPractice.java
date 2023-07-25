package mainpractice;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;

public class MainPractice {

	private static BasicDataSource basicDS;
	
	// static block. main이 호출되기 전에 실행된다.
	// 일반적으로 프로그램에서 사용하는 resource같은 것들 로딩할 때 사용한다.
	static {
//		System.out.println("static block 실행");
		
		// Connection Pool 생성
		basicDS = new BasicDataSource();
		basicDS.setDriverClassName("com.mysql.cj.jdbc.Driver"); // JDBC driver class 의 이름 설정하기. 이 Driver가 있어야 데이터베이스와 연결하니까.
		basicDS.setUrl("jdbc:mysql://127.0.0.1:3306/library?characterEncoding=UTF-8&serverTimezone=UTC&useSSL=false&allowPublicKeyRetrieval=true");
		basicDS.setUsername("root");
		basicDS.setPassword("qwer1234");
		
		basicDS.setInitialSize(10); // 초기에 만들어둘 데이터베이스 연결 개수 설정
		basicDS.setMaxTotal(20); // 처음 생성한 갯수보다 더 필요한 경우 늘릴 수 있는 한계치 설정
		
		
	}
	
	public static DataSource getDataSource() {
		// DataSource 는 BasicDataSource 의 상위 인터페이스 개념이다. IS-A 관계를 활용하자.
		return basicDS;
	}
	
	public static void main(String[] args) {
		
		// DBCP 사용에 대해서 알아보자.
		// 만들고 사용하는 과정만 살짝 알아보는 걸로.
		DataSource ds = getDataSource(); // Connection Pool 가져오기
		Connection con = null;
		try {
			con = ds.getConnection(); // Connection Pool 에서 Connection을 빌려온다.
			String sql = "SELECT btitle, bauthor FROM book";
			PreparedStatement pstmt = con.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				System.out.println(rs.getString("btitle"));
			}
			
			// 리소스 반환
			rs.close();
			pstmt.close();
			con.close(); // 여기서는 연결을 끊는 작업이 아니다. pool 에 반납하는 것이다.
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
