package MVC.VO;

import MVC.View.BookSearchView;
import MVC.View.HeadlineLoggedinView;
import MVC.View.HeadlineView;
import MVC.View.LoginView;
import MVC.View.MypageModifyMyInfoView;
import MVC.View.MypageOutstandingBookView;
import MVC.View.MypageBorrowStatView;
import MVC.View.MypageUserListView;
import MVC.View.MypageMenuView;
import MVC.View.MypageModifyBookDBView;
import MVC.View.MypageView;
import MVC.View.SignUpView;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class ShareVO {

	private BorderPane mainPane;
	
	private HeadlineView headlineView;
	private LoginView loginView;
	private BookSearchView bookSearchView;
	private SignUpView signUpView;
	private MypageView mypageView;
	private MypageMenuView mypageMenuView;
	private MypageBorrowStatView mypageBorrowStatView;
	private HeadlineLoggedinView headlineLoggedinView;
	private MypageModifyMyInfoView mypageModifyMyInfoView;
	private MypageUserListView mypageUserListView;
	private MypageModifyBookDBView mypageModifyBookDBView;
	private MypageOutstandingBookView mypageOutstandingBookView;
	
	private UserVO user;
	
	
	
	
	
	public ShareVO() {
		
		mainPane = new BorderPane();
		
		headlineView = new HeadlineView();
		loginView = new LoginView();
		bookSearchView = new BookSearchView();
		signUpView = new SignUpView();
		mypageView = new MypageView();
		mypageMenuView = new MypageMenuView();
		mypageBorrowStatView = new MypageBorrowStatView();
		headlineLoggedinView = new HeadlineLoggedinView();
		mypageModifyMyInfoView = new MypageModifyMyInfoView();
		mypageUserListView = new MypageUserListView();
		mypageModifyBookDBView = new MypageModifyBookDBView();
		mypageOutstandingBookView = new MypageOutstandingBookView();
		
		user = null;
	}
	
	



	public BorderPane getMainPane() {
		return mainPane;
	}
	public void setMainPane(BorderPane mainPane) {
		this.mainPane = mainPane;
	}
	public HeadlineView getHeadlineView() {
		return headlineView;
	}
	public void setHeadlineView(HeadlineView headlineView) {
		this.headlineView = headlineView;
	}
	public LoginView getLoginView() {
		return loginView;
	}
	public void setLoginView(LoginView loginView) {
		this.loginView = loginView;
	}
	public BookSearchView getBookSearchView() {
		return bookSearchView;
	}
	public void setBookSearchView(BookSearchView bookSearchView) {
		this.bookSearchView = bookSearchView;
	}
	public SignUpView getSignUpView() {
		return signUpView;
	}
	public void setSignUpView(SignUpView signUpView) {
		this.signUpView = signUpView;
	}
	public MypageView getMypageView() {
		return mypageView;
	}
	public void setMypageView(MypageView mypageView) {
		this.mypageView = mypageView;
	}
	public MypageMenuView getMypageMenuView() {
		return mypageMenuView;
	}
	public void setMypageMenuView(MypageMenuView mypageMenuView) {
		this.mypageMenuView = mypageMenuView;
	}
	public MypageBorrowStatView getMypageBorrowStatView() {
		return mypageBorrowStatView;
	}
	public void setMypageBorrowStatView(MypageBorrowStatView mypageBorrowStatView) {
		this.mypageBorrowStatView = mypageBorrowStatView;
	}
	public HeadlineLoggedinView getHeadlineLoggedinView() {
		return headlineLoggedinView;
	}
	public void setHeadlineLoggedinView(HeadlineLoggedinView headlineLoggedinView) {
		this.headlineLoggedinView = headlineLoggedinView;
	}
	public MypageModifyMyInfoView getMypageModifyMyInfoView() {
		return mypageModifyMyInfoView;
	}
	public void setMypageModifyMyInfoView(MypageModifyMyInfoView mypageModifyMyInfoView) {
		this.mypageModifyMyInfoView = mypageModifyMyInfoView;
	}
	public MypageUserListView getMypageUserListView() {
		return mypageUserListView;
	}
	public void setMypageUserListView(MypageUserListView mypageUserListView) {
		this.mypageUserListView = mypageUserListView;
	}
	public MypageModifyBookDBView getMypageModifyBookDBView() {
		return mypageModifyBookDBView;
	}
	public void setMypageModifyBookDBView(MypageModifyBookDBView mypageModifyBookDBView) {
		this.mypageModifyBookDBView = mypageModifyBookDBView;
	}
	public MypageOutstandingBookView getMypageOutstandingBookView() {
		return mypageOutstandingBookView;
	}
	public void setMypageOutstandingBookView(MypageOutstandingBookView mypageOutstandingBookView) {
		this.mypageOutstandingBookView = mypageOutstandingBookView;
	}

	public UserVO getUser() {
		return user;
	}
	public void setUser(UserVO user) {
		this.user = user;
	}
	
}
