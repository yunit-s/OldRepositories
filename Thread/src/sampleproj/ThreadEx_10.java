package sampleproj;

class ThreadEx_10_1 extends Thread {

	@Override
	public void run() {
		for (int i = 0; i < 100; i++) {
			System.out.print("-");
		}
	}

}

class ThreadEx_10_2 extends Thread {

	@Override
	public void run() {
		for (int i = 0; i < 100; i++) {
			System.out.print("|");
		}
	}
}

public class ThreadEx_10 {

	public static void main(String[] args) {
		long startTime = 0;
		
		Thread t1 = new ThreadEx_10_1();
		Thread t2 = new ThreadEx_10_2();
		
		t1.start();
		t2.start();
		
		startTime = System.currentTimeMillis(); // 현재 시간을 ms단위로 표현해준다.
		
		try {
			t1.join(); // 이걸 수행하자마자 main Thread가 멈춰. 왜냐? t1을 현재 쓰레드 내에 포함시키기 때문.
					// t1이 종료된 다음에야 main Thread가 다시 동작하게 된다.
			t2.join(); // 이거 끝날 때까지 main Thread는 밀리게 된다.
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("\n소요시간 : " + (System.currentTimeMillis() - startTime));
	}
}
