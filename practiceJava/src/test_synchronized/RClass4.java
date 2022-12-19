package test_synchronized;

public class RClass4 implements Runnable {

	SharedClass shared;
	
	public RClass4(SharedClass shared) {
		this.shared = shared;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while (true) {
			try {
				Thread.sleep(500);
				synchronized (shared) {
					shared.process(4, 200);
				}
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
