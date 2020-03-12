/*
Author: Jordan Adkins
Date: 3/11/18
Abstract: Create a class that has no main method and uses static methods to process data with multiple parameters.

 */
package testpayroll;

public class TestPayroll {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       
        float TestCalcPay1 = PRLib.calculatePay(35.45f, 21.25f);    // Tests for calculatePau with 2 parameters
        float TestCalcPayInc1= PRLib.calculatePay(-35.45f, -10.50f);
        
        float TestCalcPay2 = PRLib.calculatePay(35.45f, 21.25f, 1.5f);  // Tests for calculatePay with 3 parameters
        float TestCalcPayInc2 = PRLib.calculatePay(-35.45f, 21.25f, 1.5f);
        float TestCalcPayInc3 = PRLib.calculatePay(35.45f, -21.25f, 1.5f);
        float TestCalcPayInc4 = PRLib.calculatePay(35.45f, 21.25f, -1.5f);
        
        float TestGrossPay1 = PRLib.grossPay(500.00f, 410.77f, 111.11f, 222.22f, 333.33f);      //Tests for calculating grossPay
        float TestGrossPayInc1 = PRLib.grossPay(-500.00f, 410.77f, 111.11f, 222.22f, 333.33f);
        float TestGrossPayInc2 = PRLib.grossPay(500.00f, -410.77f, 111.11f, 222.22f, 333.33f);
        float TestGrossPayInc3 = PRLib.grossPay(500.00f, 410.77f, -111.11f, 222.22f, 333.33f);
        float TestGrossPayInc4 = PRLib.grossPay(500.00f, 410.77f, 111.11f, -222.22f, 333.33f);
        float TestGrossPayInc5 = PRLib.grossPay(500.00f, 410.77f, 111.11f, 222.22f, -333.33f);
        
        float TestSSTax1 = PRLib.SSTax(TestGrossPay1, 50000f, (50000f*.062f));      // Tests for Calculating Social security tax
        float TestSSTax2 = PRLib.SSTax(TestGrossPay1, 130000f, (128400f*.062f));
        float TestSSTax3 = PRLib.SSTax(TestGrossPay1, 127500f, (127500f*.062f));
        
        float TestMedicareTax1 = PRLib.MedicareTax(TestGrossPay1);      // Tests for calculating medicare tax
        float TestMedicareTax2 = PRLib.MedicareTax(-TestGrossPay1);
        
        float TestStateTax1 = PRLib.StateTax(TestGrossPay1, 0.035f);    // Tests for calculating state tax
        float TestStateTax2 = PRLib.StateTax(-TestGrossPay1, 0.035f);
        float TestStateTax3 = PRLib.StateTax(TestGrossPay1, -0.035f);
        
        float TestCalcDeduction1 = PRLib.calcDeduction(TestGrossPay1, 'N', 1000f);      //Tests for Calculating deductions
        float TestCalcDeduction2 = PRLib.calcDeduction(TestGrossPay1, 'F', 200.25f);
        float TestCalcDeduction3 = PRLib.calcDeduction(TestGrossPay1, 'F', 2000.25f);
        float TestCalcDeduction4 = PRLib.calcDeduction(TestGrossPay1, 'P', .5f);
        float TestCalcDeduction5 = PRLib.calcDeduction(TestGrossPay1, 'P', 1.5f);
        float TestCalcDeduction6 = PRLib.calcDeduction(TestGrossPay1, 'A', .5f);
        float TestCalcDeduction7 = PRLib.calcDeduction(-TestGrossPay1, 'P', .5f);
        
