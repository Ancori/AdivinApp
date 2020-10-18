package application;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		final int numero = (int) (Math.random() * 99 + 1);
		System.out.println(numero);
		primaryStage.setTitle("AdivinApp");
		VBox root = new VBox();
		Scene escena = new Scene(root, 300, 250);
		Text text = new Text("Introduce un numero del 1 al 100");
		final TextField texto = new TextField();
		Button boton = new Button("Comprobar");
		Text resultado = new Text();
		boton.setOnAction(new EventHandler<ActionEvent>() {
			int errores = 0;
			int nmenor = 0;
			int nmayor = 100;

			public void handle(ActionEvent e) {
				int numerodado = Integer.parseInt(texto.getText());
				if (numero > numerodado) {
					nmenor = numerodado;
					Alert alert = new Alert(AlertType.WARNING);
					alert.setTitle("No has acertado");
					alert.setHeaderText("El numero es mayor");
					alert.setContentText("El numero esta entre " + nmenor + " y " + nmayor);
					alert.showAndWait();
					errores++;

				}
				if (numero < numerodado) {
					nmayor = numerodado;
					Alert alert = new Alert(AlertType.WARNING);
					alert.setTitle("No has acertado");
					alert.setHeaderText("El numero es menor");
					alert.setContentText("El numero esta entre " + nmenor + " y " + nmayor);
					alert.showAndWait();
					errores++;

				}
				if (numero == numerodado) {
					Alert alert = new Alert(AlertType.INFORMATION);
					alert.setTitle("Has acertado");
					alert.setHeaderText("El numero es correcto");
					alert.setContentText("Has necesitado: " + errores + " intentos");
					alert.showAndWait();
				}
			}
		});

		root.getChildren().add(text);
		root.setSpacing(5);
		root.setAlignment(Pos.CENTER);
		root.getChildren().add(texto);
		root.getChildren().add(boton);
		root.getChildren().add(resultado);
		primaryStage.setScene(escena);

		primaryStage.show();
	}

	public static void main(String[] args) {

		launch(args);
	}
}
