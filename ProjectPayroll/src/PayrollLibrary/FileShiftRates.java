/*
Author: Jordan Adkins
Date: 5/5/18
Abstract: Creates a class that can open, read, write, append and close ShiftRates files.
 */
package PayrollLibrary;
import java.io.*;
import java.util.Arrays;
import javax.swing.JOptionPane;

/**
 *
 * @author jordanadkins
 */
public class FileShiftRates {
    public ShiftRates newShiftRates = new ShiftRates();           //create all variables needed for class
    private BufferedReader bufferedReader;
    private BufferedWriter bufferedWriter;
    private String filename = "Filename.csv";
    private File file = new File(filename);
    public boolean isOpen = false;
    public boolean isEOF = false;
    
    public FileShiftRates(){                  //constructor
        
    }
    
    public FileShiftRates(String filename){       //constructor with params
        this.filename = filename;
        file = new File(filename);
    }
    
    public boolean openRead() throws FileNotFoundException {            //method to open the file to read
        boolean succeeded = false;
        isOpen = false;
        if (file.exists()){
            try{
                bufferedReader = new BufferedReader(new FileReader(filename));
                isOpen = true;
                succeeded = true;
            }
            catch(FileNotFoundException err){
                JOptionPane.showMessageDialog(null,"File Not Found!");
                isOpen = false;
            }
        }else{
            throw new FileNotFoundException("File Not Found");
        }
        return succeeded;
    }
    
    public boolean readRecord() throws FileNotFoundException, IOException {  //read from the file if opened
        boolean succeeded;
        try{
        String inputLine = bufferedReader.readLine();
        if(inputLine == null){
            isEOF = true;
            succeeded = true;
        }else{
            newShiftRates = new ShiftRates();
            newShiftRates.parse(inputLine);
            succeeded = true;
            }
        }
        catch(IOException err){
                JOptionPane.showMessageDialog(null,"An IOException Error Occured!");
                succeeded = false;
            }
        return succeeded;
    }
    
    public boolean openOutput() throws FileNotFoundException, IOException {             //method to open the file to output data too
        boolean succeeded = false;
        isOpen = false;
        
        if (!file.exists()){
            try{
                bufferedWriter = new BufferedWriter(new FileWriter(filename,false));
                isOpen = true;
                succeeded = true;
            }catch(IOException err){
                JOptionPane.showMessageDialog(null,"File Not Found!");
                isOpen = false;
            }
                
        }else {
            String options[] = {"Append","Overwrite","Cancel"};
                    Object selected = JOptionPane.showInputDialog("Output file already exists.\nPlease select an option" + Arrays.toString(options));
                    if (selected!=null){
                        String selection = selected.toString();
                        switch (selection){
                            case "Append": 
                                openAppend();
                                break;
                            case "Overwrite":
                                file.delete();
                                openOutput();
                                break;
                            default:
                                JOptionPane.showMessageDialog(null, "Exiting the program");
                                System.exit(0);
                        }
                    }
                    
        }
        return succeeded;
    }
    
    public void close(){                        //method to close the file
        try{
        if (!(bufferedReader == null)){
            bufferedReader.close();
        }
        if (!(bufferedWriter == null)){
            bufferedWriter.close();
                    }
        }catch(IOException err){
                JOptionPane.showMessageDialog(null, "System Error!");
        }
    }
   
    public boolean openAppend(){                // method to open the file to append 
           boolean succeeded = false;
           isOpen = false;
           
           if (file.exists()){
               try{
                   bufferedWriter = new BufferedWriter(new FileWriter(filename,true));
                   isOpen = true;
                   succeeded = true;
               }catch(IOException err){
                   JOptionPane.showMessageDialog(null, "File System Error #2");
                   isOpen = false;
               }
           }else{
                int userChoice = JOptionPane.showConfirmDialog(null,"Error:", filename + "doesn't exist. Would you like to open as output?", JOptionPane.YES_NO_OPTION);
                try{
                    if (userChoice==0){
                    openOutput();
               }
           }catch(IOException err){
               JOptionPane.showMessageDialog(null, "System Error #3");
           }
}
return succeeded;
}
    
    public boolean writeRecord(){           //method to write to the file
        boolean succeeded = false;
        try{
            bufferedWriter.write(newShiftRates.dataWriter());
            bufferedWriter.newLine();
        }catch(IOException err){
            JOptionPane.showMessageDialog(null, "Failure to write file.");
        }
        return succeeded;
    }
    
    
}