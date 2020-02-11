import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class WebGet {

	public static void main(String[] args) throws IOException 
	{
		
		// Get command-line arguments
		
		String host;
		String resource;
		
		if (args.length == 2)
		{
			host = args[0];
			resource = args[1];
		}
		else
		{
			System.out.println("Getting / from horstmann.com");
			host = "horstmann.com";
			resource = "/";
		}
		
		// Open Socket
		
		final int HTTP_PORT = 80;
		try (Socket s = new Socket(host, HTTP_PORT))
		{
			// Get streams
			
			InputStream inStream = s.getInputStream();
			OutputStream outStream = s.getOutputStream();
			
			// Turn streams into scanners and writers
			
			Scanner in = new Scanner(inStream);
			PrintWriter out = new PrintWriter(outStream);
			
			// Send command
			
			String command = "GET " + resource + " HTTP/1.1\n" 
					+ "Host: " + host + "\n\n";
			out.print(command);
			out.flush();
			
			// Read servers response
			
			while (in.hasNextLine())
			{
				String input = in.nextLine();
				System.out.println(input);
			}
			
			in.close();
		}
		
		// The try-with-resources statement closes the socket
		
		
	}

}
