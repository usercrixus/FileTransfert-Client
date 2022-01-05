package supra.client.command;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public abstract class Command {
	
	public String send(String args) {
		String response = "";
		try {
			Socket client = new Socket("127.0.0.1", 2100);
			PrintWriter pw = new PrintWriter(client.getOutputStream());
			pw.println(args);
			pw.flush();
			
			BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
			String responseBuffer = in.readLine();
			response = responseBuffer;
			client.close();

		} catch (IOException e) {
			System.out.println("Impossible to connect to the server");
		}
		
		return response;
	}
	
	public String requestFile(String args, String fileName) {
		String response = "";
		try {
			Socket client = new Socket("127.0.0.1", 2200);
			PrintWriter pw = new PrintWriter(client.getOutputStream());
			pw.println(args);
			pw.flush();

			FileOutputStream out = new FileOutputStream("./"+fileName);
			InputStream in = client.getInputStream();
			int count;
			while((count=in.read()) > 0){
				  out.write(count);
			}
			
			out.close();
			client.close();
			
			response = "Well Downloaded";
		} catch (IOException e) {
			System.out.println("Impossible to connect to the server");
			e.printStackTrace();
		}
		
		return response;
	}

	public abstract String badUsage();
	
}
