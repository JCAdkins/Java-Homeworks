// Program: TestException.java
// Author: Gary R. Smith
// Date Written:

/* Abstract: This program tests the DeductionTypeException. */

package exceptionhandling;

// Imports
import javax.swing.*;

public class TestException
{
    //  main method.
    public static void main(String[] args)
    {
        // Get the deduciton type.
        char deductionType = getDeductionType();
        System.out.println("Deduction type :" + deductionType);
    }

    // This method returnes a dedcution code as a char data type.
    public static char getDeductionType()
    {
        return Character.toUpperCase(testDeductionType().charAt(0));
    }

    //  This methods checks the deduction type and if incorrect, keeps prompting
    //  the user until they enter an correct value.
    public static String testDeductionType()
    {
        String inputString = " ";
        try
        {
            inputString = displayDialogDeductionType();
            if(inputString==null)
            {
                //  Return an blank string.
                inputString=" ";
            }
            else
            {
                CheckField.DeductionType(inputString);
            JOptionPane.showMessageDialog(null, "Deduction type is valid.",
                "Deduction Type", JOptionPane.INFORMATION_MESSAGE);
            }
        }
        catch (DeductionTypeException e)
        {
            //  Keep displaying the input dialog box until a good entry is made.
            inputString = testDeductionType();
        }
        return inputString;
    }

    //  Displays the dialog box and returns a string.
    public static String displayDialogDeductionType()
    {
        String inputString = JOptionPane.showInputDialog(null,
                "Enter a dedcution type (N, F, P)",
                "Dedcution Type Validator",
                JOptionPane.QUESTION_MESSAGE);
        return inputString;
    }
}
