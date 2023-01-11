package MVC.VO;

public class SearchObjectVO {

	private String category;
	private String keyword;
	
	public SearchObjectVO(String category, String keyword) {
		this.category = category;
		this.keyword = keyword;
	}

	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getKeyword() {
		return keyword;
	}
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
}
