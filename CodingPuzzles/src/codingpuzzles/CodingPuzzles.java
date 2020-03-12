/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codingpuzzles;

import java.util.Hashtable;

/**
 *
 * @author jordanadkins
 */
public class CodingPuzzles {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int[] testarray = new int[9];
        testarray[0]=1;
        testarray[1]=1;
        testarray[2]=2;
        testarray[3]=2;
        testarray[4]=3;
        testarray[5]=3;
        testarray[6]=4;
        testarray[7]=4;
        testarray[8]=5;
        
        int result = GetOnlySingle(testarray);
        
        
        
    }
    
    
    private static int GetOnlySingle(int [] input){
        Hashtable<Integer, Integer> counterDict
     = new Hashtable<Integer, Integer>();
        
        for(int i=0; i<input.length; i++)
        {
            //check if key exists,
            if(counterDict.containsKey(input[i])){
                //increase the counter
                counterDict.put(input[i],counterDict.get(input[i])+1);
            }
            //if doesnt exist add it with counter1
            else{
                counterDict.put(input[i],1);

            }
        }
        
        //loop through the dict and find the key with counter=1
        for(int i = 0; i<counterDict.keySet().size();i++){
            if(counterDict.get(counterDict.keySet().))
        }
        
        
        
        
        return 0;
    }
    
}
