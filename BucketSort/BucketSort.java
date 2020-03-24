import java.security.SecureRandom;
import java.util.Arrays;

public class BucketSort {

    public static void Sort(int data[], int basePosition){
        int rowPosition;
        int colPosition = 0;
        int[][] twoDimArray = new int[10][data.length]; 
       
        // TEST PORTION... Dont know if this will work⁄
        while (arrayAvg(twoDimArray[0], data) != true){
            twoDimArray = new int[10][data.length];
        for (int index = 0; index < data.length; index++)
        {
           rowPosition = findPositionValue(data[index],basePosition);
           while (twoDimArray[rowPosition][colPosition] != 0)
           {
               colPosition++;
           }
           twoDimArray[rowPosition][colPosition] = data[index];
           colPosition = 0;
        }
        data = collectSort(twoDimArray, data.length);
        basePosition++;
    }
        System.out.printf("Sorted array:%n%s%n%n", 
         Arrays.toString(data)); // display array
    }
    
    public static boolean arrayAvg(int[] array1, int[] array2)
    {
        int avg1 = 0;
        int avg2 = 0;
        for (int length = 0; length < array1.length; length++)
        {
            avg1 = avg1 + array1[length];
        }
        for (int length2 =0; length2 < array2.length; length2++)
        {
            avg2 = avg2 + array2[length2];
        }
                    return (avg1/array1.length) == (avg2/array2.length);
    }
    
    public static int[] collectSort(int[][] twiceDimensionalArray, int length)
    {
        int[] retArray = new int[length];
        int index = 0;
        for (int row = 0; row <= 9; row++)
        {
            for (int col = 0; col < twiceDimensionalArray[row].length; col++)
            {
                if (twiceDimensionalArray[row][col] != 0)
                {
                    retArray[index] = twiceDimensionalArray[row][col];
                    index++;
                }
            }    
        }
        return retArray;
    }
    

    
    public static int findPositionValue(int number, int position)
    {
        
        number = (int) (number / Math.pow(10, position));
        return number%10;
        
    }
    
    
    
    
    
    public static void main(String[] args) {
        
        SecureRandom generator = new SecureRandom();

        int[] data = new int[1000]; // create array

        for (int i = 0; i < data.length; i++) // populate array
            data[i] = 1 + generator.nextInt(999999);
        
        System.out.printf("Unsorted array:%n%s%n%n", 
         Arrays.toString(data)); // display array
        
        Sort(data, 0);
    
    
    }
    
}
