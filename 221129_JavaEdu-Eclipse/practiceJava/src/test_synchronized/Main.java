package test_synchronized;

public class Main {

	public static void main(String[] args) {
	
		SharedClass shared = new SharedClass(3000);
		
		RClass1 r1 = new RClass1(shared);
		RClass2 r2 = new RClass2(shared);
		RClass3 r3 = new RClass3(shared);
		RClass4 r4 = new RClass4(shared);
		
		Thread t1 = new Thread(r1);
		Thread t2 = new Thread(r2);
		Thread t3 = new Thread(r3);
		Thread t4 = new Thread(r4);
		
		t1.start();
		t2.start();
		t3.start();
		t4.start();
		
	}
}
