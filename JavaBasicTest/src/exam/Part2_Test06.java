package exam;

public class Part2_Test06 {

	public static void main(String[] args) {
		
		Part2_Test06_Plane[] p = new Part2_Test06_Plane[2];
		p[0] = new Part2_Test06_Airplane("L747", 1000);
		p[1] = new Part2_Test06_Cargoplane("C40", 1000);

		printPlaneStatus(p);
		
		System.out.println("100운항");
		for (Part2_Test06_Plane tmp : p) {
			if (tmp.getClass().getSimpleName().equals("Part2_Test06_Airplane")) {
				((Part2_Test06_Airplane)tmp).flight(100);
			} else {
				((Part2_Test06_Cargoplane)tmp).flight(100);
			}
		}
		printPlaneStatus(p);
		
		System.out.println("200 주유");
		for (Part2_Test06_Plane tmp : p) {
			tmp.refuel(200);
		}
		printPlaneStatus(p);
		
	}
	
	static void printPlaneStatus(Part2_Test06_Plane[] p) {
		System.out.println("Plane\tfuelSize");
		System.out.println("----------------------");
		for (Part2_Test06_Plane tmp : p) {
			System.out.println(tmp.getPlaneName() + "\t" + tmp.getFuelSize());
		}
		System.out.println();
	}
}
