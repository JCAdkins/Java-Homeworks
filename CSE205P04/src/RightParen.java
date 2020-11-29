//**************************************************************************************************
// CLASS: RightParen
//
// DESCRIPTION
// The RightParen class for Project 4.
//
// AUTHOR
// GROUP: 26
// AUTHOR 1: Jordan Adkins, jcadkin2, jcadkin2@asu.edu
// Author 2: Cody Surwic, csurwic, csurwic@asu.edu
// AUTHOR 3: Samantha Houghton, slhought, slhought@asu.edu
//**************************************************************************************************

/**
 * Represents a right parenthesis in the expression.
 */
public class RightParen extends Parenthesis {

    public RightParen() {
    }

    /**
     * Right parentheses really don't have precedence since they are not pushed on the operator stack, but we
     * have to override precedence() so we assign the lowest precedence level to RightParen.
     */
    @Override
    public int precedence() {
        return 1;
    }

    /**
     * See comments in precedence().
     */
    @Override
    public int stackPrecedence() {
        return 1;
    }

}