package sampleproj;

class CommonClass {
	
//	String LastThread = null;
	Thread LastThread = null;
	
	public void printName() {
		
	}
	
//	public void printName() {
//		
//		synchronized (this) {
//			if (LastThread != Thread.currentThread()) {
//				System.out.println("현재 쓰레드 : " + Thread.currentThread().getName());
//				LastThread.notify();
//				LastThread = Thread.currentThread();
//				try {
//					Thread.currentThread().wait();
//				} catch (InterruptedException e) {
//				}
//			}
//			
//			if (LastThread != Thread.currentThread()) {
//				System.out.println("현재 쓰레드 : " + Thread.currentThread().getName() + ", LTh = " + LastThread);
//				if (LastThread != null) {
//					LastThread.notify();
//				}
//				LastThread = Thread.currentThread();
//			} else {
//				try {
//					Thread.currentThread().wait();
//				} catch (InterruptedException e) {
//				}
//				System.out.println("현재 쓰레드 : " + Thread.currentThread().getName());
//				if (LastThread != null) {
//					LastThread.notify();
//				}
//				LastThread = Thread.currentThread();
//			}
//		}
//	}
	
}

class RunClass implements Runnable {
	
	CommonClass cClass = new CommonClass();

	@Override
	public void run() {
		while (true) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
			}
			cClass.printName();
			
//			System.out.println("출력 " + Thread.currentThread().getName());
		}
	}
	
}

public class ThreadNotifytest {

	public static void main(String[] args) {
		RunClass r1 = new RunClass();
		RunClass r2 = new RunClass();
		Thread t1 = new Thread(r1, "Thread_A");
		Thread t2 = new Thread(r2, "Thread_B");
		
		t1.setDaemon(true);
		t2.setDaemon(true);
		
		t1.start();
		t2.start();
		
		
		
		try {
			Thread.sleep(2000);
			Thread.sleep(2000);
			Thread.sleep(2000);
			Thread.sleep(2000);
			Thread.sleep(2000);
			Thread.sleep(2000);
		} catch (InterruptedException e) {
		}
	}
}
