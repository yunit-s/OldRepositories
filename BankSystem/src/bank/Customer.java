package bank;

public class Customer {
	
	// 1. 생성자
	// 생성자가 같은 package 안에 있는 다른 class에 의해서 사용된다면? -> public 키워드 필요 없음
	// 만약 생성자가 다른 package 안에 있는 class에 의해서 사용된다면? -> public 키워드 필요함
	// 같은 프로젝트 안, 다른 package에서 Customer class의 instance를 생성하자.
	// ㄴ 그러므로 생성자에 public을 붙여야 한다.
	public Customer() {
		// default 생성자 : parameter가 없고, 하는 일도 없는 생성자
		// 지금같은 경우는 굳이 써줄 필요 없다. 왜냐하면 시스템에서 자동으로 만들어주기 때문.
	}
	// 그런데 생성자는 1개 이상 있을 수 있다.
	// 하나의 클래스 안의 생성자의 이름은 모두 동일하기 때문에 인자의 개수 혹은 인자의 타입으로 생성자를 구분해야 한다.
	// 생성자는 무슨 일을 한다? : 만들어진 인스턴스를 초기화한다. instance의 필드 초기값을 설정.
	public Customer(String name) {
		this.name = name;
	}
	
	// 2. field 선언
	public String name; // 고객 이름 (instance variable)
	public String accountNumber; // 계좌번호 (instance variable). 이런 경우, 추가적으로 수치 연산을 하는 일이 거의 없기 때문에 int형보다는 String 타입으로 잡는 것이 더 좋다. 나중에 처리하기 더 편하기 때문.
	public long balance; // 잔액 (instance variable)
	// field가 전부 instance variable이지는 않다. 나중에 공부함.
	
	// 3. method 선언
	// 잔액을 확인하다 라는 기능을 만들 때 할 수 있는 선택지 2개
	// - 기능 자체가 잔액을 조사해서 출력까지 진행한다.
	// - 기능은 잔액을 조사해서 잔액의 값만 리턴시키고, 출력은 따로 수행한다.
	// 우리는 두 번째로 간다.
	public long getBalance() {
		return this.balance;
		// this : 변수. instance에 대한 reference 주소값이 들어간다.
		// 현재 사용하는 객체에 대한 reference 주소가 들어가게 되는 것.
	}
	
	// 입금하는 기능(리턴값이 없는 형태의 method로 만들자.)
	public void deposit(long money) {
		this.balance += money; // this.balance = this.balance + money;
	}
	
	// 출금하는 기능(출금 후 잔액을 리턴값으로 사용하자.)
	public long withdraw(long money) {
		// 만약 잔액이 출금요청액보다 적으면 출금이 되면 안 된다.
		if (this.balance < money) {
			System.out.println("돈이 없어요. 확인 부탁해요!");
		} else {
			this.balance -= money;
		}
		return this.balance;
	}
}
