package javafx.media;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaView;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

public class EmbeddedMediaPlayer extends Application {

	// private static final String MEDIA_URL =
	// "http://download.oracle.com/otndocs/products/javafx/oow2010-2.flv";

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) {
		primaryStage.setTitle("Embedded Media Player");
		StackPane root = new StackPane();
		Scene scene = new Scene(root, 540, 210);

		// create media player
		Media media = new Media("file:/C:/Users/ffree/Downloads/Jump.mp4");
		MediaPlayer mediaPlayer = new MediaPlayer(media);
		mediaPlayer.setAutoPlay(true);

		// create mediaView and add media player to the viewer
		MediaView mediaView = new MediaView(mediaPlayer);
		root.getChildren().add(mediaView);

		primaryStage.setScene(scene);
		primaryStage.show();
	}
}
