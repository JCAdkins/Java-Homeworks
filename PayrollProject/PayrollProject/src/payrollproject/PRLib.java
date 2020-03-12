/*
Author: Jordan Adkins
Abstract: This class is a library containing all the major methods to be used throughout the various classes and programs.
Date: 3/20/18
 */
package payrollproject;

/**
 *
 * @author jordanadkins
 */
public class PRLib {
    
    public static float convAndRoundTime(String time){
        byte hours = getHours(time);
        byte mins = getMinutes(time);
        if (mins >= 0 && mins <8){
            return hours;
        }else if (mins >= 8 && mins <23){
            return hours + .25f;
        }else if (mins >= 23 && mins < 38){
            return hours + .50f;
        }else if (mins >= 38 && mins <53){
            return hours + .75f;
        }else{
            return hours + 1.00f;
        }
     
    }    
    public static byte getHours(String time){          // method to get Hours as a byte
        String[] splitFields = time.split(":");
        return Byte.parseByte(splitFields[0]);
    }
    
    public static byte getMinutes(String time){            // method to get minutes as byte
        String[] splitFields = time.split(":");
        return Byte.parseByte(splitFields[1]);
    }
    
    public static float calculateElapsedTime(int day, float clockIn[], float clockOut[]){            // method to calculate the elapsed time
        if (day >= 0 && day<14){
            if (clockOut[day] >= clockIn[day]){
                return clockOut[day] - clockIn[day];
            }else if (clockOut[day]<clockIn[day]) {
                return (clockOut[day] + 24) - clockIn[day];
            
            }
        }
        return 0;
    }    
    
    
    
    public static float calcWeeklyHrsWorked(float elapsedTimes[]){
        float sumHours = 0;
        for (int a = 0; a<=7; a++)
            sumHours = sumHours + elapsedTimes[a];
        return sumHours;
    }
    
    public static float calcRegHrsWorked(float weeklyHours){
        if (weeklyHours>40){
            return 40f;
        }
        return weeklyHours;
    }
    
    public static float calcOTHrs(float weeklyHours){
        if (weeklyHours>40){
            return weeklyHours;
        }
                return 0;
    }
    
    public static float calcWeekendHrs(float clockIn, float clockOut, int day){
        float weekendHours = 0;
        if (day == 5 && (clockOut<clockIn)){
           weekendHours = weekendHours + clockOut;
        }
        if (day == 6 || day == 7){
            if (clockOut>clockIn){
                weekendHours = weekendHours + (clockOut - clockIn);
            }else if (clockOut<clockIn){
                weekendHours = weekendHours + ((clockOut + 24) - clockIn);
            }
        }
        return weekendHours;
    }
    
    
    public static float calcPay(float hoursWorked, float hourlyPay){   //Method that calulates pay, 2 params
    
    if (hoursWorked>=0 && hourlyPay>0)      // logic to make sure hours worked and pay are greater than or equal to 0
        return Round(hoursWorked*hourlyPay);
   
    return 0;           // if one or both isn't return a 0
}

public static float calcPay(float hoursWorked, float hourlyPay, float rateMult){   //method to calculate pay using 3 params
    
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

public static float fwTax(float Pay, char mStatus){
    if (Pay>=0){
        if (mStatus=='M'){
            if (Pay>0 && Pay<=88){
                return 0;
            }else if (Pay>88 && Pay<=447){
                return (Pay-88)*.1f;
            }else if (Pay>447 && Pay<=1548){
                return 35.90f + (Pay-447)*.15f;
            }else if (Pay>1548 && Pay<=3623){
                return 201.05f + (Pay-1548)*.25f;
            }else if (Pay>3623 && Pay<=7460){
                return 719.80f + (Pay-3623)*.28f;
            }else if (Pay>7460 && Pay<=16115){
                return 1794.16f + (Pay-7460)*.33f;
            }else if (Pay>16115 && Pay<=16181){
                return 4650.31f + (Pay-16115)*.35f;
            }else if (Pay>16181){
                return 4673.41f + (Pay-16181)*.396f;
            }
            
        }else if(mStatus=='S'){
            if (Pay>0 && Pay<=333){
                return 0;
            }else if (Pay>333 && Pay<=1050){
                return (Pay-333)*.1f;
            }else if (Pay>1050 && Pay<=3252){
                return 71.70f + (Pay-1050)*.15f;
            }else if (Pay>3252 && Pay<=6221){
                return 402.00f + (Pay-3252)*.25f;
            }else if (Pay>6221 && Pay<=9308){
                return 1144.25f + (Pay-6221)*.28f;
            }else if (Pay>9308 && Pay<=16360){
                return 2008.16f + (Pay-9308)*.33f;
            }else if (Pay>16360 && Pay<=18437){
                return 4355.77f + (Pay-16360)*.35f;
            }else if (Pay>18437){
                return 5062.72f + (Pay-18437)*.396f;
            }
            
        }
        
        
        
        
        
    }
    return 0;
}




public static float ssTax(float grossPay, float ytdEarnings, float ytdSSWith){ // method for determining social security tax
    if (ytdEarnings>=128400)    // checks to see if earnings are greater than ss base
        return 0;               // don't tax if true
    if (ytdEarnings + grossPay < 128400)    // if ytdEarnings and gross pay are less than ss base, tax by 6.2%
        return Round(grossPay*0.062f);
    if (ytdEarnings<128400 && ytdEarnings + grossPay>128400) // if ytdEarnings is less than ss base but ytdEarnings PLUS gross pay is greater
        return Round((128400f-ytdEarnings)*0.062f);         // only tax the difference between the ss base and ytdEarnings
    
    return 0;
}

public static float medicareTax(float grossPay){ //method for determining medicare tax
    
    if (grossPay>=0)
        return Round(grossPay*0.0145f);
    
    return 0;
}

public static float stateTax(float grossPay, float SWPerc){     //method for determining state tax
    
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
            if (dedVal>1)
                dedVal = 1;
            if (dedVal>=0 && dedVal<=1)    // for 'P' since its a % we need to multiply that by gross pay before returning
                return Round(grossPay*dedVal);
            break;
            
    }
    }
    return 0;
}

public static float calcNetPay(float grossPay, float fedWith, float SSWith, float medWith, float stateWith, float ded1Amt, float ded2Amt, float ded3Amt){
        // method for calculating the net pay of employee, makes sure no numbers are negative and gross pay minus taxes plus deductions will not be negative
    if (grossPay>=0 && fedWith>=0 && SSWith>=0 && medWith>=0 && stateWith>=0 && ded1Amt>=0 && ded2Amt>=0 && ded3Amt>=0){
        if (grossPay >= (fedWith+SSWith+medWith+stateWith+ded1Amt+ded2Amt+ded3Amt))
            return Round(grossPay-(fedWith+SSWith+medWith+stateWith+ded1Amt+ded2Amt+ded3Amt));
    }
    return 0;
}

public static float Round(float input){ // this will round to two decimal places
        input = input * 100;
        input = Math.round (input);
        input = input / 100; 
        return input;
}
}
