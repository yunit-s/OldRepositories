package MVC.View;

import MVC.VO.ShareVO;
import javafx.geometry.Insets;
import javafx.scene.layout.BorderPane;

public class MypageView {

	public BorderPane getRootPane(ShareVO share) {

		// Declare variables -----
		
		// Layout
		BorderPane rootPane;
		
		// Components
		
		
		
		
		
		// Initialize -----
		
		// Layout
		rootPane = new BorderPane();
		
		// Components

		
		
		
		
		// View -----
		
		// Layout
		rootPane.setPadding(new Insets(5));
		rootPane.setLeft(share.getMypageMenuView().getRootPane(share));
		if (share.getUser().getId().equals("admin")) {
			rootPane.setCenter(share.getMypageModifyBookDBView().getRootPane(share));
		} else {
			rootPane.setCenter(share.getMypageBorrowStatView().getRootPane(share));
		}
		
		return rootPane;
	}
}
