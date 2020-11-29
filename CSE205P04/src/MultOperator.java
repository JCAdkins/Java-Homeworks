//**************************************************************************************************
// CLASS: MultOperator
//
// DESCRIPTION
// The MultOperator class for Project 4. Evaluates multiplications.
//
// AUTHOR
// GROUP: 26
// AUTHOR 1: Jordan Adkins, jcadkin2, jcadkin2@asu.edu
// Author 2: Cody Surwic, csurwic, csurwic@asu.edu
// AUTHOR 3: Samantha Houghton, slhought, slhought@asu.edu
//**************************************************************************************************

/**
 * Represents the multiplication operator which is a specific type of binary operator.
 */
public class MultOperator extends BinaryOperator {

    // Constructor
    MultOperator(){
    }

    // Return evaluated operand
    @Override
    public Operand evaluate(Operand pLhsOperand, Operand pRhsOperand) {
        return new Operand(pLhsOperand.getValue() * pRhsOperand.getValue());
    }

    // Normal precedence
    public int precedence(){
        return 3;
    }

    // Stack precedence
    public int stackPrecedence(){
        return 3;
    }
}