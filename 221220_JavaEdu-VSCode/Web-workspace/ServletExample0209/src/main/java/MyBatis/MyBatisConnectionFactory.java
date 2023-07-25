package MyBatis;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MyBatisConnectionFactory {

	// 이 Factory는 거의 예외없이 이 형태로 사용하게 된다. 
	private static SqlSessionFactory sqlSessionFactory;

	static {

		// 공장을 만들 때 필요한 XML 설정파일
		String resource = "./SqlMapConfig.xml"; // 이 설정파일을 기반으로 factory를 만들게 된다.
		try {
			Reader reader = Resources.getResourceAsReader(resource);

			if (sqlSessionFactory == null) {
				// XML설정을 이용해서 공장 객체 만들기
				sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static SqlSessionFactory getSqlSessionFactory() {
		// Sql Session 이라는 게 있어야만 query를 실행시킬 수 있다.
		return sqlSessionFactory;
	}
}
