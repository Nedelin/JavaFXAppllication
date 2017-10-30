package javafx.webviews;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

public class WebViewExample extends Application {
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		primaryStage.setTitle("Web View Example");
		WebView browser = new WebView();
		WebEngine webEngine = browser.getEngine();
		webEngine.load("https://e-uslugi.mvr.bg/ESP.Web.Portal/KATActs/ActService/Index");
		
		StackPane layout = new StackPane();
		layout.getChildren().add(browser);
		Scene scene = new Scene(layout, 800, 500);
		primaryStage.setScene(scene);
		primaryStage.show();
		
	}

}
