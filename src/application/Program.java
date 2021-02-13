package application;

import java.util.Locale;
import java.util.Scanner;

import model.entities.Account;
import model.exceptions.DomainException;

public class Program {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		try {
			System.out.println("Enter Account Data");
			System.out.print("Number: ");
			int number = sc.nextInt();
			System.out.println("Holder: ");
			sc.nextLine();
			String name = sc.nextLine();
			System.out.print("Initial Balance: ");
			double balance = sc.nextDouble();
			System.out.print("Withdraw Limit: ");
			double limit = sc.nextDouble();
			
			Account acc = new Account(number, name, balance, limit);
			
			System.out.println();
			System.out.print("Enter amount for withdraw: ");
			double amount = sc.nextDouble();
			acc.withdraw(amount);
			System.out.println(acc.toString());
			
		}
		catch(DomainException e) {	
			System.out.println("Withdraw error: " + e.getMessage());
		}
		catch (RuntimeException e) {
			System.out.println("Unexpected error");
		}
		
		sc.close();
	}

}
