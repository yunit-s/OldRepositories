package test2_planetest;

public class PlaneTest {
	
	public static void main(String[] args) {
		Plane p[] = new Plane[2];
		p[0] = new Airplane("L747", 1000);
		p[1] = new Cargoplane("C40", 1000);

//		System.out.println("Plane\tfuelSize");
//		System.out.println("---------------------");
//		System.out.println(p[0].getPlaneName() + "\t" + p[0].getFuelSize());
//		System.out.println(p[1].getPlaneName() + "\t" + p[1].getFuelSize());
//		System.out.println("\n\n");
		printPlaneStatus(p);
		
		p[0].flight(100);
		p[1].flight(100);
		printPlaneStatus(p);
		
		p[0].refuel(200);
		p[1].refuel(200);
		printPlaneStatus(p);
	}
	
	static void printPlaneStatus(Plane[] p) {
		System.out.println("Plane\tfuelSize");
		System.out.println("---------------------");
		for (Plane tmp : p) {
			System.out.println(tmp.getPlaneName() + "\t" + tmp.getFuelSize());
		}
		System.out.println("\n");
	}
	
}
