package it.edu.iisgubbio.chat;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class Login extends Stage {
	@FXML
	private TextField tNomeUtente;
	@FXML
	private PasswordField tPassword;
	@FXML
	Button invia;
	public Login() throws IOException{

		FXMLLoader loader = new FXMLLoader(this.getClass().getResource("Login.fxml"));
		loader.setController(this);
		Parent parent = loader.load();
		
		Scene scena = new Scene(parent);
		setScene(scena);
		setResizable(false);
		setTitle("Login");
	}
	

	public String getRichiestaLogin() {
		return "login#"+getNome()+"#"+getPassword()+"\n";
	}
	
	public String getNome() {
		return tNomeUtente.getText();
	}
	
	public String getPassword() {
		return tPassword.getText();
	}
	
	@FXML
	private void inviaLogin() {
		close();
	}

}
