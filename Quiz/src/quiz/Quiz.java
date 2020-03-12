/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quiz;

/**
 *
 * @author jordanadkins
 */
public class Quiz {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int[] a = { 99, 22, 11, 3, 11, 55, 44, 88, 2, -3 };

      int result = 0;

      for ( int i = 0; i < a.length; i++ )
      {
         if ( a[ i ] > 30 )
            result += a[ i ];
      } // end for

      System.out.printf( "Result is: %d\n", result );
    }
    
}
