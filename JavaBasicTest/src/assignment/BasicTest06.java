package assignment;

class Months {
	public int getDays(int months) {
		if (months == 2) return 28;
		else if (months == 4 || months == 6 || months == 9 || months == 11) return 30;
		else return 31;
	}
}

public class BasicTest06 {

	public static void main(String[] args) {
		
		int input = 0;
		
		if (args.length != 1) {
			System.out.println("한 개의 숫자만 입력해야 합니다. 다시 입력해 주세요.");
		} else {
			input = Integer.parseInt(args[0]);
			if (input < 1 || input > 12) {
				System.out.println("입력된 값이 잘못 되었습니다. 1~12 사이의 값을 입력하세요.");
			} else {
				Months mon = new Months();
				System.out.println("입력받은 월 : " + input + "월");
				System.out.println("마지막 일자 : " + mon.getDays(input) + "일");
			}
		}
	}
}
