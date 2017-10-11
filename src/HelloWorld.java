
import java.io.PrintStream;
import java.util.Scanner;

public class HelloWorld {

	private static Scanner input;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.print("JA");
		System.out.print("VA");

		input = new Scanner(System.in);
		PrintStream printer = System.out;

		String daniel = " Hello  ";
		String myName = "Daniel Strafile";
		String greeting = "Hello World";
		String river = "Mississippi";
		// river = river.toUpperCase();
		river = river.replace("p", "s");

		System.out.print("Test 2" + "\n");
		System.out.print(daniel.trim() + " " + myName + "\nThe river is " + river + "\n");
		System.out.println("The length of the greeting is " + greeting.length() + "\nThe new greeting length is "
				+ greeting.replace("World", "Dan").length());

		AddTwoString("\nLove", 3);
		System.out.print("\nPlease input a number: ");
		int adder = input.nextInt();
		printer.print(adder);

	}

	public static String AddTwoString(String A, int B) {
		String C = A + B;
		System.out.println(C);
		return C;
	}

}
