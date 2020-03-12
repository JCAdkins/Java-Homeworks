import java.io.FileNotFoundException;
import java.util.*;

public class StudentResponses {

    public static Formatter output;
    
    public static void main(String[] args) {
        
    openFile();
    addResponses();
    closeFile();
    
    }
    
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
    
    public static void closeFile()
    {
        if (output != null)
            output.close();
    }
}
