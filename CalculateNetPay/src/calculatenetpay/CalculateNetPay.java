  /* Program: CalculateNetPay
Author: Jordan Adkins   
Date Written: 1/30/18
Abstract: This program is designed to calculate the net pay of an employee on a basic payroll.
*/
package calculatenetpay;


public class CalculateNetPay {

    public static void main(String[] args) {
    String employeeName = "Jordan Adkins";
 double hourlyRate = 12.5;
 double hoursWorked = 35.25;
 double FedWithPerc = 0.23;  // Federal withholding percentage
 double SocSecPerc = 0.062;  // Social security withholding percentage
 double MedWithPerc = 0.0145; // Medicare withholding percentage
 double StateWithPerc = 0.035;  // State withholding percentage
 
 double grossPay = Round(hourlyRate * hoursWorked);
 
 double FWTax = Round(grossPay * FedWithPerc);  // Federal withholding tax total
 double SSWTax = Round(grossPay * SocSecPerc); // Social security withholding tax total
 double MWTax = Round(grossPay * MedWithPerc); // Medicare withholding tax total
 double SWTax = Round(grossPay * StateWithPerc); // State withholding tax total
 
 double netPay = grossPay - (FWTax + SSWTax + MWTax + SWTax);
 
 System.out.println(employeeName + ":\n\nGross Pay: $" + grossPay + "\n\nHourly Rate: " + hourlyRate + "\t\tHours Worked: " 
 + hoursWorked +"\n");
 System.out.println("Federal Tax: " + (FedWithPerc)*100 + "%" + "\t\tFederal Withholding Tax: $" + FWTax );
 System.out.println("State Tax: " + Round(StateWithPerc*100)+ "%" + "\t\t\tState Withholding Tax: $" + SWTax);
 System.out.println("Social Security Tax: " + (SocSecPerc)*100 + "%" + "\tSS Withholding Tax: $" + SSWTax);
 System.out.println("Medicare Tax: " + Round(MedWithPerc*100) + "%" + "\t\tMedicare Withholding Tax: $" + MWTax);
 System.out.println("\nNet Pay: $" + Round(netPay));
}
    private static double Round(double input){ // this will round to two decimal places
        input = input * 100;
        input = Math.round (input);
        input = input / 100; 
        return input;
    }
    }
  
