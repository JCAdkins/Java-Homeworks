//**************************************************************************************************
// CLASS: Operator
//
// DESCRIPTION
// The Operator class for Project 4. Abstract class for operators.
//
// AUTHOR
// GROUP: 26
// AUTHOR 1: Jordan Adkins, jcadkin2, jcadkin2@asu.edu
// Author 2: Cody Surwic, csurwic, csurwic@asu.edu
// AUTHOR 3: Samantha Houghton, slhought, slhought@asu.edu
//**************************************************************************************************

/**
 * Operator is the superclass of all binary and unary operators.
 */
public abstract class Operator extends Token{

    public abstract boolean isBinaryOperator();

    public abstract int precedence();

    public abstract int stackPrecedence();

}
