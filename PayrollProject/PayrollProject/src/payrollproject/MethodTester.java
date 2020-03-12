/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 
package payrollproject;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 *
 * @author jordanadkins
 
public class MethodTester {
    public static void main(String[] args) throws java.io.IOException {
    //TEST EMPLOYEE CLASS
     System.out.println("------------------EMPLOYEE TEST-------------------------------");
    Employee DaveMatthews = new Employee();   /*New instance of Employee 
     DaveMatthews.setemployeeNumber(2);         /*Line 17-37 set numbers to Employee using the created setXXXX method 
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
     
     System.out.println(DaveMatthews.displayEmployee());     
    //END EMPLOYEE TEST
     
     
     
     //TEST TIMECARD CLASS
     System.out.println("------------------TIMECARD TEST-------------------------------");
      String sName="";
        int sNum=0;
     TimeCard TimeCardTest = new TimeCard(sName, sNum);
     for(int day =0; day<7; day++){
         TimeCardTest.setsclockIn(day,"9:30");
     }
     for (int day=0; day<7; day++){
         TimeCardTest.setsclockOut(day,"18:45");
     }
     for(int day =7; day<14; day++){
         TimeCardTest.setsclockIn(day,"18:10");
     }
     for (int day=7; day<14; day++){
         TimeCardTest.setsclockOut(day,"6:44");
     }
     
     
     
     TimeCardTest.calculateElapsedTimes();
     System.out.print(TimeCardTest.displayTimeCard());
     //END TIMECARD CLASS TEST
     
    // TEST SHIFT RATES
    System.out.println("\n------------------SHIFT RATES-------------------------------");
    ShiftRates shiftRatesTest = new ShiftRates();
    shiftRatesTest.setshiftCode('2');
    shiftRatesTest.setshiftRate(22.22f);
    System.out.println(shiftRatesTest.displayshiftRate());
    shiftRatesTest.setshiftCode('3');
    shiftRatesTest.setshiftRate(33.33f);
    System.out.println(shiftRatesTest.displayshiftRate());
    shiftRatesTest.setshiftCode('W');
    shiftRatesTest.setshiftRate(44.44f);
    System.out.println(shiftRatesTest.displayshiftRate());
    shiftRatesTest.setshiftCode('E');
    shiftRatesTest.setshiftRate(111.22f);
    System.out.println(shiftRatesTest.displayshiftRate());
    //END SHIFT RATES TEST
    
    //EARNINGS TEST
    System.out.println("------------------EARNINGS-------------------------------");
    Earnings earningsTest = new Earnings();
    earningsTest.setdepNumber(99);
    earningsTest.setempNumber(933221);
    earningsTest.setregHours(45);
    earningsTest.setovertimeHours(10);
    earningsTest.setshift2Hours(3);
    earningsTest.setshift3Hours(1.5f);
    earningsTest.setweekendHours(.5f);
    earningsTest.setregPay(15.50f);
    earningsTest.setovertimePay(15.50f*1.5f);
    earningsTest.setshift2Pay(15.50f*1.2f);
    earningsTest.setshift3Pay(15.50f*1.25f);
    earningsTest.setweekendPay(15.50f);
    earningsTest.setgrossPay(12556.666f);
    earningsTest.setfedWithholding(125.66f);
    earningsTest.setssWithholding(89.99f);
    earningsTest.setmedWithholding(11.11f);
    earningsTest.setstateWithholding(22.22f);
    earningsTest.setvolDeductions(200.44f);
    earningsTest.setnetPay(1000.99f);
    earningsTest.setcheckDate("11/22/2018");
    earningsTest.setcheckNumber(66666);
    
    System.out.println(earningsTest.displayEarnings());
    
    
    //END EARNINGS TEST
    
    //START PAYSUM TEST
   System.out.println("------------------PAYSUM TEST-------------------------------");
    PaySum paySumTest = new PaySum();
    
    paySumTest.setempNumber(1122);
    paySumTest.setregHours(333);
    paySumTest.setovertimeHours(22);
    paySumTest.setshift2Hours(1.8f);
    paySumTest.setshift3Hours(3.4f);
    paySumTest.setweekendHours(11);
    
    System.out.println(paySumTest.displayPaySum());
    
    
    
    
    
            }   
    
}
*/