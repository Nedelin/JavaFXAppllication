package javafx.properties;

import javafx.beans.binding.Bindings;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class JavaFXBinding {
	public static void main(String[] args) {

        IntegerProperty x = new SimpleIntegerProperty(3);
        IntegerProperty y = new SimpleIntegerProperty();

        y.bind(x.multiply(10));
        System.out.println("x: " + x.getValue());
        System.out.println("y: " + y.getValue() + "\n");

        x.setValue(9);
        System.out.println("x: " + x.getValue());
        System.out.println("y: " + y.getValue() + "\n");

        StringProperty prop = new SimpleStringProperty();
        StringProperty other = new SimpleStringProperty("String Binding");

        prop.bind(Bindings.concat("Test: ").concat(other));
        System.out.println(prop.get());
        other.set("ANOTHER String");
        
        System.out.println(prop.get());
        
	}
}
