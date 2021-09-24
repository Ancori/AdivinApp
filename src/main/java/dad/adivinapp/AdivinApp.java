package dad.adivinapp;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class AdivinApp extends Application {
	TextField numero;
	Label etiqueta;
	Button comprobar;
	int intentos = 0;
	int numerosecreto =  (int) (Math.random()*100 + 1);

	public void start(Stage primaryStage) throws Exception {
		etiqueta = new Label();
		etiqueta.setText("Introduce un número del 1 al 100");
		etiqueta.setLayoutX(20);
		etiqueta.setLayoutY(20);

		numero = new TextField();
		numero.setPromptText("Introduce un numero");
		numero.setMaxWidth(150);

		comprobar = new Button();
		comprobar.setText("Comprobar");
		comprobar.setLayoutX(20);
		comprobar.setLayoutY(80);
		comprobar.setTooltip(new Tooltip("Cuando me pulses,compruebo si el numero es correcto"));
		comprobar.setOnAction(e -> onSaludar(e));
		comprobar.setDefaultButton(true);

		VBox rootpanel = new VBox();
		rootpanel.setSpacing(15);
		rootpanel.setAlignment(Pos.CENTER);
		rootpanel.getChildren().addAll(etiqueta, numero, comprobar);

		Scene scene = new Scene(rootpanel, 320, 200);

		primaryStage.setTitle("AdivinApp");
		primaryStage.setScene(scene);
		primaryStage.setResizable(false);
		primaryStage.show();

	}

	private void onSaludar(ActionEvent e) {

		if (AdivinApp.isNumeric(numero.getText()) && Integer.parseInt(numero.getText()) >= 0
				&& Integer.parseInt(numero.getText()) <= 100) {
			if (numerosecreto == Integer.parseInt(numero.getText())) {
				Alert alert = new Alert(AlertType.INFORMATION);
				alert.setTitle("AdivinApp");
				alert.setHeaderText("¡Has ganado!");
				alert.setContentText("Solo has necesitado " + intentos + " intentos.");
				intentos = 0;
				numerosecreto =  (int) (Math.random()*100 + 1);

				alert.showAndWait();
			} else {
				if (numerosecreto > Integer.parseInt(numero.getText())) {
					Alert alert = new Alert(AlertType.WARNING);
					alert.setTitle("AdivinApp");
					alert.setHeaderText("¡Has fallado!");
					alert.setContentText("El numero a acertar es mayor que " + Integer.parseInt(numero.getText()));
					alert.showAndWait();
				} else {
					Alert alert = new Alert(AlertType.WARNING);
					alert.setTitle("AdivinApp");
					alert.setHeaderText("¡Has fallado!");
					alert.setContentText("El numero a acertar es menor que " + Integer.parseInt(numero.getText()));
					alert.showAndWait();
				}
			}
			intentos++;
		} else {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("AdivinApp");
			alert.setHeaderText("Error");
			alert.setContentText("El número no es valido");

			alert.showAndWait();
		}

	}

	private static boolean isNumeric(String cadena) {
		try {
			Integer.parseInt(cadena);
			return true;
		} catch (NumberFormatException nfe) {
			return false;
		}
	}

	public static void main(String[] args) {
		launch(args);

	}

}