        float TestNetPay1 = PRLib.netPay(1500f, (1500f*.15f), 100.00f, 62.20f, 90.90f, 150f, 200f, 300f);       // Tests for calculating net pay
        float TestNetPay2 = PRLib.netPay(1500f, (1500f*.15f), 10000.00f, 62.20f, 90.90f, 150f, 200f, 300f);
        float TestNetPay3 = PRLib.netPay(-TestGrossPay1, (TestGrossPay1*.15f), TestSSTax3, TestMedicareTax1, TestStateTax1, TestCalcDeduction2, TestCalcDeduction2, TestCalcDeduction4);
        float TestNetPay4 = PRLib.netPay(TestGrossPay1, -20f, TestSSTax3, TestMedicareTax1, TestStateTax1, TestCalcDeduction1, TestCalcDeduction2, TestCalcDeduction4);
        float TestNetPay5 = PRLib.netPay(TestGrossPay1, (TestGrossPay1*.15f), -TestSSTax3, TestMedicareTax1, TestStateTax1, TestCalcDeduction2, TestCalcDeduction2, TestCalcDeduction4);
        float TestNetPay6 = PRLib.netPay(TestGrossPay1, (TestGrossPay1*.15f), TestSSTax3, -TestMedicareTax1, TestStateTax1, TestCalcDeduction2, TestCalcDeduction2, TestCalcDeduction4);
        float TestNetPay7 = PRLib.netPay(TestGrossPay1, (TestGrossPay1*.15f), TestSSTax3, TestMedicareTax1, -TestStateTax1, TestCalcDeduction2, TestCalcDeduction2, TestCalcDeduction4);
        float TestNetPay8 = PRLib.netPay(TestGrossPay1, (TestGrossPay1*.15f), TestSSTax3, TestMedicareTax1, TestStateTax1, -TestCalcDeduction2, TestCalcDeduction2, TestCalcDeduction4);
        float TestNetPay9 = PRLib.netPay(TestGrossPay1, (TestGrossPay1*.15f), TestSSTax3, TestMedicareTax1, TestStateTax1, TestCalcDeduction2, -TestCalcDeduction2, TestCalcDeduction4);
        float TestNetPay10 = PRLib.netPay(TestGrossPay1, (TestGrossPay1*.15f), TestSSTax3, TestMedicareTax1, TestStateTax1, TestCalcDeduction2, TestCalcDeduction2, -TestCalcDeduction4);
        
        System.out.println("Tests for Calculate Pay, 2 parameters:\nTest 1-\t" + TestCalcPay1 + "\nTest 2-\t" + TestCalcPayInc1);       //Displaying the outcome of all tests on screen
        System.out.println("\nTests for Calculate Pay, 3 paramaters:\nTest 1-\t" + TestCalcPay2 + "\nTest 2-\t" + TestCalcPayInc2 + "\nTest 3-\t" + TestCalcPayInc3 + "\nTest 4-\t" + TestCalcPayInc4);
        System.out.println("\nTests for Gross Pay: \nTest 1-\t" + TestGrossPay1 + "\nTest 2-\t" + TestGrossPayInc1 + "\nTest 3-\t" + TestGrossPayInc2 + "\nTest 4-\t" + TestGrossPayInc3 + "\nTest 5-\t" + TestGrossPayInc4 +"\nTest 6-\t" + TestGrossPayInc5);
        System.out.println("\nTests for SSTax: \nTest 1-\t" + TestSSTax1 + "\nTest 2-\t" + TestSSTax2 + "\nTest 3-\t" + TestSSTax3);
        System.out.println("\nTests for Medicare Tax:\nTest 1-\t" + TestMedicareTax1 + "\nTest 2-\t" + TestMedicareTax2);
        System.out.println("\nTests for State Tax: \nTest 1-\t" + TestStateTax1 + "\nTest 2-\t" + TestStateTax2 + "\nTest 3-\t" + TestStateTax3);
        System.out.println("\nTests for Deductions: \nTest 1-\t" + TestCalcDeduction1 + "\nTest 2-\t" + TestCalcDeduction2 + "\nTest 3-\t" + TestCalcDeduction3 + "\nTest 4-\t" + TestCalcDeduction4 + "\nTest 5-\t" + TestCalcDeduction5 + "\nTest 6-\t" + TestCalcDeduction6 + "\nTest 7-\t" + TestCalcDeduction7);
        System.out.println("\nTests for Net Pay: \nTest 1-\t" + TestNetPay1 + "\nTest 2-\t" + TestNetPay2 + "\nTest 3-\t" + TestNetPay3 + "\nTest 4-\t" + TestNetPay4 + "\nTest 5-\t" + TestNetPay5 + "\nTest 6-\t" + TestNetPay6 + "\nTest 7-\t" + TestNetPay7 + "\nTest 8-\t" + TestNetPay8 + "\nTest 9-\t" + TestNetPay9 + "\nTest 10- " + TestNetPay10);
        
        
    }
    
}
