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
public class PaySum {
     private int empNumber;
    private float regHours;
    private float overtimeHours;
    private float shift2Hours;
    private float shift3Hours;
    private float weekendHours;
    
    public PaySum(){
        empNumber = 0;
        regHours = 0;
        overtimeHours = 0;
        shift2Hours = 0;
        shift3Hours = 0;
        weekendHours = 0;
    }
    
    public PaySum(int empNumber, float regHours, float overtimeHours, float shift2Hours, float shift3Hours, float weekendHours){
        
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
    
    public float getweekendHours(){
        return weekendHours;
    }
    
    public void setempNumber(int empNumber){
        if (empNumber >= 0 && empNumber<=999999){
            this.empNumber = empNumber;
        }
    }
    
    public void setregHours(float regHours){
        if (regHours >=0 && regHours<=9999.99){
            this.regHours = PRLib.Round(regHours);
        }
    }
    
    public void setovertimeHours(float overtimeHours){
        if (overtimeHours >= 0 && overtimeHours<=9999.99){
            this.overtimeHours = PRLib.Round(overtimeHours);
        }
    }
    
    public void setshift2Hours(float shift2Hours){
        if (shift2Hours >= 0 && shift2Hours<=9999.99){
            this.shift2Hours = PRLib.Round(shift2Hours);
        }
    }
    
    public void setshift3Hours(float shift3Hours){
        if (shift3Hours >= 0 && shift3Hours<=9999.99){
            this.shift3Hours = PRLib.Round(shift3Hours);
        }
    }
    
    public void setweekendHours(float weekendHours){
        if (weekendHours >= 0 && weekendHours<=9999.99){
            this.weekendHours = PRLib.Round(weekendHours);
        }
    }
    
    public String displayData(){
        return "Employee Number: " + empNumber + "\nRegular Hours: " + regHours + "\tOvertime Hours: " + overtimeHours + "\tWeekend Hours: " + weekendHours + "\nShift 2 Hours: " + shift2Hours + "\tShift 3 Hours: " + shift3Hours;
    }
    
    
    
}


