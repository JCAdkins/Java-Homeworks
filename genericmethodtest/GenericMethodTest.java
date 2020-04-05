package genericmethodtest;

public class GenericMethodTest 
{
   public static void main(String[] args) throws InvalidSubscriptException
   {
      // create arrays of Integer, Double and Character
      Integer[] integerArray = {1, 2, 3, 4, 5, 6};
      Double[] doubleArray = {1.1, 2.2, 3.3, 4.4, 5.5, 6.6, 7.7};
      Character[] characterArray = {'H', 'E', 'L', 'L', 'O'};
      
      // Non-overloaded method
      System.out.printf("Array integerArray contains:%n");
      printArray(integerArray); // pass an Integer array 
      System.out.printf("%nArray doubleArray contains:%n");
      printArray(doubleArray); // pass a Double array
      System.out.printf("%nArray characterArray contains:%n");
      printArray(characterArray); // pass a Character array
      
      // Overloaded method call
       System.out.printf("%nArray integerArray[1:4] contains:%n");
      printArray(integerArray, 1, 4); // pass an Integer array 
      System.out.printf("%nArray doubleArray[2:5] contains:%n");
      printArray(doubleArray, 2, 5); // pass a Double array
      System.out.printf("%nArray characterArray[3:4] contains:%n");
      printArray(characterArray, 3, 4); // pass a Character array
      
      // Overloaded call with lowSubscript = highSubscript
      System.out.printf("%nArray doubleArray[2:2] contains:%n");
      printArray(doubleArray, 2, 2); // pass a Double array
   } 

   // generic method printArray
   public static <T> void printArray(T[] inputArray)
   {
      // display array elements
      for (T element : inputArray)
         System.out.printf("%s ", element);

      System.out.println();
   }
   
   // Overloaded generic method printArray
   public static <T> void printArray(T[] inputArray, int lowSubscript, int highSubscript) throws InvalidSubscriptException
   {
       if (lowSubscript > highSubscript) // Display error if lowSubscript > highSubscript
       {
           System.out.println("Error: lowSubscript greater than highSubscript.");
           return;
       }
       
       // Print out elements in array as long as Subscripts are in the array range
       // If subscripts out of range throw InvalidSubscriptException
       try
       {
           for (int a = lowSubscript; a <= highSubscript; a++)
           {
               System.out.printf("%s ", inputArray[a]);
           }
           System.out.println();
       }
       catch (ArrayIndexOutOfBoundsException e)
       {
           throw new InvalidSubscriptException(e.getMessage());
       }
   }
} // end class GenericMethodTest