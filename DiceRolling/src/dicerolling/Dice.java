/*
Author: Jordan Adkins
Date: 1/19/20
Abstract: This class creates everything needed for the dice
 */

package dicerolling;

import java.util.Random;

public class Dice {
    
    // Variables for the value of each die
    int Dice1 = 0;
    int Dice2 = 0;
    
// Pretty straight forward. A method to roll the dice. Returns an integer
// array with 2 indexes, one for each value of the dice.
public int[] rollDice(){
    Random random = new Random();
    Dice1 = (random.nextInt(6) + 1);
    Dice2 = (random.nextInt(6) + 1);
    
    int[] dicePair = new int[2];
    
    dicePair[0] = Dice1;
    dicePair[1] = Dice2;
    
    return dicePair;
}    

// A method that will add the value of the roll of the dice to the appropriate
// array. Then returns the updated array that was sent to it.
public int[] addToArray(int[] dicePair, int[] array){
 
        switch (array.length) {
            case 11:
                
                array[(dicePair[0] + dicePair[1]) - 2]++;
                break;
            case 36:
                array[((dicePair[0] - 1) * 6) + (dicePair[1] - 1)]++;
                break;
            default:
                System.out.println("Array length is wrong!");
                break;
        }
    
    return array;
}
    

    
}
