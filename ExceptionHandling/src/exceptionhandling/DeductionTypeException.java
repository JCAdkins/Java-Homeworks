// Program: DedcutionTypeException.java
// Author: Gary R. Smith
// Date Written: 11/4/2010

/* Abstract: This class determines if a deduction type is in error */
package exceptionhandling;

import javax.swing.*;

public class DeductionTypeException extends Exception
{
    //  Declarations
    private static final String ERROR_TITLE = "Deduction Type Error";
    private static final String ERROR_MESSAGE = "Invalid Deduciton Type!";
    
    //  Default constructor.
    public DeductionTypeException() 
    {
        super(ERROR_MESSAGE);
        displayErrorMessage(ERROR_MESSAGE, ERROR_TITLE);
    }
    
    //  Overloaded constructor for custom error message.
    public DeductionTypeException(String ERROR_MESSAGE) 
    {
        super(ERROR_MESSAGE);
        displayErrorMessage(ERROR_MESSAGE, ERROR_TITLE);
    }

    //  Displays a dialog box if an error occurs.
    private static void displayErrorMessage(String message, String title)
    {
        JOptionPane.showMessageDialog(null,
                message,
                title,
                JOptionPane.ERROR_MESSAGE);
    }
}