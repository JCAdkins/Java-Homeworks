/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testtimecard;

/**
 *
 * @author The_B
 */
public class TimeCard {
    
    private String empName;
    private int empNum;
    private String sclockIn[] = new String[14];
    private String sclockOut[] = new String[14];
    private float fclockIn[] = new float[14];
    private float fclockOut[] = new float[14];
    private float fElapsedTimes[] = new float[14];
    
    public TimeCard(String empName,int empNum){     //TimeCard constructor & assignment of input param.
        this.empName = empName;
        this.empNum = empNum; 
    }
    
    public String getempName(){     //empName accessor
        return empName;
    }
    public int getempNumber(){      //empNumber accessor
        return empNum;
    }
    public String getsclockIn(int day){ // sclockIn accessor
        if (day >= 0 && day<14)
            return sclockIn[day];
        System.out.print("Invalid Entry. Day must be between 0 and 13.");
        return null;
    }
    
    public String getsclockOut(int day){        //sclockOut accessor
        if (day >= 0 && day<14)
            return sclockOut[day];
        System.out.print("Invalid Entry. Day must be between 0 and 13.");
        return null;
    }
    
    public void setsclockIn(int day, String time){ // sclockIn mutator
        if (day >=0 && day < 14){
            if ((getHours(time)>=0 && getHours(time) < 24) && (getMinutes(time) >=0 && getMinutes(time) <60)){
            sclockIn[day] = time;
            fclockIn[day] = convertAndRoundTime(time);
                }else 
                System.out.print("Invalid time Entry. Time must be between 00:00 and 23:59");

        }else 
            System.out.print("Invalid Entry. Day must be between 0 and 13.");
    }
    
    public void setsclockOut(int day, String time){         //sclockOut mutator
        if (day >=0 && day < 14){
            if ((getHours(time)>=0 && getHours(time) < 24) && (getMinutes(time) >=0 && getMinutes(time) <60)){
            sclockOut[day] = time;
            fclockOut[day] = convertAndRoundTime(time);                                  
                }else 
                System.out.print("Invalid time Entry. Time must be between 00:00 and 23:59");

        }else 
            System.out.print("Invalid Entry. Day must be between 0 and 13.");
    }
    
    public float getfclockIn(int day){          // fclockIn accessor
        if (day >= 0 && day < 14)
            return fclockIn[day];
        System.out.print("Invalid Entry. Day must be between 0 and 13.");
        return 0;
    }
    
    public float getfclockOut(int day){         // fclockOut accessor
        if (day >= 0 && day < 14)
            return fclockOut[day];
        System.out.print("Invalid Entry. Day must be between 0 and 13.");
        return 0;
    }
    
    public float getElapsedTime(int day){           // ElapsedTime accessor
        if (day >= 0 && day < 14)
            return fElapsedTimes[day];
        System.out.print("Invalid Entry. Day must be between 0 and 13.");
        return 0;
    }
    
    public void setempName(String name){        // empName mutator
        empName = name;
    }
    
    public void setempNum(int num){         // empNum mutator
        if (num> 0)
            empNum = num;
        
    }
    
    public byte getHours(String time){          // method to get Hours as a byte
        String[] splitFields = time.split(":");
        return Byte.parseByte(splitFields[0]);
    }
    
    public byte getMinutes(String time){            // method to get minutes as byte
        String[] splitFields = time.split(":");
        return Byte.parseByte(splitFields[1]);
    }
    
    private float convertAndRoundTime(String time){         // method to convert the time and round it as a float
        byte hours = getHours(time);
        byte mins = getMinutes(time);
        if (mins >= 0 && mins <8){
            return hours;
        }else if (mins >= 8 && mins <23){
            return hours + .25f;
        }else if (mins >= 23 && mins < 38){
            return hours + .50f;
        }else if (mins >= 38 && mins <53){
            return hours + .75f;
        }else{
            return hours + 1.00f;
        }
            
    }
    
    private float calculateElapsedTime(int day){            // method to calculate the elapsed time
        if (day >= 0 && day<14){
            if (fclockOut[day] >= fclockIn[day]){
                return fclockOut[day] - fclockIn[day];
            }else if (day <13){
                return (fclockOut[day] + 24) - fclockIn[day];
            } else 
                //I would need next weeks timecard to calculate this return value
                return 0;
        }
        return 0;
    }  

    public void calculateElapsedTimes(){                // method to point fElapsedTimes to calculateElapsedTime
        for (int day = 0; day <14; day++)
            fElapsedTimes[day] = calculateElapsedTime(day);
    }
    
    public String displayData(){            // method to display data as a string
        String display = "Name: " + getempName() + "\tNumber: " + getempNumber() +"\n\nDay\tsClock-In\tsClock-Out\tfClock-In\tfClock-Out\tElapsed Time";
        for (int day = 0; day<14; day++){
            display = display + "\nDay " + (day + 1) + ": " + getsclockIn(day) + "\t\t" + getsclockOut(day) + "\t\t" + getfclockIn(day) + "\t\t" + getfclockOut(day) + "\t\t" + getElapsedTime(day);
        }
      return display;          
    }
    
    
}









    

