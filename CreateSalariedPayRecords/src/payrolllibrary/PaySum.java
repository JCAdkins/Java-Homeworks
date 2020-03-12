/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package payrolllibrary;

/**
 *
 * @author jordanadkins
 */
public class PaySum implements DisplayObject, Parser {     
     private int empNumber;                     // All variables to be used in paysum class
    private float regHours;
    private float overtimeHours;
    private float shift2Hours;
    private float shift3Hours;
    private float weekendHours;
    
    public PaySum(){                    //paysum constructor no params
        empNumber = 0;
        regHours = 0;
        overtimeHours = 0;
        shift2Hours = 0;
        shift3Hours = 0;
        weekendHours = 0;
    }
    
    public PaySum(int empNumber, float regHours, float overtimeHours, float shift2Hours, float shift3Hours, float weekendHours){    // paysum constructor all params
        this.setempNumber(empNumber);
        this.setregHours(regHours);
        this.setovertimeHours(overtimeHours);
        this.setshift2Hours(shift2Hours);
        this.setshift3Hours(shift3Hours);
        this.setweekendHours(weekendHours); 
    }
    
    
    public int getempNumber(){                  //accessor method
        return empNumber;
}
    
    public float getregHours(){                 //accessor method
        return regHours;
    }
    
    public float getovertimeHours(){            //accessor method
        return overtimeHours;
    }
    
    public float getshift2Hours(){              //accessor method
        return shift2Hours;
    }
    
    public float getshift3Hours(){              //accessor method
        return shift3Hours;
    }
    
    public float getweekendHours(){             //accessor method
        return weekendHours;
    }
    
    public void setempNumber(int empNumber){            //mutator method
        if (empNumber >= 0 && empNumber<=999999){
            this.empNumber = empNumber;
        }
    }
    
    public void setregHours(float regHours){            //mutator method
        if (regHours >=0 && regHours<=9999.99){
            this.regHours = PRLib.Round(regHours);
        }
    }
    
    public void setovertimeHours(float overtimeHours){      //mutator method
        if (overtimeHours >= 0 && overtimeHours<=9999.99){
            this.overtimeHours = PRLib.Round(overtimeHours);
        }
    }
    
    public void setshift2Hours(float shift2Hours){      //mutator method
        if (shift2Hours >= 0 && shift2Hours<=9999.99){
            this.shift2Hours = PRLib.Round(shift2Hours);
        }
    }
    
    public void setshift3Hours(float shift3Hours){          //mutator method
        if (shift3Hours >= 0 && shift3Hours<=9999.99){
            this.shift3Hours = PRLib.Round(shift3Hours);
        }
    }
    
    public void setweekendHours(float weekendHours){            //mutator method
        if (weekendHours >= 0 && weekendHours<=9999.99){
            this.weekendHours = PRLib.Round(weekendHours);
        }
    }
    
     @Override
    public String displayData(){            //returns a string that can be displayed ot view all variables
        return "Employee Number: " + empNumber + "\nRegular Hours: " + regHours + "\tOvertime Hours: " + overtimeHours + "\tWeekend Hours: " + weekendHours + "\nShift 2 Hours: " + shift2Hours + "\tShift 3 Hours: " + shift3Hours;
    }

    
    public String dataWriter(){
        return empNumber + "," + regHours + "," + overtimeHours + "," + weekendHours + "," + shift2Hours + "," + shift3Hours;
    }
    
     @Override
    public void parse(String input) {           //will parse a comma delimited input string
        String splitFields[];
        splitFields = input.split(",");
       setempNumber(Integer.parseInt(splitFields[0]));
       setovertimeHours(Float.parseFloat(splitFields[2]));
       setregHours(Float.parseFloat(splitFields[1]));
       setshift2Hours(Float.parseFloat(splitFields[3]));
       setshift3Hours(Float.parseFloat(splitFields[4]));
       setweekendHours(Float.parseFloat(splitFields[5]));
    
    }
    
    
    
}


