
public class Eratosthenes {

	public static void main(String[] args) {
		
		// I put all the programming in class Primer so I don't 
		// have to worry about the 'Cannot make a static reference
		// to a non-static method or variable' error.
		Primer primes = new Primer();
		System.out.println(primes.run());
	}

}
