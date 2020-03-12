/*
Author: Jordan Adkins
Date: 1/19/20
Abstract: Application that simulates the rolling of two dice and outputs
          
 */
package dicerolling;

public class DiceRolling {
    
    public static void main(String[] args) {
       
        // Create a new object dice and the arrays that will store 
        // the results of the method call dice.rollDice;
        Dice dice = new Dice();
        int[] sumOfValues = new int[11];
        int[] tallyOfPossibleSums = new int[36];
        
        // Loop that runs through 36 million times. Each time through the loop
        // an int array size 2 is created that will store the outcomes of the 
        // roll of the pair of dice. The results of the dice roll are then 
        // stored into the arrays sumOfValues and tallyOfPossibleSums
        for(int a = 0; a < 36000000; a++)
        {
        int[] pairOfDice = new int[2];
        pairOfDice = dice.rollDice();
        
        dice.addToArray(pairOfDice, sumOfValues);
        dice.addToArray(pairOfDice, tallyOfPossibleSums);
        
        
        }
        
        
        // This loop runs through int[] sumOfValues and displays how many times
        // each sum was rolled and the percentage it was rolled
        for (int a = 0; a < 11; a++){
            float f = (sumOfValues[a]/36000000f) * 100f;
            System.out.printf("%2d:  %,-10d  |  %f%%\n",  (a + 2), sumOfValues[a], f);
            
        } 
        
        // Just display text to make a nice pretty table
        System.out.printf("\n  |\t %10d |\t %10d |\t %10d |\t %10d |\t %10d |\t %10d |\n", 1, 2, 3, 4, 5, 6);
        System.out.println("--+-----------------+---------------+---------------+---------------+---------------+---------------|");
        
        // Loop through int[] tallyOfPossibleSums and display the value of all
        // indices, which is all the different combinations of the dice. The 
        // output is formatted to look pretty.
        int b = 1; // Just a value to properly output one of the dice on the table
        for (int a = 0; a < 35; a = a+6){
            
        System.out.printf("%d |\t %,-10d |\t %,-10d |\t %,-10d |\t %,-10d |\t %,-10d |\t %,-10d |\t\n", b, tallyOfPossibleSums[a], tallyOfPossibleSums[a + 1] 
                            , tallyOfPossibleSums[a + 2], tallyOfPossibleSums[a + 3],
                             tallyOfPossibleSums[a + 4], tallyOfPossibleSums[a + 5]);
        
        System.out.println("--+-----------------+---------------+---------------+---------------+---------------+---------------|");
        
        b++;
            
            
        }
        
        
        
        
    }
}
