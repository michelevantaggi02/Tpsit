package it.edu.iisgubbio.chat;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.Vector;

import javafx.application.Platform;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;


public class Ascoltatore extends Thread {
	public boolean run = true;
	Socket ingresso;
	ListView<String> contenitoreMessaggi;
	Label listaUtenti;
	public Ascoltatore(Socket ingresso, ListView<String> contenitoreMessaggi, Label listaUtenti) {
		this.ingresso = ingresso;
		this.contenitoreMessaggi = contenitoreMessaggi;
		this.listaUtenti = listaUtenti;
	}
	
	public void run() {
		while(run) {
			try {
				InputStream is = ingresso.getInputStream();
				InputStreamReader isr = new InputStreamReader(is, "UTF-8");
				BufferedReader br = new BufferedReader(isr);
				String s;
				while((s = br.readLine())!=null) {
					final String messaggio = s;
					System.out.println("RICEVUTO MESSAGGIO: "+ s );
					Platform.runLater(new Runnable() {
						@Override
						public void run() {
							// TODO Auto-generated method stub
							if(messaggio.startsWith("elencoUtenti")) {
								listaUtenti.setText(messaggio.replaceAll("#", " ").replace("elencoUtenti", ""));
							} else {
								contenitoreMessaggi.getItems().add(messaggio);
							}
						}
					});
						
				}
				
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
}
