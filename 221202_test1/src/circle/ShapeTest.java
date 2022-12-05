package circle;

import java.util.ArrayList;

public class ShapeTest {

	public static void main(String[] args) {
		ArrayList<Shape> arr = new ArrayList<Shape>();
		arr.add(new Rectangle(4, 7, 5));
		arr.add(new Rectangle(5, 4, 6));
		arr.add(new Circle(6, 6, 7));
		arr.add(new Circle(7, 8, 3));

		System.out.println("Figure\t\tlength\tx\ty\tArea\tCircumference");
		System.out.println("--------------------------------------------------------------");
		for (Shape tmp : arr) {
			System.out.println(tmp + "\t" + Math.round(tmp.getArea()) + "\t" + Math.round(tmp.getCircumference()));
		}
		
		for (Shape tmp : arr) {
			if (tmp instanceof Rectangle)
				((Rectangle)tmp).move(10, 10);
			else
				((Circle)tmp).move(10, 10);
		}
		
		System.out.println("\n");
		System.out.println("Figure\t\tlength\tx\ty");
		System.out.println("---------------------------------------");
		for (Shape tmp : arr) {
			System.out.println(tmp);
		}
	}
	
}
