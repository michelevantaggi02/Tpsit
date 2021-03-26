package it.edu.iisgubbio.chat;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.UnknownHostException;

import javafx.application.Application;
import javafx.stage.Stage;

public class Principale extends Application {

	@Override
	public void start(Stage stage) throws Exception {
		Login login = new Login();
		boolean risposta = false;
		Socket server = null;
		while(!risposta) {
			login.showAndWait();
			System.out.println(login.getNome());
			System.out.println(login.getPassword());
			
			try {
					server = new Socket("kili.aspix.it", 7777);
					OutputStream os = server.getOutputStream();
					OutputStreamWriter osw = new OutputStreamWriter(os);
					InputStream is = server.getInputStream();
					InputStreamReader isr = new InputStreamReader(is);
				osw.write(login.getRichiestaLogin());
				osw.flush();
				char[] buffer = new char[100];
				int lung = isr.read(buffer);
				String stringa = new String(buffer, 0, lung);
				System.out.println(stringa);
				risposta = stringa.equals("rispostaLogin#ok\n");
				if(!risposta)
					server.close();
			} catch (UnknownHostException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		if(risposta) {
			FinestraChat chat = new FinestraChat(login.getNome(), server);
			chat.showAndWait();
		}
		
	}

	public static void main(String[] args) {
		launch(args);

	}

}
