package like.vo;

public class Like {

	private int likeNum;
	private int likeArticleNum;
	private String likeMemberId;
	
	public Like() {
		// TODO Auto-generated constructor stub
	}
	public Like(int likeNum, int likeArticleNum, String likeMemberId) {
		super();
		this.likeNum = likeNum;
		this.likeArticleNum = likeArticleNum;
		this.likeMemberId = likeMemberId;
	}
	
	public int getLikeNum() {
		return likeNum;
	}
	public void setLikeNum(int likeNum) {
		this.likeNum = likeNum;
	}
	public int getLikeArticleNum() {
		return likeArticleNum;
	}
	public void setLikeArticleNum(int likeArticleNum) {
		this.likeArticleNum = likeArticleNum;
	}
	public String getLikeMemberId() {
		return likeMemberId;
	}
	public void setLikeMemberId(String likeMemberId) {
		this.likeMemberId = likeMemberId;
	}
}
