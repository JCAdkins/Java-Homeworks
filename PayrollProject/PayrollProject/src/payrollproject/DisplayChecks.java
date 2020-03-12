/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package payrollproject;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

/**
 *
 * @author jordanadkins
 */
public class DisplayChecks {
    public static void main(String[] args) {
       SwingUtilities.invokeLater(new Runnable() {
        @Override
        public void run() {
            createAndShowGUI();
            }
        });
    } 
        private static void createAndShowGUI() {
        //Create and set up the window.
        PayrollUI frame = new PayrollUI("PayrollUI");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.addColumnNamesToPane(frame.getContentPane());      
        // for each employy record, add new panel/row to frame
        PaySum paySumTest = new PaySum();
    
    paySumTest.setempNumber(1122);
    paySumTest.setregHours(333);
    paySumTest.setovertimeHours(22);
    paySumTest.setshift2Hours(1.8f);
    paySumTest.setshift3Hours(3.4f);
    paySumTest.setweekendHours(11);
        frame.addEmployeeToPane(frame.getContentPane(), paySumTest);
        //Display the window.
        frame.pack();
        frame.setVisible(true);
    }    
}

