/*
Author: Jordan Adkins
Date: 4/7/18
Abstract: This class handles the exceptions and displays the error messages generated by any exceptions.
 */
package PayrollLibrary;

import javax.swing.JOptionPane;

/**
 *
 * @author jordanadkins
 */
public class TimeFormatException extends Exception {
    private static final String ERROR_MESSAGE = "Invalid time format entered.";     //Sets error message
    private static final String ERROR_TITLE = "Input Error Occured";            //sets error title
    
    public TimeFormatException(){                   //constructor for TimeFormatException
        super(ERROR_MESSAGE);
        displayErrorMessage(ERROR_MESSAGE, ERROR_TITLE);
    }
 
    public TimeFormatException(String ERROR_MESSAGE){           //Overloaded Constructor for TimeFormatException
        super(ERROR_MESSAGE);
        displayErrorMessage(ERROR_MESSAGE, ERROR_TITLE);
    }
    
    
    
    
    
private static void displayErrorMessage(String message, String title)       //Method that will display appropriate error message
    {
        JOptionPane.showMessageDialog(null,
                message,
                title,
                JOptionPane.ERROR_MESSAGE);
    }
}