package springioc.sample10;

public class TestBean {

	private DataBean data1;
	private DataBean data2;
	
	public TestBean() {
		System.out.println("TestBean() default 생성자 호출");
	}

	public TestBean(DataBean data1, DataBean data2) {
		super();
		this.data1 = data1;
		this.data2 = data2;
		System.out.println("TestBean() 생성자 호출 - data1, data2");
	}

	public DataBean getData1() {
		return data1;
	}

	public void setData1(DataBean param) {
		this.data1 = param;
		System.out.println("TestBean.setData1() 호출");
		// autowire 설정 시, parameter의 이름은 상관없다. field명이 중요하다.
		//		data1 필드의 값을 세팅할 땐, data1 값을 정해주는 그 setter setData1() 이 필요하다.
	}

	public DataBean getData2() {
		return data2;
	}

	public void setData2(DataBean data2) {
		this.data2 = data2;
		System.out.println("TestBean.setData2() 호출");
	}
	
}
