/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculateinvoice;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 *
 * @author jordanadkins
 */
public class CalculateInvoice {

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) 
            throws java.io.IOException {
        
        
        BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));     /* Call instance of bufferedreader */
    
        
        int numOfCustomers = 0, numOfItems = 0, a , b, c;                   /* Initialize variables numOfCustomer, numOfItems, a, b, c */
        
        System.out.println("How many customers? ");                         /* Ask how many customers and make sure it's positive */
        do{
            if (numOfCustomers<0){
                System.out.println("Customers can't be negative.");}
        numOfCustomers = Integer.parseInt(keyboard.readLine());
        } while (numOfCustomers<0);
        
        
        String cusName;
        int cusNumber;
        for (a = 0; a < numOfCustomers; a++){                           /* Set outter loop for number of customers */
        double subTotal = 0;                                            
        double cusTax = 0;                                              /* Set subTotal, cusTax,cusTotal and cusSavings vars */
        double cusTotal = 0;
        double cusSavings = 0;
            System.out.println("\n\nCustomer's Name: ");                /* Ask for name */
        cusName = keyboard.readLine();
        System.out.println("Customer Number:" );                        /* Ask for customer number */
        cusNumber = Integer.parseInt(keyboard.readLine());
        
        System.out.println("How many items?");                          /* Ask for number of items purchased; make sure its positive */
            do{
            if (numOfItems<0){
                System.out.println("Items can't be negative.");}
        numOfItems = Integer.parseInt(keyboard.readLine());
        } while (numOfItems<0);
       String[] itemName = new String[numOfItems];
       int[] itemQuant = new int[numOfItems];
       double[] itemPrice = new double[numOfItems];
            for (b=0; b < numOfItems; b++){                             /* Set inner loop to then prompt for input of item name, price and quantity */
                System.out.println("Item " + (b+1) +": ");
                    itemName[b] = keyboard.readLine();
                System.out.println("Price: ");
                    itemPrice[b] = Double.parseDouble(keyboard.readLine());
                System.out.println("Quantity: ");
                     itemQuant[b] = Integer.parseInt(keyboard.readLine());
            }
            System.out.println("\n+-------------------------------------------------------------------------+");  
            System.out.println("Customer Name: " + cusName + "\t\tCustomer Number: " + cusNumber);          /* Display name and number */                
            System.out.println("\nNumber of Items Purchased: " + numOfItems);                               /*Display number of items purchased */
            for (b=0; b<numOfItems; b++){                                                      /* Round subTotal and add items purchased to subtotal */
            subTotal = Round((itemPrice[b]*itemQuant[b])) + subTotal;
            }
            if (subTotal>=500){
                cusSavings = Round(subTotal *.05);
                subTotal = Round(subTotal - cusSavings);                                    /*Calculate savings and find new subtotal if there were savings*/
            }
            cusTax = Round(subTotal*.0825);                                                 /*Calculate taxes*/
            cusTotal = Round(subTotal + cusTax);                                            /*Calculate Total*/
            System.out.println("\nSubtotal: " + subTotal + "\t\tTax: " + cusTax + "\t\tTotal: " + cusTotal      /* Display invoice totals*/
            + "\nSavings: " + cusSavings);
            System.out.println("+-------------------------------------------------------------------------+");
            
            
        }
    
        
    }  
    private static double Round(double input){ // this will round to two decimal places
        input = input * 100;
        input = Math.round (input);
        input = input / 100; 
        return input;
        
    }     
        
        }

        
        
        
