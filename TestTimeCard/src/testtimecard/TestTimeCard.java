/*
Author: Jordan Adkins
Date: 3/4/2018
Abstract: An application that will use TimeCard class to input an employee name, number
and clock-in and clock out dates. Then displays all input data as well as calculate elasped time.
 */
package testtimecard;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 *
 * @author The_B
 */
public class TestTimeCard {

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws java.io.IOException {
        String sName="";
        int sNum=0;
        
        BufferedReader keyboard =   new BufferedReader(new InputStreamReader(System.in));       // create new instance of buffered reader

        
        while (true){                           // outer loop to check whether user wants to input new timecard
            System.out.println("\nPlease enter employee name. To exit enter 'Exit'.");
              sName = keyboard.readLine();
              if ("Exit".equals(sName)){
                  System.exit(0);
              }
           System.out.println("Enter employee number.");            // input employee number
                do{
                 sNum = Integer.parseInt(keyboard.readLine());
                }while(sNum<0);
                TimeCard TimeCardTest = new TimeCard(sName, sNum);
           for (int day = 0; day<14; day++){                        // inputs clock-in
               System.out.println("\nDay " + (day +1) + " clock-in (XX:XX): ");
               TimeCardTest.setsclockIn(day, keyboard.readLine());
           }  
           for (int day = 0; day<14; day++){            // inputs clock-out
               System.out.println("\nDay " + (day + 1) + " clock-out (XX:XX): ");
               TimeCardTest.setsclockOut(day, keyboard.readLine());
           }
           TimeCardTest.calculateElapsedTimes();            // calls calculateElapsedTimes()
           System.out.print(TimeCardTest.displayData());        //displays all data on screen
           
        }
    }
}


        
        
    
    
    
    
    

