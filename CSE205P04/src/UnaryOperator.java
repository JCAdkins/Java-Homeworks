//**************************************************************************************************
// CLASS: UnaryOperator
//
// DESCRIPTION
// The UnaryOperator class for Project 4. Abstract class for the unary operator.
//
// AUTHOR
// GROUP: 26
// AUTHOR 1: Jordan Adkins, jcadkin2, jcadkin2@asu.edu
// Author 2: Cody Surwic, csurwic, csurwic@asu.edu
// AUTHOR 3: Samantha Houghton, slhought, slhought@asu.edu
//**************************************************************************************************

/**
 * UnaryOperator is the superclass of all unary operators.
 */
public abstract class UnaryOperator extends Operator {

    public UnaryOperator() {
    }
    
    /**
     * Called to evaluate the operator.
     */
    public abstract Operand evaluate(Operand pOperand);

    /**
     * Returns false since all subclasses of UnaryOperator are unary operators.
     */
    @Override
    public boolean isBinaryOperator() {
        return false;
    }

}
