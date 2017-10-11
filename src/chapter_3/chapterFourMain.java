package chapter_3;

import java.util.Random;

public class chapterFourMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		double r = Math.sqrt(2);
		double d = Math.pow(r, 2) - 2;
		if (d == 0)
			System.out.println("sqrt(2)squared minus 2 is 0");
		else
			System.out.println("sqrt(2)squared minus 2 is not 0 but " + d);

		String s1 = "hello";
		String s2 = "world";

		if (s1.compareTo(s2) < 0)
			System.out.println(s1 + " come before " + s2);
		else
			System.out.print(s1 + " come after " + s2);

		Random generator = new Random();
		int dice = generator.nextInt(6);

		double[] values = { 1, 2, 3, 4 };
		double sum = 0;
		for (double element : values) {
			sum = sum + element;

		}

		System.out.println(sum);

		final int VALUES_LENGTH = 10;
		double[] values1 = new double[VALUES_LENGTH];
		values1[0] = 1;
		for (double element : values1) {
			System.out.println(element);

		}

	}

}
