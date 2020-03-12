//  Program: FileItem.java
//  Author: Gary R Smith
//  Date Written: 10/31/2009

/*  Abstract: File control class for reading/writing item data.
*/

package displayItem;

import java.io.*;
import javax.swing.JOptionPane;

public class FileItem 
{
    //  File control variables
    public BufferedReader reader;
    public PrintWriter writer;
    private final String fileName = "/Users/jordanadkins/NetBeansProjects//Users/jordanadkins/NetBeansProjects/GUI - DisplayingTextFilesCSV 3/data/items.csv";
    public File file = new File(fileName);
    public  boolean isEOF = false;
    public  boolean isOpen = false;
    
    //  Data
    Item data;
    
    //  Opens the file for reading.
    public void open() throws IOException
    {
        //  Check to see if file exists.  If so open the file.
        if(file.exists())
        {
            try 
            {
                //  Open the file.
                reader = new BufferedReader(new FileReader(file));
                isOpen = true;
            } 
            catch (IOException err) 
            {
                JOptionPane.showMessageDialog(null, err.getMessage(), 
                        "File System Error", JOptionPane.ERROR_MESSAGE);
                isOpen = false;
            }
        }
        else
        {
            //  Display message and terminate.
            throw new FileNotFoundException("File not found");
        }
    }

    //  Opens the file for output (append).
    public void openAppend() throws IOException
    {
        //  Check to see if file exists.  If so open the file.
        if(file.exists())
        {
            try 
            {
                //  Open the file.
                writer = new PrintWriter(new FileWriter(file, true));
                isOpen = true;
            } 
            catch (IOException err) 
            {
                JOptionPane.showMessageDialog(null, err.getMessage(), 
                        "File System Error", JOptionPane.ERROR_MESSAGE);
                isOpen = false;
            }
        }
        else
        {
            //  Display message and terminate.
            throw new FileNotFoundException("File not found");
        }
    }

    //  Opens the file for output (write over).
    public void openOutput() throws IOException
    {
        //  Check to see if file exists.  If so open the file.
        if(file.exists())
        {
            //  You may want to display a message here because you are about to
            //  overwite an existing file.
            try 
            {
                //  Open the file.
                writer = new PrintWriter(new FileWriter(file, false));
                isOpen = true;
            } 
            catch (IOException err) 
            {
                JOptionPane.showMessageDialog(null, err.getMessage(), 
                        "File System Error", JOptionPane.ERROR_MESSAGE);
                isOpen = false;
            }
        }
        else
        {
            //  Display message and terminate.
            throw new FileNotFoundException("File not found");
        }
    }
    
        //  Close files.
        public void close()
        {
            //  If the file is open, close the file.
            if (isOpen)
            {
                try
                {
                    if (reader != null)
                    {  
                        reader.close();
                    }
                    if (writer != null)
                    {
                        writer.close();
                    }
                }
                catch (IOException err)
                {
                    JOptionPane.showMessageDialog(null, err.getMessage(), 
                        "File Close Error", JOptionPane.ERROR_MESSAGE);
                }
                isOpen = false;
            }
        }
    
    //  Read routine.
    public void readFile() throws IOException
    {
        try
        {
            //  Read a line from the file.
            String inputLine = reader.readLine();

            //  In the input line is null, then there are no more records to read.
            if(inputLine != null)
            {
                //  Populate the class variables.
                data = new Item();
                data.parseCSV(inputLine);
            }
            else
            {
                //  Set end of file to true.
                isEOF = true;
            }
        }
        catch (Exception e)
        {
            //  Set end of file to true.
            isEOF = true;   
        }
    }
    
    //  Writes data as a text file.
    public void writeFile()
    {
       writer.print(
                data.getItemNumber() + "," +
                data.getStatus() + "," +
                data.getCategory() + "," +
                data.getDescription() + "," +
                data.getHasDiscount() + "," +
                data.getPrice() + "," +
                data.getCost() + "," +
                data.getQtyOnHand() + "," +
                data.getQtyOnOrder() + "," +
                data.getYtdSalesQty() + "," +
                data.getYtdSalesAmt()
                );
        writer.println();
    }
}
