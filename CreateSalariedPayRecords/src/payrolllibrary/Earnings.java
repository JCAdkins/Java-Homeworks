/*
 Earnings class 
 */
package payrolllibrary;

/**
 *
 * @author jordanadkins
 */
public class Earnings extends PaySum implements DisplayObject, Parser {
    private int depNumber;                          //All variables needed in the Earnings class
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
    
    public Earnings() {                     //Earnings constructor
        super();
    }    
    
    public int getdepNumber(){              //Accessor method
        return depNumber;
    }
    
    public float getregPay(){               //Accessor method
        return regPay;
    }
    
    public float getovertimePay(){          //Accessor method
        return overtimePay;
    }
    
    public float getshift2Pay(){            //Accessor method
        return shift2Pay;
    }
    
    public float getshift3Pay(){            //Accessor method
        return shift3Pay;
    }
    
    public float getweekendPay(){           //Accessor method
        return weekendPay;
    }
    
    public float getgrossPay(){             //Accessor method
        return grossPay;
    }
    
    public float getfedWithholding(){           //Accessor method
        return fedWithholding;
    }
    
    public float getssWithholding(){            //Accessor method
        return ssWithholding;
    }
    
    public float getmedWithholding(){           //Accessor method
        return medWithholding;
    }
    
    public float getstateWithholding(){         //Accessor method
        return stateWithholding;
    }
    
    public float getvolDeductions(){            //Accessor method
        return volDeductions;
    }
    
    public float getnetPay(){                   //Accessor method
        return netPay;
    }
    
    public String getcheckDate(){               //Accessor method
        return checkDate;
    }
    
    public float getcheckNumber(){              //Accessor method
        return checkNumber;
    }
    
    public void setdepNumber(int depNumber){        //Mutator method
        if (depNumber>=0 && depNumber<=9999){
            this.depNumber = Math.round(depNumber);
        }
    }
    
    public void setregPay(float regPay){            //Mutator method
        if (regPay>=0 && regPay<=999999.99){
            this.regPay = PRLib.Round(regPay);
        }
    }
    
    public void setovertimePay(float overtimePay){          //Mutator method
        if (overtimePay>=0 && overtimePay<=999999.99){
            this.overtimePay = PRLib.Round(overtimePay);
        }
    }
    
    public void setshift2Pay(float shift2Pay){              //Mutator method
        if (shift2Pay>=0 && shift2Pay<=999999.99){
            this.shift2Pay = PRLib.Round(shift2Pay);
        }
    }
    
    public void setshift3Pay(float shift3Pay){              //Mutator method
        if (shift3Pay>=0 && shift3Pay<=999999.99){
            this.shift3Pay = PRLib.Round(shift3Pay);
        }
    }
    
    public void setweekendPay(float weekendPay){                //Mutator method
        if (weekendPay>=0 && weekendPay<=999999.99){
            this.weekendPay = PRLib.Round(weekendPay);
        }
    }
    
    public void setgrossPay(float grossPay){                    //Mutator method
         if (grossPay>=0 && grossPay<=999999.99){
             this.grossPay = PRLib.Round(grossPay);
         }
     }
    
    public void setfedWithholding(float fedWithholding){            //Mutator method
        if (fedWithholding>=0 && fedWithholding<=999999.99){
            this.fedWithholding = PRLib.Round(fedWithholding);
        }
    } 
     
    public void setssWithholding(float ssWithholding){              //Mutator method
        if (ssWithholding>=0 && ssWithholding<=999999.99){
            this.ssWithholding = PRLib.Round(ssWithholding);
        }
    } 
     
    public void setmedWithholding(float medWithholding){            //Mutator method
        if (medWithholding>=0 && medWithholding<=999999.99){
            this.medWithholding = PRLib.Round(medWithholding);
        }
    } 
     
    public void setstateWithholding(float stateWithholding){            //Mutator method
        if (stateWithholding >=0 && stateWithholding<=999999.99){
            this.stateWithholding = PRLib.Round(stateWithholding);
        }
    }
    
    public void setvolDeductions(float volDeductions){                  //Mutator method
        if (volDeductions >=0 && volDeductions<=999999.99){
            this.volDeductions = PRLib.Round(volDeductions);
        }
    }
    
    public void setnetPay(float netPay){                        //Mutator method
        if (netPay>=0 && netPay<=999999.99){
            this.netPay = PRLib.Round(netPay);
        }
    }
    
    public void setcheckDate(String checkDate){                     //Mutator method
        // Enter in the logic for this! 
        this.checkDate = checkDate;
    }
    
    public void setcheckNumber(float checkNumber){              //Mutator method
        if (checkNumber>=0 && checkNumber<=999999.99){
            this.checkNumber = PRLib.Round(checkNumber);
        }
    }
    
    @Override
    public String displayData(){                    //Returns a string that can be used to display all variables
        return "Department Number: " + depNumber + "\t" + super.displayData() +
                "\nRegular Pay: $" + regPay + "\tOvertime Pay: $" + overtimePay + "\nShift 2 Pay: $" + shift2Pay + "\tShift 3 Pay: $" + shift3Pay + "\tWeekend Pay: $"
                + weekendPay + "\tGrossPay: $" + grossPay + "\nFederal Withholding: $" + fedWithholding + "\tSocial Security Withholding: $" + ssWithholding +
                "\nMedicare Withholding: $" + medWithholding + "\tState Withholding: $" + stateWithholding + "\tTotal Deductions: $" + volDeductions +
                "\nNet Pay: $" + netPay + "\tDate: " + checkDate + "\tCheck Number: " + checkNumber;
                
                
                
                }

    @Override
    public void parse(String input) {                   //will parse a comma delimited input string
       String splitFields[];
       splitFields = input.split(",");
       super.setempNumber(Integer.parseInt(splitFields[1]));
       setdepNumber(Integer.parseInt(splitFields[0]));
       super.setovertimeHours(Float.parseFloat(splitFields[3]));
       super.setregHours(Float.parseFloat(splitFields[2]));
       super.setshift2Hours(Float.parseFloat(splitFields[4]));
       super.setshift3Hours(Float.parseFloat(splitFields[5]));
       super.setweekendHours(Float.parseFloat(splitFields[6]));
       setregPay(Float.parseFloat(splitFields[7]));
       setovertimePay(Float.parseFloat(splitFields[8]));
       setshift2Pay(Float.parseFloat(splitFields[9]));
       setshift3Pay(Float.parseFloat(splitFields[10]));
       setweekendPay(Float.parseFloat(splitFields[11]));
       setgrossPay(Float.parseFloat(splitFields[12]));
       setfedWithholding(Float.parseFloat(splitFields[13]));
       setssWithholding(Float.parseFloat(splitFields[14]));
       setmedWithholding(Float.parseFloat(splitFields[15]));
       setstateWithholding(Float.parseFloat(splitFields[16]));
       setvolDeductions(Float.parseFloat(splitFields[17]));
       setnetPay(Float.parseFloat(splitFields[18]));
       setcheckDate(splitFields[19]);
       setcheckNumber(Integer.parseInt(splitFields[20]));
    }
    
    
    
    
}


