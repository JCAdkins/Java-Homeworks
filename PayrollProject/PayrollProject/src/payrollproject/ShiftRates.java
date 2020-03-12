/*
Author: Jordan Adkins
Abstract: This class contains all the information about the shift rates of various employees.
Date: 3/20/18
 */
package payrollproject;

/**
 *
 * @author jordanadkins
 */
public class ShiftRates {
    private char shiftCode;
    private float shiftRate;
    
public ShiftRates(){
    
}    
    
public char getshiftCode(){
    return shiftCode;
}

public float getshiftRate(){
    return shiftRate;
}

public void setshiftCode(char shiftCode){
    switch (shiftCode){
        case '2': this.shiftCode = shiftCode;
        case '3': this.shiftCode = shiftCode;
        case 'W': this.shiftCode = shiftCode;
        default: System.out.println("Invalid shift code");
    }
}

public void setshiftRate(float shiftRate){
    if (shiftRate>=0 && shiftRate<=99.99){
        this.shiftRate = PRLib.Round(shiftRate);
    }
}

public String displayshiftRate(){
    return "\nShift Code: " + shiftCode + "\t Shift Rate: " + shiftRate;
}


}
