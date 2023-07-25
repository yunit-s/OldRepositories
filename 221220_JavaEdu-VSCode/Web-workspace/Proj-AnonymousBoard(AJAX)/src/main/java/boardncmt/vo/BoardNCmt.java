package boardncmt.vo;

public class BoardNCmt {

	private int boardNum;
	private String boardTitle;
	private String boardAuthor;
	private String boardContent;
	private String boardDate;
	private int boardCommentCount;
	private int boardLikeNum;
	
	public BoardNCmt() {
		// TODO Auto-generated constructor stub
	}
	public BoardNCmt(int boardNum, String boardTitle, String boardAuthor, String boardContent, String boardDate,
			int boardCommentCount, int boardLikeNum) {
		super();
		this.boardNum = boardNum;
		this.boardTitle = boardTitle;
		this.boardAuthor = boardAuthor;
		this.boardContent = boardContent;
		this.boardDate = boardDate;
		this.boardCommentCount = boardCommentCount;
		this.boardLikeNum = boardLikeNum;
	}
	
	public int getBoardNum() {
		return boardNum;
	}
	public void setBoardNum(int boardNum) {
		this.boardNum = boardNum;
	}
	public String getBoardTitle() {
		return boardTitle;
	}
	public void setBoardTitle(String boardTitle) {
		this.boardTitle = boardTitle;
	}
	public String getBoardAuthor() {
		return boardAuthor;
	}
	public void setBoardAuthor(String boardAuthor) {
		this.boardAuthor = boardAuthor;
	}
	public String getBoardContent() {
		return boardContent;
	}
	public void setBoardContent(String boardContent) {
		this.boardContent = boardContent;
	}
	public String getBoardDate() {
		return boardDate;
	}
	public void setBoardDate(String boardDate) {
		this.boardDate = boardDate;
	}
	public int getBoardCommentCount() {
		return boardCommentCount;
	}
	public void setBoardCommentCount(int boardCommentCount) {
		this.boardCommentCount = boardCommentCount;
	}
	public int getBoardLikeNum() {
		return boardLikeNum;
	}
	public void setBoardLikeNum(int boardLikeNum) {
		this.boardLikeNum = boardLikeNum;
	}
	
}
