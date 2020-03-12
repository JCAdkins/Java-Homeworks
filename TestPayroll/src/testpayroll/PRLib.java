/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testpayroll;

/**
 *
 * @author jordanadkins
 */
public class PRLib {
       
public static float calculatePay(float hoursWorked, float hourlyPay){   //Method that calulates pay, 2 params
    
    if (hoursWorked>=0 && hourlyPay>0)      // logic to make sure hours worked and pay are greater than or equal to 0
        return Round(hoursWorked*hourlyPay);
   
    return 0;           // if one or both isn't return a 0
}

public static float calculatePay(float hoursWorked, float hourlyPay, float rateMult){   //method to calculate pay using 3 params
    
    if (hoursWorked>=0 && hourlyPay>0 && rateMult>0)    // again make sure they're greater than or equal to 0
        return Round((hoursWorked*hourlyPay)*rateMult); // return pay times rate multiplier
    return 0; 
}
public static float grossPay(float regPay, float otPay, float shift2Pay, float shift3Pay, float weekendPay){
    // method for determining Gross Payy of the employee
    if (regPay>=0 && otPay>=0 && shift2Pay>=0 && shift3Pay>=0 && weekendPay>=0) // make sure employee hasn't gotten negative pay
        return Round(regPay+otPay+shift2Pay+shift3Pay+weekendPay);
    return 0;
}

public static float SSTax(float grossPay, float ytdEarnings, float ytdSSWith){ // method for determining social security tax
    if (ytdEarnings>=128400)    // checks to see if earnings are greater than ss base
        return 0;               // don't tax if true
    if (ytdEarnings + grossPay < 128400)    // if ytdEarnings and gross pay are less than ss base, tax by 6.2%
        return Round(grossPay*0.062f);
    if (ytdEarnings<128400 && ytdEarnings + grossPay>128400) // if ytdEarnings is less than ss base but ytdEarnings PLUS gross pay is greater
        return Round((128499f-ytdEarnings)*0.062f);         // only tax the difference between the ss base and ytdEarnings
    
    return 0;
}

public static float MedicareTax(float grossPay){ //method for determining medicare tax
    
    if (grossPay>=0)
        return Round(grossPay*0.0145f);
    
    return 0;
}

public static float StateTax(float grossPay, float SWPerc){     //method for determining state tax
    
    if (grossPay>=0 && SWPerc>=0 && SWPerc<=1)  // make sure tax SWPerc is between 0 and 100%
        return Round(grossPay*SWPerc);
    return 0;
}

public static float calcDeduction(float grossPay, char dedCode, float dedVal){  // method to calcuate deductions
    if (grossPay>=0){           // check to make sure gross pay isnt negative
    switch (dedCode){           // check the dedCode for 'N','F', or 'P' and return associated dedVal
        case 'N': return 0;
        case 'F': 
            if (dedVal>grossPay){
                return Round(grossPay);
            }else if (dedVal>=0){
            return Round(dedVal);
        }
            break;
        case 'P': 
            if (dedVal>=0 && dedVal<=1)    // for 'P' since its a % we need to multiply that by gross pay before returning
                return Round(grossPay*dedVal);
            break;
            
    }
    }
    return 0;
}

public static float netPay(float grossPay, float fedWith, float SSWith, float medWith, float stateWith, float ded1Amt, float ded2Amt, float ded3Amt){
        // method for calculating the net pay of employee, makes sure no numbers are negative and gross pay minus taxes plus deductions will not be negative
    if (grossPay>=0 && fedWith>=0 && SSWith>=0 && medWith>=0 && stateWith>=0 && ded1Amt>=0 && ded2Amt>=0 && ded3Amt>=0){
        if (grossPay >= (fedWith+SSWith+medWith+stateWith+ded1Amt+ded2Amt+ded3Amt))
            return Round(grossPay-(fedWith+SSWith+medWith+stateWith+ded1Amt+ded2Amt+ded3Amt));
    }
    return 0;
}

private static float Round(float input){ // this will round to two decimal places
        input = input * 100;
        input = Math.round (input);
        input = input / 100; 
        return input;
}


}