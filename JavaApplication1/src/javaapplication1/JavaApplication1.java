
package javaapplication1;


public class JavaApplication1 {

   
    public static void main(String[] args) {
    boolean p, q; 
    System.out.println( " P\tQ\tAND\tOR\tXOR\tNOT");
    p = true; q = true;
    System.out.println(p + "\t" + q + "\t" + (p&q) + "\t" + (p|q) + "\t" + (p^q) + "\t" + (!p) + "\t");
   
    p = true; q = false;
    System.out.println(p + "\t" + q + "\t" + (p&q) + "\t" + (p|q) + "\t" + (p^q) + "\t" + (!p) + "\t");
   
    p = false; q = true;
    System.out.println(p + "\t" + q + "\t" + (p&q) + "\t" + (p|q) + "\t" + (p^q) + "\t" + (!p) + "\t");
      
    p = false; q = false;
    System.out.println(p + "\t" + q + "\t" + (p&q) + "\t" + (p|q) + "\t" + (p^q) + "\t" + (!p) + "\t");
   
    }
    
}