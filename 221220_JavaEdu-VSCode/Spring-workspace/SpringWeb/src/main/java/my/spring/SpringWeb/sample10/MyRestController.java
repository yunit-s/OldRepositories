package my.spring.SpringWeb.sample10;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/rest/user")
public class MyRestController {

	Logger log = LogManager.getLogger("case3");
	
	@GetMapping
	public ResponseEntity<?> method01(String id, String name) {
		// 데이터를 RequestParam으로 받자.
		log.debug("rest-GET 방식으로 호출됨");
		log.debug("id=" + id + ", name=" + name);
		
		return null;
	}
	
	@DeleteMapping
	public ResponseEntity<?> method02(String id, String name) {
		log.debug("rest-DELETE 방식으로 호출됨");
		log.debug("id=" + id + ", name=" + name);
			// RequestParam 을 이용해서 데이터를 가져왔는데 왜 데이터를 못 받고 null이 뜰까?
			//		GET 방식은 애초에 쿼리스트링 방식으로 들어오니까 손질할 필요가 없다.
			//		그런데 POST 방식은 request body 안에 데이터가 있어서 파싱을 해야 한다.
			//		put과 delete는 post 와 동일하게, request body 안에 담겨서 데이터가 온다.
			//		tomcat이 post 방식은 알아서 처리를 해주는데, put과 delete는 자동으로 해주지 않아.
			// 방법 1
			//		tomcat 설정
			//		dispatcher 설정. 코드를 추가로 작성해야 한다.
			//		또 뭐 있다고 하신 것 같은데...
			// tomcat이 제일 쉽다. tomcat 설정하자.
			//		server.xml 63번째 줄에 아래 속성 추가하면 된다.
			//		parseBodyMethods="POST, PUT, DELETE"
		
		return null;
	}
}
