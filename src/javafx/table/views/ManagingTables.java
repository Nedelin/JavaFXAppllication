package javafx.table.views;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ManagingTables extends Application {

	private Stage window;
	private TableView<Product> table;
	private TextField nameInput, priceInput, quantityInput;

	public static void main(String[] args) {
		launch(args);
	}

	@SuppressWarnings("unchecked")
	@Override
	public void start(Stage primaryStage) throws Exception {
		window = primaryStage;
		window.setTitle("Managing Tables");

		// Name column
		TableColumn<Product, String> nameColumn = new TableColumn<>("Name");
		nameColumn.setMinWidth(200);
		nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));

		// Price column
		TableColumn<Product, Double> priceColumn = new TableColumn<>("Price");
		priceColumn.setMinWidth(100);
		priceColumn.setCellValueFactory(new PropertyValueFactory<>("price"));

		// Quantity column
		TableColumn<Product, Integer> quantityColumn = new TableColumn<>("Quantity");
		quantityColumn.setMinWidth(100);
		quantityColumn.setCellValueFactory(new PropertyValueFactory<>("quantity"));

		// Name input
		nameInput = new TextField();
		nameInput.setPromptText("Name");
		nameInput.setMinWidth(100);

		// Price input
		priceInput = new TextField();
		priceInput.setPromptText("Price");

		// Quantity input
		quantityInput = new TextField();
		quantityInput.setPromptText("Quantity");

		// Button
		Button addButton = new Button("Add");
		addButton.setOnAction(e -> addButtonClicked());
		Button deleteButton = new Button("Delete");
		deleteButton.setOnAction(e -> deleteButtonClicked());

		HBox hBox = new HBox();
		hBox.setPadding(new Insets(10, 10, 10, 10));
		hBox.setSpacing(10);
		hBox.getChildren().addAll(nameInput, priceInput, quantityInput, addButton, deleteButton);

		table = new TableView<>();
		table.setItems(getProduct());
		table.getColumns().addAll(nameColumn, priceColumn, quantityColumn);

		VBox vBox = new VBox();
		vBox.getChildren().addAll(table, hBox);

		Scene scene = new Scene(vBox);
		window.setScene(scene);
		window.show();
	}

	// Add button clicked
	public void addButtonClicked() {
		Product product = new Product();
		if (nameInput.getText().length() > 0 && priceInput.getText().length() > 0
				&& quantityInput.getText().length() > 0) {
			product.setName(nameInput.getText());
			product.setPrice(Double.parseDouble(priceInput.getText()));
			product.setQuantity(Integer.parseInt(quantityInput.getText()));
			table.getItems().add(product);
			nameInput.clear();
			priceInput.clear();
			quantityInput.clear();
		}
	}

	// Delete button clicked
	public void deleteButtonClicked() {
		ObservableList<Product> productSelected, allProducts;
		allProducts = table.getItems();
		productSelected = table.getSelectionModel().getSelectedItems();

		for (Product selectedProduct : productSelected) {
			allProducts.remove(selectedProduct);
		}
	}

	// Get all of the products
	public ObservableList<Product> getProduct() {
		ObservableList<Product> products = FXCollections.observableArrayList();
		products.add(new Product("Laptop", 859.00, 20));
		products.add(new Product("Tablet", 600.49, 198));
		products.add(new Product("TV", 200.00, 74));
		products.add(new Product("GSM", 100.99, 12));
		products.add(new Product("Speakers", 50.49, 856));
		return products;
	}

}