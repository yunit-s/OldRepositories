package ChattingApp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
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
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class ChatServer extends Application {

	// Layout components
	TextArea chatArea;
//	TextField ipTxtField;
	Button startServerBtn;
	Button stopServerBtn;
	
	// Server
	ServerSocket serverSocket;

	// Methods
	void printMsg(String msg) {
		Platform.runLater(new Runnable() {
			
			@Override
			public void run() {
				chatArea.appendText(msg + "\n");
			}
		});
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		
		// Layout Setting
		BorderPane rootPane = new BorderPane();
		rootPane.setPrefSize(700, 500);
		
//		ipTxtField = new TextField();
		
		// Layout - top
		FlowPane topPane = new FlowPane();
		topPane.setPadding(new Insets(10));
		
		startServerBtn = new Button("Start Server");
		startServerBtn.setPrefSize(150, 40);
		startServerBtn.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent arg0) {
				printMsg("Sys> Start Server.");
				// generate Server Socket
				try {
					int PortNum = 7777;
					serverSocket = new ServerSocket(PortNum);
				} catch (IOException e) {
					e.printStackTrace();
				}
				
				// generate Thread - accept Client's request
				Thread acpThread = new Thread(new Runnable() {
					
					@Override
					public void run() {
						// accept해서 쓰레드 만들기 무한반복
						while (true) {
							try {
								// wait for Client access
								Socket socket = serverSocket.accept();
								printMsg("Sys> New Client access!");
								
								// generate Thread - communicate with Client
								Thread tmpThread = new Thread(new Runnable() {

									@Override
									public void run() {
										try {
											// communicate with Client
											PrintWriter pr = new PrintWriter(socket.getOutputStream());
											BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
											
											while (true) {
												String msg = br.readLine();
												printMsg(msg);
												
												// echo
												pr.println(msg);
												pr.flush();
											}
											
										} catch (IOException e) {
											e.printStackTrace();
										}
										
									}
								});
								tmpThread.start();
								
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
		chatArea = new TextArea();
		rootPane.setCenter(chatArea);
		
		
		// generate Scene
		Scene scene = new Scene(rootPane);
		
		// window launch
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch();
	}
}
