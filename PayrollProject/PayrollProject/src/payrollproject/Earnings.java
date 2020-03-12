/*
Author: Jordan Adkins
Abstract: This class contains the data needed to record the earnings for various employees.
Date: 3/20/18
 */
package payrollproject;

/**
 *
 * @author jordanadkins
 */
public class Earnings{
    private int depNumber;
    private int empNumber;
    private float regHours;
    private float overtimeHours;
    private float shift2Hours;
    private float shift3Hours;
    private float weekendHours;
    private float regPay;
    private float overtimePay;
    private float shift2Pay;
    private float shift3Pay;
    private float weekendPay;
    private float grossPay;
    private float fedWithholding;
    private float ssWithholding;
    private float medWithholding;
    private float stateWithholding;
    private float volDeductions;
    private float netPay;
    private String checkDate;
    private float checkNumber;
    
    public Earnings(){
        
    }
    
    public int getdepNumber(){
        return depNumber;
    }
    
    public int getempNumber(){
        return empNumber;
    }
    
    public float getregHours(){
        return regHours;
    }
    
    public float getovertimeHours(){
        return overtimeHours;
    }
    
    public float getshift2Hours(){
        return shift2Hours;
    }
    
    public float getshift3Hours(){
        return shift3Hours;
    }
    
    public float getRegPay()
    {
        return regPay;
    }    
    
    public float getShift2Pay(){
        return shift2Pay;
    }

    public float getShift3Pay(){
        return shift3Pay;
    }
      
    public float getweekendPay(){
        return weekendPay;
    }
    
    public float getgrossPay(){
        return grossPay;
    }
    
    public float getfedWithholding(){
        return fedWithholding;
    }
    
    public float getssWithholding(){
        return ssWithholding;
    }
    
    public float getmedWithholding(){
        return medWithholding;
    }
    
    public float getstateWithholding(){
        return stateWithholding;
    }
    
    public float getvolDeductions(){
        return volDeductions;
    }
    
    public float getnetPay(){
        return netPay;
    }
    
    public String getcheckDate(){
        return checkDate;
    }
    
    public float getcheckNumber(){
        return checkNumber;
    }
    
    public void setdepNumber(int depNumber){
        if (depNumber>=0 && depNumber<=9999){
            this.depNumber = Math.round(depNumber);
        }
    }
    
    public void setempNumber(int empNumber){
        if (empNumber >=0 && empNumber<=999999){
            this.empNumber = Math.round(empNumber);
        }
    }
    
    public void setregHours(float regHours){
        if (regHours >=0 && regHours<=9999.99){
            this.regHours = PRLib.Round(regHours);
        }
    }
    
    public void setovertimeHours(float overtimeHours){
        if (overtimeHours>=0 && overtimeHours<=9999.99){
            this.overtimeHours = PRLib.Round(overtimeHours);
        }
    }
    
    public void setshift2Hours(float shift2Hours){
        if (shift2Hours>=0 && shift2Hours<=9999.99){
            this.shift2Hours = PRLib.Round(shift2Hours);
        }
    }
    
    public void setshift3Hours(float shift3Hours){
        if (shift3Hours>=0 && shift3Hours<=9999.99){
            this.shift3Hours = PRLib.Round(shift3Hours);
        }
    }
    
    public void setweekendHours(float weekendHours){
        if (weekendHours >=0 && weekendHours<=9999.99){
            this.weekendHours = PRLib.Round(weekendHours);
        }
    }
    
    public void setregPay(float regPay){
        if (regPay>=0 && regPay<=999999.99){
            this.regPay = PRLib.Round(regPay);
        }
    }
    
    public void setovertimePay(float overtimePay){
        if (overtimePay>=0 && overtimePay<=999999.99){
            this.overtimePay = PRLib.Round(overtimePay);
        }
    }
    
    public void setshift2Pay(float shift2Pay){
        if (shift2Pay>=0 && shift2Pay<=999999.99){
            this.shift2Pay = PRLib.Round(shift2Pay);
        }
    }
    
    public void setshift3Pay(float shift3Pay){
        if (shift3Pay>=0 && shift3Pay<=999999.99){
            this.shift3Pay = PRLib.Round(shift3Pay);
        }
    }
    
    public void setweekendPay(float weekendPay){
        if (weekendPay>=0 && weekendPay<=999999.99){
            this.weekendPay = PRLib.Round(weekendPay);
        }
    }
    
    public void setgrossPay(float grossPay){
         if (grossPay>=0 && grossPay<=999999.99){
             this.grossPay = PRLib.Round(grossPay);
         }
     }
    
    public void setfedWithholding(float fedWithholding){
        if (fedWithholding>=0 && fedWithholding<=999999.99){
            this.fedWithholding = PRLib.Round(fedWithholding);
        }
    } 
     
    public void setssWithholding(float ssWithholding){
        if (ssWithholding>=0 && ssWithholding<=999999.99){
            this.ssWithholding = PRLib.Round(ssWithholding);
        }
    } 
     
    public void setmedWithholding(float medWithholding){
        if (medWithholding>=0 && medWithholding<=999999.99){
            this.medWithholding = PRLib.Round(medWithholding);
        }
    } 
     
    public void setstateWithholding(float stateWithholding){
        if (stateWithholding >=0 && stateWithholding<=999999.99){
            this.stateWithholding = PRLib.Round(stateWithholding);
        }
    }
    
    public void setvolDeductions(float volDeductions){
        if (volDeductions >=0 && volDeductions<=999999.99){
            this.volDeductions = PRLib.Round(volDeductions);
        }
    }
    
    public void setnetPay(float netPay){
        if (netPay>=0 && netPay<=999999.99){
            this.netPay = PRLib.Round(netPay);
        }
    }
    
    public void setcheckDate(String checkDate){
        // Enter in the logic for this! 
        this.checkDate = checkDate;
    }
    
    public void setcheckNumber(float checkNumber){
        if (checkNumber>=0 && checkNumber<=999999.99){
            this.checkNumber = PRLib.Round(checkNumber);
        }
    }
    
    public String displayEarnings(){
        return "Department Number: " + depNumber + "\tEmployeeNumber: " + empNumber + "\nRegular Hours: " + regHours + "\tOvertime Hours: " + overtimeHours
                + "\tShift 2 Hours: " + shift2Hours + "\nShift 3 Hours: " + shift3Hours + "\tWeekend Hours: " + weekendHours +
                "\nRegular Pay: $" + regPay + "\tOvertime Pay: $" + overtimePay + "\nShift 2 Pay: $" + shift2Pay + "\tShift 3 Pay: $" + shift3Pay + "\tWeekend Pay: $"
                + weekendPay + "\tGrossPay: $" + grossPay + "\nFederal Withholding: $" + fedWithholding + "\tSocial Security Withholding: $" + ssWithholding +
                "\nMedicare Withholding: $" + medWithholding + "\tState Withholding: $" + stateWithholding + "\tTotal Deductions: $" + volDeductions +
                "\nNet Pay: $" + netPay + "\tDate: " + checkDate + "\tCheck Number: " + checkNumber;
                
                
                
                }
    
    
    
    
}
