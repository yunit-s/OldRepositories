package springioc.sample6;

public class MessageBeanImpl implements MessageBean {

	private String name;
	private String phone;
	private Output output;
	
	public MessageBeanImpl() {
		System.out.println("MessageBeanImpl() default 생성자 호출");
	}

	public MessageBeanImpl(String name) {
		this.name = name;
		System.out.println("MessageBeanImpl() 생성자 호출 - name : " + name);
	}

	public void setPhone(String phone) {
		this.phone = phone;
		System.out.println("MessageBeanImpl.setPhone() 호출");
	}

	public void setOutput(Output output) {
		this.output = output;
		System.out.println("MessageBeanImpl.setOutput() 호출");
	}

	@Override
	public void sayHello() {
		String msg = name + " : " + phone;
		
		try {
			output.print(msg); // 동적 바인딩이 일어난다.
			System.out.println("메시지 출력 종료");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
