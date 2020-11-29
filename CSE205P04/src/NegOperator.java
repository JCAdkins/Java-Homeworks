//**************************************************************************************************
// CLASS: NegOperator
//
// DESCRIPTION
// The NegOperator class for Project 4. Evaluates negations.
//
// AUTHOR
// GROUP: 26
// AUTHOR 1: Jordan Adkins, jcadkin2, jcadkin2@asu.edu
// Author 2: Cody Surwic, csurwic, csurwic@asu.edu
// AUTHOR 3: Samantha Houghton, slhought, slhought@asu.edu
//**************************************************************************************************

/**
 * Represents the negation operator which is a specific type of unary operator.
 */
public class NegOperator extends UnaryOperator{

    NegOperator(){
    }

    @Override
    public Operand evaluate(Operand pOperand) {
        return new Operand(pOperand.getValue() * -1);
    }

    public int precedence(){
        return 4;
    }

    public int stackPrecedence(){
        return 4;
    }

}