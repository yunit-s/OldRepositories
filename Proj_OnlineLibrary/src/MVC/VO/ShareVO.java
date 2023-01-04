package MVC.VO;

import MVC.View.BookSearchView;
import MVC.View.HeadlineView;
import MVC.View.LoginView;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class ShareVO {

	private BorderPane mainPane;
	
	private HeadlineView headlineView;
	private LoginView loginView;
	private BookSearchView bookSearchView;
	
	private UserVO user;
	
	
	
	
	public ShareVO() {
		
		mainPane = new BorderPane();
		
		headlineView = new HeadlineView(this);
		loginView = new LoginView(this);
		bookSearchView = new BookSearchView(this);
	}

//	public ShareVO(BorderPane mainPane, HeadlineView headlineView, LoginView loginView, BookSearchView bookSearchView) {
//		this.mainPane = mainPane;
//		this.headlineView = headlineView;
//		this.loginView = loginView;
//		this.bookSearchView = bookSearchView;
//	}

	
	
	
	
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

}
