package wordscramble;
import java.util.*;
import java.util.regex.Pattern;

public class WordScramble {

    public static void main(String[] args) {

        // Initializing variables needed
        int num = 0;
        String word;
    
        // Create scanner and have user input five letter word
        Scanner s = new Scanner(System.in);
        System.out.println("Please input a five letter word:");
        word = s.next();
        
        // Check to make sure user input 5 letter word
        if (!matches(word))
        {
         System.out.println("You didn't enter a five letter word.");            
        }
        else
        {
        
            // Create an array of Strings that holds the maximum different
            // combinations of letters (60). Loop through and add the unique
            // combinations to the possibleWord array.
            String [] possibleWords = new String[60];
            for (int a = 0; a <= 4; a++)
            {
                for (int b = 0; b <= 4; b++)
                {
                    for (int c = 0; c <= 4; c++)
                    {
                        if (c != b && b != a && c != a)
                        {
                            String loopString = "" + word.charAt(a) + word.charAt(b) + word.charAt(c);
                            loopString = loopString.toLowerCase();
                            possibleWords[num] = loopString;
                            num++;
                        }
                    }    
                }     
            }
            
            // Create our dictionary that will give us a list of all 3 letter
            // words stored in the variable myDictionary
            Dictionary dictionary = new Dictionary();
            String[] myDictionary = new String[1065];
            myDictionary = dictionary.wordList();
            
            // loop through our possibleWords and myDictionary to find matches
            // and print them on screen
            for (int a = 0; a < 60; a++)
            {
                for (int b = 0; b < 1065; b++)
                {
                    if (myDictionary[b].equals(possibleWords[a]))
                    {
                        System.out.println(possibleWords[a]);
                    }
                }
            }
        }
    }
    
    // Method that returns true if the input is a five letter string
    public static boolean matches(String input)
    {
        return Pattern.matches("[a-zA-Z]{5}", input);
    }
    
    
}
