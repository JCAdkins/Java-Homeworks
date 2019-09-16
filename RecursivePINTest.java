
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.*;
/**
 *
 * @author jordanadkins
 */
public class RecursivePINTest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       System.out.println("This will turn you PIN into every possible word combination."
               + "\nPlease enter a 4-digit PIN");
       Scanner s = new Scanner(System.in);
       String pin = new String();
       pin = s.nextLine();
       RecursivePIN rPIN = new RecursivePIN(pin);
       if (rPIN.hasDuplicate(pin) == true) {
    	   System.out.println("Set has duplicates!");
       } else if (rPIN.hasDuplicate(pin) == false) {
    	   System.out.println("No Duplicates!");
       } else {
    	   System.out.println("Well I don't know what happened.");
       }
       System.out.println(rPIN.getSize(pin) + " combinations");
       try {
           Thread.sleep(2000);
       } catch (InterruptedException e) {
           e.printStackTrace();
       }
       System.out.println(rPIN.Recurse(pin/*, null*/));
       s.close();
    }
    
}
