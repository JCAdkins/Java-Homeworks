/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package anthonywebclienttest;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

/**
 *
 * @author jordanadkins
 */
public class AnthonyWebClientTest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try{
            URL jokeURL = new URL("http://api.icndb.com/jokes/random");
            URLConnection uc = jokeURL.openConnection();
            BufferedReader in = new BufferedReader(
                                    new InputStreamReader(
                                            uc.getInputStream()
                                    ));
            String jokeResponse = in.readLine();
            System.out.println(jokeResponse.toString());           
        }catch(Exception ex){          
        }
    }
    
}
