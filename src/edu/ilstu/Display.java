/**
 * 
 */
package edu.ilstu;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @author israe
 *
 */
public class Display {
	public void printDisplay() {
		Scanner userInput = new Scanner(System.in);

		InputOutput io = new InputOutput();
		String[] alreadyIn = new String[50];
		/*
		 * prompt user for input and displays menu upon selecting an option
		 */
		boolean num = false;
		int already = 0;
		while (!num) {
			System.out.print("\nBiomedical Concepts Data" + "\n('A' or 'a') Add Data\n"
					+ "('R' or 'r') Save data for a relationship\n" + "('T' or 't') Save data for medical terms\n"
					+ "('E' or 'e') Exit Program\n" + "\nEnter choice from above: ");

			/*
			 * grab the userinput and call methods for what they chose from the above
			 */

			/*
			 * start switch case statements
			 */
			char choice = userInput.nextLine().charAt(0);

			switch (choice) {

			case 'A':
			case 'a':
				System.out.println("Please enter file name: ");
				
				String userIn = userInput.nextLine();
				
				if(Arrays.stream(alreadyIn).anyMatch(userIn::equals)) {
					
					System.out.println("File already read, please try a new file...");
					continue;
				}
				alreadyIn[already] = userIn;
				getFileInfo(userIn);
				already++;
				break;

			case 'R':
			case 'r':

				break;

			case 'T':
			case 't':

				break;

			case 'E':
			case 'e':
				num = true;
				for(int j = 0; j < dataSize; j++) {
					for(int k = 0; k < 3 ;k++) {
						System.out.print(firstDataIn[j][k] + ", ");
					}
					System.out.println();
				}
				break;

			}

		}
		// userInput.close();

	}

	/*
	 * grab filename from user read the provided file and extract data add it to
	 * new/existing repository/data structure print the number of rows read user
	 * enters "A"
	 */

	String[][] firstDataIn = new String[150][3];
	int dataSize = 0;
	boolean isThereAFile = false;

	public void getFileInfo(String fileName1) {

		File file = new File(fileName1);

		try {
			Scanner scanner = new Scanner(file);

			// now read the file line by line...

			int rowNum = 0;
			int colNum = 0;
			scanner.nextLine();
			while (scanner.hasNextLine()) {
				String line = scanner.nextLine();

				if (line.contains(",,")) {
					System.out.println("------------------------------");
					continue;
				}
				String[] arrOfStr = line.split(",");
				for (String element : arrOfStr) {

					firstDataIn[rowNum][colNum] = element;
					colNum++;
					System.out.println(element);
				}
				if (colNum == 3) {
					colNum = 0;
				}

				rowNum++;
				dataSize++;

			}
		} catch (FileNotFoundException e) {
			System.out.println("No file found");
		}
		System.out.println("num rows read: " + dataSize);
	}

	/*
	 * user inputs a RELA takes the name of the file where the data must be
	 * exported/saved finds all the data from the repository and exports it in CSV
	 * file with string() format user enters "R"
	 */
	public void saveDataRelation() {
			
	}

	/*
	 * user inputs medical term take the name of the file where data must be
	 * exported/saved find all the information from the repository with medical term
	 * and export it with specific string() format user enters "T"
	 */
	public void saveDataMedical() {

	}

}
