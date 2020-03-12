/*
Program Name: Deduction Calculator
Author: Jordan Adkins
Date: 2/5/18
Abstract: This program is used to calculate payroll deductions.
 */
package deductioncalculator;
import java.io.BufferedReader;
import java.io.InputStreamReader;
public class DeductionCalculator {

    public static void main(String[] args) 
            throws java.io.IOException { 
       
        BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));

      double grossPay = 0;
      char dedCode;
      double dedAmount = 0;
        do{
            if (grossPay<0)
                System.out.println("Gross pay cannot be negative.\n");
            System.out.print("Please enter gross pay: ");
            grossPay = Double.parseDouble(keyboard.readLine());

        }while (grossPay<0);
        
        do{
            System.out.print("\nN: No deduction\nF: Fixed deduction\nP: Percentage deduction\nPlease enter deduction code: ");
            dedCode = keyboard.readLine().charAt(0);
        } while ((dedCode!= 'N')&&(dedCode!= 'F')&&(dedCode!='P'));
        
        if (dedCode=='F'){
            do{
                if (dedAmount<0)
                System.out.println("Deduction amount cannot be negative.\n");
            System.out.print("\nPlease enter amount:");
                dedAmount = Double.parseDouble(keyboard.readLine());
               
        }while (dedAmount<0);
            if (dedAmount>grossPay)
                dedAmount=grossPay;
            
        } else if (dedCode=='P'){
            do{
                System.out.println("\nPlease enter percentage (0-60%):");
            dedAmount = Double.parseDouble(keyboard.readLine());
            
            }while(dedAmount<0);
            
            if (dedAmount>60){
                dedAmount=60;}
            
                dedAmount=grossPay*(dedAmount/100);
            }
            
        
    
        double netPay = grossPay - dedAmount;
        System.out.println("\nGross pay: $" + Round(grossPay));
        System.out.println("Deduction Code: " + dedCode);
        if (dedCode=='P'){
            System.out.print("Percent Deduction: " + (dedAmount/grossPay)*100 +"\n");
        }
        System.out.println("Deduction Amount: $" + Round(dedAmount));
        System.out.println("Pay after deduction: $" + Round(netPay));
        
    }
private static double Round(double input){ // this will round to two decimal places
        input = input * 100;
        input = Math.round (input);
        input = input / 100; 
        return input;
        
    }     
}

    
    
    
    

