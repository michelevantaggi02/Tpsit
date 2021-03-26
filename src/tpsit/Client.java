package tpsit;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {
	public static void main(String[] args) {
		try (Socket server = new Socket("kili.aspix.it", 7777);
				OutputStream os = server.getOutputStream();
				OutputStreamWriter osw = new OutputStreamWriter(os);
				InputStream is = server.getInputStream();
				InputStreamReader isr = new InputStreamReader(is)){
			
			osw.write("login#michele#michele\n");
			osw.flush();
			char[] buffer = new char[1000];
			int lung = isr.read(buffer);
			System.out.println(new String(buffer, 0, lung));
			server.close();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
