package simpleprogram;

import java.util.Scanner;

class Methods {

	int tableNum;
	int memberNum;
	int[] seatSelected; // 0 : 공석, 1 : 배정됨
	String[] memberName;
	
	public Methods() {
		tableNum = 24;
		memberNum = tableNum - 2;
		seatSelected = new int[tableNum + 1]; // 0 : 공석, 1 : 배정됨
		memberName = new String[tableNum];
		
		for (int i = 0; i < tableNum; i++) {
			memberName[i] = "";
		}
		seatSelected[0] = 1;
		seatSelected[5] = 1;
		memberName[0] = "  - ";
		memberName[5] = "  - ";
	}
	
	public int getMemberNum() {
		return memberNum;
	}

	public void addMember(String name) {
		// 랜덤 숫자 추출 -> 빈 자리면 배정. 있으면 무한 반복
		while (true) {
			int rSeat = (int)(Math.random() * tableNum) % tableNum;
			// 해당 좌석이 빈 자리인 경우
			if (seatSelected[rSeat] == 0) {
				seatSelected[rSeat] = 1;
				memberName[rSeat] = name;
				break;
			}
		}
		printSeatAll();
	}
	
	public void printSeatAll() {
		// 좌석 배치
		System.out.println("\n\n\n\t\t\t      스크린");
		for (int i = 0; i < memberNum; i = i + 6) {
			if (i == 0) {
				System.out.println("┌───────┬───────┐\t┌───────┬───────┐\t┌───────┬───────┐");
			} else {
				System.out.println("├───────┼───────┤\t├───────┼───────┤\t├───────┼───────┤");
			}
			System.out.println("│ " + memberName[i] + "\t│ " + memberName[i + 1] + "\t│\t│ "
					+ memberName[i + 2] + "\t│ " + memberName[i + 3] + "\t│\t│ "
					+ memberName[i + 4] + "\t│ " + memberName[i + 5] + "\t│");
		}
		System.out.println("└───────┴───────┘\t└───────┴───────┘\t└───────┴───────┘");
	}
}

public class SetMemberSeat {
	
	public static void main(String[] args) {
		Methods methods = new Methods();
		Scanner sc = new Scanner(System.in);
		
		for (int i = 0; i < methods.getMemberNum(); i++) {
			methods.addMember(sc.next());
		}
		System.out.println("\n======================== 자리 배정 종료 ========================");
	}
	
}