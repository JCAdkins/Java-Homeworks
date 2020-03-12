/*
Author: Jordan Adkins
Date: 1/25/2020
Abstract:  
 */

public class SavingsAccount {
    // Class variables
    static float annualInterestRate;
    private float savingsBalance;
    
    // Constructor
    public SavingsAccount(){
        annualInterestRate = 0;
        savingsBalance = 0;
    }    
    
    // Overloaded constructor
    public SavingsAccount(float savingsBalance){
        this.savingsBalance = savingsBalance;
    }    
    
    // Returns the rounded balace of the savingsBalance
    public float getBalance(){
        return round(savingsBalance);
    }
    
    // Calculates the interest accrued for that month of the savings balance
    public void calculateSavingsBalance(){
        savingsBalance = savingsBalance + calculateMonthlyInterest();
    }
    
    // Returns the monthly interest rate
    public float calculateMonthlyInterest()
    {   
        return savingsBalance * (annualInterestRate / 12);
    }        
    
    // Allows someone to modify the interest rate 
    public static void modifyInterestRate(float newInterestRate)
    {
        annualInterestRate = (newInterestRate / 100);
    }
    
    // Rounding method
    public float round(float number){
       float n1 = number * 100;
       n1 = Math.round(n1);
       n1 = n1 / 100;
       return n1;
        }
}
