package my.spring.SpringWeb.sample06.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import my.spring.SpringWeb.sample06.dao.LottoDao;
import my.spring.SpringWeb.sample06.vo.Lotto;

// Bean으로 등록하자.
//		용도를 정확하게 표기하기 위해 @Component 대신 @Service 를 사용하자.
@Service
public class LottoService {
	
	Logger log = LogManager.getLogger("case3");

	// @Autowired 도 가능하고 @Resource 도 가능하다.
//	@Resource(name="lottoDao")
		// 이름으로 검색하기
	@Autowired
	@Qualifier(value="lottoDao")
		// Type으로 검새하기
	private LottoDao dao;
	
	public LottoService() {
		// TODO Auto-generated constructor stub
	}
	
	public boolean checkLottoNumber(Lotto lotto) {
		// 일반적인 로직처리 진행
		// DB 처리 -> DAO 필요
		//		원래 DB처리를 해야겠지만, 지금은 그냥 난수 생성하는 기능으로 구현해보자.
		boolean result = false; // 당첨여부
		int randomNumber = dao.selectLottoNumber(); // dao를 이용해서 당첨번호를 알아오기
		
		log.debug("내가 선택한 번호 : " + lotto.getLottoNum() + ", 당첨 번호  : " + randomNumber);
		if (randomNumber == lotto.getLottoNum()) {
			result = true;
		} else {
			result = false;
		}
		
		return result;
	}
}
