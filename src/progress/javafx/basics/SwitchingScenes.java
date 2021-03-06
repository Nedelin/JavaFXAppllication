package progress.javafx.basics;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class SwitchingScenes extends Application{

	private Scene scene1, scene2;
	
	public static void main(String[] args) {
		launch(args);
	}
	@Override
	public void start(Stage primaryStage){
		Label label1 = new Label("Welcome to the first scene!");
		Button button1 = new Button("Go to scene 2");
		button1.setOnAction(e -> primaryStage.setScene(scene2));
		
		VBox layout1 = new VBox(20);
		layout1.getChildren().addAll(label1,button1);
		scene1 = new Scene(layout1, 400, 200);
		
		Button button2 = new Button("This scane is so ugly. Go back to scene one.");
		button2.setOnAction(e -> primaryStage.setScene(scene1));
		
		VBox layout2 = new VBox();
		layout2.getChildren().addAll(button2);
		scene2 = new Scene(layout2, 600, 300);
		
		primaryStage.setScene(scene1);
		primaryStage.setTitle("Switching scense");
		primaryStage.show();
		
	}
}
