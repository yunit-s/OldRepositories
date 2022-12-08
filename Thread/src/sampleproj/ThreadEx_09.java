package sampleproj;

class ThreadEx_09_1 implements Runnable {

	// 로직 처리를 위한 변수를 만들자
	// volatile : 이 데이터에서 값을 읽어올 때는 언제나 memory에서 직접 가져오게 해주는 키워드
	volatile boolean suspended = false;
	volatile boolean stopped = false;
	
	Thread t; // 나를 실행시킨 쓰레드가 누구인지를 기억하기 위해서 선언하는 필드
	
	void setThread(Thread t) {
		this.t = t;
	}
	
	@Override
	public void run() {

		while (!stopped) {
			// 만약 suspended가 true면 busy-waiting이 발생하긴 하지만, 쓰레드가 끝나지는 않는다.
			if (!suspended) {
				System.out.println(Thread.currentThread().getName());
				
				try {
					Thread.sleep(1000);
				} catch (Exception e) {

				}
			} else {
				Thread.yield(); // 현재 실행 중인 method를..... 뭐라구?
			}
		}
	}
	
	// 이건 오버라이드도 아니고 그냥 우리가 만드는 메소드야.
	public void suspend() {
		suspended = true;
		// 아마도 최대 1초 뒤에 상태를 확인해서 일시중지 작업을 시행.
		// 최대한 빨리 일시중지 상태에 돌입하려면 현재 thread에 대해서 interrupt를 걸어야 한다.
		t.interrupt();
		// 여기서 this 못 쓴다. 여기서 this는 Runnable을 구현한 객체일 뿐이니까.
	}
	public void resume() { suspended = false; }
	public void stop() {
		stopped = true;
		t.interrupt();
	}
}

public class ThreadEx_09 {

	public static void main(String[] args) {
		// 나중에 필드가 공유될 수 있기 때문에, Runnable 객체를 공유하면 안 된다.
		ThreadEx_09_1 r1 = new ThreadEx_09_1();
		ThreadEx_09_1 r2 = new ThreadEx_09_1();
		ThreadEx_09_1 r3 = new ThreadEx_09_1();
		
		Thread t1 = new Thread(r1, "*");
		Thread t2 = new Thread(r2, "**");
		Thread t3 = new Thread(r3, "***");
		
		r1.setThread(t1); // 자신을 실행시키는 쓰레드에 대한 정보를 저장
		r2.setThread(t2);
		r3.setThread(t3);
		
		t1.start();
		t2.start();
		t3.start();
		
		try {
			Thread.sleep(2000); // main thread sleep
			// 첫 번째 thread를 일시정지하자.
			// Thread를 직접 제어하지 않는다. Thread가 가지고 있는 Runnable 객체의 field값을 조절해서 Runnable 객체가 가지고 있는 run() method의 로직을 변화시킨다.
			r1.suspend(); // t1.suspend()가 아니다.
			Thread.sleep(2000);
			r2.suspend();
			Thread.sleep(2000);
			r1.resume();
			Thread.sleep(2000);
			r1.stop();
			r2.stop();
			Thread.sleep(2000);
			r3.stop();
			
		} catch (InterruptedException e) {

		}
	}
}
