package jdbc.vo;

// VO는 데이터를 표현하는 객체다.
// 값을 저장하고, 값을 표현하는 클래스이기 때문에, 일반적인 Business Logic이 나오면 안 된다.
// Database의 Table을 참조해서 만든다.

public class Book {

	// 필드를 전부 다 정의하면 그게 바로 DO야.
	// 근데 우리한테는 다 필요한 게 아니잖아? 몇 개만 가져다 쓸 거니까 VO로 사용할거야.
	private String bisbn; // 괜히 isbn으로 만들지 말자. 오히려 안 좋다.
	private String btitle;
	private String bauthor;
	private int bprice;
	
	public Book() {
		// TODO Auto-generated constructor stub
	}

	public Book(String bisbn, String btitle, String bauthor, int bprice) {
		this.bisbn = bisbn;
		this.btitle = btitle;
		this.bauthor = bauthor;
		this.bprice = bprice;
	}

	public String getBisbn() {
		return bisbn;
	}

	public void setBisbn(String bisbn) {
		this.bisbn = bisbn;
	}

	public String getBtitle() {
		return btitle;
	}

	public void setBtitle(String btitle) {
		this.btitle = btitle;
	}

	public String getBauthor() {
		return bauthor;
	}

	public void setBauthor(String bauthor) {
		this.bauthor = bauthor;
	}

	public int getBprice() {
		return bprice;
	}

	public void setBprice(int bprice) {
		this.bprice = bprice;
	}
	
	@Override
	public String toString() {
		return bisbn + ", " + btitle + ", " + bauthor + ", " + bprice;
	}
}
