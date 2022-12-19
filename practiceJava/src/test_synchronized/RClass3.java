package test_synchronized;

public class RClass3 implements Runnable {

	SharedClass shared;
	
	public RClass3(SharedClass shared) {
		this.shared = shared;
	}

	@Override
	public void run() {
		
//		// 메소드 자체에 동기화를 걸어둔 경우
//		while (true) {
//			try {
//				Thread.sleep(500);
//				shared.process(3, 7);
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}
		
		// 외부에서 객체에 동기화를 걸어둔 경우
		while (true) {
			try {
				Thread.sleep(500);
				synchronized (shared) {
					shared.process(3, 7);
				}
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
