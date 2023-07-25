package MVC.VO;

public class BookVO {

	private String bisbn;
	private String btitle;
	private String bdate;
	private int bpage;
	private int bprice;
	private String bauthor;
//	private String btranslator;
//	private String bsupplement;
	private String bpublisher;
	private String bimgurl;
	private String bimgbase64;
	private String bborrowable;
	private String breturndate;

	public BookVO(String bisbn, String btitle, String bauthor, int bprice) {
		this.bisbn = bisbn;
		this.btitle = btitle;
		this.bauthor = bauthor;
		this.bprice = bprice;
	}
	public BookVO(String bisbn, String btitle, String bdate, int bpage, int bprice, String bauthor,
			String bpublisher, String bimgurl, String bimgbase64, String bborrowable, String breturndate) {
		this.bisbn = bisbn;
		this.btitle = btitle;
		this.bdate = bdate;
		this.bpage = bpage;
		this.bprice = bprice;
		this.bauthor = bauthor;
//		this.btranslator = btranslator;
//		this.bsupplement = bsupplement;
		this.bpublisher = bpublisher;
		this.bimgurl = bimgurl;
		this.bimgbase64 = bimgbase64;
		this.bborrowable = bborrowable;
		this.breturndate = breturndate;
	}

	public String getBisbn() {return bisbn;}
	public void setBisbn(String bisbn) {this.bisbn = bisbn;}
	public String getBtitle() {return btitle;}
	public void setBtitle(String btitle) {this.btitle = btitle;}
	public String getBdate() {return bdate;}
	public void setBdate(String bdate) {this.bdate = bdate;}
	public int getBpage() {return bpage;}
	public void setBpage(int bpage) {this.bpage = bpage;}
	public int getBprice() {return bprice;}
	public void setBprice(int bprice) {this.bprice = bprice;}
	public String getBauthor() {return bauthor;}
	public void setBauthor(String bauthor) {this.bauthor = bauthor;}
//	public String getBtranslator() {return btranslator;}
//	public void setBtranslator(String btranslator) {this.btranslator = btranslator;}
//	public String getBsupplement() {return bsupplement;}
//	public void setBsupplement(String bsupplement) {this.bsupplement = bsupplement;}
	public String getBpublisher() {return bpublisher;}
	public void setBpublisher(String bpublisher) {this.bpublisher = bpublisher;}
	public String getBimgurl() {return bimgurl;}
	public void setBimgurl(String bimgurl) {this.bimgurl = bimgurl;}
	public String getBimgbase64() {return bimgbase64;}
	public void setBimgbase64(String bimgbase64) {this.bimgbase64 = bimgbase64;}
	public String getBborrowable() {return bborrowable;}
	public void setBborrowable(String bborrowable) {this.bborrowable = bborrowable;}
	public String getBreturndate() {return breturndate;}
	public void setBreturndate(String breturndate) {this.breturndate = breturndate;}
	
	
	
}
