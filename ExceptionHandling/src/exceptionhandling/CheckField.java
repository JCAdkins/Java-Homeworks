// Program: Validate.java
// Author: Gary R. Smith
// Date Written: 

/*  Abstract: This class contains methods to validate fields.  Since the methods
    are "public static", they can be called from any program without createing an
    instance of this class.  */
package exceptionhandling;

public class CheckField 
{
    //  Validates the deduction code and throws an error if it is invalid.
    public static void DeductionType(String dedType) 
            throws DeductionTypeException
    {
        boolean isValid = true;
        // Test the length.  Must be a single character.
        if (dedType.length() !=1)
        {
            throw (new DeductionTypeException("Deduction type length error."));
        }
        else
        {
            //  Deduction type can only be 'N', 'F', or 'P'
            switch (Character.toUpperCase(dedType.charAt(0)))
            {
                case 'N':       // Valid
                case 'F':       // Valid
                case 'P':       // Valid
                    break;
                default:
                    throw (new DeductionTypeException());
            }
        }
    }  
}
