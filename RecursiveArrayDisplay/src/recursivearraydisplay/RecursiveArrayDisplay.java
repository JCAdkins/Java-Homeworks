package recursivearraydisplay;

import java.util.Random;

public class RecursiveArrayDisplay {

    public static void main(String[] args) {
        
        // Create integer arrays to be used at tests
        int[] oddNumbers = {1,3,5,7,9,11,13,15,17,19};
        int[] evenNumbers = {2,4,6,8,10,12,14,16,18,20};
        
        // Creating a random integer array to test
        Random rand = new Random();
        int[] randomArray = new int[rand.nextInt(20)];
        for(int a = 0; a < randomArray.length; a++)
        {
            randomArray[a] = rand.nextInt(20);
        }

    // Display the output from our call to the printArray method
    System.out.println(printArray("", oddNumbers, 0, oddNumbers.length));
    System.out.println(printArray("", evenNumbers, 0, evenNumbers.length));
    System.out.println(printArray("", randomArray, 0, randomArray.length));
        
    }
    
    /* Method printArray: output = start with a blank input string so you only
                                   return a string with data from the int[]
                          array = the array of integers you would like to recurse
                                  through
                          startPlace = where you would like to start the recursion 
                                       process
                          endPlace = this is how far through the array of integers
                                   you would like to recurse
    */

    public static String printArray(String output, int[] array, int startPlace, int endPlace)
    {
    
        if (endPlace == startPlace)
        {
            return output;
        }
       output = output + Integer.toString(array[startPlace]) + " ";
       return printArray(output, array, startPlace + 1, endPlace);
            
    }
    
}
