package lecture.jdbc.vo;

public class BookVO {

	// 전체 데이터 중에서 필요한 컬럼에 대해서만 필드로 설정
	private String bisbn; // 컬럼 명과 필드 명 똑같이 잡는 게 기본 룰
	private String btitle;
	private String bauthor;
	private int bprice;
	
	public BookVO() {
		
	}
	public BookVO(String bisbn, String btitle, String bauthor, int bprice) {
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
	
	// VO에는 business logic을 넣지 않는다.
}
