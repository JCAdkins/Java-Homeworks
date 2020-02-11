import java.util.ArrayList;

public class HashTable {
	
	private Object elements[];
	private int currentSize;
	
	public HashTable() {
		
		final int INIT_SIZE = 10;
		elements = new Object[INIT_SIZE];
		currentSize = 0;		 
		 
		 
	}
	
	public int Size() {
		return currentSize;
	}
	
	public int elementsSize() {
		return elements.length;
	}
	
	private void checkBounds(int n) {
		if (n < 0 || n >= currentSize) {
			throw new IndexOutOfBoundsException();
		}
	}
	
	public Object get(int hash) {
		 int pos = hash % elementsSize();
		return elements[pos];
	}
	
	public void set(Object element, int hash) {
		//checkBounds(hash);
		int position = hash % elementsSize();
		if (elements[position] == null){
			elements[position] = element;
			currentSize++;
		}
		else
		{
			int a = 0;
			do {
				a++;
			}while(elements[position + a]!=null);
			
			elements[position + a] = element;
			
		}
	}
	
	/*public boolean checkLoc() {
		
		
	}*/
		
	}
		
		
		
		
	
		 
	
		 
		 
		
	
	
	
	
	/*public Object Next(Object x, String name, int data) {
		
		
		
		
		
		
		return x;
		
	}*/
	
	
	
	

