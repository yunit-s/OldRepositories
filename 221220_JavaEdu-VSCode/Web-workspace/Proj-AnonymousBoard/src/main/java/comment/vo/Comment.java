package comment.vo;

public class Comment {

	private int commentNum;
	private int commentArticleNum;
	private String commentAuthor;
	private String commentContent;
	private String commentDate;
	
	public Comment() {
		// TODO Auto-generated constructor stub
	}
	public Comment(int commentNum, int commentArticleNum, String commentAuthor, String commentContent,
			String commentDate) {
		super();
		this.commentNum = commentNum;
		this.commentArticleNum = commentArticleNum;
		this.commentAuthor = commentAuthor;
		this.commentContent = commentContent;
		this.commentDate = commentDate;
	}
	
	public int getCommentNum() {
		return commentNum;
	}
	public void setCommentNum(int commentNum) {
		this.commentNum = commentNum;
	}
	public int getCommentArticleNum() {
		return commentArticleNum;
	}
	public void setCommentArticleNum(int commentArticleNum) {
		this.commentArticleNum = commentArticleNum;
	}
	public String getCommentAuthor() {
		return commentAuthor;
	}
	public void setCommentAuthor(String commentAuthor) {
		this.commentAuthor = commentAuthor;
	}
	public String getCommentContent() {
		return commentContent;
	}
	public void setCommentContent(String commentContent) {
		this.commentContent = commentContent;
	}
	public String getCommentDate() {
		return commentDate;
	}
	public void setCommentDate(String commentDate) {
		this.commentDate = commentDate;
	}
	
}