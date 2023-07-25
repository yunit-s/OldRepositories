package test5_company;

import java.util.HashMap;

public class Company {

	public static void main(String[] args) {
		
		HashMap<Integer, Employee> map = new HashMap<Integer, Employee>();
		Employee e1 = new Secretary("Hilery", 1, "secretary", 800);
		Employee e2 = new Sales("Clinten", 2, "sales    ", 1200);
		
		map.put(e1.getNumber(), e1);
		map.put(e2.getNumber(), e2);
		
		System.out.println("name\tdepartment\tsalary");
		System.out.println("----------------------------------------------");
		for (Integer i : map.keySet()) {
			System.out.println(map.get(i));
		}
		
		((Bonus)(map.get(1))).incentive(100);
		((Bonus)(map.get(2))).incentive(100);
		
		System.out.println("\n");
		System.out.println("name\tdepartment\tsalary\ttax");
		System.out.println("----------------------------------------------");
		for (Integer i : map.keySet()) {
			System.out.println(map.get(i) + "\t" + map.get(i).tax());
		}
	}
}
