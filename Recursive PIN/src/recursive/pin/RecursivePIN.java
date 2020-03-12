package recursive.pin;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author jordanadkins
 */
public class RecursivePIN {
    //String sPIN = new String(); //sPIN is the string of the integer PIN
    //int count = 0;
    RecursivePIN(String pin){
        //sPIN = pin;
    }
    
    public List<String> Recurse(String pin/*, List<String> currentCombinations*/) {
        if (pin.length() == 1){
            String currentLetters =  detLetter1(Integer.parseInt(pin)); 
        	List<String> returnList = new ArrayList<>();
        	for (int a = 0; a < currentLetters.length(); a++) {
        	returnList.add(currentLetters.substring(a,a+1));
        	}
        	return returnList;
        	
        }
        String tempString = "";
        //get the first letter of pin
        String subStr = pin.substring(0,1);
        //convert first letter to an int
        int parseInt = Integer.parseInt(subStr);
        //get all letters on dialpad for that number as a string
        String tempString2 = detLetter1(parseInt);
        tempString = tempString + tempString2;

        pin = pin.substring(1);
        
        List<String> tempString4 =Recurse(pin);
        //for (String someName : tempString2) {
        	//tempString4.add
        //}
        return null;//tempString + tempString4;
    }
    
    public String detLetter1(int num){
        
          List<String> wasteOfTime = Arrays.asList("+", "*", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz");
          //ArrayList<String> detLetter1 = new ArrayList<String>(){};
          //detLetter1.addAll(wasteOfTime);
         
          
      return wasteOfTime.get(num);  
    }
        
    
        
        
        
}
    
    
    
    


