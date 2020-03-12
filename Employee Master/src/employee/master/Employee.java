/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package employee.master;

/**
 *
 * @author The_B
 */
public class Employee {                               /* Creates class Employee and then creates the private components */
    private int employeeNumber;                       /* employeeNumber, depNumber, lastName, firstName, payType */
    private int depNumber;                            /* hourlyRate, TMStatus, numExemptions, SWPercentage, grossEarning, */
    private String lastName;                          /* fedTaxes, SSTaxes, medTaxes, stateTaxes, ytdDeductions */
    private String firstName;                         /* dedCode(1-3) and dedVal(1-3).    */
    private char payType;
    private double hourlyRate;
    private char TMStatus;
    private int numExemptions;
    private double SWPercentage;
    private double grossEarning;
    private double fedTaxes;
    private double SSTaxes;
    private double medTaxes;
    private double stateTaxes;
    private double ytdDeductions;
    private char dedCode1;
    private double dedVal1;
    private char dedCode2;
    private double dedVal2;
    private char dedCode3;
    private double dedVal3;
    
    public Employee(){                          /* Employee constructor */
        
    }
    public int getemployeeNumber(){             /* The following getXXXX methods are the accessor methods so others can */
        return employeeNumber;                  /* view what is associated with Employee.XXXX */
    }
    public int getdepNumber(){
        return depNumber;
    }
    public String getlastName(){
        return lastName;
    }
    public String getfirstName(){
        return firstName;
    }
    public char getpayType(){
        return payType;
    }
    public double gethourlyRate(){
        return hourlyRate;
    }
    public char getTMStatus(){
        return TMStatus;
    }
    public int getnumExceptions(){
        return numExemptions;
    }
    public double getSWPercentage(){
        return SWPercentage;
    }
    public double getgrossEarning(){
        return grossEarning;
    }
    public double getfedTaxes(){
        return fedTaxes;
    }
    public double getSSTaxes(){
        return SSTaxes;
    }
    public double getmedTaxes(){
        return medTaxes;
    }
    public double getstateTaxes(){
        return stateTaxes;
    }
    public double getytdDeductions(){
        return ytdDeductions;
    }
    public char getdedCode1(){
        return dedCode1;
    }
    public double getdedVal1(){
        return dedVal1;
    }
    public char getdedCode2(){
        return dedCode1;
    }
    public double getdedVal2(){
        return dedVal1;
    }
    public char getdedCode3(){
        return dedCode1;
    }
    public double getdedVal3(){
        return dedVal1;
    }
    public void setemployeeNumber(int val){                 /* The Following setXXXX methods are methods others can use */
        if (val > 0){
        employeeNumber = val;                               /* to set a comoponent of Employee.XXXX  */
        }else
            System.out.println("Invalid Entry. Employee number not set.");
    }
    public void setdepNumber(int val){
        if (val > 0){
        depNumber = val;
        }else
                System.out.println("Invalid entry. Department number not set.");
    }
    public void setlastName(String val){
        this.lastName = val;
    }
    public void setfirstName(String val){
        firstName = val;
    }
    public void setpayType(char val){
       if (val == 'H' || val == 'S'){                       /* Sets payType to Val if val is char 'H' or 'S' */
           payType = val;
       }else 
           System.out.println("Invalid character input. Pay type not set");
    }
    public void sethourlyRate(double val){
        if (hourlyRate >= 0){                               /* Ensures hourly rate is not negative */
            hourlyRate = Round(val);
        }else
            System.out.println("Hourly rate must be positive.");
    }
    public void setTMStatus(char val){
        if (val == 'S' || val == 'M'){                      /* Sets TMStatus to val if val is a valid char 'S' or 'M' */
        TMStatus = val;
    }else 
            System.out.println("Invalid entry. Tax marital status not set");
    }
    public void setnumExemptions(int val){
        if (val >= 0 && val <= 99){                         /* Ensures exemptions are 0-99 */
        numExemptions = val;
    }else
            System.out.println("Number of Exemptions must be 0-99");
    }
    public void setSWPercentage(double val){
        if (val >= 0 && val <= .9999){                      /* Ensures SWPercentage is 0-.9999 and then rounds it to four decimals */
        SWPercentage = Round(val*100)/100;
        }else
            System.out.println("Invalid Entry. State withholding percentage not set.");
    }
    public void setgrossEarning(double val){
        if (val >= 0 && val <= 99999999.99){                /*Ensures grossEarning is between 0-99999999.99 and then rounds to two decimals */
        grossEarning = Round(val);
        }else
            System.out.println("Invalid Entry. Gross earnings not set.");
    }
    public void setfedTaxes(double val){
        if (val >= 0 && val <= 99999999.99){                /* Ensures fedTaxes is between 0-99999999.99 and rounds to two decimals */
        fedTaxes = Round(val);
        }else
            System.out.println("Invalid Entry. Federal taxes not set.");
    }
    public void setSSTaxes(double val){
        if (val >= 0 && val <= 99999999.99){                /* Ensures SSTaxes is between 0-99999999.99 and rounds to two decimals */
        SSTaxes = Round(val);
        }else
            System.out.println("Invalid Entry. Social security taxes not set.");
    }
    public void setmedTaxes(double val){
        if (val >= 0 && val <= 99999999.99){                /* Ensures medTaxes is between 0-99999999.99 and rounds to two decimals */
        medTaxes = Round(val);
        }else
            System.out.println("Invalid Entry. Medicare taxes not set.");
    }
    public void setstateTaxes(double val){
        if (val >= 0 && val <= 99999999.99){                /* Ensures stateTaxes is between 0-99999999.99 and rounds to two decimals. */
        stateTaxes = Round(val);
        }else
            System.out.println("Invalid Entry. State taxes not set.");
    }
    public void setytdDeductions(double val){
        if (val >= 0 && val <= 99999999.99){               /* Ensures ytdDeductions is between 0-99999999.99 and roudns to two decimals */
        ytdDeductions = Round(val);
        }else
            System.out.println("Invalid Entry. Year-to-date deductions not set.");
    }
    public void setdedVal1(double val){                     /* Allows user to enter correct value for dedVal1 depending on dedCode1 */
        switch (dedCode1) {
            case 'F':
                if (val >= 0 && val <= 99999.99){
                    dedVal1 = Round(val);
                }else
                    System.out.println("Invalid Entry. Deduction value 1 not set.");
                break;
            case 'P':
                if (val >= 0 && val <= .99){
                    dedVal1= Round(val);
                }else
                    System.out.println("Invalid Entry. Deduction value 1 not set.");
                break;
            case 'N':
                dedVal1 = 0;
                break;
            default:
                System.out.println("Invalid Entry. Deduction value 1 not set.");
                break;
        }
            
    }
    public void setdedCode1(char val){                      /* Ensures dedCode1 wills be set to either 'F', 'P' */
        if (val == 'F' || val == 'P' || val == 'N'){
        dedCode1 = val;
        }else
            System.out.println("Invalid Entry. Deduction code 1 not set.");
    }
    public void setdedVal2(double val){                     /* Allows user to enter correct value for dedVal2 depending on dedCode2 */
        switch (dedCode2) {
            case 'F':
                if (val >= 0 && val <= 99999.99){
                    dedVal2 = Round(val);
                }else
                    System.out.println("Invalid Entry. Deduction value 2 not set.");
                break;
            case 'P':
                if (val >= 0 && val <= .99){
                    dedVal2= Round(val);
                }else
                    System.out.println("Invalid Entry. Deduction value 2 not set.");
                break;
            case 'N':
                dedVal2 = 0;
                break;
            default:
                System.out.println("Invalid Entry. Deduction value 2 not set.");
                break;
        }
            
    }
    public void setdedCode2(char val){                       /* Ensures dedCode2 wills be set to either 'F', 'P' */
        if (val == 'F' || val == 'P' || val == 'N'){
        dedCode2 = val;
        }else
            System.out.println("Invalid Entry. Deduction code 2 not set.");
    }
    public void setdedVal3(double val){                        /* Allows user to enter correct value for dedVal1 depending on dedCode1 */
        switch (dedCode3) {
            case 'F':
                if (val >= 0 && val <= 99999.99){
                    dedVal3 = Round(val);
                }else
                    System.out.println("Invalid Entry. Deduction value 3 not set.");
                break;
            case 'P':
                if (val >= 0 && val <= .99){
                    dedVal3= Round(val);
                }else
                    System.out.println("Invalid Entry. Deduction value 3 not set.");
                break;
            case 'N':
                dedVal3 = 0;
                break;
            default:
                System.out.println("Invalid Entry. Deduction value 3 not set.");
                break;
        }
            
    }
    public void setdedCode3(char val){                       /* Ensures dedCode3 wills be set to either 'F', 'P' */
        if (val == 'F' || val == 'P' || val == 'N'){
        dedCode3 = val;
        }else
            System.out.println("Invalid Entry. Deduction code 3 not set.");
    }
    
