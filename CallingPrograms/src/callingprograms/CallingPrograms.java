//  Program: CallingPrograms.java
//  Author: Gary R. Smith
//  Date Written: 11/28/2012

/*  Abstract: This program calls two Java program with main methods.  */

package callingprograms;

public class CallingPrograms 
{
    private static MyForm myForm;
    
    //  Main method.
    public static void main(String[] args) 
    {
        /*  Here we will execute two programs with main methdos.  Because the
            program's methods are public static, we can call them wothout an 
            instance of the class.  Note, main receives arguments so I am just
            passing the args array from this main method to the other programs.
        */
        InvokedProgram1.main(args);
        InvokedProgram2.main(args); 
        
        //  Creating an instance of a form.
        myForm = new MyForm(null, true);
        myForm.setVisible(true);
        
        //  Gets data from teh form.
        System.out.println(myForm.txtName.getText());
        
        //  Running a form.  In this case, you do not have access to the
        //  form objects and their data.  Good for menu programs like this.
        MyForm.main(args);
        
    }
}