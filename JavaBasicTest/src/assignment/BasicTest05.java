package assignment;

public class BasicTest05 {

	public static void main(String[] args) {
		int args0 = Integer.parseInt(args[0]);
		int args1 = Integer.parseInt(args[1]);
		int args2 = Integer.parseInt(args[2]);
		int max = args0;
		int min = args0;
		
		if (args1 > max) max = args1;
		else if (args1 < min) min = args1;
		if (args2 > max) max = args2;
		else if (args2 < min) min = args2;
		
		System.out.println("최대값 : " + max);
		System.out.println("최소값 : " + min);
	}
}
