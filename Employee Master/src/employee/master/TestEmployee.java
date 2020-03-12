/*
Author: Jordan Adkins
Date: February, 23, 2018
Abstract: Create an object class with accessor and mutator methods for 
          Employee Master.
 */
package employee.master;

public class TestEmployee {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
     
     Employee DaveMatthews = new Employee();   /*New instance of Employee */
     DaveMatthews.setemployeeNumber(2);         /*Line 17-37 set numbers to Employee using the created setXXXX method */
     DaveMatthews.setdepNumber(51);
     DaveMatthews.setlastName("Matthews");
     DaveMatthews.setfirstName("David");
     DaveMatthews.setpayType('H');
     DaveMatthews.sethourlyRate(29.50);
     DaveMatthews.setTMStatus('S');
     DaveMatthews.setnumExemptions(4);
     DaveMatthews.setSWPercentage(.04444);
     DaveMatthews.setgrossEarning(2679.54);
     DaveMatthews.setfedTaxes(426.25);
     DaveMatthews.setSSTaxes(29.64);
     DaveMatthews.setmedTaxes(17.89);
     DaveMatthews.setstateTaxes(109.32);
     DaveMatthews.setytdDeductions(367.99);
     DaveMatthews.setdedCode1('F');
     DaveMatthews.setdedVal1(33.33);
     DaveMatthews.setdedCode2('P');
     DaveMatthews.setdedVal2(.33);
     DaveMatthews.setdedCode3('N');
     DaveMatthews.setdedVal3(133.33);
     
     System.out.println(DaveMatthews.getEmployee());        /* Prints String returned from method getEmployee on display */
     
    }
    
}
