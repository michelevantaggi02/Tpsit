package tpsit;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class Login {

	public static void main(String[] args) {
		try(Socket server = new Socket("kili.aspix.it", 7777);
			InputStreamReader isr = new InputStreamReader(server.getInputStream());
			OutputStreamWriter osw = new OutputStreamWriter(server.getOutputStream());){
			
			osw.write("michele#nonvidolapassword\n");
			osw.flush();
			char[] buffer = new char[10];
			int len = isr.read(buffer);
			System.out.println(new String(buffer, 0, len));
			
			
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
