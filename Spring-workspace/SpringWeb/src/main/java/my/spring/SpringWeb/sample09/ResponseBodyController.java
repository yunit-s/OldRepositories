package my.spring.SpringWeb.sample09;

import java.nio.charset.Charset;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import my.spring.SpringWeb.sample09.vo.User;

//@Controller
// 이거 대신 REST 기반의  서버쪽 프로그램, 핸들러를 만들 때는
//		@Controller 대신 @RestController 를 사용하고,
//		이 안의 메소드들에서 @RespnseBody 가  자동으로 붙게 된다.
@RestController
@RequestMapping(value="responseBody")
public class ResponseBodyController {

	
	@RequestMapping(value="text/{id}", produces="text/plain; charset=UTF-8")
		// Get방식인데 데이터는 @PathVariable 로 받겠다는 뜻
		// URL 안에 특정 데이터를 포함시켜서 전달하는 방식
		// produces
		//		내가 만든 데이터에 대한 content type 명시
		//		text/plain
		//			일반 문자열이라는 의미
//	@ResponseBody
		// 이 메소드가 jsp를 찾아야하는 게 아니라 ResponseBody에 그냥 담는 거라고 명시하는 어노테이션
	public String method01(@PathVariable String id) {
		
		return "<h3>jsp 안 찾고 html 태그를 입력한 문자열을 리턴하자. (id = " + id + ") </h3>";
			// @ResponseBody 덕분에, 이 문자열을 MessageConverter 를 거쳐서 일반 문자열로 변환을 거친다.
			// 무슨 말이냐? 태그를 넣었지만 이걸 태그로 받아들이지 않고 일반 문자열로 보내준다는 의미다.
	}
	
	@RequestMapping(value="textObject/{id}", produces="text/plain; charset=UTF-8")
//	@ResponseBody
	public ResponseEntity<String> method02(@PathVariable String id) {
		
		// ResponseEntity 안에는 3가지 정보가 들어간다.
		//		data, header, 상태코드
		String msg = "<h3>jsp 안 찾고 html 태그를 입력한 문자열을 리턴하자. (id = " + id + ") </h3>";
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(new MediaType("text", "plain", Charset.forName("UTF-8"))); // MediaType은 쉽게 생각해서 MIME type이라고 생각하면 된다.
			// 만약 여기서 두 번째 인자를 html로 바꾸면, produces를 text/plain으로 적어도
			//		브라우저에서 결국에는 headers 정보를 읽어서 text/html로 읽게 된다.
			//		message converter가 headers 정보를 text/plain 식으로 바꿀 건데,
			//			애초에 headers가 text/html 로 만들어져서 그대로 html 형식으로 출력된다??? ㅍㅍㅍㅍㅍㅍㅍㅍㅍㅍㅍㅍㅍㅍㅍㅍㅍㅍㅍㅍㅍㅍㅍㅍ
		
//		return new ResponseEntity(msg, headers, HttpStatus.OK); // 성공적으로 수행됐다는 상태코드 : 200
		return new ResponseEntity(msg, headers, HttpStatus.CREATED); // 무언가 객체가 완성됐음을 알려주는 상태코드 : 201
	}
	
	@RequestMapping(value="json/{name}", produces="application/json; charset=UTF-8")
//	@ResponseBody
	public User method03(@PathVariable String name) {
		
		User user = new User();
		user.setName(name);
		user.setAddr("서울");
		
		return user;
			// VO를 보내야 한다고? 이때 메시지 컨버터를 여기에 적합한 놈으로 골라. 메시지 컨버터가 알아서 해주기 때문에 스프링에서 알아서 다 해준가ㅗ줌
	}
}
