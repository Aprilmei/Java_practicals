package assignment_1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileReaderTest {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		String FileName = "src/assignment_1/InputProperty.txt";
		File inputFile = new File(FileName);
		String first = new Scanner(inputFile).next();
		System.out.print(first);
	}

}
