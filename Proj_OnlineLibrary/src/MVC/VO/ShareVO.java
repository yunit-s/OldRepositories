package MVC.VO;

import MVC.View.BookSearchView;
import MVC.View.HeadlineView;
import MVC.View.LoginView;
import MVC.View.MypageBorrowStatView;
import MVC.View.MypageMenuView;
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
	
}
