package my.spring.SpringWeb.sample04;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PathController {

	@RequestMapping(value="/character/detail/{name}/{number}")
		// /character/detail 까지는 고정 경로
		// {} 부분은 동적으로 접근하겠다는 의미
	public String myMethod1(@PathVariable("name") String name,
			@PathVariable("number") int num, Model model) {
		// client가 보내준 데이터를 url에 포함시켜서 받을 수 있게 해준다.
		// 이건 Query String과 다르다.
		// Query String이나 Request Body에 들어있는 데이터를 통해서 맵핑을 할 때는 @RequestParam 을 사용한다.
		
		// 이미지에 대한 파일명을 model 객체에 문자열로 저장
		if (name.equals("kakao")) {
			if (num == 1) {
				model.addAttribute("imgname", "ryan");
			} else if (num == 2) {
				model.addAttribute("imgname", "apeach");
			} else if (num == 3) {
				model.addAttribute("imgname", "frodoneo");
			}
		}
		if (name.equals("line")) {
			if (num == 1) {
				model.addAttribute("imgname", "brown");
			} else if (num == 2) {
				model.addAttribute("imgname", "james");
			} else if (num == 3) {
				model.addAttribute("imgname", "cony");
			}
		}
		
		return "sample04/detailView";
	}
}
