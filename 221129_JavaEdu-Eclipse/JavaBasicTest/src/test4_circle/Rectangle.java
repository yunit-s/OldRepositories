package test4_circle;

public class Rectangle extends Shape implements Movable {
	
	// constructors
	public Rectangle() {
	}
	public Rectangle(int width, int x, int y) {
//		Point tmp = new Point(x, y);
//		setPoint(tmp);
		super(new Point(x, y)); // 교수님 코드인데 이게 훨씬 낫네
		this.width = width;
	}

	// fields
	private int width;
	
	// methods
	@Override
	public double getArea() {
		return width * width;
	}
	@Override
	public double getCircumference() {
		return width * 4;
	}
	@Override
	public void move(int x, int y) {
		Point tmp = new Point(getPoint().getX() + x + 2, getPoint().getY() + y + 2);
		setPoint(tmp);
	}
	@Override
	public String toString() {
		return "Rectangle\t" + getWidth() + "\t" + getPoint().getX() + "\t" + getPoint().getY();
	}
	
	// getter & setter
	public int getWidth() {
		return width;
	}
	public void setWidth(int width) {
		this.width = width;
	}

	
}
