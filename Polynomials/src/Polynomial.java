import java.util.*;

public class Polynomial {

	int numOfTerms;
	LinkedList<Terms> numPow = new LinkedList<>();
	
	
	//Constructor
	public Polynomial(int a)
	{
		numOfTerms = a;
	}
		
		
		// +----------------------------------------------------+
		// | Method where the coefficients and powers are added |
		// | to the Linked List                                 |
		// +----------------------------------------------------+
		public LinkedList<Terms> run()
		{

			int coEff;
			int power;
			
			Scanner s = new Scanner(System.in);
			
			for(int a = 0; a < numOfTerms; a++)
			{
			System.out.println("Enter co-efficient: ");
			coEff = Integer.parseInt(s.nextLine());
			System.out.println("Enter power");
			power = Integer.parseInt(s.nextLine());			
			Terms term = new Terms(coEff,power);
			
				if (numPow.isEmpty())
				{
					numPow.addFirst(term);
				}else
				{
					numPow.addLast(term);
				}
			}
			
			return numPow;
		}
		
		
		// +--------------------------------+
		// | Method to print the polynomial |
		// +--------------------------------+
		public void display(LinkedList<Terms> term)
		{
			
			Terms terms;
			String disp = "";
			
			for (int a = 0; a < term.size(); a++)
			{
				
				terms = term.get(a);
				
				disp = disp + terms.coEfficient + "x^" + terms.power;
				
				if (a < (term.size() - 1))
				{
					
					disp = disp + " + ";
					
				}	
				
			}
			System.out.println(disp);
		}
	
		
		// +-------------------------------+
		// | Method Adding the Polynomials |
		// +-------------------------------+
		public LinkedList<Terms> polyAdd(LinkedList<Terms> p1, LinkedList<Terms> p2)
		{
			
			LinkedList<Terms> p3 = new LinkedList<>();
			int p1Size = p1.size();
			int p2Size = p2.size();
			Terms termP1 = new Terms(0,0);
			Terms termP2 = new Terms(0,0);
			
			
				for (int a = 0; a < p1Size; a++)
				{
				
					if (!p1.isEmpty()) 
					{
					
						termP1 = p1.get(a);
					
					}
					
					for (int b = 0; b < p2Size; b++)
					{
						
						if (!p2.isEmpty()) 
						{
						
							termP2 = p2.get(b);
						
						}
						
						
						if ((termP1.power) == (termP2.power))
						{
						
							p3.addLast(new Terms((termP1.coEfficient + termP2.coEfficient), termP1.power));
							p2.remove(b);
							b--;
						}
						else
						{
							
							p3.add(p1.get(a));
							p3.add(p2.get(b));
							p1.remove(a);
							a--;
							p2.remove(b);
							b--;
							
						}
					
					}	
				}
			return p3;
			
		}
}
