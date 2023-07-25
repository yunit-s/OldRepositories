package ChattingApp;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class ChatServer extends Application {

	// Layout components
	TextArea serverLogArea;
	Button startServerBtn;
	Button stopServerBtn;
	
	// Server
	ServerSocket serverSocket;

	// Methods
	public void printMsg(String msg) {
		Platform.runLater(new Runnable() {
			
			@Override
			public void run() {
				serverLogArea.appendText(msg + "\n");
			}
		});
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		
		// Layout Setting
		BorderPane rootPane = new BorderPane();
		rootPane.setPrefSize(700, 500);
		
		// Layout - top
		FlowPane topPane = new FlowPane();
		topPane.setPadding(new Insets(10));
		
		startServerBtn = new Button("Start Server");
		startServerBtn.setPrefSize(100, 40);
		startServerBtn.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent arg0) {
				
				// generate Shared Instance
				SharedInfo sharedInst = new SharedInfo(serverLogArea);
				
				// generate Server Socket
				try {
					int PortNum = 7777;
					serverSocket = new ServerSocket(PortNum);
					printMsg("Sys> Start Server. (Port:" + PortNum + ")");
				} catch (IOException e) {
					e.printStackTrace();
				}
				
				// generate Thread - accept Client's request
				Thread acpThread = new Thread(new Runnable() {
					
					@Override
					public void run() {
						while (true) {
							try {
								// wait for Client access
								Socket socket = serverSocket.accept();
								
//								// generate Thread - communicate with Client
								Runnable tmpR = new CommuThread(socket, sharedInst);
								Thread tmpT = new Thread(tmpR);
//								tmpT.setDaemon(true);
								tmpT.start();
								
							} catch (IOException e) {
								e.printStackTrace();
							}
							
						}
					}
				});
				acpThread.start();
				
			}
		});
		
		stopServerBtn = new Button("Stop Server");
		stopServerBtn.setPrefSize(150, 40);
		stopServerBtn.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent arg0) {
				printMsg("Sys> Stop Server.");
			}
		});
		

		topPane.getChildren().add(startServerBtn);
		rootPane.setTop(topPane);
		
		// Layout - center
		serverLogArea = new TextArea();
		rootPane.setCenter(serverLogArea);
		
		// generate Scene
		Scene scene = new Scene(rootPane);
		
		// window launch
		primaryStage.setScene(scene);
		primaryStage.setTitle("Multi Chatting - Server v.221216");
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch();
	}
}
