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
public class Earnings extends PaySum {
    private int depNumber;
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
    
    public Earnings() {
        super();
    }    
    
    public int getdepNumber(){
        return depNumber;
    }
    
    public float getregPay(){
        return regPay;
    }
    
    public float getovertimePay(){
        return overtimePay;
    }
    
    public float getshift2Pay(){
        return shift2Pay;
    }
    
    public float getshift3Pay(){
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
    
    public String displayData(){
        return "Department Number: " + depNumber + "\t" + super.displayData() +
                "\nRegular Pay: $" + regPay + "\tOvertime Pay: $" + overtimePay + "\nShift 2 Pay: $" + shift2Pay + "\tShift 3 Pay: $" + shift3Pay + "\tWeekend Pay: $"
                + weekendPay + "\tGrossPay: $" + grossPay + "\nFederal Withholding: $" + fedWithholding + "\tSocial Security Withholding: $" + ssWithholding +
                "\nMedicare Withholding: $" + medWithholding + "\tState Withholding: $" + stateWithholding + "\tTotal Deductions: $" + volDeductions +
                "\nNet Pay: $" + netPay + "\tDate: " + checkDate + "\tCheck Number: " + checkNumber;
                
                
                
                }
    
    
    
    
}


