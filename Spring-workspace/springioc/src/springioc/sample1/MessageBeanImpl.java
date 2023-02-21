package springioc.sample1;

public class MessageBeanImpl implements MessageBean {

	// 지금은 stateful 관련된 생각은 하지 말고 작성. 동작 이해를 위해.
	private String fruit;
	private int cost;
	
	public MessageBeanImpl() {
		System.out.println("MessageBeanImpl 기본 생성자 호출");
	}

	public MessageBeanImpl(String fruit) {
		this.fruit = fruit;
		System.out.println("MessageBeanImpl 생성자 호출 - " + fruit);
	}

	public MessageBeanImpl(String fruit, int cost) {
		this.fruit = fruit;
		this.cost = cost;
		System.out.println("MessageBeanImpl 생성자 호출 - " + fruit + ", " + cost);
	}

	public void setCost(int cost) {
		this.cost = cost;
		System.out.println("setCost setter 호출");
	}

	@Override
	public void sayHello() {
		System.out.println(fruit + ", " + cost);
	}
}
