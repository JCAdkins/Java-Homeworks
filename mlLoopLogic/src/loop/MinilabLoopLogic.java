/* Name: Jordan Adkins
 * Date: 09/19/19
 * Purpose: Use loops
 */
package loop;

import java.util.*;

public class MinilabLoopLogic
{
	public static void main(String[ ] args)
	{
		Scanner kb = new Scanner(System.in);	
		int divInt = 0;			// this is the integer that we will use to divide
		int[] progInts = {0,0};  // progInts[0] is first integer, progInts[1] is second integer

		System.out.print("Please enter first integer: ");
		progInts[0] = kb.nextInt();		// set first integer
		System.out.println("Please enter second integer: ");
		progInts[1] = kb.nextInt();		// set second integer

		System.out.println("\n\nThis program will generate numbers BETWEEN ");
		System.out.println( " and " + " that are divisible by a certain number.");

		
		do {
			System.out.print("\nPlease enter the integer your output should be divisible by: ");
			divInt = kb.nextInt(); // set second integer as long as it isn't 0
				
		}while(divInt == 0);

		System.out.println("\n\n----------------------------------------");
       
		
		// check if first integer is less than second integer if it is count from
		// first integer up to second and output all numbers divisible by divInt
		if (progInts[0] < progInts[1]) {
		
		for (int a = (progInts[0] + 1); a < progInts[1]; a++) {
			if (a % divInt == 0) {
				System.out.println(a);
				}
			
			
			}
		}
		// if first integer is bigger than second integer count backwards and display
		// all integers divisible by divInt
		else {
			for (int a = (progInts[0] - 1); a > progInts[1]; a--) {
			if (a % divInt == 0) {
				System.out.println(a);
			}
			}
		}
	kb.close();
	}
}

