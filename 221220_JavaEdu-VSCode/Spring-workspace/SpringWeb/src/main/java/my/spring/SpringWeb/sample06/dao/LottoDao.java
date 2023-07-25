package my.spring.SpringWeb.sample06.dao;

import java.util.Random;

import org.springframework.stereotype.Repository;

// lottoDao
//		디폴트 속성. Repository의 id
@Repository("lottoDao")
public class LottoDao {

	public LottoDao() {
		// TODO Auto-generated constructor stub
	}
	
	public int selectLottoNumber() {
		Random rand = new Random();
		return rand.nextInt(6) + 1; // 0~5까지 정수형 난수를 발생
	}

}
