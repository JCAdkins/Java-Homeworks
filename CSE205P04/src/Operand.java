//**************************************************************************************************
// CLASS: Operand
//
// DESCRIPTION
// The Operand class for Project 4.
//
// AUTHOR
// GROUP: 26
// AUTHOR 1: Jordan Adkins, jcadkin2, jcadkin2@asu.edu
// Author 2: Cody Surwic, csurwic, csurwic@asu.edu
// AUTHOR 3: Samantha Houghton, slhought, slhought@asu.edu
//**************************************************************************************************

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
