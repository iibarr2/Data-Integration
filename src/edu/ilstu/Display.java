/**
 * 
 */
package edu.ilstu;

import java.util.Scanner;

/**
 * @author israe
 *
 */
public class Display 
{
	public void printDisplay()
	{
		Scanner userInput = new Scanner(System.in);
	
		InputOutput io = new InputOutput();
	
	
	
	
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
	public void addData()
	{
		String filename = "";
		String file;
		boolean num = true;
		
		
		
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
