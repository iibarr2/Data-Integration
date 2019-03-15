/**
 * 
 */
package edu.ilstu;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
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
				saveDataMedical();
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
	int numFiles = 0;
	ArrayList<String> addedFiles = new ArrayList<String>();
	boolean added = false;
	boolean repeat = false;
	InputOutput inFile = new InputOutput();
	public Scanner input = new Scanner(System.in);
	
	
	public void addData()
	{
		String fileName = "";
		String file = "";
		boolean isTrue = true;
		int period = 0;
		
		/*
		 * while loop to execute the adding of the file
		 */
		while(isTrue)
		{
			System.out.println("\nrelationships.csv"
					+ "\nrelationships2.csv\n"
					+ "relationships3.csv\n"
					+ "\nEnter filename from above: ");
			
			fileName = input.nextLine();
			if(fileName.equals("relationships.csv")||fileName.equals("relationships2.csv")||fileName.equals("relationships3.csv"))
			{
				System.out.println("\nFile has been found");
				for(int i = 0; i<fileName.length();i++)
				{
					period = fileName.indexOf('.');
				}
				file = fileName.substring(0, period);
				isTrue = false;
			}
			else{
				System.out.println("Invalid filename, enter again.");
			}
				
		}
		
		for(int i = 0; i< addedFiles.size(); i++)
		{
			if(addedFiles.equals(fileName))
				repeat = true;
		}
		
		/*
		 * check to make sure the file isn't being processed again
		 */
		if(repeat)
		{
			System.out.println("File has already been processed");
			/*
			 * loop back to display the menu
			 */
			printDisplay();
		}
		else 
		{
			boolean result = inFile.readRelations(fileName, file);
			if(result)
			{
				added = true;
				addedFiles.add(fileName);
			}
			fileNames[numFiles] = fileName;
			numFiles++;
			printDisplay();
		}
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
		
		String term = null;
		String termCode = null;
		String line = null;
        int lineNum = 0;
		
		System.out.println("enter medical term");
		term = input.nextLine();

        File file= new File("terms.csv");
        BufferedReader br = null;
		try
		{
			br = new BufferedReader(new FileReader(file));
			while ((line = br.readLine()) != null) 
			{
				// use comma as separator
				String[] cols = line.split(",");
				if(cols[1].equalsIgnoreCase(term))
				{
					System.out.println(cols[0]);
					termCode = cols[0];
				}
			}
		}
		catch (FileNotFoundException e)
		{
			System.out.println("file not found");
		}
		catch (IOException e)
		{
			System.out.print("failure to read");
		}
       
		
	}
        

}


