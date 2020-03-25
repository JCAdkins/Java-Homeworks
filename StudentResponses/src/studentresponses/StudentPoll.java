import java.io.*;
import java.util.*;

public class StudentPoll 
{
   public static void main(String[] args)
   {
       // Create new file object text from numbers.txt
       File text = new File("numbers.txt");
       int[] frequency = new int[6]; // array of frequency counters
       
       // Create scanner reading input from text that keeps strack of responses
       // as long as they're within the allowable rating
       try
       {
       Scanner s = new Scanner(text);
 
       while (s.hasNextInt())
       {
          int response = s.nextInt();
          if (response < 1 | response > 5)
          {
              System.out.println("A response was outside the allowable rating.");
              System.out.println("Rating: " + response);
          }
          else
          {
              try
              {
                  ++frequency[response];
              }
              catch (ArrayIndexOutOfBoundsException e)
              {
                      System.out.println(e);    
              }
          }
           
           
       }
       }
       catch (FileNotFoundException e)
       {
           System.out.println(e);
       }   
      
       // Creating a formatter object out that writes the frequency array to the
       // file output.txt
       try {
           Formatter out = new Formatter("output.txt");
           out.format("%s%10s%n", "Rating", "Frequency");
           for (int rating = 1; rating < frequency.length; rating++)
           {
            out.format("%6d%10d%n", rating, frequency[rating]);
           }
           out.close();
       } catch (FileNotFoundException e) {
           System.out.println(e);
       }
       
       
       
   } 
} // end class StudentPoll


/**************************************************************************
 * (C) Copyright 1992-2014 by Deitel & Associates, Inc. and               *
 * Pearson Education, Inc. All Rights Reserved.                           *
 *                                                                        *
 * DISCLAIMER: The authors and publisher of this book have used their     *
 * best efforts in preparing the book. These efforts include the          *
 * development, research, and testing of the theories and programs        *
 * to determine their effectiveness. The authors and publisher make       *
 * no warranty of any kind, expressed or implied, with regard to these    *
 * programs or to the documentation contained in these books. The authors *
 * and publisher shall not be liable in any event for incidental or       *
 * consequential damages in connection with, or arising out of, the       *
 * furnishing, performance, or use of these programs.                     *
 *************************************************************************/
