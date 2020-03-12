//  Program: InvokedProgram2.java
//  Author: Gary R. Smith
//  Date Written: 11/28/2012

/*  Abstract: This progam will be called from another java main program.  */

package callingprograms;

import javax.swing.JOptionPane;

public class InvokedProgram2 
{
    //  Main method.
    public static void main(String[] args) 
    {
        System.out.println("Hi from program 2!");
                
        //  Not a bad idea to display a message that the program has finished.
        JOptionPane.showMessageDialog(null, "Program 2 has ended", "Operator Message",
                JOptionPane.INFORMATION_MESSAGE);
    }
}