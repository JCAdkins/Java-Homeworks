/*
Author: Jordan Adkins
Abstract: This class contains all the information about the shift rates of various employees.
Date: 3/20/18
 */
package PayrollLibrary;

/**
 *
 * @author jordanadkins
 */
public class ShiftRates implements DisplayObject, Parser {
    private char shiftCode;                     //All Variables to be used in shift rates class
    private float shiftRate;
    
public ShiftRates(){            //shift rates constructor
    
}    
    
public char getshiftCode(){         //accessor method
    return shiftCode;
}

public float getshiftRate(){            //accessor method
    return shiftRate;
}

public void setshiftCode(char shiftCode){           //mutator method
    switch (shiftCode){
        case '2': this.shiftCode = shiftCode;
        case '3': this.shiftCode = shiftCode;
        case 'W': this.shiftCode = shiftCode;
        default: System.out.println("Invalid shift code");
    }
}

public void setshiftRate(float shiftRate){              //mutator method
    if (shiftRate>=0 && shiftRate<=99.99){
        this.shiftRate = PRLib.Round(shiftRate);
    }
}

    @Override
    public String displayData(){            //this will return a string that can be used to display all variables
    return "\nShift Code: " + shiftCode + "\t Shift Rate: " + shiftRate;
}
    
    public String dataWriter(){
        return shiftCode + "," + shiftRate;
    }

    @Override
    public void parse(String input) {               //will parse a comma delimited input string
       String splitFields[];
       splitFields = input.split(",");
       shiftCode = splitFields[0].charAt(0);
       shiftRate = Float.parseFloat(splitFields[1]);
               }


}
