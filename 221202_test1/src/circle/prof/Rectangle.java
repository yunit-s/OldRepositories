package circle.prof;

public class Rectangle extends Shape implements Movable {

	// constructor
	public Rectangle() {
		// TODO Auto-generated constructor stub
	}
	public Rectangle(int width, int x, int y) {
		super(new Point(x, y));
		this.width = width;
	}
	
	// field
	private int width;
	
	@Override
	public void move(int x, int y) {
		// x와 y의 좌표값 변경하기
		Point p = getPoint();
		p.setX(p.getX() + x + 2);
		p.setY(p.getY() + y + 2);
		setPoint(p);
	}

	@Override
	public double getArea() {
		return Math.round(Math.pow(width, 2)); // Math.pow : 여러 번 제곱하기
	}

	@Override
	public double getCircumference() {
		return Math.round(4 * width);
	}
	
	@Override
	public String toString() {
		// getSimpleName() : 클래스 이름 리턴받기
		return this.getClass().getSimpleName() + "   " + width + "   "
				+ getPoint().getX() + "   " + getPoint().getY() + "   "
				+ getArea() + "   " + getCircumference();
	}

	// getter & setter
	public int getWidth() {
		return width;
	}
	public void setWidth(int width) {
		this.width = width;
	}

}
