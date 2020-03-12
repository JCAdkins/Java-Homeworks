/*
Author: Jordan Adkins
Abstract: This is the class that will be responsible for maintaining all the important information about employees. Their names,
tax marital status, year-to-date earnings and taxes, etc.
Date: 3/20/18
 */
package payrolllibrary;

/**
 *
 * @author jordanadkins
 */
public class Employee implements DisplayObject, Parser {
    private int employeeNumber;                       /* employeeNumber, depNumber, lastName, firstName, payType */
    private int depNumber;                            /* hourlyRate, TMStatus, numExemptions, SWPercentage, grossEarning, */
    private String lastName;                          /* fedTaxes, SSTaxes, medTaxes, stateTaxes, ytdDeductions */
    private String firstName;                         /* dedCode(1-3) and dedVal(1-3).    */
    private char payType;
    private float hourlyRate;
    private char TMStatus;
    private int numExemptions;
    private float SWPercentage;
    private float ytdgrossEarning;
    private float ytdfedTaxes;
    private float ytdSSTaxes;
    private float ytdmedTaxes;
    private float ytdstateTaxes;
    private float ytdDeductions;
    private char dedCode1;
    private float dedVal1;
    private char dedCode2;
    private float dedVal2;
    private char dedCode3;
    private float dedVal3;
    
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
    public float gethourlyRate(){
        return hourlyRate;
    }
    public char getTMStatus(){
        return TMStatus;
    }
    public int getnumExceptions(){
        return numExemptions;
    }
    public float getSWPercentage(){
        return SWPercentage;
    }
    public float getgrossEarning(){
        return ytdgrossEarning;
    }
    public float getfedTaxes(){
        return ytdfedTaxes;
    }
    public float getSSTaxes(){
        return ytdSSTaxes;
    }
    public float getmedTaxes(){
        return ytdmedTaxes;
    }
    public float getstateTaxes(){
        return ytdstateTaxes;
    }
    public float getytdDeductions(){
        return ytdDeductions;
    }
    public char getdedCode1(){
        return dedCode1;
    }
    public float getdedVal1(){
        return dedVal1;
    }
    public char getdedCode2(){
        return dedCode1;
    }
    public float getdedVal2(){
        return dedVal1;
    }
    public char getdedCode3(){
        return dedCode1;
    }
    public float getdedVal3(){
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
    public void sethourlyRate(float val){
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
    public void setSWPercentage(float val){
        if (val >= 0 && val <= .9999){                      /* Ensures SWPercentage is 0-.9999 and then rounds it to four decimals */
        SWPercentage = Round(val*100)/100;
        }else
            System.out.println("Invalid Entry. State withholding percentage not set.");
    }
    public void setytdgrossEarning(float val){
        if (val >= 0 && val <= 99999999.99){                /*Ensures grossEarning is between 0-99999999.99 and then rounds to two decimals */
        ytdgrossEarning = Round(val);
        }else
            System.out.println("Invalid Entry. Gross earnings not set.");
    }
    public void setytdfedTaxes(float val){
        if (val >= 0 && val <= 99999999.99){                /* Ensures fedTaxes is between 0-99999999.99 and rounds to two decimals */
        ytdfedTaxes = Round(val);
        }else
            System.out.println("Invalid Entry. Federal taxes not set.");
    }
    public void setytdSSTaxes(float val){
        if (val >= 0 && val <= 99999999.99){                /* Ensures SSTaxes is between 0-99999999.99 and rounds to two decimals */
        ytdSSTaxes = Round(val);
        }else
            System.out.println("Invalid Entry. Social security taxes not set.");
    }
    public void setytdmedTaxes(float val){
        if (val >= 0 && val <= 99999999.99){                /* Ensures medTaxes is between 0-99999999.99 and rounds to two decimals */
        ytdmedTaxes = Round(val);
        }else
            System.out.println("Invalid Entry. Medicare taxes not set.");
    }
    public void setytdstateTaxes(float val){
        if (val >= 0 && val <= 99999999.99){                /* Ensures stateTaxes is between 0-99999999.99 and rounds to two decimals. */
        ytdstateTaxes = Round(val);
        }else
            System.out.println("Invalid Entry. State taxes not set.");
    }
    public void setytdDeductions(float val){
        if (val >= 0 && val <= 99999999.99){               /* Ensures ytdDeductions is between 0-99999999.99 and roudns to two decimals */
        ytdDeductions = Round(val);
        }else
            System.out.println("Invalid Entry. Year-to-date deductions not set.");
    }
    public void setdedVal1(float val){                     /* Allows user to enter correct value for dedVal1 depending on dedCode1 */
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
    public void setdedVal2(float val){                     /* Allows user to enter correct value for dedVal2 depending on dedCode2 */
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
    public void setdedVal3(float val){                        /* Allows user to enter correct value for dedVal1 depending on dedCode1 */
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
    
    @Override
    public String displayData(){                            /* Method that returns a String containing all pertinent information regarding Employee */
       String retEmployee = "Employee number: " + employeeNumber + "\tDepartment number: " + depNumber +
              "\tName: " + lastName + ", " + firstName + "\n\nPay Type: " + payType + "\tHourly Rate: " +
               hourlyRate + "\tTax Marital Status: " + TMStatus + "\tExemptions: " + numExemptions +
               "\nState Withholding Percentage: " + SWPercentage*100 + "\tGross Earnings: $" + ytdgrossEarning +
               "\tFederal Taxes: $" + ytdfedTaxes + "\nSocial Security Taxes: $" + ytdSSTaxes + "\tMedicare Taxes: $" +
               ytdmedTaxes + "\nState Taxes: $" + ytdstateTaxes + "\tYTD Deductions: $" + ytdDeductions + 
               "\nDeduction Code 1: " + dedCode1 + "\tDeduction Value: $" + dedVal1 + "\nDeduction Code 2: " +
               dedCode2 + "\tDeduction Value: $" + dedVal2 + "\nDeduction Code 3: " + dedCode3 + "\tDeduction Value: $"
               + dedVal3;
        return retEmployee;
        
    }
    
    public String dataWriter(){

                String retEmployee = employeeNumber + "," + depNumber +
              "," + lastName + ", " + firstName + "," + payType + "," +
               hourlyRate + "," + TMStatus + "," + numExemptions +
               "," + SWPercentage*100 + "," + ytdgrossEarning +
               "," + ytdfedTaxes + "," + ytdSSTaxes + "," +
               ytdmedTaxes + "," + ytdstateTaxes + "," + ytdDeductions + 
               "," + dedCode1 + "," + dedVal1 + "," +
               dedCode2 + "," + dedVal2 + "," + dedCode3 + ","
               + dedVal3;
        return retEmployee;        
    }
    
    
     private static float Round(float input){ // this will round to two decimal places
        input = input * 100;
        input = Math.round (input);
        input = input / 100; 
        return input;  
     }

    @Override
    public void parse(String input) {               //will parse a comma delimited input string
        String splitFields[];
        splitFields = input.split(",");
        setemployeeNumber(Integer.parseInt(splitFields[0]));                  
        setdepNumber(Integer.parseInt(splitFields[1]));                          
        setlastName(splitFields[2]);                         
        setfirstName(splitFields[3]);                        
        setpayType(splitFields[4].charAt(0));
        sethourlyRate(Float.parseFloat(splitFields[5]));
        setTMStatus(splitFields[6].charAt(0));
        setnumExemptions(Integer.parseInt(splitFields[7]));
        setSWPercentage(Float.parseFloat(splitFields[8]));
        setytdgrossEarning(Float.parseFloat(splitFields[9]));
        setytdfedTaxes(Float.parseFloat(splitFields[10]));
        setytdSSTaxes(Float.parseFloat(splitFields[11]));
        setytdmedTaxes(Float.parseFloat(splitFields[12]));
        setytdstateTaxes(Float.parseFloat(splitFields[13]));
        setytdDeductions(Float.parseFloat(splitFields[14]));
        setdedCode1(splitFields[15].charAt(0));
        setdedVal1(Float.parseFloat(splitFields[16]));
        setdedCode2(splitFields[17].charAt(0));
        setdedVal2(Float.parseFloat(splitFields[18]));
        setdedCode3(splitFields[19].charAt(0));
        setdedVal3(Float.parseFloat(splitFields[20]));
    }
}
