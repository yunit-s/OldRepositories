package assignment;

import java.util.HashSet;

class Book {
	private String category;
	private String bookName;
	private double bookPrice;
	private double bookDiscountRate;

	public Book() {
	}
	public Book(String category, String bookName, double bookPrice, double bookDiscountRate) {
		super();
		this.category = category;
		this.bookName = bookName;
		this.bookPrice = bookPrice;
		this.bookDiscountRate = bookDiscountRate;
	}
	
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public double getBookPrice() {
		return bookPrice;
	}
	public void setBookPrice(double bookPrice) {
		this.bookPrice = bookPrice;
	}
	public double getBookDiscountRate() {
		return bookDiscountRate;
	}
	public void setBookDiscountRate(double bookDiscountRate) {
		this.bookDiscountRate = bookDiscountRate;
	}
	
	public double getDiscountBookPrice() {
		return bookPrice * (100 - bookDiscountRate) / 100;
	}
	@Override
	public String toString() {
		return category + "\t" + bookName + "\t" + bookPrice + "원 " + bookDiscountRate + "%";
	}
	
}

public class BasicTest09 {

	public static void main(String[] args) {
		Book bookArray[] = new Book[5];
		bookArray[0] = new Book("IT", "SQL Plus", 50000, 5);
		bookArray[1] = new Book("IT", "Java 2.0", 40000, 3);
		bookArray[2] = new Book("IT", "JSP Servlet", 60000, 6);
		bookArray[3] = new Book("Novel", "davincicode", 30000, 10);
		bookArray[4] = new Book("Novel", "cloven hoof", 50000, 15);
		
		for (Book arr : bookArray) {
			System.out.println(arr);
		}
		System.out.println();

//		// simple version
//		double novelSum = 0, novelDisSum = 0, itSum = 0, itDisSum = 0;
//		for (Book arr : bookArray) {
//			if (arr.getCategory().equals("Novel")) {
//				novelSum += arr.getBookPrice();
//				novelDisSum += arr.getDiscountBookPrice();
//			} else {
//				itSum += arr.getBookPrice();
//				itDisSum += arr.getDiscountBookPrice();
//			}
//		}
//		System.out.println("Novel Category의 책 가격 합 : " + novelSum);
//		System.out.println("Novel Category의 할인된 책 가격 합 : " + novelDisSum);
//		System.out.println("IT Category의 책 가격 합 : " + itSum);
//		System.out.println("IT Category의 할인된 책 가격 합 : " + itDisSum);
		
		// versatile version
		HashSet<String> cateSet = new HashSet<String>();
		for (Book book : bookArray) {
			cateSet.add(book.getCategory());
		}
		
		for (String category : cateSet) {
			double priceSum = 0, disPriceSum = 0;
			for (Book book : bookArray) {
				if (book.getCategory().equals(category)) {
					priceSum += book.getBookPrice();
					disPriceSum += book.getBookPrice() * (100 - book.getBookDiscountRate()) / 100;
				}
			}
			System.out.println(category + " Category 의 책 가격 합 : " + priceSum);
			System.out.println(category + " Category 의 할인된 책 가격 합 : " + disPriceSum);
		}
	}
}
