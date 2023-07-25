package sampleproj;

class Account {
	// 일반 클래스의 일반 객체를 만들 거야. 이거는 쓰레드 클래스 아니야.
	// constructor
	public Account() {
	}
	public Account(int balance) {
		super();
		this.balance = balance;
	}

	// field
	private int balance;
	
	// getter & setter
	public int getBalance() {
		return balance;
	}
	public void setBalance(int balance) {
		this.balance = balance;
	}
	
	// business method
	// synchronized method(동기화 메소드)
	// 이 메소드를 실행한 Thread가 먼저 Lock(Monitor) 획득.
	// 하나의 thread가 메소드를 호출하면, 나머지 하나는 block된다.
	
	// method 자체를 동기화 메소드화하기
//	public synchronized void withdraw(int money) {
//		// 출금
//		if (balance >= money) {
//			try {
//				Thread.sleep(1000); // 제대로 출금처리(동기화처리) 됐는지 확인하기 위해서 잠시 대기
//			} catch (Exception e) {
//			}
//			balance -= money;
//		}
//	}
	
	// synchronized block 이용하는 방법
	public void withdraw(int money) {
		// synchronized () 블록 밖에서는 동기화되지 않는다.
		synchronized (this) {
			if (balance >= money) {
				try {
					Thread.sleep(1000); // 제대로 출금처리(동기화처리) 됐는지 확인하기 위해서 잠시 대기
				} catch (Exception e) {
				}
				balance -= money;
			}	
		}
	}
}

class ThreadEx_12_1 implements Runnable {
	// field
	Account acc = new Account(1000);

	@Override
	public void run() {
		while (acc.getBalance() > 0) {
			int money = (int)(Math.random() * 3 + 1) * 100;
			acc.withdraw(money); // 공용객체의 출금처리
			System.out.println("남은 금액 : " + acc.getBalance());
		}
	}
}

public class ThreadEx_12 {

	public static void main(String[] args) {
		ThreadEx_12_1 r = new ThreadEx_12_1();
		
		Thread t1 = new Thread(r);
		Thread t2 = new Thread(r);
		
		t1.start();
		t2.start();
	}
}
