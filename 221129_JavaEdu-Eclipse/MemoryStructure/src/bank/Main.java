package bank;

public class Main {

	public static void main(String[] args) {
		
		// 프로그램 시작(main method를 여기에만 넣었으니까)
		Customer hong = new Customer(); // hong : 지역변수
		hong.name = "홍길동";
		
		hong.deposit(2000);
	}
}
