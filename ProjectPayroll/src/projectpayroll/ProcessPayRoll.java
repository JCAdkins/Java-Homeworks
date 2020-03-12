/*
Author: Jordan Adkins
Date: 4/28/18
Abstract: This program processes the payroll summary and employee files to output the earnings file.
 */

package projectpayroll;
import PayrollLibrary.*;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class ProcessPayRoll {

    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args) {
        
        //create new files for the objects from the specified files
        FilePaySum newFilePaySum = new FilePaySum("/Users/jordanadkins/NetBeansProjects/ProjectPayroll/PayrollSummaries.csv");
        FileEmployee newFileEmployee = new FileEmployee("/Users/jordanadkins/NetBeansProjects/ProjectPayroll/ProjectFiles/employee.csv");
        FileShiftRates newFileShiftRates = new FileShiftRates("/Users/jordanadkins/NetBeansProjects/ProjectPayroll/ProjectFiles/shift.csv");
        FileEarnings newFileEarnings = new FileEarnings("EmployeeEarnings.csv");
        
        //set check number
        int checkNo = 305612;
        //create arraylist to store shift rates
        ArrayList<ShiftRates> arrayShiftList = new ArrayList();
            
        
        
        
        
        try{                                           
            //opens the files
            newFileEmployee.openRead();
            newFilePaySum.openRead();
            newFileShiftRates.openRead();
            newFileEarnings.openOutput();
            
            //loop through the shift rate entries as long as it's not the end of file
            while (newFileShiftRates.isEOF==false){
            newFileShiftRates.readRecord();
            if (newFileShiftRates.isEOF==false)
            arrayShiftList.add(newFileShiftRates.newShiftRates);        //adds the shift rate to the array list
           }
            

        while (newFileEmployee.isEOF==false){                  //loops through the documents until the EOF is reached
            newFileEmployee.readRecord();
            if (newFileEmployee.isEOF==false){
            newFilePaySum.readRecord();
            
            //fill the newFileEarnings.newEarnings object with the information from the newFilePaySum.newPaySum and newFileEmployee.newEmployee objects
            newFileEarnings.newEarnings.setdepNumber(newFileEmployee.newEmployee.getdepNumber());
            newFileEarnings.newEarnings.setempNumber(newFilePaySum.newPaySum.getempNumber());
            newFileEarnings.newEarnings.setregHours(newFilePaySum.newPaySum.getregHours());
            newFileEarnings.newEarnings.setovertimeHours(newFilePaySum.newPaySum.getovertimeHours());
            newFileEarnings.newEarnings.setshift2Hours(newFilePaySum.newPaySum.getshift2Hours());
            newFileEarnings.newEarnings.setshift3Hours(newFilePaySum.newPaySum.getshift3Hours());
            newFileEarnings.newEarnings.setweekendHours(newFilePaySum.newPaySum.getweekendHours());
            newFileEarnings.newEarnings.setregPay(newFilePaySum.newPaySum.getregHours()*newFileEmployee.newEmployee.gethourlyRate());
            newFileEarnings.newEarnings.setovertimePay(newFilePaySum.newPaySum.getovertimeHours()*newFileEmployee.newEmployee.gethourlyRate()*1.5f);
            newFileEarnings.newEarnings.setshift2Pay(newFilePaySum.newPaySum.getshift2Hours()*PRLib.get2ndShiftRate(arrayShiftList).getshiftRate());
            newFileEarnings.newEarnings.setshift3Pay(newFilePaySum.newPaySum.getshift3Hours()*PRLib.get3rdShiftRate(arrayShiftList).getshiftRate());
            newFileEarnings.newEarnings.setweekendPay(newFilePaySum.newPaySum.getweekendHours()*PRLib.getweekendShiftRate(arrayShiftList).getshiftRate());
            newFileEarnings.newEarnings.setgrossPay(PRLib.grossPay(newFileEarnings.newEarnings.getregPay(), newFileEarnings.newEarnings.getovertimePay(), newFileEarnings.newEarnings.getshift2Pay(), newFileEarnings.newEarnings.getshift3Pay(), newFileEarnings.newEarnings.getweekendPay()));
            newFileEarnings.newEarnings.setfedWithholding(PRLib.fwTax(newFileEarnings.newEarnings.getgrossPay(), newFileEmployee.newEmployee.getTMStatus(), newFileEmployee.newEmployee.getnumExceptions()));
            newFileEarnings.newEarnings.setssWithholding(PRLib.ssTax(newFileEarnings.newEarnings.getgrossPay(), newFileEmployee.newEmployee.getytdgrossEarning(), newFileEmployee.newEmployee.getytdSSTaxes()));
            newFileEarnings.newEarnings.setmedWithholding(PRLib.medicareTax(newFileEarnings.newEarnings.getgrossPay()));          
            newFileEarnings.newEarnings.setstateWithholding(PRLib.stateTax(newFileEarnings.newEarnings.getgrossPay(), newFileEmployee.newEmployee.getSWPercentage()));
            newFileEarnings.newEarnings.setvolDeductions(PRLib.calcDeduction(newFileEarnings.newEarnings.getgrossPay(), newFileEmployee.newEmployee.getdedCode1(), newFileEmployee.newEmployee.getdedVal1())+PRLib.calcDeduction(newFileEarnings.newEarnings.getgrossPay(), newFileEmployee.newEmployee.getdedCode2(), newFileEmployee.newEmployee.getdedVal2())+PRLib.calcDeduction(newFileEarnings.newEarnings.getgrossPay(), newFileEmployee.newEmployee.getdedCode3(), newFileEmployee.newEmployee.getdedVal3()));
            newFileEarnings.newEarnings.setnetPay(PRLib.calcNetPay(newFileEarnings.newEarnings.getgrossPay(), newFileEarnings.newEarnings.getfedWithholding(), newFileEarnings.newEarnings.getssWithholding(), newFileEarnings.newEarnings.getmedWithholding(), newFileEarnings.newEarnings.getstateWithholding(), PRLib.calcDeduction(newFileEarnings.newEarnings.getgrossPay(), newFileEmployee.newEmployee.getdedCode1(), newFileEmployee.newEmployee.getdedVal1()), PRLib.calcDeduction(newFileEarnings.newEarnings.getgrossPay(), newFileEmployee.newEmployee.getdedCode2(), newFileEmployee.newEmployee.getdedVal2()), PRLib.calcDeduction(newFileEarnings.newEarnings.getgrossPay(), newFileEmployee.newEmployee.getdedCode3(), newFileEmployee.newEmployee.getdedVal3())));
            newFileEarnings.newEarnings.setcheckDate("5/6/2018");
            newFileEarnings.newEarnings.setcheckNumber(checkNo);
            checkNo++; //increase check number by one
            newFileEarnings.writeRecord();          //write the newEarnings to the file
        }
        }
        newFileEmployee.close();        //close the files
        newFileEarnings.close();
        newFileShiftRates.close();
        newFilePaySum.close();
        }
        
        catch(FileNotFoundException err){           //catch if file wasn't found
            JOptionPane.showMessageDialog(null, "File Not Found.");
        }catch(IOException err){                    // catch if theres an I/O error
            JOptionPane.showMessageDialog(null, "IOException occurred.");
        }
        
        
        
    }
    
   
    
    
    
    
    }
