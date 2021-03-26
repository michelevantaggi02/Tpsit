package it.edu.iisgubbio.chat;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class FinestraChat extends Stage {
	@FXML
	private ListView<String> listaMessaggi = new ListView<>();
	@FXML
	private Label listaUtenti = new Label();
	@FXML
	private TextField testo = new TextField();
	@FXML
	private Button invia = new Button("Invia");
	
	private String username;
	private Socket server;

	
	public FinestraChat(String username, Socket server) throws IOException {
		super();
		this.username = username;
		this.server = server;
		/*BorderPane bordo = new BorderPane();
		bordo.setCenter(listaMessaggi);
		bordo.setTop(listaUtenti);
		
		BorderPane testoInvia = new BorderPane();
		testoInvia.setCenter(testo);
		testoInvia.setRight(invia);
		bordo.setBottom(testoInvia);*/
		FXMLLoader loader = new FXMLLoader(this.getClass().getResource("Client.fxml"));
		loader.setController(this);
		Parent root = loader.load();
		Scene scena = new Scene(root);//new Scene(bordo);
		
		setScene(scena);

		listaMessaggi.setCellFactory(lista->new CellaLista(username));
		
		//String lista = comunica("elencoUtenti\n").replaceAll("#", " ").replace("elencoUtenti", "");
		//listaUtenti.setText(lista);
		
		Ascoltatore ascoltatore = new Ascoltatore(server, listaMessaggi, listaUtenti);
		ascoltatore.start();
		
		comunica("elencoUtenti\n");
		
		setTitle("Chat di "+username);
		setOnCloseRequest(e -> {
			try {
				ascoltatore.run = false;
				server.close();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});
	}
	
	@FXML
	private void inviaMessaggio() {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm");
		LocalDateTime now = LocalDateTime.now();
		comunica("messaggio#" + username + "#" + testo.getText() + "#" + dtf.format(now) + "\n");
		testo.setText("");
		//listaMessaggi.getItems().add(risposta);
	}
	
	@FXML
	private void gestisciTasto(KeyEvent e) {
		if (e.getCode().equals(KeyCode.ENTER))
			inviaMessaggio();
	}
	
	private void comunica(String richiesta) {
		//String ritorno = null;
		try {
			OutputStream os = server.getOutputStream();
			OutputStreamWriter osw = new OutputStreamWriter(os, "UTF-8");
			//InputStream is = server.getInputStream();
			//InputStreamReader isr = new InputStreamReader(is);

			osw.write(richiesta);
			osw.flush();
			/*char[] buffer = new char[1000];
			int lung = isr.read(buffer);
			ritorno = new String(buffer, 0, lung);
			System.out.println(ritorno);*/

		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		//return ritorno;
	}
}
