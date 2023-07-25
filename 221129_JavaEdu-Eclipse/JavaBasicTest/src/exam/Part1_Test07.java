package exam;

class Tv {
	private String name;
	private int price;
	private String description;
	
	public Tv() {
	}
	public Tv(String name, int price, String description) {
		super();
		this.name = name;
		this.price = price;
		this.description = description;
	}
	
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	
	@Override
	public String toString() {
		return name + "\t" + price + "\t" + description;
	}
	
}

public class Part1_Test07 {

	public static void main(String[] args) {
		Tv[] tvArray = new Tv[3];
		tvArray[0] = new Tv("INFINIA", 1500000, "LED TV");
		tvArray[1] = new Tv("XCANVAS", 1000000, "LCD TV");
		tvArray[2] = new Tv("CINEMA", 2000000, "3D TV");
		
		int sum = 0;
		for (Tv arr : tvArray) {
			System.out.println(arr);
			sum += arr.getPrice();
		}
		System.out.println("가격의 합 : " + sum);
	}
}
