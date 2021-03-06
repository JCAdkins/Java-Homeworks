//**************************************************************************************************
// CLASS: SubOperator
//
// DESCRIPTION
// The SubOperator class for Project 4. Evaluates subtractions.
//
// AUTHOR
// GROUP: 26
// AUTHOR 1: Jordan Adkins, jcadkin2, jcadkin2@asu.edu
// Author 2: Cody Surwic, csurwic, csurwic@asu.edu
// AUTHOR 3: Samantha Houghton, slhought, slhought@asu.edu
//**************************************************************************************************

/**
 * Represents the subtraction operator which is a specific type of binary operator.
 */
public class SubOperator extends BinaryOperator {

        public SubOperator() {
        }

        /**
         * Returns the sum of the left-hand side operand and the right-hand side operand.
         */
        @Override
        public Operand evaluate(Operand pLhsOperand, Operand pRhsOperand) {
                return new Operand(pLhsOperand.getValue() - pRhsOperand.getValue());
        }

        /**
         * Returns the normal precedence level of this operator.
         */
        @Override
        public int precedence() {
                return 2;
        }

        /**
         * Returns the precedence level of this operator when on it is on the operator stack.
         */
        @Override
        public int stackPrecedence() {
                return 2;
        }
}