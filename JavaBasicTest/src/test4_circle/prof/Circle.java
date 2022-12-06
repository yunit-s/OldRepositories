package test4_circle.prof;

public class Circle extends Shape implements Movable {

	// constructor
	public Circle() {
		// TODO Auto-generated constructor stub
	}
	public Circle(int radius, int x, int y) {
		super(new Point(x, y));
		this.radius = radius;
	}
	
	// field
	private int radius;
	
	@Override
	public void move(int x, int y) {
		// x와 y의 좌표값 변경하기
		Point p = getPoint();
		p.setX(p.getX() + x + 1);
		p.setY(p.getY() + y + 1);
		setPoint(p);
	}

	@Override
	public double getArea() {
		// TODO Auto-generated method stub
//		return Math.pow(radius, 2) * Math.PI; // Math.pow : 여러 번 제곱하기
		return Math.round(Math.pow(radius, 2) * Math.PI); // Math.pow : 여러 번 제곱하기
	}

	@Override
	public double getCircumference() {
		// TODO Auto-generated method stub
		return Math.round(2 * radius * Math.PI);
	}
	
	@Override
	public String toString() {
		// getSimpleName() : 클래스 이름 리턴받기
		return this.getClass().getSimpleName() + "   " + radius + "   "
				+ getPoint().getX() + "   " + getPoint().getY() + "   "
				+ getArea() + "   " + getCircumference();
	}
	
	// getter & setter
	public int getRadius() {
		return radius;
	}
	public void setRadius(int radius) {
		this.radius = radius;
	}

}
