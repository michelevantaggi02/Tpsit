package tpsit;

import java.io.Serializable;

public class Messaggio implements Serializable{
	public Messaggio(String mittente, String messaggio) {
		this.mittente = mittente;
		this.messaggio = messaggio;
	}

	private String mittente;
	public String getMittente() {
		return mittente;
	}

	public void setMittente(String mittente) {
		this.mittente = mittente;
	}

	public String getMessaggio() {
		return messaggio;
	}

	public void setMessaggio(String messaggio) {
		this.messaggio = messaggio;
	}

	private String messaggio;
	
	@Override
	public String toString() {
		return mittente+": "+messaggio;
	}
}
