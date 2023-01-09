package MVC.VO;

public class BorrBookVO {
	
	private String bisbn;
	private String btitle;
	private String id;
	private String borrdate;
	private String returndate;
	
	public BorrBookVO(String bisbn, String btitle, String id, String borrdate, String returndate) {
		this.bisbn = bisbn;
		this.btitle = btitle;
		this.id = id;
		this.borrdate = borrdate;
		this.returndate = returndate;
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
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getBorrdate() {
		return borrdate;
	}
	public void setBorrdate(String borrdate) {
		this.borrdate = borrdate;
	}
	public String getReturndate() {
		return returndate;
	}
	public void setReturndate(String returndate) {
		this.returndate = returndate;
	}
	
}
