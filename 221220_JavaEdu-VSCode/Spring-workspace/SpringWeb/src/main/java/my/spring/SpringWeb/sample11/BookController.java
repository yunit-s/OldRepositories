package my.spring.SpringWeb.sample11;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import my.spring.SpringWeb.sample11.dao.BookDao;

@Controller
@RequestMapping(value="book")
public class BookController {

	@Autowired
	private BookDao dao;
	
	Logger log = LogManager.getLogger("case3");
	
	@GetMapping(value="count")
	public String method01(Model model) {
		model.addAttribute("mode", "count");
		model.addAttribute("result", dao.getBookCount());
		
		return "sample11/bookCount";
			// book리졸버가 이 jsp를 찾게 되겠지
	}
	
	@GetMapping(value="all")
	public String method02(Model model) {
		model.addAttribute("mode", "selectAll");
		model.addAttribute("resultList", dao.getAllBooks());
		
		return "sample11/bookCount";
	}
	
	@PostMapping(value="search")
	public String method03(Model model, @RequestParam(value="keyword", defaultValue="파이썬") String keyword) {
		model.addAttribute("mode", "search");
		model.addAttribute("resultList", dao.getSearchBooks(keyword));

		return "sample11/bookCount";
	}
}
