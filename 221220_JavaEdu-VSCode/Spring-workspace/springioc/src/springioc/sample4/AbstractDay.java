package springioc.sample4;

import java.util.Calendar;
import java.util.GregorianCalendar;

public abstract class AbstractDay {

	// abstract method
	public abstract String dayInfo();
	
	// static method
	// Factory method
	//		: 객체를 만들 수 있는 메소드를 지칭한다.
	//		추상 클래스는 원래 객체를 만들 수 없다.
	//		그러나 static 메소드를 활용하면, 추상 클래스가 객체를 만들어낼 수 있게 된다.
	public static AbstractDay getInstance() {
		System.out.println("AbstractDay getInstance() 메소드 호출");
		// 오늘 날짜의 요일 얻기
		// GregorianCalendar
		//		Java에서 캘린더 정보를 다룰 때 자주 사용되는 API
		GregorianCalendar cal = new GregorianCalendar();
		int day = cal.get(Calendar.DAY_OF_WEEK);
			// 해당 날짜에 대한 요일을 숫자로 알려준다.
			//		1 -> 일요일, 2 -> 월요일, ...
		
		AbstractDay my_day = null;
		switch(day) {
			case 1:
				my_day = new Sunday(); // 구현체 만들기
				break;
			case 2:
				my_day = new Monday();
				break;
			case 3:
				my_day = new Tuesday();
				break;
		}
		return my_day;
	}
	
}
