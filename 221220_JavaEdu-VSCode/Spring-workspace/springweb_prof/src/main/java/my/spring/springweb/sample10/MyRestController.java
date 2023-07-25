package my.spring.springweb.sample10;

import java.util.HashMap;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;

@RestController
@RequestMapping(value = "/rest/user", 
				produces = "application/json; charset=UTF-8")
public class MyRestController {

	@Autowired
	private Gson gson;
	
	Logger log = LogManager.getLogger("case3");

	@GetMapping
	public String method01(String id, String name) {

		log.debug("Get방식으로 호출되었어요!");
		log.debug(id + ", " + name);

		HashMap<String, String> map = new HashMap<String, String>();
		
		map.put("name","홍길동");
		
		return gson.toJson(map);
	}

	@DeleteMapping
	public ResponseEntity<?> method02(String id, String name) {

		log.debug("DELETE 방식으로 호출되었어요!");
		log.debug(id + ", " + name);

		return null;
	}

}
