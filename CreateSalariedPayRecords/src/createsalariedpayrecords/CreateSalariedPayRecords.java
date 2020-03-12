/*
Author: Jordan Adkins
Date: 4/28/18
Abstract: This program displays the pay records of all salaried employees.
 */
package createsalariedpayrecords;
import java.io.FileNotFoundException;
import java.io.IOException;
import javax.swing.JOptionPane;
import payrolllibrary.*;
/**
 *
 * @author jordanadkins
 */
public class CreateSalariedPayRecords {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // creates the FileEmployee and FilePaySum classes with the correct file names
        FileEmployee newEmployee = new FileEmployee("/Users/jordanadkins/NetBeansProjects/CreateSalariedPayRecords/Data/employee.csv");
        FilePaySum newPaySum = new FilePaySum("SalariedEmployees.csv");
       
        
        try{                                            //opens the files
            newEmployee.openRead();
            newPaySum.openOutput();
        while (newEmployee.isEOF==false){                  //loops through the documents until the EOF is reached
            newEmployee.readRecord();
            if ((newEmployee.isEOF)==false){               
               if (newEmployee.newEmployee.getpayType()=='S'){          //if employee is Salaried insert their numbers into the paysum 
                PaySum tempPaySum = new PaySum(newEmployee.newEmployee.getemployeeNumber(), 80, 0, 0, 0, 0 );
               
               newPaySum.newPaySum = tempPaySum;
               newPaySum.writeRecord();                         // write to the created file
                System.out.println(newEmployee.newEmployee.displayData() + "\n");       //output all data
                    System.out.println(newPaySum.newPaySum.displayData() + "\n");       // output all data
               }
            }
        }
        newPaySum.close();          //close paysum file
        newEmployee.close();        //close employee file
        }
        catch(FileNotFoundException err){           //catch if file wasn't found
            JOptionPane.showMessageDialog(null, "File Not Found.");
        }catch(IOException err){                    // catch if theres an I/O error
            JOptionPane.showMessageDialog(null, "IOException occurred.");
        }
        
        
        
    }
    
}
