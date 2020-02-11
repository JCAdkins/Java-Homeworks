import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Scanner;

public class Reverses 
{
		// Constructor 
		Reverses() {}
			 
			 
		// Initiate String textInFile
		private String textInFile = "";
			
			 
		// Where all the stuff happens
		public String run() {		
				 
			
		// Put everything in a try clause in case something goes horribly wrong
		try {
				
				// Get the name of the file
				Scanner scan = new Scanner(System.in);
				System.out.println("Input name of file: ");
				String file = scan.nextLine();
				
				
				// Put name of file in a File object; This is just so we can get the path of the file
				File newFile  = new File(file);
				
				
				// Get the file path of the file
				file = newFile.getAbsolutePath();
				
				
				// Read from the file... this method also reverses the text and eliminates
				// the chars we don't want at the same time
				file = ReadText(file);
				
				
				// Close scan
				scan.close();
				
				}catch(Exception e)
					{
					System.out.println(e);
					}
			
		return textInFile;	
}
			
			 
			 //---------------------------------//
			 // Method to read the text in file //
			 //---------------------------------//
			 public String ReadText(String methodFile) 
			 {
				
				 	// Another try catch clause
				 	try 
				 	{
				 		
				 		// Creates a BufferedReader that is 
				 		String file = methodFile;
				 		BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
				 			String st;
				 			
				 			
				 			// Loop that adds the line from the text that we read to String textInFile
				 			// it calls after reading a line it invokes the method ReverseString()
				 			// which reverses the text before it is added to the final String textInFile
				 			while((st = bufferedReader.readLine()) != null) 
				 			{
				 				st = ReverseString(removeChars(st));
				 				textInFile = textInFile + st + "\n";
				 			}

				
				    // Close bufferedReader
				 	bufferedReader.close();
				
				 	}catch(Exception e) 
				 	{
				 		System.out.println(e);
				 	}
			
				return textInFile;
			 }
			
			
			 //------------------------------------------------------------//
			 // Method that reverses the text of a single line of the text //
			 //------------------------------------------------------------//
			 public String ReverseString(String st) {
				
				 // Convert the string to a byte array
				byte[] strAsByteArray = st.getBytes();
				
				// Create another byte array 'result' with the same length as first byte array,
				// this byte array will hold the reversed text
				byte[] result = new byte[strAsByteArray.length];
				
				
				// Loop through the length of the byte arrays and insert the last character of 
				// strAsByteArray into the first slot of byte array 'result'
				for (int a = 0; a < strAsByteArray.length; a++) {
					result[a] = strAsByteArray[strAsByteArray.length - a - 1];
					
				}
				
				return (new String(result));
			}
			 
			 
			 //---------------------------------------------------------------------//
			 // Method that removes or 'cleans' the String from chars we don't want //
			 //---------------------------------------------------------------------//
			 public String removeChars(String str)
			 {
				 String retString = "";
				 
				 for (int i = 0; i < str.length(); i++)
				 {
					 char c = str.charAt(i);
					 if ((Character.isLetter(c)) || Character.isDigit(c) || (c == ' ') || (c == ')')|| (c =='(') || (c == ':') || (c == ',') || (c == ';') || (c == '.'))
					 {
						 retString = retString + c;
					 }
				 }
				 
				 
				 
				 return retString;
			 }
			
			 
}
			 

