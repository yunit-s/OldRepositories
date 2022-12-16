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
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class ChatClient extends Application {

	// Layout components - top
	Label serverIpLabel;
	TextField serverIpField;
	Label serverPortLabel;
	TextField serverPortField;
	Button connBtn;
	Label nameLabel;
	TextField nameField;
	
	// Layout components - center
	TextArea chatArea;
	
	// Layout components - bottom
	Label sendtoLabel;
	TextField sendtoField;
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
		serverIpLabel = new Label("Server IP:");
		serverIpLabel.setPrefSize(60, 40);
		serverIpLabel.setAlignment(Pos.CENTER_RIGHT);
		
		String ServerIp = "127.0.0.1";
		serverIpField = new TextField(ServerIp);
		serverIpField.setPrefSize(80, 40);
		
		serverPortLabel = new Label("Server Port:");
		serverPortLabel.setPrefSize(80, 40);
		serverPortLabel.setAlignment(Pos.CENTER_RIGHT);
		
		String ServerPort = "7777";
		serverPortField = new TextField(ServerPort);
		serverPortField.setPrefSize(60, 40);
		
		connBtn = new Button("Connet Server");
		connBtn.setPrefSize(100, 40);
		connBtn.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent arg0) {
				try {
					// connect Server
					int Port = 7777;
					socket = new Socket(serverIpField.getText(), Port);
					pr = new PrintWriter(socket.getOutputStream());
					br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
					pr.println(nameField.getText());
					pr.flush();
					nameField.setDisable(true);
					printMsg("Sys> Server connect success! (IP:" + serverIpField.getText() + ", Port:" + Port + ")");

					// generate Thread - receive message from Server
					Thread RcvThread = new Thread(new Runnable() {
						
						@Override
						public void run() {
							while (true) {
								try {
									String msg = br.readLine();
									String[] msgToken = msg.split(":");
									String msgFrom = msgToken[0];
									String msgContents;
									if (msgToken.length != 2) {
										msgContents = "";
									} else {
										msgContents = msgToken[1];
									}
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
		topPane.getChildren().add(serverIpLabel);
		topPane.getChildren().add(serverIpField);
		topPane.getChildren().add(serverPortLabel);
		topPane.getChildren().add(serverPortField);
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
				String msg = inputTextField.getText();
				pr.println(sendtoField.getText() + ":" + msg);
				pr.flush();
				inputTextField.clear();
				printMsg("Me> " + msg);
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
