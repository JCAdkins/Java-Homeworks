import java.io.FileNotFoundException;
import java.util.*;

public class StudentResponses {

    public static Formatter output;
    
    public static void main(String[] args) {
    openFile();
    addResponses();
    closeFile();
    
    }
    
    // Method creates a formatter object output that will write to the file
    // numbers.txt
    public static void openFile()
    {
        try 
        {
            output = new Formatter("numbers.txt");
        }
        catch (SecurityException | FileNotFoundException e)
        {
            System.err.println(e);
            System.exit(1);
        }
    }
    
    // This method allows user to input 'ratings' to a survey and writes it to 
    // the numbers.txt file until EOF indicator is input.
    public static void addResponses()
    {
        Scanner s = new Scanner(System.in);
        System.out.println("Please enter your survey response (1-5).");
        System.out.println("Enter End Of File indicator to exit.");
        
        while (s.hasNext())
        {
            try
            {
                output.format("%d%n", s.nextInt());
            }
            catch (FormatterClosedException | NoSuchElementException e)
            {
                System.out.println(e);
            }
            
        } 
    }
    
    // Method closes the file
    public static void closeFile()
    {
        if (output != null)
            output.close();
    }
}
