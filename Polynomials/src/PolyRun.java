import java.util.LinkedList;
import java.util.Scanner;

public class PolyRun {

	public static void main(String[] args) {

		
		int numOfTermsFirst, numOfTermsSecond;
		
		Scanner s = new Scanner(System.in);
		Polynomial polynomial;
		
		System.out.println("Input number of terms 1st Polynomial: ");
		
		numOfTermsFirst = Integer.parseInt(s.nextLine());
		System.out.println("Input number of terms 2nd Polynomial: ");
		numOfTermsSecond = Integer.parseInt(s.nextLine());
		
		System.out.println("-----------First Polynomial---------");
		polynomial = new Polynomial(numOfTermsFirst);
		LinkedList<Terms> firstPolynomial = polynomial.run();
		
		
		System.out.println("-----------Second Polynomial--------");
		polynomial = new Polynomial(numOfTermsSecond);
		LinkedList<Terms> secondPolynomial = polynomial.run();
		
		polynomial.display(firstPolynomial);
		polynomial.display(secondPolynomial);
		
		System.out.println(polynomial.polyAdd(firstPolynomial, secondPolynomial));
		
		
		s.close();
	}

}
