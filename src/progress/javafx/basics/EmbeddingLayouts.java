package progress.javafx.basics;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class EmbeddingLayouts extends Application{

	private Stage window;
	public static void main(String[] args) {
		launch(args);

	}
	@Override
	public void start(Stage primaryStage) throws Exception {
		window = primaryStage;
		window.setTitle("Embedding Layouts");
		HBox topMenu = new HBox(20);
		Button fileButton = new Button("File");
		Button editButton = new Button("Edit");
		Button viewButton = new Button("View");
		topMenu.getChildren().addAll(fileButton, editButton , viewButton);
		
		VBox leftMenu = new VBox(20);
		Button openButton = new Button ("Open");
		Button closeButton = new Button ("CLose");
		Button deleteButton = new Button ("Delete");
		leftMenu.getChildren().addAll(openButton, closeButton, deleteButton);
		
		BorderPane borderPane = new BorderPane();
		Insets insets = new Insets(10);
		borderPane.setTop(topMenu);
		borderPane.setMargin(topMenu, insets);
		borderPane.setLeft(leftMenu);
		borderPane.setMargin(leftMenu, insets);
		
		
		Scene scene = new Scene(borderPane,600,400);
		window.setScene(scene);
		window.show();
	}

}
