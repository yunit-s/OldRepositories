package MVC.View;

import MVC.VO.BookVO;
import MVC.VO.ShareVO;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;

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
//		rootPane.getChildren().add(share.getMypageMenuView().getRootPane(share));
//		rootPane.getChildren().add(share.getMypageBorrowStatView().getRootPane(share));
		rootPane.setPadding(new Insets(5));
		rootPane.setLeft(share.getMypageMenuView().getRootPane(share));
		rootPane.setCenter(share.getMypageBorrowStatView().getRootPane(share));
		
		return rootPane;
	}
}
