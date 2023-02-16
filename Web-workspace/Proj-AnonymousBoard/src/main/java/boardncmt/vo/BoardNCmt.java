package boardncmt.vo;

public class BoardNCmt {

	private int boardNum;
	private String boardNCmtTitle;
	private String boardNCmtAuthor;
	private String boardNCmtContent;
	private String boardNCmtDate;
	private int boardNCmtCommentNum;
	private int boardLikeNum;
	
	public BoardNCmt() {
		// TODO Auto-generated constructor stub
	}
	public BoardNCmt(int boardNum, String boardNCmtTitle, String boardNCmtAuthor, String boardNCmtContent,
			String boardNCmtDate, int boardNCmtCommentNum, int boardLikeNum) {
		super();
		this.boardNum = boardNum;
		this.boardNCmtTitle = boardNCmtTitle;
		this.boardNCmtAuthor = boardNCmtAuthor;
		this.boardNCmtContent = boardNCmtContent;
		this.boardNCmtDate = boardNCmtDate;
		this.boardNCmtCommentNum = boardNCmtCommentNum;
		this.boardLikeNum = boardLikeNum;
	}
	
	public int getBoardNum() {
		return boardNum;
	}
	public void setBoardNum(int boardNum) {
		this.boardNum = boardNum;
	}
	public String getBoardNCmtTitle() {
		return boardNCmtTitle;
	}
	public void setBoardNCmtTitle(String boardNCmtTitle) {
		this.boardNCmtTitle = boardNCmtTitle;
	}
	public String getBoardNCmtAuthor() {
		return boardNCmtAuthor;
	}
	public void setBoardNCmtAuthor(String boardNCmtAuthor) {
		this.boardNCmtAuthor = boardNCmtAuthor;
	}
	public String getBoardNCmtContent() {
		return boardNCmtContent;
	}
	public void setBoardNCmtContent(String boardNCmtContent) {
		this.boardNCmtContent = boardNCmtContent;
	}
	public String getBoardNCmtDate() {
		return boardNCmtDate;
	}
	public void setBoardNCmtDate(String boardNCmtDate) {
		this.boardNCmtDate = boardNCmtDate;
	}
	public int getBoardNCmtCommentNum() {
		return boardNCmtCommentNum;
	}
	public void setBoardNCmtCommentNum(int boardNCmtCommentNum) {
		this.boardNCmtCommentNum = boardNCmtCommentNum;
	}
	public int getBoardLikeNum() {
		return boardLikeNum;
	}
	public void setBoardLikeNum(int boardLikeNum) {
		this.boardLikeNum = boardLikeNum;
	}
	
}
