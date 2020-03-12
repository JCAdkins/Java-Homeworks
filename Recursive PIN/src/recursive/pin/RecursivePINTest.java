package recursive.pin;

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
       String pin = s.nextLine();
       RecursivePIN rPIN = new RecursivePIN(pin);
       System.out.println(rPIN.Recurse(pin/*, null*/));
    }
    
}
