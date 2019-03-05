package edu.ilstu;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/*
 * class handles input for the files and makes sure they are
 * read in correctly, else exception thrown
 */

public class InputOutput 
{
	//private Scanner keyboard = new Scanner(System.in);
	
	/*
	 * Reads the lines from the Terms.csv file
	 * parses them and creates objects
	 * @param terms
	 * @return size
	 */
	
	public int readTerms(Terms[] terms)
	{
		final String FILENAME = "Terms.csv";
		int size = 0;
		
		Scanner input = null;
		try
		{
			input = new Scanner(new File(FILENAME));
		}
		catch(FileNotFoundException e)
		{
			System.out.println("Unable to open file " +FILENAME);
		}
		
		String line = input.nextLine();
		
		/*
		 * variable names to be used for certain files
		 */
		String CUI = "";
		String CUIName = "";
		
		while(input.hasNext() && size < terms.length)
		{
			line = input.nextLine();
			String[] record = line.split(",");
			
			CUI = record[0];
			CUIName = record[1];
		}//end while
		input.close();
		return size;
	}
	
	/*
	 * Reads the lines from all three relationships.csv files
	 * parses them and creates objects, combining all three together
	 * and taking empty spaces into consideration
	 * @param terms
	 * @return size
	 */
	
	public int readRelationships(Relationships[] relations)
	{
		final String FILENAME_1 = "relationships.csv";
		int size = 0;
		
		Scanner input = null;
		
		try
		{
			input = new Scanner(new File(FILENAME_1));
		}
		catch(FileNotFoundException e)
		{
			System.out.println("Unable to open file " +FILENAME_1);
		}
		
		/*
		 * reads the first line of the relationship files
		 * and discards the first line
		 */
		String line = input.nextLine();
		/*
		 * variable names to be used for certain files
		 */
		String CUI = "";
		String relation = "";
		String CUI2 = "";
		
		/*
		 * while loop to instantiate the variables
		 */
		while(input.hasNext() && size<relations.length)
		{
			line = input.nextLine();
			
			String[] record = line.split(",");
			
			/*
			 * validate for the empty spaces that are in the
			 * Relationship files and instantiate them to the variables
			 */
			
			if(!(record[0].equals("")))
			{
				CUI = record[0];
			}
			else
			{
				CUI = "";
			}
			
			if(!(record[1].equals("")))
			{
				relation = record[1];
			}
			else
			{
				relation = "";
			}
			
			if(!(record[2].equals("")))
			{
				CUI2 = record[2];
			}
			else
			{
				CUI2 = "";
			}
			
		
		}
		input.close();
		return size;
	}
	
	public int readRelationships2(Relationships[] relations2)
	{
		final String FILENAME_2 = "relationships2.csv";
		int size = 0;
		
		Scanner input = null;
		
		try
		{
			input = new Scanner(new File(FILENAME_2));
		}
		catch(FileNotFoundException e)
		{
			System.out.println("Unable to open file " +FILENAME_2);
		}
		
		/*
		 * reads the first line of the relationship files
		 * and discards the first line
		 */
		String line = input.nextLine();
		/*
		 * variable names to be used for certain files
		 */
		String CUI = "";
		String relation = "";
		String CUI2 = "";
		
		/*
		 * while loop to instantiate the variables
		 */
		while(input.hasNext() && size<relations2.length)
		{
			line = input.nextLine();
			
			String[] record = line.split(",");
			
			/*
			 * validate for the empty spaces that are in the
			 * Relationship files and instantiate them to the variables
			 */
			
			if(!(record[0].equals("")))
			{
				CUI = record[0];
			}
			else
			{
				CUI = "";
			}
			
			
			if(!(record[1].equals("")))
			{
				relation = record[1];
			}
			else
			{
				relation = "";
			}
			
			if(!(record[2].equals("")))
			{
				CUI2 = record[2];
			}
			else
			{
				CUI2 = "";
			}
			
		
		}
		input.close();
		return size;
		
	}
	
	public int readRelationships3(Relationships[] relations3)
	{
		final String FILENAME_3 = "relationships3.csv";
		int size = 0;
		
		Scanner input = null;
		
		try
		{
			input = new Scanner(new File(FILENAME_3));
		}
		catch(FileNotFoundException e)
		{
			System.out.println("Unable to open file " +FILENAME_3);
		}
		
		/*
		 * reads the first line of the relationship files
		 * and discards the first line
		 */
		String line = input.nextLine();
		/*
		 * variable names to be used for certain files
		 */
		String CUI = "";
		String relation = "";
		String CUI2 = "";
		
		/*
		 * while loop to instantiate the variables
		 */
		while(input.hasNext() && size<relations3.length)
		{
			line = input.nextLine();
			
			String[] record = line.split(",");
			
			/*
			 * validate for the empty spaces that are in the
			 * Relationship files and instantiate them to the variables
			 */
			
			if(!(record[0].equals("")))
			{
				CUI = record[0];
			}
			else
			{
				CUI = "";
			}
			
			
			if(!(record[1].equals("")))
			{
				relation = record[1];
			}
			else
			{
				relation = "";
			}
			
			if(!(record[2].equals("")))
			{
				CUI2 = record[2];
			}
			else
			{
				CUI2 = "";
			}
			
		
		}
		input.close();
		return size;
		
	}

}
