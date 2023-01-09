package example.mybatis;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MyBatisConnectionFactory {

	private static SqlSessionFactory sqlSessionFactory; // 공장은 하나만 만들기 때문에 static으로 선언
	
	static {
		
		String resource = "./SqlMapConfig.xml";
		try {
			Reader reader = Resources.getResourceAsReader(resource); // Reader라는 스트림을 이용해서 xml 리소스 파일을 읽어들이겠다는 의미
			
			if (sqlSessionFactory == null) {
				// 만약 공장이 아직 없으면 공장 만들기. 결국, 공장을 단 한 개만 만들게 된다.
				sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader); // FactoryBuilder가 xml코드를 들고 build()를 실행해서 Factory 생성
			}
		} catch (IOException e) {
			// reader 초기화할 때 io관련 실행이기 때문에 io exception try/catch가 있어야 한다.
			e.printStackTrace();
		}
	}
	
	public static SqlSessionFactory getSqlSessionFactory() {
		return sqlSessionFactory;
	}
}
