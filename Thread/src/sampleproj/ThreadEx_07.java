package sampleproj;

class ThreadEx_07_1 implements Runnable {

	@Override
	public void run() {

		while(true) {
			System.out.println(Thread.currentThread().getName()); // getName()은 쓰레드 클래스에 있다. this는 Thread클래스가 아니기 때문에, this로는 getName()에 접근할 수 없다.
					// 그래서 Thread.currentThread()를 활용해서 현재 쓰레드의 이름을 받아온다.
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
//				e.printStackTrace();
			}
		}
	}
	
}

public class ThreadEx_07 {
	
	public static void main(String[] args) {
		// Runnable interface를 구현한 class의 instance를 생성
		Runnable r = new ThreadEx_07_1();
		
		// 쓰레드 만들자
		// t1, t2, t3가 메소드 코드만 공유하기 때문에 별개로 동작한다.
		Thread t1 = new Thread(r, "*"); // 생성자 첫 번째 인자 : 러너블 객체, 두 번째 인자 : 문자열(쓰레드 이름)
		Thread t2 = new Thread(r, "**"); // 이름만 다르고 똑같은 r을 활용한다. 
		Thread t3 = new Thread(r, "***");
		
		t1.start();
		t2.start();
		t3.start();
		
		try {
			Thread.sleep(2000); // main thread가 sleep된다.
			t1.suspend(); // t1만 일시중지
			Thread.sleep(2000);
			t2.suspend();
			Thread.sleep(3000);
			t1.resume();
			Thread.sleep(3000);
			t1.stop();
			t2.stop();
			Thread.sleep(2000);
			t3.stop();
		} catch (Exception e) {
			
		}
		System.out.println("main method 종료");
	}
}
