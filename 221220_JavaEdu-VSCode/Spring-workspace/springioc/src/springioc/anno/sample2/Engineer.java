package springioc.anno.sample2;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class Engineer {

	// type으로 찾을 때는 @Autowired 활용
//	@Autowired
//	@Qualifier("emp1")
	
	// 이름으로 찾을 때는 @Resource를 활용
	@Resource(name="emp1")
	private Emp emp;
	private String dept;
	
	public Engineer() {
		System.out.println("Engineer() default 생성자 호출");
	}
	
	// setter가 아닌 일반 메소드. 역할은 setter와 동일하게 구현
	//		이런 일반 메소드에 @Autowired를 붙여보자
	//		Autowired를 하면 일단 주입이 일어나는데, 일반 메소드인 경우, 매개변수에 주입이 된다.
	//		주입의 목표가 되는 대상은 매개변수의 이름이다.
	@Autowired
	public void my_dept(String dept) {
		this.dept = dept;
		System.out.println("Engineer.my_dept() 일반 메소드 호출");
	}
}
