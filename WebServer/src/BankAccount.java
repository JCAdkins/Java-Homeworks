
public class BankAccount {

	int accountNumber;
	double amount;
	
	BankAccount(int account){
		
		accountNumber = account;
		amount = 0;
		
		
	}
	
	BankAccount(int acc, double amt) {
		
		accountNumber = acc;
		amount = amt;
		
		
	}
	
	public void deposit(double amt){
		
		amount = amount + amt;
		System.out.println("Bank: " + accountNumber + " has new balance: " + amount);
	}
	
	public void withdraw(double amt){
		
		amount = amount - amt;
		System.out.println("Bank: " + accountNumber + " has new balance: " + amount);
	}

	public double getBalance() {
		return amount;
	}

	
}
