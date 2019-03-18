/**
 * 
 */
package edu.ilstu;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
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
		readTermsData();
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
					System.out.println("Please enter the relationship you want to save: ");
					String userIn1 = userInput.nextLine();
					System.out.println("Please enter the file name you want to create or save it: ");
					String fileName = userInput.nextLine();
					saveDataRelation(userIn1, fileName);
				break;

			case 'T':
			case 't':
				System.out.println("Please enter the term you want to save: ");
				String userIn2 = userInput.nextLine();
				System.out.println("Please enter the file name you want to create or save it: ");
				String fileName1 = userInput.nextLine();
				saveTerms(userIn2, fileName1);
				
				break;

			case 'E':
			case 'e':
				num = true;
				System.out.println("Program has ended.");
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
	String[][] termsData = new String[100][2];
	String[][] str2Data = new String[100][2];
	String[][] dataIn = new String[150][4];
	int str2Size =0;
	int dataSize = 0;
	int termsDataSize = 0;
	boolean isThereAFile = false;

	public void getFileInfo(String fileName1) {


		File file = new File(fileName1);

		try {
			Scanner scanner = new Scanner(file);

			// now read the file line by line...

			int rowNum = 0;
			int colNum = 0;
			int str2Col = 0;
			int str2Row = 0;
			
			dataSize =0;
			scanner.nextLine();
			while (scanner.hasNextLine()) {
				String line = scanner.nextLine();

				if (line.contains(",,")) {
					System.out.println("------------------------------");
					continue;
				}
				String[] arrOfStr = line.split(",");
				dataSize++;
				for (String element : arrOfStr) {
					 if(colNum ==2 ) {

						 str2Data[str2Row][str2Col] = element;
						 str2Col++;
					 }
					 else if(colNum ==3) {
						 str2Data[str2Row][str2Col] = element;
						 str2Row++;
						 str2Size++;
						 str2Col =0;
					 }
					dataIn[rowNum][colNum] = element;
					colNum++;
					//System.out.println(element);
					
				}
				if(colNum == 4) {
					colNum =0;
				}
				

				rowNum++;
				

			}
		} catch (FileNotFoundException e) {
			System.out.println("No file found");
		}
		System.out.println("num rows read: " + dataSize);
		

	}
	
	public void readTermsData() {
		File file = new File("Terms.csv");

		try {
			Scanner scanner = new Scanner(file);

			// now read the file line by line...

			int rowNum = 0;
			int colNum = 0;
			scanner.nextLine();
			while (scanner.hasNextLine()) {
				String line = scanner.nextLine();

				if (line.contains(",,")) {
					
					continue;
				}
				String[] arrOfStr = line.split(",");
				for (String element : arrOfStr) {

					termsData[rowNum][colNum] = element;
					colNum++;
					
				}
				if (colNum == 2) {
					colNum = 0;
				}

				rowNum++;
				dataSize++;
				termsDataSize++;
			}
		} catch (FileNotFoundException e) {
			System.out.println("No file found");
		}	
		System.out.println("Terms size" + termsDataSize);
	}
	/*
	 * user inputs a RELA takes the name of the file where the data must be
	 * exported/saved finds all the data from the repository and exports it in CSV
	 * file with string() format user enters "R"
	 */
	public void saveDataRelation(String relaStr, String fileName) {
		
		
		File newFile = new File(fileName);
		try {
			PrintWriter pw = new PrintWriter(fileName+".csv");
			
			StringBuilder sb = new StringBuilder();
			
			sb.append("STR");
			sb.append(",");
			sb.append("Relationship");
			sb.append(",");
			sb.append("STR2");
			sb.append("\n");
			
			for(int i = 0; i < dataSize; i++) {
				
				
					try {
						if(dataIn[i][1].toString().equals(relaStr)) {
							
							for(int e = 0; e < termsDataSize; e++) {
								
								if(dataIn[i][0].toString().equals(termsData[e][0].toString())){
								sb.append(termsData[e][1].toString());
								
								}
							}
								sb.append(",");
								sb.append(relaStr);
								sb.append(",");
								for(int e = 0; e < str2Size; e++) {
									
								if(dataIn[i][1+1].toString().equals(str2Data[e][0].toString())){
										sb.append(str2Data[e][1].toString());
									}
								
								}
								sb.append("\n");
								
							
								
								
							}
						
						
			        } catch (NullPointerException e) {
			            System.out.print("Caught the NullPointerException");
			        }
					
				
			}
			pw.write(sb.toString());
			pw.close();
			System.out.println("finished");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}

	/*
	 * user inputs medical term take the name of the file where data must be
	 * exported/saved find all the information from the repository with medical term
	 * and export it with specific string() format user enters "T"
	 */
	
		public void saveTerms(String relaStr, String fileName) {
		
			
		String cuiCode = null;
		
		File newFile = new File(fileName);
		try {
			PrintWriter pw = new PrintWriter(fileName+".csv");
			
			StringBuilder sb = new StringBuilder();
			
			for(int e = 0; e < termsDataSize; e++) {
				
				if(termsData[e][1].toString().equalsIgnoreCase(relaStr)){
				cuiCode = termsData[e][0];
				
				}
			}
			
			//I'm just using this to make sure its grabbing the right code for the term.
			//can be deleted before submission
			//System.out.println(relaStr + "    " + cuiCode);
			
			sb.append("STR");
			sb.append(",");
			sb.append("Relationship");
			sb.append(",");
			sb.append("STR2");
			sb.append("\n");
			
			
			
			/*
			 * so from what i can tell, the dataIn array holds a cui code matching a 
			 * term and a relationship and the str2data array holds the code and the second part of the relationship
			 * the following should grab the right relation ship for the term,
			 * then add the term, then the relationship, and then the corresponding string from str2.
			 */
			for(int i = 0; i < dataIn.length; i++) 
			{
				
				//used the print line to see if that dataIn array is updated when a new file is added
				//it is but the new data replaces the old.
				//System.out.println("dataIn: " + dataIn[i][1]);
				try {
					if(dataIn[i][0].toString().equalsIgnoreCase(cuiCode) ) {
							
						sb.append(relaStr);
						sb.append(",");
						sb.append(dataIn[i][1]);
						sb.append(",");
						sb.append(str2Data[i][1]);
						sb.append("\n");
							
						}
						
						
			       } catch (NullPointerException e) {
			           //commented this out because it prints every time there isnt the code at that point in the array.
			    	   // System.out.print("Caught the NullPointerException");
			       }
					
				
			}
			pw.write(sb.toString());
			pw.close();
			System.out.println("finished");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			//
			e.printStackTrace();
		}
	}

}
