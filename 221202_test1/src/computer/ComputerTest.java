package computer;

public class ComputerTest {

	public static void main(String[] args) {
		Computer arrays[] = new Computer[4];
		arrays[0] = new Laptop("Lap01", 2, 1024, 2000);
		arrays[1] = new Laptop("Lap02", 3, 2048, 2300);
		arrays[2] = new Tab("Tab01", 2, 1024, 1200);
		arrays[3] = new Tab("Tab02", 3, 2048, 1300);
		
		System.out.println("name\tcpu\tmemory\tbattery");
		System.out.println("----------------------------------------");
		for (Computer c : arrays) {
			System.out.println(c.getName() + "\t" + c.getCpu() + "\t" + c.getMemory() + "\t" + c.getBattery());
		}
		System.out.println("\n\n");
		
		System.out.println("name\tcpu\tmemory\tbattery\trendering time");
		System.out.println("--------------------------------------------------------");
		for (Computer c : arrays) {
			c.operate(55);
		}

		System.out.println(arrays[0].getName() + "\t" + arrays[0].getCpu() + "\t" + arrays[0].getMemory() + "\t" + arrays[0].getBattery() + "\t" + ((Laptop)arrays[0]).rendering(100));
		System.out.println(arrays[1].getName() + "\t" + arrays[1].getCpu() + "\t" + arrays[1].getMemory() + "\t" + arrays[1].getBattery() + "\t" + ((Laptop)arrays[1]).rendering(100));
		System.out.println(arrays[2].getName() + "\t" + arrays[2].getCpu() + "\t" + arrays[2].getMemory() + "\t" + arrays[2].getBattery() + "\t" + ((Tab)arrays[2]).rendering(100));
		System.out.println(arrays[3].getName() + "\t" + arrays[3].getCpu() + "\t" + arrays[3].getMemory() + "\t" + arrays[3].getBattery() + "\t" + ((Tab)arrays[3]).rendering(100));
	}
}
