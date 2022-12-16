package exam04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

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

public class Exam04_ChatClientYH extends Application {

	TextField ServerIpField;
	TextField ServerPortField;
	Button connBtn;
	TextArea chatArea;
	TextField inputTextField;
	
	Socket socket;
	PrintWriter pr;
	BufferedReader br;
	
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
		
		// Layout setting
		BorderPane rootPane = new BorderPane();
		rootPane.setPrefSize(700, 500);
		
		// Layout - top
		String ServerIp = "127.0.0.1";
		ServerIpField = new TextField(ServerIp);
		ServerIpField.setPrefSize(100, 40);
		
		String ServerPort = "7777";
		ServerPortField = new TextField(ServerPort);
		ServerPortField.setPrefSize(50, 40);
		
		connBtn = new Button("Connet Server");
		connBtn.setPrefSize(150, 40);
		connBtn.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent arg0) {
				try {
					// connect Server
					int Port = 7777;
					socket = new Socket(ServerIpField.getText(), Port);
					pr = new PrintWriter(socket.getOutputStream());
					br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
					printMsg("Sys> Server connect success!");

					// generate Thread - receive message from Server
					Thread RcvThread = new Thread(new Runnable() {
						
						@Override
						public void run() {
							while (true) {
								try {
									printMsg(br.readLine());
								} catch (IOException e) {
									e.printStackTrace();
								}
							}
						}
					});
					RcvThread.start();
					
				} catch (UnknownHostException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		});
		
		FlowPane topPane = new FlowPane();
		topPane.setPadding(new Insets(10));
		topPane.setHgap(10);
		topPane.getChildren().add(ServerIpField);
		topPane.getChildren().add(ServerPortField);
		topPane.getChildren().add(connBtn);
		rootPane.setTop(topPane);
		
		// Layout - center
		chatArea = new TextArea();
		rootPane.setCenter(chatArea);
		
		// Layout - bottom
		inputTextField = new TextField();
		inputTextField.setPrefSize(200, 40);
		inputTextField.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent arg0) {
				// send Message
//				printMsg("Sys> Enter in chatField");
				String msg = inputTextField.getText();
				pr.println(msg);
				pr.flush(); 
				inputTextField.clear();
			}
		});
		
		FlowPane bottomPane = new FlowPane();
		bottomPane.setPadding(new Insets(10));
		bottomPane.getChildren().add(inputTextField);
		rootPane.setBottom(bottomPane);
		
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
