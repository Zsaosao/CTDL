package lab8;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class TestReadFile {
	public static void main(String[] args) throws FileNotFoundException {
		// Scanner input = new Scanner(new File("data/hamlet.txt"));
		Scanner input = new Scanner(new File("src/asset/fit.txt"));

		while (input.hasNext()) {
			String word = input.next();
			System.out.println(word);
		}
	}
}