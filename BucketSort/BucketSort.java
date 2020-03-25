import java.security.SecureRandom;
import java.util.Arrays;

public class BucketSort {

    private static int[] bucketSort(int arrayToSort[]) {
        int rowPosition;
        int colPosition = 0;
        int[][] twoDimArray = new int[10][arrayToSort.length];

        int numberOfIterations = (int)Math.log10(getArrayMaxValue(arrayToSort))+1;

        //loop for each power of 10
        for(int basePosition=0; basePosition< numberOfIterations; basePosition++) {
            //initialize empty sorting buckets
            twoDimArray = new int[10][arrayToSort.length];

            //loop over each value in the array and put it in its bucket. Sorting Pass
            for (int index = 0; index < arrayToSort.length; index++) {

                rowPosition = findPositionValue(arrayToSort[index], basePosition);

                //but value at the end of the bucket
                while (twoDimArray[rowPosition][colPosition] != 0) {
                    colPosition++;
                }
                twoDimArray[rowPosition][colPosition] = arrayToSort[index];
                colPosition = 0;
            }
            //get integers from buckets. Gathering Pass.
            arrayToSort = collectSort(twoDimArray, arrayToSort.length);
        }
        return arrayToSort;
    }

    //collect sort pulls values out of buckets and puts back into 1 dimensional array
    private static int[] collectSort(int[][] twiceDimensionalArray, int length) {
        int[] retArray = new int[length];
        int index = 0;
        for (int row = 0; row <= 9; row++) {
            for (int col = 0; col < twiceDimensionalArray[row].length; col++) {
                if (twiceDimensionalArray[row][col] != 0) {
                    retArray[index] = twiceDimensionalArray[row][col];
                    index++;
                }
            }
        }
        return retArray;
    }
    //gets integer/character at positon
    private static int findPositionValue(int number, int position) {
        number = (int) (number / Math.pow(10, position));
        return number % 10;
    }

    //get max value in array
    private static int getArrayMaxValue(int[] arr){
        int arrayMax=0;
        //get iterations. we need to do log 10(max(arrayToSort))+1 iterations
        for(int i = 0; i<arr.length; i++){
            if(arr[i]>arrayMax){
                arrayMax = arr[i];
            }
        }
        return arrayMax;
    }
    public static void main(String[] args) {
        //generate random array of integers 
        SecureRandom generator = new SecureRandom();
        int[] data = new int[1000]; // create array
        for (int i = 0; i < data.length; i++) // populate array
            data[i] = 1 + generator.nextInt(999999);

        System.out.printf("Unsorted array:%n%s%n%n", Arrays.toString(data)); // display array

        int[] sortedArray = bucketSort(data);
        System.out.printf("Sorted array:%n%s%n%n", Arrays.toString(sortedArray)); // display array
        
        //test to make sure sorted correctly
        for(int i=0; i<sortedArray.length-1; i++){
            if(sortedArray[i]>sortedArray[i+1]){
                System.out.println("Sorting Error: " + sortedArray[i] + " is greater than "+ sortedArray[i+1]);
            }
        }
    }
}