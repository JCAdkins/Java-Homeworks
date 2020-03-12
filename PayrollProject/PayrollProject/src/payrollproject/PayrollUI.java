/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package payrollproject;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author jordanadkins
 */
public class PayrollUI extends JFrame{
    public PayrollUI(String name) {
        super(name);
        setResizable(false);
        
    }
  //sets column names at the top of the frame
    public void addColumnNamesToPane(Container pane) {
        JPanel compsToExperiment = new JPanel();
        GridLayout layout = new GridLayout(1,10);
        compsToExperiment.setLayout(layout);

        //Add labels/columns to window
        compsToExperiment.add(new JLabel("Emp Numb"));
        compsToExperiment.add(new JLabel("Emp Dept"));
        compsToExperiment.add(new JLabel("Column3"));
        compsToExperiment.add(new JLabel("Column4"));
        compsToExperiment.add(new JLabel("Column5"));
        compsToExperiment.add(new JLabel("Column6"));
        compsToExperiment.add(new JLabel("Column7"));
        compsToExperiment.add(new JLabel("Column8"));
        compsToExperiment.add(new JLabel("Column9"));
        compsToExperiment.add(new JLabel("Column10"));
        pane.add(compsToExperiment, BorderLayout.NORTH);  
        
    }

    //might want to pass in employee
    public void addEmployeeToPane(Container pane, PaySum paySumTest) {
        JPanel compsToExperiment = new JPanel();
        GridLayout layout = new GridLayout(1,1);
        compsToExperiment.setLayout(layout);  
        //Add buttons to experiment with Grid Layout
        compsToExperiment.add(new JLabel(paySumTest.displayPaySum()));
        
        
       
        pane.add(compsToExperiment);  
    }
}
