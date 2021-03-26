package tpsit;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

public class LoginServer {

	public static void main(String[] args) {
		try(ServerSocket server = new ServerSocket(7777);
				Socket client = server.accept();
				InputStreamReader isr = new InputStreamReader(client.getInputStream());
				OutputStreamWriter osw = new OutputStreamWriter(client.getOutputStream());){
				char[] buf = new char[20];
				isr.read(buf);
				osw.write("ok");
				osw.flush();
				
				
			} catch (UnknownHostException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}

	}

}
