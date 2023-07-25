package sampleproj;
// 수업시간에는 클래스 이름을 ThreadEx_11 으로 사용했음.

class ThreadEx_11_4 extends Thread {
	
	final static int MAX_MEMORY = 1000;
	int usedMemory = 0;
	
	@Override
	public void run() {
		// Thread를 계속 잡아두기 위해서 무한루프 돌릴 거야
		while (true) {
			try {
				Thread.sleep(10000);
			} catch (InterruptedException e) {
			}
			gc();
		}
	}
	
	public void gc() {
		// 현재 사용되는 메모리량을 300만큼 차감한다.
		usedMemory -= 300; // usedMemory = usedMemory - 300;
		if (usedMemory < 0) {
			usedMemory = 0;
		}
	}
	public int totalMemory() {
		// 전체 용량 확인하기
		return MAX_MEMORY;
	}
	public int freeMemory() {
		// 현재 가용 메모리량 확인하기
		return MAX_MEMORY - usedMemory;
	}
	
}

public class ThreadEx_11_3 {

	public static void main(String[] args) {
		
		ThreadEx_11_4 t = new ThreadEx_11_4();
		t.setDaemon(true); // ThreadEx_11_4 는 강제로 종료시키지 않으면 무한루프도는 코드다. 그렇기때문에 main 쓰레드의 데몬 쓰레드로 설정한다.
		t.start();
		
		int requiredMemory = 0;
		
		for (int i = 0; i < 20; i++) {
			// 난수 발생
			requiredMemory = ((int)(Math.random() * 10)) * 20; // Math.random() 은 static method이다. 0.0~1.0 사이의 실수값을 난수로 리턴해준다.
			// 위에서 구한 필요한 메모리량이 사용할 수 있는 메모리 량보다 크거나, 전체 메모리의 60% 이상 사용했을 때는 GC를 깨우자.
			if ((t.freeMemory() < requiredMemory) || t.freeMemory() < t.totalMemory() * 0.4) {
				t.interrupt();
				try {
					t.join(100); // 이를 실행하는 건 main thread니까, join() 끝날 때까지 main thread는 대기하게 된다.
							// join(100) : 100ms만큼만 main 쓰레드를 멈춘다. 인자값을 안 주면, 시간제한이 없어진다.
				} catch (InterruptedException e) {
				}
			}
			// 여기서 main thread는 잠시 멈춰야해. 안 그러면 남은 메모리량이 0 이하로 떨어질 수 있다.
			// t 쓰레드가 먼저 gc()를 실행한 다음에 main thread가 동작을 해야만 이를 방지할 수 있다.
			
			t.usedMemory += requiredMemory; // 사용된 메모리량을 누적.
			System.out.println("남은 메모리량 : " + t.freeMemory());
		}
	}
}
