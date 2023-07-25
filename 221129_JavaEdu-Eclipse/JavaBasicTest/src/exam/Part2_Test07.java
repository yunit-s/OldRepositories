package exam;

import java.util.HashMap;

public class Part2_Test07 {

	public static void main(String[] args) {

		Part2_Test07_Employee[] e = new Part2_Test07_Employee[2];
		e[0] = new Part2_Test07_Secretary("Hilery", 1, "secretary", 800);
		e[1] = new Part2_Test07_Sales("Clinten", 2, "sales", 1200);
		
		HashMap<Integer, Part2_Test07_Employee> map = new HashMap<Integer, Part2_Test07_Employee>();
		map.put(e[0].getNumber(), e[0]);
		map.put(e[1].getNumber(), e[1]);
		
		System.out.println("name\t\tdepartment\tsalary");
		System.out.println("---------------------------------------");
		for (Integer key : map.keySet()) {
			System.out.println(map.get(key));
		}
		System.out.println();
		
		System.out.println("인샌티브 100 지급");
		for (Integer key : map.keySet()) {
			((Part2_Test07_Bonus)map.get(key)).incentive(100);
		}
		System.out.println("name\t\tdepartment\tsalary\t\ttax");
		System.out.println("----------------------------------------------------");
		for (Integer key : map.keySet()) {
			System.out.println(map.get(key).toString() + "\t\t" + map.get(key).tax());
		}
		
	}
}
