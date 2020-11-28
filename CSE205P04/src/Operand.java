//**************************************************************************************************************
// CLASS: Operand
//
// AUTHOR
// Kevin R. Burger (burgerk@asu.edu)
// Computer Science & Engineering Program
// Fulton Schools of Engineering
// Arizona State University, Tempe, AZ 85287-8809
// http://www.devlang.com
//**************************************************************************************************************

/**
 * An operand is a numeric value represented as a Double.
 */
public class Operand extends Token{
    //Class variables
    Double mValue;

    //Constructor
    Operand(Double pValue){
        this.mValue = pValue;
    }

    //Accessor
    public Double getValue(){
        return mValue;
    }

    //Mutator
    public void setValue(Double pValue){
        mValue = pValue;
    }
}
