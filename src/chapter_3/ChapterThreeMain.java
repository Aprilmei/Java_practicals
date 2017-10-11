package chapter_3;

import java.util.Scanner;

import javax.swing.JOptionPane;

public class ChapterThreeMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int PowerOfTen = (int) Math.pow(10, 3);
		System.out.println("Power of ten is " + PowerOfTen);

		String Money = "10";
		int MoneyNumber = Integer.parseInt(Money);

		String str = "" + MoneyNumber;
		str = Integer.toString(MoneyNumber);
		System.out.println(MoneyNumber + str);

		Scanner in = new Scanner(System.in);
		System.out.println("Please input your quota: ");
		int Mount = in.nextInt();

		// System.out.print("Please input your question: ");
		// String Question = in.nextLine();
		System.out.println("Quota is " + Mount);

		System.out.println("Please input your Rate: ");
		Double Rate = in.nextDouble();
		System.out.println("The Rate is : " + Rate);

		in.close();

		String input = JOptionPane.showInputDialog("Enter price: ");
		int count = Integer.parseInt(input);
		System.out.print("The price is :" + count);
		System.exit(0);

	}

}
