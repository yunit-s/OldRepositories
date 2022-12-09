package sample;

class Shared {
	
	public synchronized void printName() {
		
		try {
			for (int i = 0; i < 10; i++) {
				Thread.sleep(1000);
				System.out.println(Thread.currentThread().getName());
				notify();
				wait();
			}
		} catch (Exception e) {
			
		}
	}
}

class ThreadEx_13_1 implements Runnable {
	
	public ThreadEx_13_1 () {
		
	}
	public ThreadEx_13_1(Shared shared) {
		super();
		this.shared = shared;
	}
	
	private Shared shared;

	@Override
	public void run() {
		shared.printName();
	}
	
}

public class ThreadEx_13 {
	
	public static void main(String[] args) {
		// 공유객체
		Shared shared = new Shared();
		
		Thread t1 = new Thread(new ThreadEx_13_1(shared), "첫 번째 쓰레드");
		Thread t2 = new Thread(new ThreadEx_13_1(shared), "두 번째 쓰레드");
		
		t1.start();
		t2.start();
	}
}
