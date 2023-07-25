package test4_circle.prof;

import java.util.ArrayList;

public class ShapeTest {

	public static void main(String[] args) {
		
		ArrayList<Shape> list = new ArrayList<Shape>();
		// 여기 generic type에는 Shape이나 Movable이 올 수 있다.
		// 좀 더 편하게 활용하기 위해 Shape으로 구현한다.
		list.add(new Rectangle(4, 7, 5));
		list.add(new Rectangle(5, 4, 6));
		list.add(new Circle(6, 6, 7));
		list.add(new Circle(7, 8, 3));
		
		for (Shape s : list) {
			System.out.println(s);
		}
		
		for (Shape s : list) {
			((Movable)s).move(10, 10);
		}
	}
}
