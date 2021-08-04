package simple_tcp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {
	
	public Client () throws Exception {
		Socket socket = new Socket("192.168.1.4", 2020);
		System.out.println("Succesfull connection to the server");
		
		// I/O streams
		BufferedReader in_socket = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		PrintWriter out_socket = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()), true);
		
		String message = in_socket.readLine();
		System.out.println("Server says: " + message);
		out_socket.println("Thanks! ");
		
		socket.close();
		System.out.println("Socket closed on Client");
	}
	
	public static void main(String[] args) {
		try {
			new Client();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
