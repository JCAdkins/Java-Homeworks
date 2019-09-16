/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 *
 * @author jordanadkins
 */
public class RecursivePIN {
   
	boolean isBiggerThanOne = false;
	
    RecursivePIN(String pin){
       
    }
    
    public List<String> Recurse(String pin) {
    	
    	if (pin.length() > 1) {
    		// set isBiggerThanOne to true if pin is bigger than one digit
    		isBiggerThanOne = true;
    	}	else {
    		//else set isBiggerThanOne to false
    		isBiggerThanOne = false;
    	}
    
        if (pin.length() == 1){
        	//base case; if the length of pin is 1 then return the string of
        	//letters that the one number represents; e.g. if 3, then return
        	// return returnList('d', 'e', 'f')
        	
            String currentLetters =  detLetter1(Integer.parseInt(pin)); 
        	List<String> returnList = new ArrayList<String>();
        	for (int a = 0; a < currentLetters.length(); a++) {
        	returnList.add(currentLetters.substring(a,a+1));
        	}
        	
        	return returnList;
        	
        }
        String tempString = new String();
        
        tempString = detLetter1(Integer.parseInt(pin.substring(0,1))); 
        //gets first letter of pin, converts it to an int, then gets all 
        //letters on dial pad for that number as a string
        
        pin = pin.substring(1);		//remove first number from pin
        
        List<String> tempString4 = Recurse(pin);		//recurse Recurse method and store it in tempString4
        List<String> finalList = new ArrayList<String>();
        
        if (isBiggerThanOne = true) {
        	//if isBiggerThanOne is true (aka if pin is bigger than one digit)
        	//then increase the size of tempString by the multiple of how long
        	// tempString is
        	
        	int size = tempString4.size();
        	for (int a =0; a < size * (tempString.length()-1); a++) {
        	tempString4.add(tempString4.get(a));
        }
        }
        
        
        Collections.sort(tempString4);			//sort tempString4 alphabetically
        //very important its alphabetical as the next step loops through and 
        //adds the characters in tempString to each letter and if its not 
        //alphabetical you will get duplicates
        
        int b = 0;
        
        for (int a = 0; a < tempString4.size(); a++) {
        //loop through the size of tempString4 and add the characters stored
        //in tempString to the current strings that are stored in tempString4
        //b loops at the length of tempString while a loops through all the 
        //strings stored in tempString4; the characters stored in tempString
        //will be added to the strings in tempString4 and then added to finalList
        	
        	finalList.add(a, tempString.charAt(b) + tempString4.get(a));
        	b++;
        	if (b > (tempString.length() - 1)) { b = 0;}
        	//once b reaches the length of tempString (that is once it's looped
        	//through all the characters in tempString) reset b back to zero
        	//to be looped through again
        	
        }
        
        
        Collections.sort(finalList);		//sort finalList alphabetically
        return finalList;
    }
    
    
    public String detLetter1(int num){
        //method that returns a string at the location of input 'int num'
    	
          List<String> wasteOfTime = Arrays.asList("+", "*", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz");
          
      return wasteOfTime.get(num);  
    }
    
    public boolean hasDuplicate(String pin) {
    	//method to check for duplicates that the method Recurse() returns
    	//returns true if there are duplicates and false if there aren't
    	
    	Set<String> set = new HashSet<String>(this.Recurse(pin));
    	
    	if (set.size() < this.Recurse(pin).size()) {
    		return true;
    	} else if (set.size() == this.Recurse(pin).size()){
    		return false;
    	} 
    	return true;
    }
    
    public int getSize(String pin) {
    	//method that returns the number of possible combinations that are possible
    	//given the input pin
    	
    	return this.Recurse(pin).size();
    	
    }
        
        
        
}
    
    
    
    


