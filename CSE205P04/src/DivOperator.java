//**************************************************************************************************
// CLASS: DivOperator
//
// DESCRIPTION
// The DivOperator class for Project 4. Evaluates divisions.
//
// AUTHOR
// GROUP: 26
// AUTHOR 1: Jordan Adkins, jcadkin2, jcadkin2@asu.edu
// Author 2: Cody Surwic, csurwic, csurwic@asu.edu
// AUTHOR 3: Samantha Houghton, slhought, slhought@asu.edu
//**************************************************************************************************

/**
 * Represents the division operator which is a specific type of binary operator.
 */
public class DivOperator extends BinaryOperator {

    // Constructor
    DivOperator(){
    }

    // Return evaluated operand
    @Override
    public Operand evaluate(Operand pLhsOperand, Operand pRhsOperand) {
        return new Operand(pLhsOperand.getValue() / pRhsOperand.getValue());
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