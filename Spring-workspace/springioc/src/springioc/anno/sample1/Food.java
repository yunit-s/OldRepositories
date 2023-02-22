package springioc.anno.sample1;

public class Food {

	private String foodName;
	private String foodPrice;
	
	public Food() {
		System.out.println("!! Food() default 생성자 호출");
	}

	public void setFoodName(String foodName) {
		this.foodName = foodName;
		System.out.println("!!! Food.setFoodName() 호출 - foodName : " + foodName);
	}

	public void setFoodPrice(String foodPrice) {
		this.foodPrice = foodPrice;
		System.out.println("!!! Food.setFoodPrice() 호출 - foodPrice : " + foodPrice);
	}

	@Override
	public String toString() {
		return foodName + " : " + foodPrice;
	}
	
}
