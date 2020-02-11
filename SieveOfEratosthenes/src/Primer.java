import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Primer
{
	
	// Constructor
	public Primer(){}
	
	
	// +-----------------------------------+
	// | Method where all the fun happens. |
	// +-----------------------------------+
	public Set<Integer> run(){
		
		
		// Start our TreeSet primes and open the scanner to get the input integer
		Set<Integer> primes = new TreeSet<>();
		Scanner s = new Scanner(System.in);
		System.out.println("Enter an integer: ");
		int integer = s.nextInt();
		
		
		// We don't need the scanner anymore so close it
		s.close();
	
		
		// Loop to add all integers to our set up to the user input integer
		for (int a = 1; a <= integer; a++)
		{
			primes.add(a);
		}
		
		
		// n is going to be how many times we have to loops we are going to have to perform
		// to make sure we erase all non-prime integers; e.g if input integer is 100 we will
		// only have to loop through our EraseMultiples method sqrt(100), or 10, times to get
		// rid of all the non-prime integers.
		double n = java.lang.Math.sqrt(primes.size());
		
		
		// Our main loop using our EraseMultiples method.
		for (int temp = 1; temp <= n; temp++)
		{
			primes = EraseMultiples(temp, primes);
		}
		return primes;
	}
	
	
	// +------------------------------------------------+
	// | Method to erase the numbers that aren't prime. |
	// +------------------------------------------------+
	public Set<Integer> EraseMultiples(int i, Set<Integer> s)
	{
		// Just things we need to make this method work
		Set<Integer> set = s;
		Set<Integer> set2 = new TreeSet<>();
		Iterator<Integer> iter = s.iterator();
		
		
		// Loop that uses the modulus operator to check if our integer from our iterators 
		// next() method when divided by i, the integer from the main loop from our run() 
		// method above, the remainder is 0. If it is 0 add it to our second set. As long as its
		// not the first iteration of our iterator, a = i. If a = i, then it would erase
		// itself and thus all integers and we wouldn't have any left in the set.
		while (iter.hasNext())
		{
			int a = iter.next();
			
			if (a % i == 0 && (a != i))
			{
				set2.add(a);
			}	
		}
		
		
		// As long as its not the first time through our main run() loop, remove from our set
		// all numbers that were added to set2. We do this because if they were added to set2
		// then the modulus operator returned 0 which means those numbers can't be prime.
		if (i != 1) 
		{
				set.removeAll(set2);
		}
		
		
		return set;
	}
	
	
	
	
	
	
	
}