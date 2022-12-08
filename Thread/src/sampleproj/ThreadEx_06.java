package sampleproj;

import javax.swing.JOptionPane;

// Thread 클래스를 상속받아서 이 클래스가 쓰레드가 되게 한다.
class ThreadEx_06_1 extends Thread {
	
	// 내 인스턴스가 쓰레드가 되고, 그때 수행하는 일을 작성하기 위해 run()이라는 메소드를 오버라이딩한다.
	@Override
	public void run() {
		int i = 10;
		while (i != 0 && !this.isInterrupted()) {
			System.out.println(i--); // i 단조 감소. (1씩 감소)
			// busy-waiting. 바쁘게 기다리는 거야. 절대 좋은 코드 아니야. 코어가 노는 게 아니라 일을 하는 거거든
			for (long k = 0; k < 1000000000000000000L; k++);
		}
		System.out.println("카운트가 종료되었습니다.!");
	}
}

public class ThreadEx_06 {

	public static void main(String[] args) {
		Thread t = new ThreadEx_06_1(); // thread instance 생성
		
		t.start(); // thread를 Runnable 상태로 전이시킨다.
				// 바로 실행되지는 않지만, 언젠가는 Thread Scheduler에 의해 실행된다.

		String data = JOptionPane.showInputDialog("값을 입력하세요!"); // GUI를 이용해서 창 하나 띄우기
				// JOptionPane : 클래스. showInputDialog : 스태틱 메소드. 특별한 기능을 하는 메소드.
				// 이거는 blocking 메소드야. 확인 버튼을 누르기 전까지는 main thread가 hold되어 있다.
		
		System.out.println(data);
		
		t.interrupt(); // t라는 thread를 interrupt했어. 그러면 t 쓰레드가 멈출까?
				// 그렇지 않다. thread가 중지된다던지 일시정지된다던지 하는 일은 발생하지 않아요!
				// interrupt에는 interrupt states라는 보이지않는 변수가 있는데, 그 값을 바꿔주게 된다. 그렇다고 뭔가 현상이 바뀌지는 않아.
		
		System.out.println("main 쓰레드 종료");
	}
}
