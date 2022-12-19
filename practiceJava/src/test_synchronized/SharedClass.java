package test_synchronized;

public class SharedClass {

	long account;
	
	public SharedClass() {
		// TODO Auto-generated constructor stub
	}
	public SharedClass(long account) {
		this.account = account;
	}
	
	public long getAccount() {
		return account;
	}
	public void setAccount(long account) {
		this.account = account;
	}

//	// 메소드 자체에 동기화를 걸어둔 경우
//	public synchronized void process(int rNum, int gap) {
//			System.out.print("RC" + rNum + " acc = " + account + ", gap = " + gap + ",\t\t");
//			account -= gap;
//			System.out.println("RC" + rNum + " rem = " + account);
//	}
	
	public void process(int rNum, int gap) {
		if (rNum == 4) {
			System.out.println(" -- ");
		} else {
			System.out.print("RC" + rNum + " acc = " + account + ", gap = " + gap + ",\t\t");
			account -= gap;
			System.out.println("RC" + rNum + " rem = " + account);
		}
	}
}
