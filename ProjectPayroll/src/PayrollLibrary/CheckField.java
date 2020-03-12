/*
Author: Jordan Adkins  
Date: 4/7/18
Abstract: This class contains the logic that will ensure the time entered is valid.
 */
package PayrollLibrary;

/**
 *
 * @author jordanadkins
 */
public class CheckField {
    
    public static void IsValidTime(String time) throws TimeFormatException {
        if (time.length()==4){                  //If time entered is x:xx format add a 0 to make it xx:xx format just so i don't have to add logic for x:xx format
           time = "0" + time;           
        }
        
        if (time.length()!=5){              //checks to make sure time entered is correct length and throws exception if it isn't
            throw (new TimeFormatException("Time length invalid."));   
        } else if (time.charAt(2)!=':'){            //If length=5 and : isn't in correct spot throw an exception
                throw (new TimeFormatException());
        }
   
    for (int loc=0; loc<5; loc++){      //this will loop through each location of the String time
        if (loc==2){                    //location 2 will be skipped since we already know it's a :
            loc++;
        }
    if (time.charAt(loc)!= '0' && time.charAt(loc)!= '1' && time.charAt(loc)!= '2'&& time.charAt(loc)!= '3'&& time.charAt(loc)!= '4'&& time.charAt(loc)!= '5'
            && time.charAt(loc)!= '6'&& time.charAt(loc)!= '7'&& time.charAt(loc)!= '8'&& time.charAt(loc)!= '9'){  // if the location doesn't contain a number then throw an exception
        throw (new TimeFormatException());
      
    }
    }
    if (PRLib.getMinutes(time)>59 || PRLib.getMinutes(time)<0){     //gets the minutes and ensures they are from 0-59, throws exception if not
        throw (new TimeFormatException());
    } else if (PRLib.getHours(time)<0 || PRLib.getHours(time)>23){  //gets the hours and ensures they are from 0-12, throws exception if not
        throw (new TimeFormatException());
    }
    }
    
        
        
       
        
    }
        
     
       

