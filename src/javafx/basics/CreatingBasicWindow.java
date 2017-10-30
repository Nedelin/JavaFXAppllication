package javafx.basics;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class CreatingBasicWindow extends Application {

	private Button okButton;

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		
		primaryStage.setTitle("Creating a Simple Window");
		okButton = new Button();
		okButton.setText("OK");

		StackPane layout = new StackPane();
		layout.getChildren().add(okButton);
		Scene scene = new Scene(layout, 600, 300);
		primaryStage.setScene(scene);
		primaryStage.show();
	}

}