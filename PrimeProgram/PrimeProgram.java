package primeprogram;

import java.util.*;

public class PrimeProgram {
    
    public static void main (String[] args) {
        
        // Create scanner and have user input a positive whole number 
        Scanner s = new Scanner(System.in);
        System.out.println("Please input a positive whole number: ");
        int inputNumber = s.nextInt();
        
        // Check to see if prime using isPrime() method if it is display it is else
        // find the prime factors using getPrimeFactors() method
        if (isPrime(inputNumber) == true)
            System.out.println("Your number is prime!");
        else
            System.out.println("Your number is composite!\nThe prime factors are : " + getPrimeFactors(inputNumber).toString());
        
    }
    
    // Method that returns true if a number is prime and false if it isn't
    public static boolean isPrime(int number)
    {
        if ((number == 2) || (number == 3)) 
            return true;
        
        int max =(int) Math.sqrt(number) + 1; 
        for (int a = 2; a < max ; a++)
        {
            if (number % a == 0) 
                return false;
        }
        return true; 
    }
    
    // Method that returns a set of all the prime factors
    public static Set<Integer> getPrimeFactors(int number)
    {
    
        Set<Integer> primeFactors = new TreeSet<Integer>();
        ArrayList<Integer> primeNumbers = eratosthenes(number); // This returns an
        // ArrayList of all integers that are prime up to number/2.
        
        // This loop iterates through primeNumbers and finds the prime factors
        // and adds them to our Set primeFactors which can't have duplicates
        for (int a = 0; a < primeNumbers.size(); a++)
        {
            
            while (number % primeNumbers.get(a) == 0)
            {
                primeFactors.add(primeNumbers.get(a));
                number = number / primeNumbers.get(a);
            }
        }
        return primeFactors;
    }
    
    // Method that uses the Sieve of Eratosthenes algorithm to return prime numbers
    // up to the input number divided by 2
    public static ArrayList<Integer> eratosthenes(int number)
    {
        ArrayList<Integer> returnArray = new ArrayList<>();
        boolean prime[] = new boolean[number+1]; 
        // Set all initial values to true
        for(int a = 0; a < number; a++) 
            prime[a] = true; 
          
        for(int b = 2; b*b <= number; b++) 
        { 
            // If prime[b] is not changed, then it is a prime 
            if(prime[b] == true) 
            { 
                // Update all multiples of p 
                for(int c = b*b; c <= number ; c += b) 
                    prime[c] = false; 
            } 
        }
        
        // Add primes to returnArray
        for (int d = 2; d <= number / 2; d++)
        {
            if (prime[d] == true)
            {
                returnArray.add(d);
            }
        }
        
        return returnArray;
    }
}
