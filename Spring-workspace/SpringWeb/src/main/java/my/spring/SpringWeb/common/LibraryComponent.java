package my.spring.SpringWeb.common;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.google.gson.Gson;

// 수동으로 Bean을 Application context 에 등록하는 방법
//		@Bean 어노테이션 사용
//			얘는 클래스 위에 적는다.
//			근데 얘만 있다고 Bean으로 등록해주지 않는다.
//		@Configuration
//			우리 클래스를 Bean으로 등록하려고 하는 거네?
//			그 아래에 @Bean
//				아 이 메소드를 수동으로 Bean으로 등록하려고 하네?

@Configuration
public class LibraryComponent {

	@Bean
	// 메소드 아이디 자체가 bean으로 등록된다.
	public Gson getGson() {
		return new Gson();
	}
}
