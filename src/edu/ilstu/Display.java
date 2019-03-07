/**
 * 
 */
package edu.ilstu;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author israe
 *
 */
public class Display 
{
	InputOutput io = new InputOutput();
	
	public void printDisplay()
	{
		Scanner userInput = new Scanner(System.in);
	
		/*
		 * prompt user for input and displays menu
		 * upon selecting an option
		 */
		boolean num = false;
		while(!num)
		{
			System.out.print("\nBiomedical Concepts Data"
							+ "\n('A' or 'a') Add Data\n"
							+ "('R' or 'r') Save data for a relationship\n"
							+ "('T' or 't') Save data for medical terms\n"
							+ "('E' or 'e') Exit Program\n"
							+ "\nEnter choice from above: ");
			
			/*
			 * grab the userinput and call methods for what they chose
			 * from the above
			 */
			String choice = userInput.nextLine();
			choice = choice.toUpperCase();
			
			/*
			 * start switch case statements
			 */
			switch(choice)
			{
			case "A":
				addData();
				break;
			case "R":
				//saveDataRelationShip();
				break;
			case "T":
				//saveDataMedical();
				break;
			case "E":
				System.out.println("\nQuitting Application.");
				System.exit(0);
				break;
			default:
				System.out.println("Invalid choise, please try again.");
				num = false;			
			}//end of switch
							
		}
		//userInput.close();
		
	}


	/*
	 * grab filename from user
	 * read the provided file and extract data
	 * add it to new/existing repository/data structure
	 * print the number of rows read
	 * user enters "A"
	 */
	
	String[] fileNames = new String[3];
//	int numFiles = 0;
//	ArrayList<String> addedFiles = new ArrayList<String>();
//	boolean added = false;
//	boolean repeat = false;
//	InputOutput inFile = new InputOutput();
	public Scanner input = new Scanner(System.in);
	
	
	public void addData()
	{
		String fileName = "";
		boolean num = true;
		
		/*
		 * while loop to execute the adding of the file
		 */
		while(num)
		{
			System.out.println("\nrelationships.csv"
					+ "\nrelationships2.csv\n"
					+ "relationships3.csv\n"
					+ "\nEnter filename from above: ");
			
			fileName = input.nextLine();
			if(fileName.equals("relationships.csv")||fileName.equals("relationships2.csv")||fileName.equals("relationship3.csv"))
			{
				System.out.println("\nFile has been found");
			}
			else
			{
				System.out.println("Invalid filename, enter again.");
			}
				
		}
		
//		for(int i = 0; i< addedFiles.size(); i++)
//		{
//			if(addedFiles.equals(fileName))
//			{
//				repeat = true;
//			}
//		}
//		
//		/*
//		 * check to make sure the file isn't being processed again
//		 */
//		if(repeat)
//		{
//			System.out.println("File has already been processed");
//			/*
//			 * loop back to display the menu
//			 */
//			printDisplay();
//		}
//		else if(fileName.equals("relationships"))
//		{
//			added = true;
//			addedFiles.add(fileName);
//			
//			fileNames[numFiles] = fileName;
//			numFiles++;
//			printDisplay();
//		}
		
		
		
		
		
	}
	
	/*
	 * user inputs a RELA
	 * takes the name of the file where the data must be exported/saved
	 * finds all the data from the repository and exports it in
	 * CSV file with string() format
	 * user enters "R"
	 */
	public void saveDataRelation()
	{
		
	}
	
	
	/*
	 * user inputs medical term
	 * take the name of the file where data must be exported/saved
	 * find all the information from the repository with medical term
	 * and export it with specific string() format
	 * user enters "T"
	 */
	public void saveDataMedical()
	{
		
	}

}
