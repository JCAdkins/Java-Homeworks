/*
Author: Jordan Adkins  
Date: 1/26/2020
Abstract: Class to test SavingsAccount class
 */
 
public class SavingsAccountTester {

    public static void main(String[] args) {
        
        // Create saver1 and saver 2 and set interest rate to 4%
        SavingsAccount saver1 = new SavingsAccount(2000);
        SavingsAccount saver2 = new SavingsAccount(3000);
        SavingsAccount.modifyInterestRate(4.0f);
        
        // Loop that simulates a year of interest 
        for (int a = 0; a < 12; a++)
        {
            saver1.calculateSavingsBalance();
            saver2.calculateSavingsBalance();
        }
        
        // Display balances after 12 months of interest
        System.out.println("Interest calculated at 4%: ");
        System.out.println("Saver1 balance: $" + saver1.getBalance());
        System.out.println("Saver2 balance: $" + saver2.getBalance() + "\n");
        
        // Change interest rate to 5%
        SavingsAccount.modifyInterestRate(5.0f);
        
        // Calculate savings after one month of interest
        saver1.calculateSavingsBalance();
        saver2.calculateSavingsBalance();
        
        // Display results
        System.out.println("Interest calculated at 5%: ");
        System.out.println("Saver1 balance: $" + saver1.getBalance());
        System.out.println("Saver2 balance: $" + saver2.getBalance());
        
    }
    
}
