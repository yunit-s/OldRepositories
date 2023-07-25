package springioc.anno.sample1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("myFood")
	// ()괄호가 없으면, default bean id : myFoodMgr
public class MyFoodMgr {

	@Autowired
	@Qualifier(value="unFavoriteFood")
		// 명시적으로 지정해준 이름의 bean을 가져올 수 있다.
	private Food favoriteFood;
		// 필드명과 동일한 bean id를 가진 bean을 가져와서 넣는다.
	
	@Autowired
	private Food unFavoriteFood;
	
	public MyFoodMgr() {
		System.out.println("!! MyFoodMgr() default 생성자 호출");
	}
	
	@Override
	public String toString() {
		return favoriteFood + ", " + unFavoriteFood;
	}
}
