package it.edu.iisgubbio.chat;

import java.io.IOException;
import java.util.Arrays;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.layout.BorderPane;

public class CellaLista extends ListCell<String>{
	@FXML
	private Label ora;
	@FXML
	private Label utente;
	@FXML
	private Label testo;
	@FXML
	private BorderPane pannello;
	
	private String username;
	public CellaLista(String utente) {
		super();
		this.username = utente;
	}
	@Override
	protected void updateItem(String stringa, boolean vuoto) {
		super.updateItem(stringa, vuoto);
		FXMLLoader loader;
		if(vuoto || stringa == null || stringa.equals("")) {
			pannello = null;
		} else {
			String oggetti[] = stringa.split("#");
			
			if(oggetti[1].equals(username)) {
				loader = new FXMLLoader(this.getClass().getResource("messaggio_inviato.fxml"));
			}else {
				loader = new FXMLLoader(this.getClass().getResource("messaggio_ricevuto.fxml"));
			}
			loader.setController(this);
			try {
				loader.load();
			} catch (IOException e) {
				e.printStackTrace();
			}
			if(utente != null) {
				utente.setText(oggetti[1]);
			}
			testo.setText(oggetti[2]);
			ora.setText(oggetti[3]);
			
		}
		setGraphic(pannello);
	}
}
