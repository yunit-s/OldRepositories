package ChattingApp;

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
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

public class ChatClient extends Application {

	// Layout - top
	TextField ServerIpField;
	TextField ServerPortField;
	Button connBtn;
	Label nameLabel;
	TextField nameField;
	
	// Layout - bottom
	Label sendtoLabel;
	TextField sendtoField;
	TextArea chatArea;
	TextField inputTextField;
	
	// Communicate
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
					printMsg("Sys> IP:" + ServerIpField.getText() + ", Port:" + Port + " Server connect success!");

					// generate Thread - receive message from Server
					Thread RcvThread = new Thread(new Runnable() {
						
						@Override
						public void run() {
							while (true) {
								try {
									String msg = br.readLine();
									String[] msgToken = msg.split(":");
									String msgFrom = msgToken[0];
//									String msgTo = msgToken[1];
									String msgContents = msgToken[2];
									printMsg(msgFrom + "> " + msgContents);
									
								} catch (IOException e) {
									e.printStackTrace();
								}
							}
						}
					});
					RcvThread.setDaemon(true);
					RcvThread.start();
					
				} catch (UnknownHostException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		});
		
		nameLabel = new Label("My name");
		nameLabel.setPrefSize(100, 40);
//		nameLabel.setTextAlignment(TextAlignment.RIGHT);
		nameLabel.setAlignment(Pos.CENTER_RIGHT);
				
		nameField = new TextField("Lion");
		nameField.setPrefSize(100, 40);
		
		FlowPane topPane = new FlowPane();
		topPane.setPadding(new Insets(10));
		topPane.setHgap(10);
		topPane.getChildren().add(ServerIpField);
		topPane.getChildren().add(ServerPortField);
		topPane.getChildren().add(connBtn);
		topPane.getChildren().add(nameLabel);
		topPane.getChildren().add(nameField);
		rootPane.setTop(topPane);
		
		// Layout - center
		chatArea = new TextArea();
		rootPane.setCenter(chatArea);
		
		// Layout - bottom
		sendtoLabel = new Label("send to");
		sendtoLabel.setPrefSize(50, 40);
		sendtoLabel.setAlignment(Pos.CENTER_RIGHT);
		
		sendtoField = new TextField("Apeach");
		sendtoField.setPrefSize(100, 40);
		
		inputTextField = new TextField();
		inputTextField.setPrefSize(300, 40);
		inputTextField.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent arg0) {
				// send Message
//				printMsg("Sys> Enter in chatField");
				String msg = inputTextField.getText();
				pr.println(nameField.getText() + ":" + sendtoField.getText() + ":" + msg);
				pr.flush(); 
				inputTextField.clear();
			}
		});
		
		FlowPane bottomPane = new FlowPane();
		bottomPane.setPadding(new Insets(10));
		bottomPane.setHgap(10);
		bottomPane.getChildren().add(sendtoLabel);
		bottomPane.getChildren().add(sendtoField);
		bottomPane.getChildren().add(inputTextField);
		rootPane.setBottom(bottomPane);
		
		// generate Scene
		Scene scene = new Scene(rootPane);
		
		// window launch
		primaryStage.setScene(scene);
		primaryStage.setTitle("Multi Chatting - Client v.221216");
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch();
	}
}
