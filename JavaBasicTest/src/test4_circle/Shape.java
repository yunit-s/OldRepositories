package test4_circle;

public abstract class Shape {

	// constructors
	public Shape() {
		
	}
	public Shape(Point point) {
		this.point = point;
	}
	
	// fields
	protected Point point;
	
	// methods
	public abstract double getArea();
	public abstract double getCircumference();
	
	// getter & setter
	public Point getPoint() {
		return point;
	}
	public void setPoint(Point point) {
		this.point = point;
	}
}
