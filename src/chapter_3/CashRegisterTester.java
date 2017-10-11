
package chapter_3;

import java.util.Scanner;

import org.junit.Assert;
import org.junit.Test;

public class CashRegisterTester {

	public static void main(String[] args) {

		double account = 2.19;
		int newaccount = (int) Math.round(account);

		System.out.print("The account is " + account + "\nthe new account is " + newaccount);
		double total_number = CashRegister.Add_two(2, 5.6);
		System.out.print("\nThe total number is " + total_number);

		CashRegister register = new CashRegister();

		register.recordPurchase(0.75);
		register.recordPurchase(1.50);
		register.enterPayment(2, 0, 5, 0, 0);
		System.out.print("\nChange: ");
		System.out.println(register.giveChange());
		System.out.println("Expected: 0.25");

		Scanner in = new Scanner(System.in);
		System.out.print("Enter price: ");
		double price = in.nextDouble();
		register.recordPurchase(price);

		System.out.println("Enter payment : Dollar, Quarter, Dime, Nickel, Penny ");
		int dollars = in.nextInt();
		int quarters = in.nextInt();
		int dimes = in.nextInt();
		int nickels = in.nextInt();
		int pennies = in.nextInt();

		register.enterPayment(dollars, quarters, dimes, nickels, pennies);
		System.out.print("\nYour Change is : ");
		System.out.println(register.giveChange());

	}

	@Test
	public void twoPurchases() {
		CashRegister register = new CashRegister();
		register.recordPurchase(0.75);
		register.recordPurchase(1.50);
		register.enterPayment(2, 0, 5, 0, 0);
		double expected = 0.25;
		Assert.assertEquals(expected, register.giveChange());
	}

}