    public String getEmployee(){                            /* Method that returns a String containing all pertinent information regarding Employee */
       String retEmployee = "Employee number: " + employeeNumber + "\tDepartment number: " + depNumber +
              "\tName: " + lastName + ", " + firstName + "\n\nPay Type: " + payType + "\tHourly Rate: " +
               hourlyRate + "\tTax Marital Status: " + TMStatus + "\tExemptions: " + numExemptions +
               "\nState Withholding Percentage: " + SWPercentage*100 + "\tGross Earnings: $" + grossEarning +
               "\tFederal Taxes: $" + fedTaxes + "\nSocial Security Taxes: $" + SSTaxes + "\tMedicare Taxes: $" +
               medTaxes + "\nState Taxes: $" + stateTaxes + "\tYTD Deductions: $" + ytdDeductions + 
               "\nDeduction Code 1: " + dedCode1 + "\tDeduction Value: $" + dedVal1 + "\nDeduction Code 2: " +
               dedCode2 + "\tDeduction Value: " + dedVal2 + "\nDeduction Code 3: " + dedCode3 + "\tDeduction Value: $"
               + dedVal3;
        return retEmployee;
        
    }
    
    
     private static double Round(double input){ // this will round to two decimal places
        input = input * 100;
        input = Math.round (input);
        input = input / 100; 
        return input;  
     }
    
}
