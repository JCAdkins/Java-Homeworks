/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paysum.and.earnings;

/**
 *
 * @author jordanadkins
 */
public class TestEarnings {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
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
    earningsTest.setcheckDate("11/22/2017");
    earningsTest.setcheckNumber(66666);
    
    System.out.println(earningsTest.displayData());
    System.out.println("==========================EARNINGS TEST 2====================================");
    
     Earnings earningsTest2 = new Earnings();
    earningsTest2.setdepNumber(-99);
    earningsTest2.setempNumber(-933221);
    earningsTest2.setregHours(-45);
    earningsTest2.setovertimeHours(-10);
    earningsTest2.setshift2Hours(-3);
    earningsTest2.setshift3Hours(-1.5f);
    earningsTest2.setweekendHours(-.5f);
    earningsTest2.setregPay(-15.50f);
    earningsTest2.setovertimePay(-15.50f*1.5f);
    earningsTest2.setshift2Pay(-15.50f*1.2f);
    earningsTest2.setshift3Pay(-15.50f*1.25f);
    earningsTest2.setweekendPay(-15.50f);
    earningsTest2.setgrossPay(-12556.666f);
    earningsTest2.setfedWithholding(-125.66f);
    earningsTest2.setssWithholding(-89.99f);
    earningsTest2.setmedWithholding(-11.11f);
    earningsTest2.setstateWithholding(-22.22f);
    earningsTest2.setvolDeductions(-200.44f);
    earningsTest2.setnetPay(-1000.99f);
    earningsTest2.setcheckDate("11/22/2017");
    earningsTest2.setcheckNumber(-66666);
    
    System.out.println(earningsTest2.displayData());
    
    
    System.out.println("=============================== PAYSUM TEST 1============================================================================");
    
    PaySum PaySumTest1 = new PaySum();
    PaySumTest1.setempNumber(111);
    PaySumTest1.setovertimeHours(4.4f);
    PaySumTest1.setregHours(39f);
    PaySumTest1.setshift2Hours(8.8f);
    PaySumTest1.setshift3Hours(3.7f);
    PaySumTest1.setweekendHours(1.3f);
    System.out.println(PaySumTest1.displayData());
    
    System.out.println("=================================PAYSUM TEST 2==========================================================================");
    
    PaySum PaySumTest2 = new PaySum();
    PaySumTest2.setempNumber(-111);
    PaySumTest2.setovertimeHours(-4.4f);
    PaySumTest2.setregHours(-44f);
    PaySumTest2.setshift2Hours(-8.8f);
    PaySumTest2.setshift3Hours(100000f);
    PaySumTest2.setweekendHours(-1.3f);
    System.out.println(PaySumTest2.displayData());
    }
}
