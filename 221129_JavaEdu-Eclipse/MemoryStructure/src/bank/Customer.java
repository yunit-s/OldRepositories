package bank;

public class Customer {

	// 1. constructor(생성자)
	// 인자도 없고 하는 일도 없는 생성자 => default constructor
	// 사용하든 안 하든, 내가 작성하는 것이 좋다. 추가적으로 필요하다면 그때 작성하는 거고...
	public Customer() {
		// default constructor. 하는 일이 아무것도 없음.
	}
	
	// 2. field
	public String name;
	public long balance;
	
	// 3. method
	void deposit(long money) {
		int myMoney = 100;
		this.balance += money;
	}
}
