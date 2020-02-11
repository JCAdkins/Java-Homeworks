import java.util.Objects;
import java.util.Scanner;

public class HashTableDemo {

	public static void main(String[] args) {
		
		boolean breaker = false;
		
		HashTable Tester = new HashTable();
		Scanner s = new Scanner(System.in);
		do {
		System.out.println("Input name: ");
		String name = s.nextLine();
		System.out.println("Select sex: 1) M  2)F ");
		String sex = s.nextLine();
		char cex = ' ';
		if (Objects.equals(sex, "1")) {
			cex = 'M';
			} 
		else if(Objects.equals(sex, "2")) {
			cex = 'F';
			}	
		else {
			break;
		}
		System.out.println("intput secret int: ");
		int sec = Integer.parseInt(s.nextLine());
		if (name == "exit") {
			breaker = true;
		}
		HashObject hashObject = new HashObject(name,cex,sec);
		Tester.set(hashObject, hashObject.getHash());
		
		
		}while(Objects.equals(breaker, false));
		
		System.out.println("\n\n\n\n\n\n");
		breaker = false;
		do {
		System.out.println("who's secret number would you like to return?\n");
		String retName = s.nextLine();
		String retSex = s.nextLine();
		char cex = ' ';
		if (Objects.equals(retSex, "1")) {
			cex  = 'M';
			} 
		else if(Objects.equals(retSex, "2")) {
			cex = 'F';
			}	
		else {
			break;
		}
		if (Objects.equals(retName, "exit")){
			breaker = true;
		}
		
		HashObject hashObject = new HashObject(retName,cex);
		int hash = hashObject.getHash();
		@SuppressWarnings("unused")
		HashObject retObject = (HashObject) Tester.get(hash);
		System.out.println(retObject.getSecret());
		}while(Objects.equals(breaker,  false));
		
		s.close();
	}

}
