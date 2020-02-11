import java.util.Scanner;

public class HexTester {

	public static void main(String[] args) throws InterruptedException {
		HexConverter hex = new HexConverter();
		Scanner scan = new Scanner(System.in);
		System.out.println("Input base of original number: ");
		String oBase = scan.nextLine();
		System.out.println("Input a number:");
			System.out.println("Value base " + oBase + " is equal to:\n " + hex.HexConvertersion(oBase, scan.nextLine()) + " in decimal.");
		scan.close();
	}

}
