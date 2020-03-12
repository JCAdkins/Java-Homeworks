/*
Author: Jordan Adkins
Date: 4/28/18
Abstract: This program reads the employee and timecard file and uses them to create the payroll summaries file.
 */
package projectpayroll;
import PayrollLibrary.*;
import java.io.FileNotFoundException;
import java.io.IOException;
import javax.swing.JOptionPane;
/**
 *
 * @author jordanadkins
 */
public class ProcessTimeCards {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // creates the FileEmployee and FilePaySum classes with the correct file names
        FileEmployee newEmployee = new FileEmployee("/Users/jordanadkins/NetBeansProjects/ProjectPayroll/ProjectFiles/employee.csv");
        FilePaySum newPaySum = new FilePaySum("PayrollSummaries.csv");
        FileTimeCard newFileTimeCard = new FileTimeCard("/Users/jordanadkins/NetBeansProjects/ProjectPayroll/ProjectFiles/timecard.csv");
        
        
        try{                                         
               //opens the files
            newEmployee.openRead();
            newFileTimeCard.openRead();
            newPaySum.openOutput();
            
             //loops through the documents until the EOF is reached
        while (newEmployee.isEOF==false){  
            float tempOt= 0;        //value used to calculate the second weeks hours worked
            
            newEmployee.readRecord();       //read new line from th employee file
            
            if ((newEmployee.isEOF)==false){    //as long as not end of file             
               
                 //if employee is Salaried insert their numbers into the paysum then write into the file
                if (newEmployee.newEmployee.getpayType()=='S'){          
                PaySum tempPaySum = new PaySum(newEmployee.newEmployee.getemployeeNumber(), 80, 0, 0, 0, 0 );
               
               newPaySum.newPaySum = tempPaySum;
               newPaySum.writeRecord();                         // write to the created file
               } 
                
                //if employee is hourly calculate the hours worked
                else if (newEmployee.newEmployee.getpayType()=='H'){
                   float shift2Hours = 0, shift3Hours = 0, shift1Hours = 0, weekendHours = 0, regHours = 0, overtimeHours = 0; //set variables for paysum
                       
                        newFileTimeCard.readRecord();   //read from the time card
                        
                        //if the employee numbers from the timecard do not matchup with the employee file read another line until they do
                        while (newEmployee.newEmployee.getemployeeNumber()!=newFileTimeCard.newTimeCard.getempNumber()){
                            newFileTimeCard.readRecord();
                        }
                       if (newFileTimeCard.isEOF==false){
                       for (int day = 0; day<14; day++){            //loop through the days to calculate shift 1, 2, and 3 hours
                           
                           shift1Hours = shift1Hours + TimeCard.calculateShift(08.00f, 16.0f, newFileTimeCard.newTimeCard.getfclockIn(day), newFileTimeCard.newTimeCard.getfclockOut(day), 1);
                           shift2Hours = shift2Hours + TimeCard.calculateShift(16.00f, 0.00f, newFileTimeCard.newTimeCard.getfclockIn(day), newFileTimeCard.newTimeCard.getfclockOut(day), 2);
                           shift3Hours = shift3Hours + TimeCard.calculateShift(0.00f, 8.00f, newFileTimeCard.newTimeCard.getfclockIn(day ), newFileTimeCard.newTimeCard.getfclockOut(day), 3);
                           
                           //if the day is a friday (day 4 or 11) add hours after midnight to weekend hours
                           if (day==4 || day ==11){
                               if (newFileTimeCard.newTimeCard.getfclockIn(day)>newFileTimeCard.newTimeCard.getfclockOut(day)){
                                   weekendHours += newFileTimeCard.newTimeCard.getfclockOut(day);
                               }
                           }
                           //if day is saturday add whole clock time to weekend hours
                           if (day==5 || day==12){
                               if (newFileTimeCard.newTimeCard.getfclockIn(day)<newFileTimeCard.newTimeCard.getfclockOut(day)){
                                   weekendHours += newFileTimeCard.newTimeCard.getfclockOut(day) - newFileTimeCard.newTimeCard.getfclockIn(day);
                               } else if (newFileTimeCard.newTimeCard.getfclockIn(day)>newFileTimeCard.newTimeCard.getfclockOut(day)){
                                   weekendHours += (newFileTimeCard.newTimeCard.getfclockOut(day) + 24) - newFileTimeCard.newTimeCard.getfclockIn(day);
                               }
                               
                           }
                           // set weekendhours and calculate weeks hours to determine regular hours and OT hours worked
                           if (day==6 || day==13){        
                               if (newFileTimeCard.newTimeCard.getfclockIn(day)<newFileTimeCard.newTimeCard.getfclockOut(day)){
                                   weekendHours += newFileTimeCard.newTimeCard.getfclockOut(day) - newFileTimeCard.newTimeCard.getfclockIn(day);
                               } else if (newFileTimeCard.newTimeCard.getfclockIn(day)>newFileTimeCard.newTimeCard.getfclockOut(day)){
                                   weekendHours += 24 - newFileTimeCard.newTimeCard.getfclockIn(day);
                               }
                                if (day==6 && (shift1Hours + shift2Hours + shift3Hours)>40){
                                    regHours += 40;
                                    overtimeHours += (shift1Hours + shift2Hours + shift3Hours) - 40;
                                    tempOt = (shift1Hours + shift2Hours + shift3Hours);
                                } else if (day==6 && shift1Hours + shift2Hours + shift3Hours<=40){
                                    regHours += shift1Hours + shift2Hours + shift3Hours;
                                    tempOt = (shift1Hours + shift2Hours + shift3Hours);
                                } else if (day==13 && ((shift1Hours + shift2Hours + shift3Hours)- tempOt)> 40){
                                    regHours += 40;
                                    overtimeHours += ((shift1Hours + shift2Hours + shift3Hours) - tempOt) - 40;
                                } else if (day ==13 && ((shift1Hours + shift2Hours + shift3Hours)- tempOt)<= 40){
                                    regHours += (shift1Hours + shift2Hours + shift3Hours) - tempOt;
                                }
                            }
                       }   
                       //set the newPaySum.newPaySum equal to tempPaySum and then write it to file
                       PaySum tempPaySum = new PaySum(newEmployee.newEmployee.getemployeeNumber(), regHours, overtimeHours, shift2Hours, shift3Hours, weekendHours);
                       newPaySum.newPaySum = tempPaySum;
                       newPaySum.writeRecord();
                       }
                  
               
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
