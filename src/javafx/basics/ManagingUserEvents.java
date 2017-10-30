package javafx.basics;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ManagingUserEvents extends Application {

	private Button okButton;
	private Button cancelButton;

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) {
		primaryStage.setTitle("Managing User Events");
		okButton = new Button();
		okButton.setText("OK");
		okButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				System.out.println("OK Button Clicked");
			}
		});
		cancelButton = new Button();
		cancelButton.setText("Cancel");
		cancelButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				System.out.println("Cancel Button Clicked");
			}
		});
		Label windowLabel = new Label("How to manage user events");
		VBox layout = new VBox(15);
		layout.getChildren().addAll(windowLabel, okButton, cancelButton);
		Scene scene = new Scene(layout, 600, 250);
		primaryStage.setScene(scene);
		primaryStage.show();
	}
}