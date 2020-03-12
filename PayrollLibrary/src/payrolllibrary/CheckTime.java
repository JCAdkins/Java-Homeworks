/*
Program: CheckTime
Author: Jordan Adkins
Date: 4/7/18
Abstract: Have user input a Time. Check to see if the Time entered is valid. If it isn't the user can re-enter or cancel.
          If Time entered is valid confirm to user that it is valid.
 */
package payrolllibrary;

import javax.swing.JOptionPane;

public class CheckTime {
    
    public static void main(String[] args) {
      String Time = getTime();                  //calls getTime() method and sets Time to what is returned
      System.out.println("Time: " + Time);      // display Time
        
    }       
    public static String getTime(){
        String Time;
        try {                                           
            Time = JOptionPane.showInputDialog(null,        //have user enter Time
                "Enter a time (00:00-23:59):",
                "Time Format Validator",
                JOptionPane.QUESTION_MESSAGE);
            if (Time == null){                              //if user clicks cancel button return a blank space
                JOptionPane.showMessageDialog(null, "No Time Entered.",
               "", JOptionPane.INFORMATION_MESSAGE);
                return " ";
            }
            CheckField.IsValidTime(Time);                   //check to make sure time entered is valid
            JOptionPane.showMessageDialog(null, "Time Format is valid.",            //confirm to user that entry is valid
               "", JOptionPane.INFORMATION_MESSAGE);

    } catch(TimeFormatException e){
            Time = getTime();           //recurse until input is valid
        }
return Time;
    }
}
