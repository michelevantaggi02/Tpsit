package it.edu.iisgubbio.chat;

import java.time.LocalTime;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class TestChat extends Application {

	@FXML
	private TextField testo;
	@FXML
	private Button invia;
	@FXML
	private ListView<String> listaMessaggi;
	
	@Override
	public void start(Stage arg0) throws Exception {
		System.out.println(LocalTime.now());
		FXMLLoader loader = new FXMLLoader(this.getClass().getResource("Client.fxml"));
		loader.setController(this);
		Scene scena = new Scene(loader.load());
		listaMessaggi.setCellFactory(lista->new CellaLista("michele"));
		
		arg0.setScene(scena);
		arg0.show();
	}
	
	@FXML
	private void inviaMessaggio() {
		listaMessaggi.getItems().add("messaggio#michele#"+testo.getText()+"#00:00");
	}
	
	
	public static void main(String[] args) {
		launch(args);
	}

}
