package test4_circle;

public class Circle extends Shape implements Movable {

	// constructors
	public Circle() {
	}
	public Circle(int radius, int x, int y) {
//		Point tmp = new Point(x, y);
//		setPoint(tmp);
		super(new Point(x, y)); // 교수님 코드인데 이게 훨씬 낫네
		this.radius = radius;
	}

	// fields
	private int radius;

	// methods
	@Override
	public double getArea() {
		return 3.14 * radius * radius;
	}
	@Override
	public double getCircumference() {
		return 2 * 3.14 * radius;
	}
	@Override
	public void move(int x, int y) {
		Point tmp = new Point(getPoint().getX() + x + 1, getPoint().getY() + y + 1);
		setPoint(tmp);
	}
	@Override
	public String toString() {
		return "Circle\t\t" + getRadius() + "\t" + getPoint().getX() + "\t" + getPoint().getY();
	}
	
	// getter & setter
	public int getRadius() {
		return radius;
	}
	public void setRadius(int radius) {
		this.radius = radius;
	}
	
}
